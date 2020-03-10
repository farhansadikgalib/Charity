package com.farhan.charity.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.farhan.charity.Model.ItemModel;
import com.farhan.charity.R;
import com.farhan.charity.Unapproved_Application_Details_Activity;

import java.util.List;

public class Unapproved_Adapter extends  RecyclerView.Adapter<Unapproved_Adapter.ViewHolder> {

    private Context context;
    private List<ItemModel> itemModelList;

    public Unapproved_Adapter(Context context, List<ItemModel> list) {
        this.context = context;
        this.itemModelList = list;
    }

    @Override
    public Unapproved_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_layout_2, parent, false);
        return new Unapproved_Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ItemModel itemModel = itemModelList.get(position);


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, ""+ itemModel.getApplicantName() ,Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context, Unapproved_Application_Details_Activity.class);
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

        public ViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}


