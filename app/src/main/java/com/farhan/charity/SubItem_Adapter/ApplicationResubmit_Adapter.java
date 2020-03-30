package com.farhan.charity.SubItem_Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.farhan.charity.Applicant_Details;
import com.farhan.charity.Model.ItemModel;
import com.farhan.charity.R;
import com.farhan.charity.UnderConsideration_Details_Activity;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ApplicationResubmit_Adapter extends  RecyclerView.Adapter<ApplicationResubmit_Adapter.ViewHolder> {

    private Context context;
    private List<ItemModel> itemModelList;

    public ApplicationResubmit_Adapter(Context context, List<ItemModel> list) {
        this.context = context;
        this.itemModelList = list;
    }

    @Override
    public ApplicationResubmit_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false);
        return new ApplicationResubmit_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ItemModel itemModel = itemModelList.get(position);
        holder.tilte.setText(itemModel.getApplication_title_bn());
        holder.name.setText(itemModel.getUsers_name_bn());
        holder.amount.setText(itemModel.getApplication_amount());


        final String UserName  = itemModel.getUsers_name_bn();
        final String Amount = itemModel.getApplication_amount();
        final String ApllicationId = itemModel.getApplication_id();
        final String ApplicationTitle = itemModel.getApplication_title_bn();
        final String Status = itemModel.getApplication_status();
        final String Image= itemModel.getUsers_image();


        final String imageUrl = "http://charity.olivineltd.com/upload/frontend/users_image/"+itemModel.getUsers_image();
        Picasso.get().load(imageUrl).into(holder.user_Img);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, ""+ itemModel.getUsers_name_bn() ,Toast.LENGTH_SHORT).show();

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
        TextView tilte,name,amount;
        CircleImageView user_Img;

        public ViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);

            tilte = itemView.findViewById(R.id.application_for);
            name = itemView.findViewById(R.id.applicant_name);
            amount = itemView.findViewById(R.id.applicant_amount);
            user_Img = itemView.findViewById(R.id.profileImage);
        }
    }

}

