package com.farhan.charity.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.farhan.charity.R;
import com.mukesh.OtpView;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class OtpFragment extends Fragment {

    public OtpFragment() {
    }

    private Button otpSubmitBtn;
    private FrameLayout parentFrameLayout;
    private OtpView otpView;
    String otp;
    String password = "123456";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_otp, container, false);

        otpSubmitBtn = view.findViewById(R.id.otpSubmitBtn);
        otpView = view.findViewById(R.id.pinView);

        otp = otpView.getText().toString();




        parentFrameLayout = getActivity().findViewById(R.id.registration_framelayout);


        otpSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            setFragment(new NewPasswordFragment());

                StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://charity.olivineltd.com/api/login", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");

                            if (status.equals("Ok"))
                            {
                                Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();
                                setFragment(new NewPasswordFragment());
                            }


                        }
                        catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(getContext(), "আপনি ভুল মোবাইল নাম্বার দিয়েছেন", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "error" , Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("admin_mobile", otp);
                        params.put("admin_password", password);
                        return params;
                    }
                };
                Volley.newRequestQueue(getContext()).add(stringRequest);
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
