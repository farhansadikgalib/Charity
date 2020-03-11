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

import com.farhan.charity.Applicant_Details;
import com.farhan.charity.Dashboard_Items.All_Application_Activity;
import com.farhan.charity.Model.ItemModel;
import com.farhan.charity.R;

import java.util.List;

public class Adapter_item2 extends  RecyclerView.Adapter<Adapter_item2.ViewHolder> {

    private Context context;
    private List<ItemModel> itemModelList;

    public Adapter_item2(Context context, List<ItemModel> list) {
        this.context = context;
        this.itemModelList = list;
    }

    @Override
    public Adapter_item2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false);
        return new Adapter_item2.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ItemModel itemModel = itemModelList.get(position);


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, ""+ itemModel.getApplicantName() ,Toast.LENGTH_SHORT).show();
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

        public ViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}



