package com.farhan.charity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.farhan.charity.Fragment.MainActivity;
import com.farhan.charity.Model.LogInModelClass;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheekActivity extends AppCompatActivity {
    private EditText phoneET, passwordET;
    private TextView forgetPass;
    private Button singInBtn;
    private CheckBox checkBox;
    private FrameLayout parentFrameLayout;
    String username;
    String passwordd;
    private RequestQueue mRequestQueue;

    ArrayList<LogInModelClass> logInModelClasses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheek);

        phoneET = findViewById(R.id.phoneET);
        passwordET = findViewById(R.id.passET);
        singInBtn = findViewById(R.id.loginBtn);
        checkBox = findViewById(R.id.remenbercheckbox);
        forgetPass = findViewById(R.id.forgetPass);
        parentFrameLayout = findViewById(R.id.registration_framelayout);





        singInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                username = phoneET.getText().toString();
                passwordd = passwordET.getText().toString();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://demo.olivineltd.com/primary_attendance/api/school/login",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                if(response.equals("Invalid Credentials"))
                                {
                                    Toast.makeText(CheekActivity.this, "MOira ja", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {

                                    try {
                                        JSONObject jsonObject = new JSONObject(response);
                                        String name__en = jsonObject.getString("school_name_en");
                                        String name__bn = jsonObject.getString("school_name_bn");
                                        String phone = jsonObject.getString("school_teacher_mobile");
                                        String upazila__id = jsonObject.getString("school_upazila_id");
                                        String teacher__name = jsonObject.getString("school_teacher_name");
                                        String school__eiin = jsonObject.getString("school_eiin_no");
                                        String school__id = jsonObject.getString("school_id");


                                       /* SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor=sharedPreferences.edit();
                                        editor.putString("name_key", name__bn);
                                        editor.putString("phone_key",phone);
                                        editor.apply();
*/

                                        //Toast.makeText(LoginActivity.this, "data store succefull", Toast.LENGTH_SHORT).show();
                                        Toast.makeText(CheekActivity.this, name__bn, Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(CheekActivity.this,DashBoard.class);
                                        startActivity(intent);


                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String,String>prams=new HashMap<>();
                        prams.put("mobile_no",username);
                        prams.put("password",passwordd);
                        return prams;
                    }
                };

                Volley.newRequestQueue(CheekActivity.this).add(stringRequest);

            }
        });



    }
}
