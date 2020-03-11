package com.farhan.charity;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


/**
 * A simple {@link Fragment} subclass.
 */
public class OtpFragment extends Fragment {


    public OtpFragment() {
        // Required empty public constructor
    }

 //   private PinView otpET;
    private Button otpSubmitBtn;
    private FrameLayout parentFrameLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_otp, container, false);

      //  otpET =view.findViewById(R.id.pinView);
        otpSubmitBtn = view.findViewById(R.id.otpSubmitBtn);
        parentFrameLayout = getActivity().findViewById(R.id.registration_framelayout);


        otpSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            setFragment(new NewPasswordFragment());

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
