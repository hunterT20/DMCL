package com.hunterit.dmcl.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hunterit.dmcl.R;
import com.hunterit.dmcl.model.ItemDanhGia;

import java.util.List;

import static com.hunterit.dmcl.R.color.colorItemTraLoi;

public class ItemDanhGiaChildAdapter extends BaseAdapter {
    private List<ItemDanhGia> list;
    private Context context;
    private LayoutInflater layoutInflater;

    public ItemDanhGiaChildAdapter(List<ItemDanhGia> list, Context context) {
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
            view = layoutInflater.inflate(R.layout.item_child_danhgia, null);
            holder = new ViewHolder();
            holder.txtvNameKhachHangDanhGia = view.findViewById(R.id.txtvNameKhachHangDanhGia);
            holder.txtvThoiGianDanhGia = view.findViewById(R.id.txtvThoiGianDanhGia);
            holder.txtvDanhGia = view.findViewById(R.id.txtvDanhGia);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        ItemDanhGia itemDanhGia = list.get(i);

        holder.txtvNameKhachHangDanhGia.setText(itemDanhGia.getTenKhachHangDanhGia());
        holder.txtvThoiGianDanhGia.setText(itemDanhGia.getThoiGianDanhGia());
        holder.txtvDanhGia.setText(itemDanhGia.getDanhGia());
        view.setBackgroundColor(context.getResources().getColor(colorItemTraLoi));
        return view;
    }

    private class ViewHolder{
        private TextView txtvNameKhachHangDanhGia,txtvThoiGianDanhGia,txtvDanhGia;
    }
}
