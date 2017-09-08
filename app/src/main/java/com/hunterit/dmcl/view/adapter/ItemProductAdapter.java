package com.hunterit.dmcl.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hunterit.dmcl.R;
import com.hunterit.dmcl.model.Product;
import com.hunterit.dmcl.util.NumberTextWatcherForThousand;
import com.hunterit.dmcl.view.activity.ChiTietSPActivity;

import java.util.List;

public class ItemProductAdapter extends RecyclerView.Adapter<ItemProductAdapter.ItemSearchViewHolder> {
    private List<Product> listItems;
    private LayoutInflater mLayoutInflater;
    private Context context;

    public ItemProductAdapter(List<Product> listItems, Context context) {
        this.listItems = listItems;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public ItemSearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_rcv_main,parent,false);
        return new ItemSearchViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ItemSearchViewHolder holder, int position) {
        final Product pro = listItems.get(position);

        holder.txtvNameProduct.setText(pro.getName());
        holder.txtvPrice.setText(NumberTextWatcherForThousand.getDecimalFormattedString(String.valueOf(pro.getPrice())) + "đ");
        holder.txtvPriceDel.setText(NumberTextWatcherForThousand.getDecimalFormattedString(String.valueOf(pro.getPriceDel())) + "đ");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChiTietSPActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    class ItemSearchViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgItemProduct;
        private TextView txtvNameProduct,txtvPrice,txtvPriceDel;
        ItemSearchViewHolder(View itemView) {
            super(itemView);
            txtvNameProduct = itemView.findViewById(R.id.txtvNameProduct);
            txtvPriceDel = itemView.findViewById(R.id.txtvPriceDel);
            txtvPrice = itemView.findViewById(R.id.txtvPrice);
            imgItemProduct = itemView.findViewById(R.id.imgItemProduct);
        }
    }
}
