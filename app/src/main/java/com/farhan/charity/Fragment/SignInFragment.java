package com.farhan.charity.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.farhan.charity.DashBoard;
import com.farhan.charity.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {


    public SignInFragment() {
        // Required empty public constructor
    }

    private EditText phoneET, passwordET;
    private TextView forgetPass;
    private Button singInBtn;
    private CheckBox checkBox;
    private FrameLayout parentFrameLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        phoneET = view.findViewById(R.id.phoneET);
        passwordET = view.findViewById(R.id.passET);
        singInBtn = view.findViewById(R.id.loginBtn);
        checkBox = view.findViewById(R.id.remenbercheckbox);
        forgetPass = view.findViewById(R.id.forgetPass);
        parentFrameLayout = getActivity().findViewById(R.id.registration_framelayout);


        singInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getContext(), DashBoard.class));

            }
        });


        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setFragment(new PhoneFragment());
            }
        });


        return view;
    }


    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(parentFrameLayout.getId(), fragment);
        fragmentTransaction.commit();


    }

}
