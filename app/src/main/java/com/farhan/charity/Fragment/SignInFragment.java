package com.farhan.charity.Fragment;


import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.farhan.charity.DashBoard;
import com.farhan.charity.Model.LogInModelClass;
import com.farhan.charity.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


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
    String phone,password ;
    private RequestQueue mRequestQueue;

    ArrayList<LogInModelClass> logInModelClasses;

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
                 phone = phoneET.getText().toString().trim();
                 password = passwordET.getText().toString().trim();
                 parseJSON();

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        logInModelClasses = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(getContext());


    }

    private void parseJSON() {
        String url="http://charity.olivineltd.com/api/login";



        if (TextUtils.isEmpty(phone)) {
            phoneET.setError("মোবাইল নাম্বার আবশ্যক");
            phoneET.requestFocus();
            return;
        }


        if (TextUtils.isEmpty(password)) {
            passwordET.setError("পাসওয়ার্ড আবশ্যক");
            passwordET.requestFocus();
            return;
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://charity.olivineltd.com/api/login", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
              //  Toast.makeText(getContext(), "hello" + response, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String status = jsonObject.getString("status");

                    if (status.equals("Ok"))
                    {
                        Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getContext(),DashBoard.class));
                    }

                   // Toast.makeText(getContext(), ""+jsonObject.getString("Valid"), Toast.LENGTH_SHORT).show();
                    //String users_phone = jsonObject.getString("mobile");
                  //  String  users_password= jsonObject.getString("password");


// Toast.makeText(MainActivity.this, ""+data, Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(getContext(),DashBoard.class));

                } catch (Exception e) {
                    e.printStackTrace();
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
                params.put("admin_mobile", phone);
                params.put("admin_password", password);
                return params;
            }
        };
        Volley.newRequestQueue(getContext()).add(stringRequest);
    }
}
