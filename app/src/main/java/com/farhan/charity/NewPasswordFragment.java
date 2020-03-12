package com.farhan.charity;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewPasswordFragment extends Fragment {


    private EditText passET,confirmPassET;
    private Button finalSubmitBtn;
    public NewPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_new_password, container, false);

        passET = view.findViewById(R.id.newPassET);
        confirmPassET = view.findViewById(R.id.newPassET2);
        finalSubmitBtn  = view.findViewById(R.id.finalSubmitBtn);


        finalSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DashBoard.class));

            }
        });

    return  view;
    }

}
