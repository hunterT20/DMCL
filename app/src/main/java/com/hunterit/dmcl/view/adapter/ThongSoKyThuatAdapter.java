package com.hunterit.dmcl.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.hunterit.dmcl.R;
import com.hunterit.dmcl.model.ItemThongTinKyThuat;

import java.util.List;

public class ThongSoKyThuatAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layout;
    private List<ItemThongTinKyThuat> itemThongSos;

    public ThongSoKyThuatAdapter(Context context, List<ItemThongTinKyThuat> itemThongSos) {
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
            view = layout.inflate(R.layout.item_thongtin_kythuat, null);
            holder = new ViewHolder();
            holder.txtvTitleThongSo = view.findViewById(R.id.txtvTitleThongSo);
            holder.lvThongSo = view.findViewById(R.id.lvThongSo);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        ItemThongTinKyThuat itemThongSo = itemThongSos.get(i);

        holder.txtvTitleThongSo.setText(itemThongSo.getTitleThongSoKyThuat());
        ThongSoAdapter adapter = new ThongSoAdapter(context,itemThongSo.getItemThongSoList());
        holder.lvThongSo.setAdapter(adapter);
        return view;
    }

    private class ViewHolder{
        TextView txtvTitleThongSo;
        ListView lvThongSo;
    }
}
