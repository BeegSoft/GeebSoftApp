package com.tecnologiasintech.geebsoftapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Sergio on 1/18/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView nameTxt;
    ItemClickListener itemClickListener;

    public MyViewHolder(View itemView) {
        super(itemView);

        nameTxt = (TextView) itemView.findViewById(R.id.nameTxt);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener=itemClickListener;
    }
    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClick(this.getLayoutPosition());
    }
}
