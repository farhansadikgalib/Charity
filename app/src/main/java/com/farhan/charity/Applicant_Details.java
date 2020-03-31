package com.farhan.charity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    TextView applicantsNameTV1, app_ID, app_Title, app_amount, app_staus;
    CircleImageView profilex;
    Button forwardBtn;
    SharedPreferences sharedPreferences;
    String application_track_id;
    String RejectData;
    EditText rejectReasonx;
    RequestQueue mRequestQueuex;
    String admins_track_id = "ijOhgOL20180808104412";
    String lostid;
    LinearLayout Onumodon, Prottakhan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant_details);
        forwardBtn = findViewById(R.id.forwardBtn);
        profilex = findViewById(R.id.profile_image_p);
        applicantsNameTV1 = findViewById(R.id.applicantsNameTV);
        app_ID = findViewById(R.id.idTV);
        app_Title = findViewById(R.id.titleHeadingTV);
        app_amount = findViewById(R.id.currencyTV);
        app_staus = findViewById(R.id.stateTV);
        Onumodon = findViewById(R.id.Onumodon);
        Prottakhan = findViewById(R.id.prottakhan_korun);
        mRequestQueuex = Volley.newRequestQueue(this);


        sharedPreferences = this.getSharedPreferences("myapp", Context.MODE_PRIVATE);
        lostid = sharedPreferences.getString("UTI", null);
        Toast.makeText(this, lostid, Toast.LENGTH_SHORT).show();

        Log.d("admin_track", lostid);

        application_track_id = app_ID.getText().toString();


        Onumodon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(Applicant_Details.this).inflate(R.layout.custom_alert_dialog, viewGroup, false);
                AlertDialog.Builder builder = new AlertDialog.Builder(Applicant_Details.this);
                builder.setView(dialogView);
                alertDialog = builder.create();
                alertDialog.show();


            }
        });

        Prottakhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(Applicant_Details.this).inflate(R.layout.custom_alert_dialog_2, viewGroup, false);
                AlertDialog.Builder builder = new AlertDialog.Builder(Applicant_Details.this);
                builder.setView(dialogView);
                alertDialog = builder.create();
                alertDialog.show();


            }
        });


        Intent iin = getIntent();
        Bundle b = iin.getExtras();

        if (b != null) {
            String Name = (String) b.get("name");
            String Amount = (String) b.get("amount");
            String Title = (String) b.get("title");
            String Status = (String) b.get("status");
            String Id = (String) b.get("id");
            //int img = (int) b.get("img");
            String img = (String) b.get("img");

            applicantsNameTV1.setText(Name);
            app_ID.setText(Id);
            app_Title.setText(Title);
            app_amount.setText(Amount);
            app_staus.setText(Status);
            //profile.setImageResource(Integer.parseInt(img));
            Picasso.get().load(img).into(profilex);


        }


        applicantsNameTV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Applicant_Details.this, ProfilewithPermanentAddressActivity.class));
            }
        });


    }


    public void crossBtn(View view) {

        alertDialog.dismiss();

    }

    public void final_submit_button(View view) {

        String url = "http://charity.olivineltd.com/api/approveApplication";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String status = jsonObject.getString("status");

                    if (status.equals("Ok")) {

                        //       Toast.makeText(Applicant_Details.this, "Okk Baby!", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(Applicant_Details.this, ""+lostid+"\n"+application_track_id, Toast.LENGTH_SHORT).show();

                        ViewGroup viewGroup = findViewById(android.R.id.content);
                        View dialogView = LayoutInflater.from(Applicant_Details.this).inflate(R.layout.custom_alert_dialog_3, viewGroup, false);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Applicant_Details.this);
                        builder.setView(dialogView);
                        alertDialog = builder.create();
                        alertDialog.show();
                    } else {

                        Toast.makeText(Applicant_Details.this, "Something went wrong!!", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                    //    Toast.makeText(Applicant_Details.this, "আপনি ভুল মোবাইল নাম্বার অথবা পাসওয়ার্ড দিয়েছেন", Toast.LENGTH_SHORT).show();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Applicant_Details.this, "অনুগ্রহপূর্বক ইন্টারনেট সংযোগ চালু করুন", Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("admins_id", lostid);
                params.put("application_track_id", application_track_id);
                return params;
            }
        };
        Volley.newRequestQueue(Applicant_Details.this).add(stringRequest);


    }


    public void submit_prottakhan(View view) {


        rejectReasonx = view.findViewById(R.id.reject_reason);


        String url = "http://charity.olivineltd.com/api/rejectApplication";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                RejectData = rejectReasonx.getText().toString();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String status = jsonObject.getString("status");

                    if (status.equals("Ok")) {

                        //       Toast.makeText(Applicant_Details.this, "Okk Baby!", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(Applicant_Details.this, ""+lostid+"\n"+application_track_id, Toast.LENGTH_SHORT).show();

                        ViewGroup viewGroup = findViewById(android.R.id.content);
                        View dialogView = LayoutInflater.from(Applicant_Details.this).inflate(R.layout.custom_alert_dialog_4, viewGroup, false);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Applicant_Details.this);
                        builder.setView(dialogView);
                        alertDialog = builder.create();
                        alertDialog.show();

                    } else {

                        Toast.makeText(Applicant_Details.this, "Something went wrong!!", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                    //    Toast.makeText(Applicant_Details.this, "আপনি ভুল মোবাইল নাম্বার অথবা পাসওয়ার্ড দিয়েছেন", Toast.LENGTH_SHORT).show();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Applicant_Details.this, "অনুগ্রহপূর্বক ইন্টারনেট সংযোগ চালু করুন", Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("admins_id", lostid);
                params.put("application_rejection_note", RejectData);
                params.put("application_track_id", application_track_id);
                return params;
            }
        };
        Volley.newRequestQueue(Applicant_Details.this).add(stringRequest);

    }


    public void forwardForm(View view) {

        //startActivity(new Intent(Applicant_Details.this, FowardForm.class));
        startActivity(new Intent(Applicant_Details.this, ForwardForm.class));

    }


    public void backToAllApplication(View view) {

        super.onBackPressed();
    }


}
