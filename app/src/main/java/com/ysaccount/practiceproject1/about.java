package com.ysaccount.practiceproject1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.os.Bundle;

/*
Date & Version:2016-10-16 V1.2.0
Program Name: PracticeProject1.about
Programer: Taylor
Note: This project for practice the Tutorial
基礎練習 包含以下內容
Activity元件的開發與設定方式，並瞭解關於Activity元件的生命週期概念，還有Activity元件之間的互動與資料傳輸
1. New about activity show程式資訊
1-1  Java Class
從AppCompatActivity改為Activity
requestWindowFeature(Window.FEATURE_NO_TITLE);取消元件的應用程式標題
1-2  about.XML加入text,ok button
1-3  AndroidManifest.xml加上"@android:style/Theme.Dialog"
android:theme="@android:style/Theme.Dialog"
*/

// 從AppCompatActivity改為Activity
public class about extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 取消元件的應用程式標題
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_about);
    }

    // 結束按鈕
    public void clickOk(View view) {
        // 呼叫這個方法結束Activity元件
        finish();
    }
}
