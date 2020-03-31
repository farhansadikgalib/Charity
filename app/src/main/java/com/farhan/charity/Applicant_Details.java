package com.farhan.charity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class Applicant_Details extends AppCompatActivity {
    AlertDialog alertDialog;
    TextView applicantsNameTV1,app_ID,app_Title,app_amount,app_staus;
    CircleImageView profilex;
    Button forwardBtn;
    String application_track_id;
    String rejectReason;
    RequestQueue mRequestQueuex;
    String admins_track_id ="ijOhgOL20180808104412" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant_details);
        forwardBtn=findViewById(R.id.forwardBtn);
       profilex  = findViewById(R.id.profile_image_p);
        applicantsNameTV1 = findViewById(R.id.applicantsNameTV);
        app_ID = findViewById(R.id.idTV);
        app_Title = findViewById(R.id.titleHeadingTV);
        app_amount = findViewById(R.id.currencyTV);
        app_staus = findViewById(R.id.stateTV);



        mRequestQueuex = Volley.newRequestQueue(this);



        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String Name =(String) b.get("name");
            String  Amount =(String)  b.get("amount");
            String Title =(String) b.get("title");
            String  Status =(String)  b.get("status");
            String Id =(String) b.get("id");
            //int img = (int) b.get("img");
            String img = (String) b.get("img") ;

            applicantsNameTV1.setText(Name);
            app_ID.setText(Id);
            app_Title.setText(Title);
            app_amount.setText(Amount);
            app_staus.setText(Status);
            //profile.setImageResource(Integer.parseInt(img));
            Picasso.get().load(img).into(profilex);

            application_track_id = app_ID.getText().toString();
        }



        applicantsNameTV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Applicant_Details.this, ProfilewithPermanentAddressActivity.class));
            }
        });


    }

    public void Onumodon_korun(View view) {

        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.custom_alert_dialog, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        alertDialog = builder.create();
        alertDialog.show();

    }

    public void crossBtn(View view) {

        alertDialog.dismiss();



    }

    public void submit_button(View view) {

        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.custom_alert_dialog_3, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        alertDialog = builder.create();
        alertDialog.show();


    }

    public void prottakhan_korun(View view) {


        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.custom_alert_dialog_2, viewGroup, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        alertDialog = builder.create();
        alertDialog.show();
    }

    public void submit_prottakhan(View view) {

//
//        EditText rejectReasonx   = findViewById(R.id.reject_reason);
//        rejectReason =   rejectReasonx.getText().toString();
//
//
////        if (TextUtils.isEmpty(rejectReason)) {
////            Toast.makeText(this, "অনুগ্রহপূর্বক প্রত্যাখানের কারণ উল্লেখ করুন", Toast.LENGTH_SHORT).show();
////            alertDialog.dismiss();
////            return;
////
////        } else {
//
//
//
//
//            String url = "http://charity.olivineltd.com/api/rejectApplication";
//
//            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//                @Override
//                public void onResponse(String response) {
//                    try {
//                        JSONObject jsonObject = new JSONObject(response);
//                        String status = jsonObject.getString("status");
//
//                        if (status.equals("Ok")) {
//
//                            Toast.makeText(Applicant_Details.this, "Okk Baby!", Toast.LENGTH_SHORT).show();
//
//                            ViewGroup viewGroup = findViewById(android.R.id.content);
//                            View dialogView = LayoutInflater.from(Applicant_Details.this).inflate(R.layout.custom_alert_dialog_4, viewGroup, false);
//                            AlertDialog.Builder builder = new AlertDialog.Builder(Applicant_Details.this);
//                            builder.setView(dialogView);
//                            alertDialog = builder.create();
//                            alertDialog.show();
//
//
//                        }
//
//
//                        // startActivity(new Intent(getContext(),DashBoard.class));
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        //     Toast.makeText(Applicant_Details.this, "আপনি ভুল মোবাইল নাম্বার অথবা পাসওয়ার্ড দিয়েছেন", Toast.LENGTH_SHORT).show();
//
//                    }
//
//                }
//            }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//
//                    Toast.makeText(Applicant_Details.this, "অনুগ্রহপূর্বক ইন্টারনেট সংযোগ চালু করুন", Toast.LENGTH_SHORT).show();
//
//                }
//            }) {
//                @Override
//                protected Map<String, String> getParams() throws AuthFailureError {
//                    Map<String, String> params = new HashMap<>();
//                    params.put("application_track_id", application_track_id);
//                    params.put("application_rejection_note", rejectReason);
//                    params.put("admins_id", admins_track_id);
//                    return params;
//                }
//            };
//            Volley.newRequestQueue(this).add(stringRequest);
        }









    public void forwardForm(View view) {

        //startActivity(new Intent(Applicant_Details.this, FowardForm.class));
        startActivity(new Intent(Applicant_Details.this, ForwardForm.class));



    }


    public void backToAllApplication(View view){

        super.onBackPressed();
    }










}
