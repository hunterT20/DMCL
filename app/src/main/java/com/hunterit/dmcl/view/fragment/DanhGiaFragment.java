package com.hunterit.dmcl.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hunterit.dmcl.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DanhGiaFragment extends Fragment {


    public DanhGiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_danh_gia, container, false);
    }

}
