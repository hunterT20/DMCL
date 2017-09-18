package com.hunterit.dmcl.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.hunterit.dmcl.R;
import com.hunterit.dmcl.model.ItemDanhGia;

import java.util.List;

public class ItemDanhGiaParentAdapter extends BaseAdapter {
    private List<ItemDanhGia> list;
    private Context context;
    private LayoutInflater layoutInflater;

    public ItemDanhGiaParentAdapter(List<ItemDanhGia> list, Context context) {
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
            view = layoutInflater.inflate(R.layout.item_parent_danhgia, null);
            holder = new ViewHolder();
            holder.txtvNameKhachHangDanhGia = view.findViewById(R.id.txtvNameKhachHangDanhGia);
            holder.txtvThoiGianDanhGia = view.findViewById(R.id.txtvThoiGianDanhGia);
            holder.txtvDanhGia = view.findViewById(R.id.txtvDanhGia);
            holder.lvTraloi = view.findViewById(R.id.lvTraloi);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        ItemDanhGia itemDanhGia = list.get(i);

        holder.txtvNameKhachHangDanhGia.setText(itemDanhGia.getTenKhachHangDanhGia());
        holder.txtvThoiGianDanhGia.setText(itemDanhGia.getThoiGianDanhGia());
        holder.txtvDanhGia.setText(itemDanhGia.getDanhGia());
        ItemDanhGiaChildAdapter adapter = new ItemDanhGiaChildAdapter(itemDanhGia.getTraloiList(), context);
        holder.lvTraloi.setAdapter(adapter);
        return view;
    }

    private class ViewHolder{
        private TextView txtvNameKhachHangDanhGia,txtvThoiGianDanhGia,txtvDanhGia;
        private ListView lvTraloi;
    }
}
