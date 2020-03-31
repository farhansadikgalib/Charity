package com.farhan.charity.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.farhan.charity.DashBoard;
import com.farhan.charity.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewPasswordFragment extends Fragment {


    private EditText passET, confirmPassET;
    private Button finalSubmitBtn;
    String pass;
    public NewPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_password, container, false);

        passET = view.findViewById(R.id.newPassET);
        confirmPassET = view.findViewById(R.id.newPassET2);
        finalSubmitBtn = view.findViewById(R.id.finalSubmitBtn);

        pass = confirmPassET.getText().toString();



        finalSubmitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://charity.olivineltd.com/api/passwordReset", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String status = jsonObject.getString("status");

                                if (status.equals("Ok")) {
                                    Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();

                                    if (passET.getText().toString().equals("")) {
                                        passET.setError("Please Enter Your Password");

                                    } else if (passET.getText().toString().length() < 8) {

                                        passET.setError("Please Input minimume 8 digits");

                                    } else if (!passET.getText().toString().equals(confirmPassET.getText().toString())) {
                                        confirmPassET.setError("New Password and Confirm Password should be same.");
                                    }
                                    else if (passET.getText().length()>7 && confirmPassET.equals(passET)) {

                                        startActivity(new Intent(getContext(), DashBoard.class));
                                        getActivity().finish();
                                    }



                                } else {


                                    Toast.makeText(getContext(), "আপনি ভুল পাসওয়ার্ড দিয়েছেন", Toast.LENGTH_SHORT).show();

                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("password", pass);
                            return params;
                        }
                    };
                    Volley.newRequestQueue(getContext()).add(stringRequest);
                }


            });

            return view;
        }

    }