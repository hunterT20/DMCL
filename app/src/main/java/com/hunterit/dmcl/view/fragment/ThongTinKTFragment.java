package com.hunterit.dmcl.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.hunterit.dmcl.R;
import com.hunterit.dmcl.model.ItemThongSo;
import com.hunterit.dmcl.model.ItemThongTinKyThuat;
import com.hunterit.dmcl.view.adapter.ThongSoKyThuatAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.facebook.login.widget.ProfilePictureView.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThongTinKTFragment extends Fragment {
    private ListView lvThongSoKyThuat;

    public ThongTinKTFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_thong_tin_kt, container, false);
        addViews(view);
        return view;
    }

    private void addViews(View view) {
        lvThongSoKyThuat = view.findViewById(R.id.lvThongSoKyThuat);

        List<ItemThongSo> thongSoListTongQuan = new ArrayList<>();
        ItemThongSo itemThongSoTongQuan = new ItemThongSo("Loại điện thoại","SmartPhone");
        thongSoListTongQuan.add(itemThongSoTongQuan);

        List<ItemThongSo> thongSoListSim = new ArrayList<>();
        ItemThongSo itemThongSoSim1 = new ItemThongSo("Loại Sim","Nano SIM");
        ItemThongSo itemThongSoSim2 = new ItemThongSo("Số Sim","2 Sim");
        thongSoListSim.add(itemThongSoSim1);
        thongSoListSim.add(itemThongSoSim2);
        thongSoListSim.add(itemThongSoSim2);

        List<ItemThongTinKyThuat> kyThuatList = new ArrayList<>();
        ItemThongTinKyThuat itemThongTinKyThuatTongQuan = new ItemThongTinKyThuat("Tổng Quan",thongSoListTongQuan);
        ItemThongTinKyThuat itemThongTinKyThuatSim = new ItemThongTinKyThuat("Sim", thongSoListSim);

        kyThuatList.add(itemThongTinKyThuatTongQuan);
        kyThuatList.add(itemThongTinKyThuatSim);

        ThongSoKyThuatAdapter adapter = new ThongSoKyThuatAdapter(getActivity(),kyThuatList);
        lvThongSoKyThuat.setAdapter(adapter);
    }

}
