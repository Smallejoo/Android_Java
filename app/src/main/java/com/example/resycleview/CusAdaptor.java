package com.example.resycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CusAdaptor extends RecyclerView.Adapter<CusAdaptor.ViewHolder> {
    ArrayList<DataModule> Data;
    public CusAdaptor (ArrayList<DataModule> data)
    {
        this.Data=data;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView Text1;
        TextView Text2;
        ImageView Image1;
        public ViewHolder(@NonNull View View) {
            super(View);
            Text1=View.findViewById(R.id.Text1);
            Text2=View.findViewById(R.id.Text2);
            Image1=View.findViewById(R.id.Image);
        }
    }
    @NonNull
    @Override
    public CusAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CusAdaptor.ViewHolder holder, int position) {

        TextView text1=holder.Text1;
        TextView text2=holder.Text2;
        ImageView image=holder.Image1;

        text1.setText(Data.get(position).getName());
        text2.setText(Data.get(position).getDescription());
        image.setImageResource(Data.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return Data.size();
    }
}
