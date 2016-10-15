package com.ysaccount.practiceproject1;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

/*
Date & Version:2016-10-15 V1.1.0
Program Name: PracticeProject1
Programer: Taylor
Note: This project for practice the Tutorial
基礎練習 包含以下內容
1.values practice for Multi-Locale Language
    New -> Values resources file -> strings
          1)  Availiable qualifliers => Locale => Any Region
          2)  建立英文文字資源檔
          3)  當模擬器設定文字語言為英文時.可顯示對應文字
2.啟動圖示 icon設定
3.Layout Practice
4.假如出現Cannot resolve symbol R
  代表貼了新圖片or元件進來,但圖片沒進來,編譯器不通了
  解決方法:Build->Clean Project or Rebuild Project
5.Create Menu on toolbar
  1).add menu resource XML
  2).add Menu in java class onCreateOptionsMenu
  3).Xml設置clickMenuItem為按下Menu Item所呼叫的方法
  4).Java Class加上"clickMenuItem" function
    使用參數取得使用者選擇的選單項目元件編號
        int itemId = item.getItemId();
    依據itemId判斷該執行什麼工作
    彈出AlertDialog顯示當前行為

6.動態建立ListView
  1).add ListView in resource XML
  2).Java Class 加入Array資料 for List View
     宣告 ListView,String array,Adapter
  3).processViews =>取得畫面元件變數指給欄位變數
     EX: item_list = (ListView)findViewById(R.id.item_list);
  4).processControllers  宣告或建立需要的監聽物件並執行所有需要的註冊工作
     AdapterView.OnItemClickListener{
     ...
       onItemClick funtion{}
     }

     OnItemLongClickListener{
     ...

*/

public class MainActivity extends AppCompatActivity {
    private ListView item_list;
    // 增加「final」關鍵字，讓巢狀類別中的程式碼使用
    private static final String[] data = {
            "List View Item_1",
            "List View Item_2",
            "List View Item_3"};
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processViews();  //在這個方法中，取得畫面元件物件後指定給欄位變數
        processControllers();   // 在這個方法中，宣告或建立需要的監聽物件並執行所有需要的註冊工作

        int ListViewID = android.R.layout.simple_list_item_1;
        adapter = new ArrayAdapter <> (this, ListViewID, data);
        item_list.setAdapter(adapter);
    }

    private void processViews() {
        item_list = (ListView)findViewById(R.id.item_list);
    }

    private void processControllers() {
        // 建立選單項目點擊監聽物件
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            // 第一個參數是使用者操作的ListView物件
            // 第二個參數是使用者選擇的項目
            // 第三個參數是使用者選擇的項目編號，第一個是0
            // 第四個參數在這裡沒有用途
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Toast.makeText(MainActivity.this,
                        data[position], Toast.LENGTH_LONG).show();
            }
        };

        // 註冊選單項目點擊監聽物件
        item_list.setOnItemClickListener(itemListener);

        // 建立選單項目長按監聽物件
        AdapterView.OnItemLongClickListener itemLongListener = new AdapterView.OnItemLongClickListener() {
            // 第一個參數是使用者操作的ListView物件
            // 第二個參數是使用者選擇的項目
            // 第三個參數是使用者選擇的項目編號，第一個是0
            // 第四個參數在這裡沒有用途
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                Toast.makeText(MainActivity.this,
                        "Long: " + data[position], Toast.LENGTH_LONG).show();
                return false;
            }
        };

        // 註冊選單項目長按監聽物件
        item_list.setOnItemLongClickListener(itemLongListener);
        // 建立長按監聽物件
        View.OnLongClickListener listener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder dialog =
                        new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle(R.string.app_name)
                        .setMessage(R.string.app_about)
                        .show();
                return false;
            }
        };
    }

    // 加入載入選單資源的方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    // 使用者選擇所有的選單項目都會呼叫這個方法
    public void clickMenuItem(MenuItem item) {
        // 使用參數取得使用者選擇的選單項目元件編號
        int itemId = item.getItemId();

        // 判斷該執行什麼工作，目前還沒有加入需要執行的工作
        switch (itemId) {
            case R.id.search_item:
                break;
            case R.id.add_item:
                break;
            case R.id.revert_item:
                break;
            case R.id.delete_item:
                break;
        }

        // AlertDialog 彈出對話視窗
        AlertDialog.Builder dialog =
                new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("MenuItem Test")
                .setMessage(item.getTitle())
                .setIcon(item.getIcon())
                .show();
    }

    // 方法名稱與onClick的設定一樣，參數的型態是android.view.View
    public void aboutApp(View view) {
        // 顯示訊息框，指定三個參數
        // Context：通常指定為「this」
        // String或int：設定顯示在訊息框裡面的訊息或文字資源
        // int：設定訊息框停留在畫面的時間
        Toast.makeText(this, R.string.app_name, Toast.LENGTH_LONG).show();
    }
}
