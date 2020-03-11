package com.farhan.charity.DashbordAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.farhan.charity.Adapter.Adapter_item1;
import com.farhan.charity.R;

import java.util.ArrayList;
import java.util.List;

public class DashbordRecyclerViewAdapter extends RecyclerView.Adapter<DashbordRecyclerViewAdapter.MyViewHolder> {

    public Context context;
    public List<DataModel> dataModels = new ArrayList<DataModel>();

    public DashbordRecyclerViewAdapter(Context context, List<DataModel> dataModels) {
        this.context = context;
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.dashbord_raw,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        DataModel model = dataModels.get(position);
        holder.Name.setText(model.getName());
        holder.Number.setText(model.getNumber());
        holder.imageView.setImageResource(model.getImage());

    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public  class  MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name, Number;
        ImageView imageView;
        CardView cardView;
        public MyViewHolder(View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.textViewNameId);
            Number = itemView.findViewById(R.id.textViewNumberId);
            imageView = itemView.findViewById(R.id.imageViewId);
            cardView = itemView.findViewById(R.id.cardViewId);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Item"+getLayoutPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
