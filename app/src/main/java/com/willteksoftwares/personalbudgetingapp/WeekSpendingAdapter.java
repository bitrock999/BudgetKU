package com.willteksoftwares.personalbudgetingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WeekSpendingAdapter extends RecyclerView.Adapter<WeekSpendingAdapter.ViewHolder> {

    private Context mContext;
    private List<Data> myDataList;

    public WeekSpendingAdapter(Context mContext, List<Data> myDataList) {
        this.mContext = mContext;
        this.myDataList = myDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.retrieve_layout, parent,false);
        return new WeekSpendingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final  Data data = myDataList.get(position);

        holder.item.setText("Item: "+ data.getItem());
        holder.amount.setText("Amount: "+ data.getAmount());
        holder.date.setText("On "+data.getDate());
        holder.notes.setText("Note: "+data.getNotes());


        switch (data.getItem()){
            case "Transport":
                holder.imageView.setImageResource(R.drawable.bus);
                break;
            case "Food":
                holder.imageView.setImageResource(R.drawable.makan);
                break;
            case "House":
                holder.imageView.setImageResource(R.drawable.rumah);
                break;
            case "Entertainment":
                holder.imageView.setImageResource(R.drawable.vids);
                break;
            case "Education":
                holder.imageView.setImageResource(R.drawable.books);
                break;
            case "Charity":
                holder.imageView.setImageResource(R.drawable.love);
                break;
            case "Apparel":
                holder.imageView.setImageResource(R.drawable.cloth);
                break;
            case "Health":
                holder.imageView.setImageResource(R.drawable.drugs);
                break;
            case "Personal":
                holder.imageView.setImageResource(R.drawable.man);
                break;
            case "Other":
                holder.imageView.setImageResource(R.drawable.more);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return myDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView item, amount, date, notes;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            item = itemView.findViewById(R.id.item);
            amount = itemView.findViewById(R.id.amount);
            date = itemView.findViewById(R.id.date);
            notes = itemView.findViewById(R.id.note);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
