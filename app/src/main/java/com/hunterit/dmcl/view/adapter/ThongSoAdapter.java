package com.hunterit.dmcl.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hunterit.dmcl.R;
import com.hunterit.dmcl.model.ItemThongSo;

import java.util.List;

public class ThongSoAdapter extends BaseAdapter{
    private Context context;
    private LayoutInflater layout;
    private List<ItemThongSo> itemThongSos;

    public ThongSoAdapter(Context context, List<ItemThongSo> itemThongSos) {
        this.context = context;
        this.itemThongSos = itemThongSos;
        this.layout = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemThongSos.size();
    }

    @Override
    public Object getItem(int i) {
        return itemThongSos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = layout.inflate(R.layout.item_thongso, null);
            holder = new ViewHolder();
            holder.txtvNameThongSO = view.findViewById(R.id.txtvNameThongSO);
            holder.txtvValueThongSo = view.findViewById(R.id.txtvValueThongSo);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        ItemThongSo itemThongSo = itemThongSos.get(i);

        holder.txtvNameThongSO.setText(itemThongSo.getTitle());
        holder.txtvValueThongSo.setText(itemThongSo.getThongSo());
        return view;
    }

    private static class ViewHolder {
        TextView txtvNameThongSO;
        TextView txtvValueThongSo;
    }
}
