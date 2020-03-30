package com.farhan.charity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Applicant_Details extends AppCompatActivity {
    AlertDialog alertDialog;
    TextView applicantsNameTV1,app_ID,app_Title,app_amount,app_staus;
    CircleImageView profilex;
    Button forwardBtn;
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


        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.custom_alert_dialog_4, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        alertDialog = builder.create();
        alertDialog.show();

    }

    public void forwardForm(View view) {

        //startActivity(new Intent(Applicant_Details.this, FowardForm.class));
        startActivity(new Intent(Applicant_Details.this, ForwardForm.class));



    }


    public void backToAllApplication(View view){

        super.onBackPressed();
    }
}
