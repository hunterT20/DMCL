package com.hunterit.dmcl.view.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hunterit.dmcl.R;
import com.hunterit.dmcl.model.Product;
import com.hunterit.dmcl.util.RecyclerViewHorizontalUtil;
import com.hunterit.dmcl.view.adapter.ItemProductAdapter;
import com.hunterit.dmcl.view.adapter.SliderMainAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 */
public class TongQuanFragment extends Fragment {
    private ViewPager viewPager;
    private SliderMainAdapter sliderMainAdapter;
    private CircleIndicator circleIndicator;
    private RecyclerView rcvProductTongQuan;

    int[] img;
    private static int currentPage = 0;
    private static int numberPage = 0;
    private List<Product> productList;

    public TongQuanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tong_quan, container, false);
        img =  new int[]{R.drawable.tongquan1,R.drawable.tongquan1,R.drawable.tongquan1,R.drawable.tongquan1};
        addViews(view);
        return view;
    }

    private void addViews(View view) {
        viewPager = view.findViewById(R.id.viewPager);
        circleIndicator = view.findViewById(R.id.indicator);
        sliderMainAdapter = new SliderMainAdapter(img, getActivity());
        rcvProductTongQuan = view.findViewById(R.id.rcvProductTongQuan);

        viewPager.setAdapter(sliderMainAdapter);
        circleIndicator.setViewPager(viewPager);

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
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    int pageCount = img.length;
                    if (currentPage == 0) {
                        viewPager.setCurrentItem(pageCount - 1, false);
                    } else if (currentPage == pageCount - 1) {
                        viewPager.setCurrentItem(0, false);
                    }
                }
            }
        });

        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == numberPage) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        Timer swipe = new Timer();
        swipe.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 3000, 1000);

        productList = new ArrayList<>();

        RecyclerViewHorizontalUtil.setupRecyclerView(
                rcvProductTongQuan,
                new ItemProductAdapter(productList, getActivity()),getActivity()
        );

        Product product = new Product("Smart Tivi LED SAMSUNG 43 Inch UA43K5300AKXXV",36000000,3400000);
        Product product1 = new Product("Smart Tivi LED SAMSUNG 43 Inch UA43K5300AKXXV",36000000,3400000);
        Product product2 = new Product("Smart Tivi LED SAMSUNG 43 Inch UA43K5300AKXXV",36000000,3400000);
        Product product3 = new Product("Smart Tivi LED SAMSUNG 43 Inch UA43K5300AKXXV",36000000,3400000);
        productList.add(product);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        ItemProductAdapter adapter = new ItemProductAdapter(productList, getActivity());
        rcvProductTongQuan.setAdapter(adapter);
    }

}
