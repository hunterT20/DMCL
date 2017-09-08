package com.hunterit.dmcl.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.hunterit.dmcl.R;
import com.hunterit.dmcl.view.fragment.ThongTinKTFragment;
import com.hunterit.dmcl.view.adapter.ViewPagerAdapter;
import com.hunterit.dmcl.view.fragment.TongQuanFragment;

public class ChiTietSPActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_sp);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() == null) return;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Chi tiết sản phẩm");

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TongQuanFragment(), "Tổng quan");
        adapter.addFragment(new ThongTinKTFragment(), "Về sản phẩm");
        adapter.addFragment(new ThongTinKTFragment(), "Thông số kĩ thuật");
        viewPager.setAdapter(adapter);
    }
}
