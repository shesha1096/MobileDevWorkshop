package com.shesha.mobiledevworkshop.workshop4firebaseintro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.shesha.mobiledevworkshop.workshop4firebaseintro.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText emailInput;
    private Button addUserButton;

    //private FirebaseDatabase firebaseDatabase;

    FirebaseFirestore firebaseFirestore;

    private ArrayList<String> users;

    private Button listAllUsersButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameInput = findViewById(R.id.username_input);
        emailInput = findViewById(R.id.user_email_input);
        addUserButton = findViewById(R.id.add_user_btn);
        listAllUsersButton = findViewById(R.id.list_all_users_btn);

        //firebaseDatabase = FirebaseDatabase.getInstance();

        firebaseFirestore = FirebaseFirestore.getInstance();

        //DatabaseReference userReference = firebaseDatabase.getReference("users");

        users = new ArrayList<>();

        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User(usernameInput.getText().toString(), emailInput.getText().toString());

                firebaseFirestore.collection("users")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                if (documentReference != null) {
                                    Toast.makeText(MainActivity.this, "User added successfully", Toast.LENGTH_LONG).show();
                                }

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Could not create user:" + e.toString(), Toast.LENGTH_LONG).show();
                            }
                        });

//                userReference.child(UUID.randomUUID().toString()).setValue(user)
//                        .addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                if (task.isSuccessful()) {
//                                    Toast.makeText(MainActivity.this, "User created successfully",Toast.LENGTH_LONG).show();
//                                }
//                            }
//                        })
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Toast.makeText(MainActivity.this, "Unable to create user: " + e.toString(), Toast.LENGTH_LONG).show();
//                            }
//                        });
            }
        });

        firebaseFirestore.collection("users")
                .get()
                        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                for (QueryDocumentSnapshot querySnapshot: queryDocumentSnapshots) {
                                   User user = querySnapshot.toObject(User.class);
                                   users.add(user.getUserName());
                                }

                            }
                        })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(MainActivity.this, "Could not get users: " + e, Toast.LENGTH_LONG).show();
                                    }
                                });
//        userReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
//                    User user = dataSnapshot.getValue(User.class);
//                    if (user != null) {
//                        users.add(user.getUserName());
//                    }
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        listAllUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListAllUsersActivity.class);
                intent.putStringArrayListExtra("users",users);
                startActivity(intent);
            }
        });
    }
}