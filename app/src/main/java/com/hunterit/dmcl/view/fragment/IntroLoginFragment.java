package com.hunterit.dmcl.view.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hunterit.dmcl.R;
import com.hunterit.dmcl.view.activity.LoginActivity;
import com.hunterit.dmcl.view.adapter.SliderMainAdapter;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.relex.circleindicator.CircleIndicator;

import static com.facebook.login.widget.ProfilePictureView.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroLoginFragment extends Fragment {
    @BindView(R.id.viewPager) ViewPager viewPager;
    private SliderMainAdapter sliderMainAdapter;
    @BindView(R.id.indicator) CircleIndicator circleIndicator;
    @BindView(R.id.layout_button_intro) LinearLayout layout_button_intro;

    int[] img;
    private static int currentPage = 0;
    private static int numberPage = 0;


    public IntroLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_intro_login, container, false);
        ButterKnife.bind(this,view);
        img =  new int[]{R.drawable.intro,R.drawable.intro,R.drawable.intro,R.drawable.intro,R.drawable.intro};
        addViews(view);
        return view;
    }

    @OnClick(R.id.btnLogin_intro)
    public void loginOnClick(){
        ((LoginActivity)getActivity()).callFragment(new LoginFragment());
    }

    private void addViews(View view) {
        ((LoginActivity)getActivity()).getToolbar().setVisibility(View.GONE);

        layout_button_intro = view.findViewById(R.id.layout_button_intro);
        sliderMainAdapter = new SliderMainAdapter(img, getActivity());

        viewPager.setAdapter(sliderMainAdapter);
        circleIndicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                layout_button_intro.setVisibility(position == 4 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
