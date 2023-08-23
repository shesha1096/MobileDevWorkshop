package com.shesha.mobiledevworkshop.workshop1app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String ACTIVITY_NAME = "MainActivity";

    private EditText numberOneInput;
    private EditText numberTwoInput;
    private TextView displaySumOutput;

    private Button submitButton;
    private int sum  = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(ACTIVITY_NAME,"inside onCreate");
        numberOneInput = findViewById(R.id.num1_input);
        numberTwoInput = findViewById(R.id.num2_input);
        submitButton = findViewById(R.id.submit_btn);
        displaySumOutput = findViewById(R.id.sum_output);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum = (Integer.parseInt(numberOneInput.getText().toString()) + Integer.parseInt(numberTwoInput.getText().toString()));
                displaySumOutput.setText("The Sum is: " + sum);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(ACTIVITY_NAME, "inside onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(ACTIVITY_NAME, "inside onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(ACTIVITY_NAME, "inside onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(ACTIVITY_NAME, "inside onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(ACTIVITY_NAME, "inside onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(ACTIVITY_NAME, "inside onRestart");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("sum",sum);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        sum = savedInstanceState.getInt("sum");
        displaySumOutput.setText(String.valueOf(sum));
    }
}