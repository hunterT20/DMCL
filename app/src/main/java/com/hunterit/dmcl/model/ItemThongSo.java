package com.hunterit.dmcl.model;

public class ItemThongSo {
    private String Title;
    private String ThongSo;

    public ItemThongSo(String title, String thongSo) {
        Title = title;
        ThongSo = thongSo;
    }

    public ItemThongSo() {
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getThongSo() {
        return ThongSo;
    }

    public void setThongSo(String thongSo) {
        ThongSo = thongSo;
    }
}
