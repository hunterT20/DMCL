package com.hunterit.dmcl.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hunterit.dmcl.R;
import com.hunterit.dmcl.model.ItemIndex;

import java.util.List;

public class IndexAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layout;
    private List<ItemIndex> itemList;

    public IndexAdapter(Context context, List<ItemIndex> khoList) {
        this.context = context;
        this.itemList = khoList;
        layout = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = layout.inflate(R.layout.item_listmain, null);
            holder = new ViewHolder();
            holder.txtvTitleTang = view.findViewById(R.id.txtvTitleTang);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        ItemIndex itemIndex = itemList.get(i);

        holder.txtvTitleTang.setText(itemIndex.getTitle());
        return view;
    }

    private static class ViewHolder {
        TextView txtvTitleTang;
    }
}
