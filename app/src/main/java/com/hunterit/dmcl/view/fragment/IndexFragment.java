package com.hunterit.dmcl.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.hunterit.dmcl.R;
import com.hunterit.dmcl.model.ItemIndex;
import com.hunterit.dmcl.model.Product;
import com.hunterit.dmcl.view.adapter.IndexAdapter;
import com.hunterit.dmcl.view.adapter.SliderMainAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class IndexFragment extends Fragment {
    private ImageView imgSlider;
    private ListView lvIndex;

    private ViewPager viewPager;
    private SliderMainAdapter sliderMainAdapter;
    private CircleIndicator circleIndicator;
    private TextView txtvTinKhuyenMai;
    private TextView txtvMuaTraGop;
    private TextView txtvTheThanhVien;
    int[] img;
    private static int currentPage = 0;
    private static int numberPage = 0;

    public IndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_index, container, false);
        img =  new int[]{R.drawable.slide,R.drawable.slide,R.drawable.slide,R.drawable.slide,R.drawable.slide};
        addViews(view);
        return view;
    }

    private void addViews(final View view) {
        View headerView = ((LayoutInflater) getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.header_listmain, null, false);
        viewPager = headerView.findViewById(R.id.viewPager);
        txtvTinKhuyenMai = headerView.findViewById(R.id.txtvTinKhuyenMai);
        txtvMuaTraGop = headerView.findViewById(R.id.txtvMuaTraGop);
        txtvTheThanhVien = headerView.findViewById(R.id.txtvTheThanhVien);
        circleIndicator = headerView.findViewById(R.id.indicator);
        sliderMainAdapter = new SliderMainAdapter(img,getActivity());

        viewPager.setAdapter(sliderMainAdapter);
        circleIndicator.setViewPager(viewPager);

        lvIndex = view.findViewById(R.id.lvIndex);
        lvIndex.addHeaderView(headerView,null,false);

        List<Product> productList = new ArrayList<>();
        Product product = new Product("Smart Tivi LED SAMSUNG 43 Inch UA43K5300AKXXV",36000000,3400000);
        Product product1 = new Product("Smart Tivi LED SAMSUNG 43 Inch UA43K5300AKXXV",36000000,3400000);
        Product product2 = new Product("Smart Tivi LED SAMSUNG 43 Inch UA43K5300AKXXV",36000000,3400000);
        Product product3 = new Product("Smart Tivi LED SAMSUNG 43 Inch UA43K5300AKXXV",36000000,3400000);
        productList.add(product);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        List<ItemIndex> list = new ArrayList<>();
        ItemIndex itemIndex1 = new ItemIndex("Khuyến mãi",productList);
        ItemIndex itemIndex2 = new ItemIndex("Điện tử",productList);
        ItemIndex itemIndex3 = new ItemIndex("Điện lạnh",productList);
        ItemIndex itemIndex4 = new ItemIndex("Di động - Tablet",productList);
        ItemIndex itemIndex5 = new ItemIndex("Gia dụng",productList);
        ItemIndex itemIndex6 = new ItemIndex("Viễn thông - Laptop",productList);
        ItemIndex itemIndex7 = new ItemIndex("Nội thất",productList);
        ItemIndex itemIndex8 = new ItemIndex("Đối tác - Dịch vụ",productList);

        list.add(itemIndex1);
        list.add(itemIndex2);
        list.add(itemIndex3);
        list.add(itemIndex4);
        list.add(itemIndex5);
        list.add(itemIndex6);
        list.add(itemIndex7);
        list.add(itemIndex8);

        IndexAdapter indexAdapter = new IndexAdapter(getActivity(),list);

        lvIndex.setAdapter(indexAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE){
                    int pageCount = img.length;
                    if (currentPage == 0){
                        viewPager.setCurrentItem(pageCount-1, false);
                    }else if (currentPage == pageCount -1){
                        viewPager.setCurrentItem(0,false);
                    }
                }
            }
        });

        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == numberPage){
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        Timer swipe =  new Timer();
        swipe.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },3000,1000);
    }

}
