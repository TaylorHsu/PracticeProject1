package com.ysaccount.practiceproject1;

import android.graphics.Color;

/**
 * Created by 宏暉 on 2016/10/17.
 * 一般的物件封裝作法可以讓程式碼比較簡潔一些。這個應用程式需要管理所有的記事資料，
 * 所以應該為應用程式新增一個封裝記事資料的類別。
 * 因為希望可以為每一個記事資料加入顏色設定的功能，所以先建立一個封裝顏色資料的類別
 */

public enum color {

    LIGHTGREY("#D3D3D3"), BLUE("#33B5E5"), PURPLE("#AA66CC"),
    GREEN("#99CC00"), ORANGE("#FFBB33"), RED("#FF4444");

    private String code;

    private color(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public int parseColor() {
        return Color.parseColor(code);
    }
}
