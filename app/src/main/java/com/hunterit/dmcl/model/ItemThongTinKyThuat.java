package com.hunterit.dmcl.model;

import java.util.List;

public class ItemThongTinKyThuat {
    private String TitleThongSoKyThuat;
    private List<ItemThongSo> itemThongSoList;

    public ItemThongTinKyThuat(String titleThongSoKyThuat, List<ItemThongSo> itemThongSoList) {
        TitleThongSoKyThuat = titleThongSoKyThuat;
        this.itemThongSoList = itemThongSoList;
    }

    public ItemThongTinKyThuat() {
    }

    public String getTitleThongSoKyThuat() {
        return TitleThongSoKyThuat;
    }

    public void setTitleThongSoKyThuat(String titleThongSoKyThuat) {
        TitleThongSoKyThuat = titleThongSoKyThuat;
    }

    public List<ItemThongSo> getItemThongSoList() {
        return itemThongSoList;
    }

    public void setItemThongSoList(List<ItemThongSo> itemThongSoList) {
        this.itemThongSoList = itemThongSoList;
    }
}
