package com.hunterit.dmcl.model;

import java.util.List;

public class ItemDanhGia {
    private String tenKhachHangDanhGia;
    private String thoiGianDanhGia;
    private String DanhGia;
    private List<ItemDanhGia> traloiList;

    public ItemDanhGia(String tenKhachHangDanhGia, String thoiGianDanhGia, String danhGia, List<ItemDanhGia> traloiList) {
        this.tenKhachHangDanhGia = tenKhachHangDanhGia;
        this.thoiGianDanhGia = thoiGianDanhGia;
        DanhGia = danhGia;
        this.traloiList = traloiList;
    }

    public ItemDanhGia() {
    }

    public String getTenKhachHangDanhGia() {
        return tenKhachHangDanhGia;
    }

    public void setTenKhachHangDanhGia(String tenKhachHangDanhGia) {
        this.tenKhachHangDanhGia = tenKhachHangDanhGia;
    }

    public String getThoiGianDanhGia() {
        return thoiGianDanhGia;
    }

    public void setThoiGianDanhGia(String thoiGianDanhGia) {
        this.thoiGianDanhGia = thoiGianDanhGia;
    }

    public String getDanhGia() {
        return DanhGia;
    }

    public void setDanhGia(String danhGia) {
        DanhGia = danhGia;
    }

    public List<ItemDanhGia> getTraloiList() {
        return traloiList;
    }

    public void setTraloiList(List<ItemDanhGia> traloiList) {
        this.traloiList = traloiList;
    }
}
