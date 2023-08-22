package com.shesha.mobiledevworkshop.viewpagerapp.fargments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.shesha.mobiledevworkshop.viewpagerapp.R;

public class RecentsFragment extends Fragment {

    public RecentsFragment() {
        // Required empty public constructor
    }

    /**
     * @return A new instance of fragment SpeedDialFragment.
     */
    public static RecentsFragment newInstance() {
        return new RecentsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        return root;
    }
}

