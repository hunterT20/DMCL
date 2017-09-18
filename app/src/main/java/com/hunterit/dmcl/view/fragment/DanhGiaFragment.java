package com.hunterit.dmcl.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.hunterit.dmcl.R;
import com.hunterit.dmcl.model.ItemDanhGia;
import com.hunterit.dmcl.view.adapter.ItemDanhGiaParentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DanhGiaFragment extends Fragment {
    private ListView lvDanhGia;

    public DanhGiaFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_danh_gia, container, false);
        addViews(view);
        return view;
    }

    private void addViews(View view) {
        lvDanhGia = view.findViewById(R.id.lvDanhGia);
        List<ItemDanhGia> listTraLoi1 = new ArrayList<>();
        ItemDanhGia itemTraLoi1 = new ItemDanhGia("Quản trị viên","2 giờ trước","Chào bạn!Sản phẩm này hiện không tặng gì thêm. Hiện chi nhánh Vũng Tàu có hàng, bạn có thể đến chi nhánh mua hàng. Nếu bạn ở thành phố Vũng Tàu thì có thể đặt hàng online rồi chi nhánh sẽ giao đến nhà cho bạn.Thân chào!",null);
        listTraLoi1.add(itemTraLoi1);

        List<ItemDanhGia> listDanhGia = new ArrayList<>();
        ItemDanhGia itemDanhGia1 = new ItemDanhGia("Ngô Thanh Tuấn","1 ngày trước","Sản phẩm này hiện còn hàng không? Và có khuyến mãi gì không ạ?",listTraLoi1);

        listDanhGia.add(itemDanhGia1);
        listDanhGia.add(itemDanhGia1);
        listDanhGia.add(itemDanhGia1);
        listDanhGia.add(itemDanhGia1);

        ItemDanhGiaParentAdapter adapter = new ItemDanhGiaParentAdapter(listDanhGia,getActivity());
        lvDanhGia.setAdapter(adapter);
    }

}
