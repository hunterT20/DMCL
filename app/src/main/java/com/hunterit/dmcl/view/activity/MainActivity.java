package com.hunterit.dmcl.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.hunterit.dmcl.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_chinhanh:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_giohang:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_goi:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_sanpham:
                    mTextMessage.setText("Sản phẩm");
                    return true;
                case R.id.navigation_taikhoan:
                    mTextMessage.setText("Tài khoản");
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
