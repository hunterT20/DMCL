package com.hunterit.dmcl.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hunterit.dmcl.R;
import com.hunterit.dmcl.model.Product;
import com.hunterit.dmcl.util.NumberTextWatcherForThousand;
import com.hunterit.dmcl.view.activity.ChiTietSPActivity;

import java.util.List;


public class ItemSearchAdapter extends BaseAdapter {
    private List<Product> list;
    private Context context;
    private LayoutInflater layoutInflater;

    public ItemSearchAdapter(List<Product> list, Context context) {
        this.list = list;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_rcv_main, null);
            holder = new ViewHolder();
            holder.txtvNameProduct = view.findViewById(R.id.txtvNameProduct);
            holder.txtvPrice = view.findViewById(R.id.txtvPrice);
            holder.txtvPriceDel = view.findViewById(R.id.txtvPriceDel);
            holder.imgItemProduct = view.findViewById(R.id.imgItemProduct);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Product product = list.get(i);

        holder.txtvNameProduct.setText(product.getName());
        holder.txtvPrice.setText(String.format("%sđ", NumberTextWatcherForThousand.getDecimalFormattedString(String.valueOf(product.getPrice()))));
        holder.txtvPriceDel.setText(String.format("%sđ", NumberTextWatcherForThousand.getDecimalFormattedString(String.valueOf(product.getPriceDel()))));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChiTietSPActivity.class);
                context.startActivity(intent);
            }
        });

        return view;
    }

    private class ViewHolder{
        private ImageView imgItemProduct;
        private TextView txtvNameProduct,txtvPrice,txtvPriceDel;
    }
}
