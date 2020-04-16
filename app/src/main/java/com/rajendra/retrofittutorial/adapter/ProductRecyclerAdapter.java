package com.rajendra.retrofittutorial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rajendra.retrofittutorial.R;
import com.rajendra.retrofittutorial.model.Products;

import java.util.List;

public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.ProductViewHolder> {

    private List<Products> productsList;
    private Context context;

    public ProductRecyclerAdapter(List<Products> productsList, Context context) {
        this.productsList = productsList;
        this.context = context;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycler_row_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        holder.name.setText(productsList.get(position).getName());
        holder.price.setText(productsList.get(position).getPrice());
        holder.qty.setText(productsList.get(position).getQuantity());
        holder.unit.setText(productsList.get(position).getUnit());

        //for image wee need to add a library for fetching image from server

        Glide.with(context).load(productsList.get(position).getImageUrl()).into(holder.productImage);

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }


    static  class  ProductViewHolder extends  RecyclerView.ViewHolder{

        ImageView productImage;
        TextView name, price, qty, unit;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.imageView2);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            qty = itemView.findViewById(R.id.quantity);
            unit = itemView.findViewById(R.id.unit);
        }
    }
}
