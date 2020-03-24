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

public class ApplicationUnderConsideration_Adapter extends  RecyclerView.Adapter<ApplicationUnderConsideration_Adapter.ViewHolder> {

    private Context context;
    private List<ItemModel> itemModelList;

    public ApplicationUnderConsideration_Adapter(Context context, List<ItemModel> list) {
        this.context = context;
        this.itemModelList = list;
    }

    @Override
    public ApplicationUnderConsideration_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false);
        return new ApplicationUnderConsideration_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ItemModel itemModel = itemModelList.get(position);

        holder.tilte.setText(itemModel.getApplication_title_bn());
        holder.name.setText(itemModel.getUsers_name_bn());
        holder.amount.setText(itemModel.getApplication_amount());

        String imageUrl = "http://charity.olivineltd.com/upload/frontend/users_image/" + itemModel.getUsers_image();
        Picasso.get().load(imageUrl).into(holder.user_Img);


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "" + itemModel.getUsers_name_bn(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context, Applicant_Details.class);
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
        TextView tilte, name, amount;
        ImageView user_Img;

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



