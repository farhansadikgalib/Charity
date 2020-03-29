package com.farhan.charity.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.farhan.charity.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneFragment extends Fragment  {


    public PhoneFragment() {
        // Required empty public constructor
    }

    private FrameLayout parentFrameLayout;
    private EditText phoneET;
    private Button submitBtn;
    private String phone,pass;
    private RequestQueue mRequestQueue;
    private ProgressBar progress_circular;
    private String passwordx ="123456";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_phone, container, false);


        parentFrameLayout = getActivity().findViewById(R.id.registration_framelayout);
        phoneET = view.findViewById(R.id.forgetPhoneET);
        submitBtn = view.findViewById(R.id.submitBtn);
        progress_circular=view.findViewById(R.id.progress_circular);

        mRequestQueue = Volley.newRequestQueue(getContext());






        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
              //  Log.i(tag, "keyCode: " + keyCode);
                if( keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
              //      Log.i(tag, "onKey Back listener is working!!!");
                    getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    return true;
                }
                return false;
            }
        });












        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = phoneET.getText().toString().trim();
                pass = passwordx.trim();

               // Toast.makeText(getContext(), ""+phone, Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), ""+pass, Toast.LENGTH_SHORT).show();

                if (TextUtils.isEmpty(phone)) {
                    phoneET.setError("মোবাইল নাম্বার আবশ্যক");
                    phoneET.requestFocus();
                    return;
                }


                progress_circular.setVisibility(View.VISIBLE);

                StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://charity.olivineltd.com/api/login", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");

                            if (status.equals("Ok"))
                            {
                                Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();
                                setFragment(new OtpFragment());
                            }else{

                                Toast.makeText(getContext(), "আপনি ভুল মোবাইল নাম্বার দিয়েছেন", Toast.LENGTH_SHORT).show();


                            }



                        }
                        catch (Exception e) {
                            e.printStackTrace();
                           progress_circular.setVisibility(View.GONE);

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
                        params.put("admin_password", pass);
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
          getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
          fragmentTransaction.commit();



          getView().setFocusableInTouchMode(true);
          getView().requestFocus();
          getView().setOnKeyListener(new View.OnKeyListener() {
              @Override
              public boolean onKey(View v, int keyCode, KeyEvent event) {
                  //  Log.i(tag, "keyCode: " + keyCode);
                  if( keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
                      //      Log.i(tag, "onKey Back listener is working!!!");
                      getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                      return true;
                  }
                  return false;
              }
          });


      }



}




