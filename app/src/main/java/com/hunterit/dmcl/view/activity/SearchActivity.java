package com.hunterit.dmcl.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;

import com.hunterit.dmcl.R;
import com.hunterit.dmcl.model.Product;
import com.hunterit.dmcl.view.adapter.ItemSearchAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private GridView grvSearch;
    private EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        addViews();
    }

    private void addViews() {
        grvSearch = (GridView) findViewById(R.id.grvSearch);
        edtSearch = (EditText) findViewById(R.id.edtSearch);
        List<Product> list = new ArrayList<>();
        Product product = new Product("Smart Tivi LED SAMSUNG 43 Inch UA43K5300AKXXV",36000000,3400000);
        list.add(product);
        list.add(product);
        list.add(product);
        list.add(product);
        list.add(product);
        list.add(product);
        list.add(product);
        list.add(product);
        list.add(product);
        list.add(product);

        ItemSearchAdapter adapter = new ItemSearchAdapter(list, this);

        grvSearch.setAdapter(adapter);

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                grvSearch.setVisibility(editable.length() > 0 ? View.VISIBLE : View.GONE);
            }
        });
    }
}
