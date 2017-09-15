package com.hunterit.dmcl.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
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
    private ExpandableListView lvThongSoKyThuat;

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

        List<ItemThongSo> thongSoListManHinh = new ArrayList<>();
        ItemThongSo itemThongSoManHinh1 = new ItemThongSo("Kích Thước Màn Hình", "6.3inch");
        ItemThongSo itemThongSoManHinh2 = new ItemThongSo("Loại màn hình", "Super AMOLED");
        ItemThongSo itemThongSoManHinh3 = new ItemThongSo("Màu màn hình", "16 triệu màu");
        ItemThongSo itemThongSoManHinh4 = new ItemThongSo("Độ phân giải", "1440 x 2960 Pixels");
        ItemThongSo itemThongSoManHinh5 = new ItemThongSo("Công nghệ cảm ứng", "Cảm ứng điện dung đa điểm");
        thongSoListManHinh.add(itemThongSoManHinh1);
        thongSoListManHinh.add(itemThongSoManHinh2);
        thongSoListManHinh.add(itemThongSoManHinh3);
        thongSoListManHinh.add(itemThongSoManHinh4);
        thongSoListManHinh.add(itemThongSoManHinh5);

        List<ItemThongSo> thongSoListCPU = new ArrayList<>();
        ItemThongSo itemThongSoCPU1 = new ItemThongSo("Hệ điều hành","Android 7.1 (Nougat)");
        ItemThongSo itemThongSoCPU2 = new ItemThongSo("Tốc độ CPU","4 x 2.3GHz + 4 x 1.7GHz");
        ItemThongSo itemThongSoCPU3 = new ItemThongSo("Số nhân","8 nhân 64Bit");
        thongSoListCPU.add(itemThongSoCPU1);
        thongSoListCPU.add(itemThongSoCPU2);
        thongSoListCPU.add(itemThongSoCPU3);

        List<ItemThongTinKyThuat> kyThuatList = new ArrayList<>();
        ItemThongTinKyThuat itemThongTinKyThuatTongQuan = new ItemThongTinKyThuat("Tổng Quan",thongSoListTongQuan);
        ItemThongTinKyThuat itemThongTinKyThuatSim      = new ItemThongTinKyThuat("Sim", thongSoListSim);
        ItemThongTinKyThuat itemThongTinKyThuatManHinh  = new ItemThongTinKyThuat("Màn Hình", thongSoListManHinh);
        ItemThongTinKyThuat itemThongTinKyThuatCPU      = new ItemThongTinKyThuat("CPU", thongSoListCPU);

        kyThuatList.add(itemThongTinKyThuatTongQuan);
        kyThuatList.add(itemThongTinKyThuatSim);
        kyThuatList.add(itemThongTinKyThuatManHinh);
        kyThuatList.add(itemThongTinKyThuatCPU);

        ThongSoKyThuatAdapter adapter = new ThongSoKyThuatAdapter(getActivity(),kyThuatList);
        lvThongSoKyThuat.setAdapter(adapter);
        for (int i = 0; i < kyThuatList.size(); i++){
            lvThongSoKyThuat.expandGroup(i);
        }
    }

}
