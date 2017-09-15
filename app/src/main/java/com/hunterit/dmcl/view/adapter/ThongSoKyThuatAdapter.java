package com.hunterit.dmcl.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.hunterit.dmcl.R;
import com.hunterit.dmcl.model.ItemThongSo;
import com.hunterit.dmcl.model.ItemThongTinKyThuat;

import java.util.List;

public class ThongSoKyThuatAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<ItemThongTinKyThuat> thongTinKyThuats;

    public ThongSoKyThuatAdapter(Context context, List<ItemThongTinKyThuat> thongTinKyThuats) {
        this.context = context;
        this.thongTinKyThuats = thongTinKyThuats;
    }

    @Override
    public int getGroupCount() {
        return thongTinKyThuats.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return thongTinKyThuats.get(i).getItemThongSoList().size();
    }

    @Override
    public Object getGroup(int i) {
        return thongTinKyThuats.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return thongTinKyThuats.get(i).getItemThongSoList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        ItemThongTinKyThuat itemThongTinKyThuat = thongTinKyThuats.get(i);
        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.item_thongtin_kythuat, null);
        }

        TextView txtvTitleThongSO = view.findViewById(R.id.txtvTitleThongSo);

        txtvTitleThongSO.setText(itemThongTinKyThuat.getTitleThongSoKyThuat());

        return view;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ItemThongSo itemKM = (ItemThongSo) getChild(i,i1);
        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.item_thongso, null);
        }

        TextView txtvNameThongSO = view.findViewById(R.id.txtvNameThongSO);
        TextView txtvValueThongSo = view.findViewById(R.id.txtvValueThongSo);

        txtvNameThongSO.setText(itemKM.getTitle());
        txtvValueThongSo.setText(itemKM.getThongSo());

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
