package com.farhan.charity.Adapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.farhan.charity.Applicant_Details;
import com.farhan.charity.Dashboard_Items.All_Application_Activity;
import com.farhan.charity.Model.ItemModel;
import com.farhan.charity.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter_item1 extends  RecyclerView.Adapter<Adapter_item1.ViewHolder> {

    private Context context;
    private List<ItemModel> itemModelList;

    public Adapter_item1(Context context, List<ItemModel> list) {
        this.context = context;
        this.itemModelList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        final ItemModel itemModel = itemModelList.get(position);
        String applicantsName=itemModel.getUsers_name_bn();
        String applicataionFor=itemModel.getApplication_title_bn();
        String applictionAmount=itemModel.getApplication_amount();

       // String imageUrl = "http://charity.olivineltd.com/upload/frontend/users_image/"+itemModel.getUsers_image();

  //      Toast.makeText(context, ""+imageUrl, Toast.LENGTH_LONG).show();
      //  Picasso.get().load("http://charity.olivineltd.com/upload/frontend/users_image/20180726225536OL5b59fd087bc788.jpg").placeholder(R.mipmap.ic_launcher).into(holder.profileImagex);


        holder.applicant_name.setText(applicantsName);
        holder.application_for.setText(applicataionFor);
        holder.applicant_amount.setText(applictionAmount);
     //   Glide.with(context).load("http://charity.olivineltd.com/upload/frontend/users_image/20180726225536OL5b59fd087bc788.jpg").into(holder.profileImagex);
        final String UserName  = itemModel.getUsers_name_bn();
        final String Amount = itemModel.getApplication_amount();
        final String ApllicationId = itemModel.getApplication_id();
        final String ApplicationTitle = itemModel.getApplication_title_bn();
        final String Status = itemModel.getApplication_status();
        final String Image= itemModel.getUsers_image();


        final String imageUrl = "http://charity.olivineltd.com/upload/frontend/users_image/"+itemModel.getUsers_image();
        Picasso.get().load(imageUrl).into(holder.profileImagex);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Toast.makeText(context, ""+ itemModel.getUsers_name_bn() ,Toast.LENGTH_SHORT).show();

                Intent i = new Intent(context, Applicant_Details.class);
                // i.putExtra("imageUrl",imageUrl);
                i.putExtra("name",UserName);
                i.putExtra("id",ApllicationId);
                i.putExtra("amount",Amount);
                i.putExtra("title",ApplicationTitle);
                i.putExtra("status",Status);
                i.putExtra("img",imageUrl);
                context.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return itemModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        CircleImageView profileImagex;
        TextView applicant_name,application_for,applicant_money,applicant_amount;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);

            profileImagex=itemView.findViewById(R.id.profileImage);
            applicant_name=itemView.findViewById(R.id.applicant_name);
            application_for=itemView.findViewById(R.id.application_for);
            applicant_money=itemView.findViewById(R.id.applicant_money);
            applicant_amount=itemView.findViewById(R.id.applicant_amount);

        }
    }
}



