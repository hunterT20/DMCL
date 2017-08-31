package com.hunterit.dmcl.view.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.hunterit.dmcl.R;
import com.hunterit.dmcl.view.fragment.IndexFragment;
import com.hunterit.dmcl.view.fragment.LoginFragment;

public class ContentMain extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_chinhanh:

                    return true;
                case R.id.navigation_giohang:

                    return true;
                case R.id.navigation_goi:

                    return true;
                case R.id.navigation_sanpham:

                    return true;
                case R.id.navigation_taikhoan:
                    callFragment(new LoginFragment(),"Đăng nhập");
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        addViews();
    }

    private void addViews() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        callFragment(new LoginFragment(),"Trang chủ");
    }

    public void callFragment(Fragment fragment, String title) {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.frmContent, fragment)
                .commit();
        if (getSupportActionBar() == null) return;
        getSupportActionBar().setTitle(title);
    }

}
