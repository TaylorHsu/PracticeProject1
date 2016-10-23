package com.ysaccount.practiceproject1;

import android.app.Activity;
import android.content.DialogInterface;
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
import android.content.Intent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
----------------------------------------------------------------
Date & Version:2016-10-20 V1.6.0
Program Name: PracticeProject1
Programer: Taylor
Note: This project for practice the Tutorial
基礎練習
Android 系統提供一種「Preference」的架構，它可以在應用程式中儲存一些「名稱＝值」這類簡單的資料，
這些資料可以用來儲存應用程式的狀態，或是儲存使用者執行的設定。這些資料在應用程式中執行儲存與讀取的工作都非常容易，
如果有這類的需求，使用它來處理是最方便的。

PreferenceActivity元件 – 設定元件專用的Activity元件，讓你的元件類別繼承自這個類別。
設定元件專用的畫面配置檔放在專案的「res/xml」目錄下，這個設定檔的最外層使用「PreferenceScreen」標籤，根據應用程式需要的設定資料，在這裡標籤中加入這些需要的設定元件標籤：

EditTextPreference – 使用對話框讓使用者輸入文字資料。
CheckBoxPreference – 勾選元件，儲存boolean 資料。
SwitchPreference – 在Android 4.0（API level 14）加入，提供開關式的元
件，儲存boolean 資料。
ListPreference – 使用對話框讓使用者在列表中選擇一個項目，儲存字串資料。
MultiSelectListPreference – 在Android 3.0（API level 11）加入，使用對話框讓使用者在列表中選擇多個項目，儲存Set 資料。
RingtonePreference – 開啟系統內建選擇來電鈴聲的對話框讓使用者選擇，儲存文字資料。
PreferenceCategory – 用來執行設定資料的分組。
Preference – 啟動其它元件執行設定的工作。




----------------------------------------------------------------
Date & Version:2016-10-19 V1.5.0
Program Name: PracticeProject1
Programer: Taylor
Note: This project for practice the Tutorial
基礎練習 包含以下內容  使用照相機與麥克風

應用程式需要執行拍照的功能，可以啟動系統相機元件執行拍照的工作，它的系統Action名稱變數是「MediaStore.ACTIONIMAGECAPTURE」，
使用這個Action名稱建立好的Intent物件，可以呼叫putExtra方法加入照片檔案儲存位置的設定資料，
資料的名稱是「MediaStore.EXTRA_OUTPUT」，如果沒有指定的話，會使用系統預設的名稱儲存在預設的位置。

<!-- 需要攝錄鏡頭設備 -->
<uses-feature android:name="android.hardware.camera" />
<!-- 寫入外部儲存設備 -->
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
<!--使用裝置的錄音設備-->
<uses-permission android:name="android.permission.RECORD_AUDIO"/>

1.建立FileUtil來做檔案控制
2.呼叫相機拍照畫面來拍照
  Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
3.Play/Record Activity 做出錄音和播放頁面


----------------------------------------------------------------
Date & Version:2016-10-18 V1.4.0
Program Name: PracticeProject1
Programer: Taylor
Note: This project for practice the Tutorial
基礎練習 包含以下內容
使用Android內建的SQLite資料庫
1 設計資料庫表格  SQLite資料庫的資料型態只有下面這幾種
INTEGER – 整數，對應Java 的byte、short、int 和long。
REAL – 小數，對應Java 的float 和double。
TEXT – 字串，對應Java 的String。
2. 建立SQLiteOpenHelper類別  new=>MyDBHelper.Class
Android 提供許多方便與簡單的資料庫API，可以簡化應用程式處理資料庫的工作。
這些API都在「android.database.sqlite」套件，它們可以用來執行資料庫的管理和查詢的工作。
在這個套件中的「SQLiteOpenHelper」類別，可以在應用程式中執行建立資料庫與表格的工作，
應用程式第一次在裝置執行的時候，由它負責建立應用程式需要的資料庫與表格，後續執行的時候開啟已經建立好的資料庫讓應用程式使用。
還有應用程式在運作一段時間以後，如果增加或修改功能，資料庫的表格也增加或修改了，
它也可以為應用程式執行資料庫的修改工作，讓新的應用程式可以正常的運作

MyDBHelper.Class

3.ItemDAO  在一般應用程式中執行資料庫工作的設計方式，把執行資料庫工作的部份寫在一個獨立的Java類別中

----------------------------------------------------------------
Date & Version:2016-10-17 V1.3.0
Program Name: PracticeProject1
Programer: Taylor
Note: This project for practice the Tutorial
基礎練習 包含以下內容
加強ListView元件的使用，為它設計專用的畫面，讓一個項目可以顯示比較多的資料
1.建立Color enum class以封裝顏色資料的類別,用來記錄顏色

2.new Item class用來讓Item List儲存較多資料

3.new item_drawable for List資料前的顏色按鈕

4.new single item xml表示單個item在List上的元件

5.new ItemAdapter=>撰寫一個自訂的Adapter來給ListView使用來處理複雜資料

6.修改MainActivity
  用自訂物件宣告 ItemAdapter , List<Item>
  新增範例資料(到陣列)
  建立自定Adapter物件 ,setAdapter

 7.修改ItemActivity
  OnCreate時,若為新增,則new Item
  onSubmit,改為處理Item物件

  8.MainActivity    onActivityResult=>新增item,更新畫面資料

  9.ItemActivity,onCreate 若是Edit,接收Item物件(item,position)以取得要修改的item

  10.MainActivity  onActivityResult=>修改item,更新畫面資料

  11.新增ColorActivity,以設定顏色 ("@android:style/Theme.Dialog")
    ColorActivity
     1)LinearLayout color_gallery
     2) for (Colors c : Colors.values())
         loop new color Button
     3)Button Click傳送Color ID
     4)回到 ItemActivity,Onclick func 若點選Select Color 則跳出ColorActivity
            onActivityResult 依回傳值get color ,set item color
  12.設定 長按修改,Click為選擇
    當選擇1個以上  menu修改為show delete
    可點選和取消點選
    當按下delete詢問是否刪除


 ---------------------------------------------------------------
Date & Version:2016-10-16 V1.2.0
Program Name: PracticeProject1
Programer: Taylor
Note: This project for practice the Tutorial
基礎練習 包含以下內容
有Activity元件之間的互動與資料傳輸
1. New about activity show程式資訊
  1-1  Java Class
       從AppCompatActivity改為Activity
       requestWindowFeature(Window.FEATURE_NO_TITLE);取消元件的應用程式標題
  1-2  about.XML加入text,ok button
  1-3  AndroidManifest.xml加上"@android:style/Theme.Dialog"
       android:theme="@android:style/Theme.Dialog"
2. Activity元件間傳遞資料 New ItemActivity
   2-1 AndroidManifest.xml加入元件傳遞name for ItemActivity
     <intent-filter>
        <!-- 新增用的名稱 -->
        <action android:name="net.macdidi.myandroidtutorial.ADD_ITEM"/>
        <!-- 修改用的名稱 -->
        <action android:name="net.macdidi.myandroidtutorial.EDIT_ITEM"/>
        <!-- 一定要加入，內容固定不變 -->
        <category android:name="android.intent.category.DEFAULT" />
    </intent-filter>
   2-2 ItemActivity Java Class檔加上getIntent & getAction
       1).
          // 取得Intent物件
            Intent intent = getIntent();
          // 讀取Action名稱
            String action = intent.getAction();
       2).修改的話,要取回前面的值
         if (action.equals("com.ysaccount.practiceproject1.EDIT_ITEM")) {
            // 接收與設定標題
            String titleText = intent.getStringExtra("titleText");
            title_text.setText(titleText);
          }
        3).修改完成,回傳資料
          // 讀取使用者輸入的標題與內容
            String titleText = title_text.getText().toString();
            String contentText = content_text.getText().toString();

            // 取得回傳資料用的Intent物件
            Intent result = getIntent();
            // 設定標題與內容
            result.putExtra("titleText", titleText);
            result.putExtra("contentText", contentText);

            // 設定回應結果為確定
            setResult(Activity.RESULT_OK, result);
   2-3 MainActivity Java Class
       1.add_item:
         點新增按鈕時:
             // 使用Action名稱建立啟動另一個Activity元件需要的Intent物件
             Intent intent = new Intent("com.ysaccount.practiceproject1.ADD_ITEM");
             // 呼叫「startActivityForResult」，，第二個參數「0」表示執行新增
             startActivityForResult(intent, 0);

       2.Edit Item
         點要修改的item時:
           // 使用Action名稱建立啟動另一個Activity元件需要的Intent物件
            Intent intent = new Intent("com.ysaccount.practiceproject1.EDIT_ITEM");
            // 設定記事編號與標題
            intent.putExtra("position", position);
            intent.putExtra("titleText", data.get(position));
            // 呼叫「startActivityForResult」，第二個參數「1」表示執行修改
            startActivityForResult(intent, 1);

       3.onActivityResult 取得回傳結果並存到畫面
          ItemActivity回傳時,onActivityResult
           if (resultCode == Activity.RESULT_OK) ....
             新增:
                this.data.add(titleText);
                // 通知資料已經改變，ListView元件才會重新顯示
                adapter.notifyDataSetChanged();
             修改:
                int position = data.getIntExtra("position", -1);

                if (position != -1) {
                    // 設定標題項目
                    this.data.set(position, titleText);
                    // 通知資料已經改變，ListView元件才會重新顯示
                    adapter.notifyDataSetChanged();
                }

----------------------------------------------------------------
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
    /*private static final String[] data = {
            "List View Item_1",
            "List View Item_2",
            "List View Item_3"};*/
    // 換掉原來的字串陣列

    // 刪除原來的宣告
    //private ArrayList<String> data = new ArrayList<>();
    //private ArrayAdapter<String> adapter;

    // ListView使用的自定Adapter物件
    private ItemAdapter itemAdapter;
    // 儲存所有記事本的List物件
    private List<Item> items;

    // 選單項目物件
    private MenuItem add_item, search_item, revert_item, share_item, delete_item;

    // 已選擇項目數量
    private int selectedCount = 0;

    // 宣告資料庫功能類別欄位變數
    private ItemDAO itemDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* data.add("List Item 1");
        data.add("List Item 2");
        data.add("List Item 3");*/

        processViews();  //在這個方法中，取得畫面元件物件後指定給欄位變數
        processControllers();   // 在這個方法中，宣告或建立需要的監聽物件並執行所有需要的註冊工作
        /*
        int ListViewID = android.R.layout.simple_list_item_1;
        adapter = new ArrayAdapter <> (this, ListViewID, data);
        item_list.setAdapter(adapter);*/

        /*// 加入範例資料 ,改用自定Adapter物件
        items = new ArrayList<Item>();
        items.add(new Item(1, new Date().getTime(), color.RED, "List Item 1.", "Hello content", "", 0, 0, 0));
        items.add(new Item(2, new Date().getTime(), color.BLUE, "List Item 2", "Hello content", "", 0, 0, 0));
        items.add(new Item(3, new Date().getTime(), color.GREEN, "List Item 3", "Hello content", "", 0, 0, 0));
        */

        // 建立資料庫物件
        itemDAO = new ItemDAO(getApplicationContext());

        // 如果資料庫是空的，就建立一些範例資料
        // 這是為了方便測試用的，完成應用程式以後可以拿掉
        if (itemDAO.getCount() == 0) {
            itemDAO.sample();
        }

        // 取得所有記事資料
        items = itemDAO.getAll();

        // 建立自定Adapter物件
        itemAdapter = new ItemAdapter(this, R.layout.singleitem, items);
        item_list.setAdapter(itemAdapter);


    }

    private void processViews() {
        item_list = (ListView)findViewById(R.id.item_list);
    }

    private void processControllers() {
        // 建立選單項目點擊監聽物件
        /*
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            // 第一個參數是使用者操作的ListView物件
            // 第二個參數是使用者選擇的項目
            // 第三個參數是使用者選擇的項目編號，第一個是0
            // 第四個參數在這裡沒有用途
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Toast.makeText(MainActivity.this,
                        //data[position], Toast.LENGTH_LONG).show();
                        // // 換掉「data[position]」 =>  data.get(position)
                        data.get(position), Toast.LENGTH_LONG).show();
            }
        };
        //V1.2.0改成點選ListView Item跳出視窗 修改Item
        */
        /*
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // 使用Action名稱建立啟動另一個Activity元件需要的Intent物件
                Intent intent = new Intent("com.ysaccount.practiceproject1.EDIT_ITEM");
                // 設定記事編號與標題
                intent.putExtra("position", position);
                intent.putExtra("titleText", data.get(position));

                // 呼叫「startActivityForResult」，第二個參數「1」表示執行修改
                startActivityForResult(intent, 1);
            }
        };
        // 註冊選單項目點擊監聽物件
        item_list.setOnItemClickListener(itemListener);
        */
        // 讀取選擇的記事物件
        //
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // 讀取選擇的記事物件
                Item item = itemAdapter.getItem(position);

                // 如果已經有勾選的項目
                if (selectedCount > 0) {
                    // 處理是否顯示已選擇項目
                    processMenu(item);
                    // 重新設定記事項目
                    itemAdapter.set(position, item);
                } else {
                    Intent intent = new Intent(
                            "com.ysaccount.practiceproject1.EDIT_ITEM");

                    // 設定記事編號與記事物件
                    intent.putExtra("position", position);
                    intent.putExtra("com.ysaccount.practiceproject1.Item", item);

                    startActivityForResult(intent, 1);
                }
            }
        };
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
                // 讀取選擇的記事物件
                Item item = itemAdapter.getItem(position);
                // 處理是否顯示已選擇項目
                processMenu(item);
                // 重新設定記事項目
                itemAdapter.set(position, item);
                return true;
            }
        };

        // 註冊選單項目長按監聽物件
        item_list.setOnItemLongClickListener(itemLongListener);

        /*
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
        };*/
    }

    // 加入載入選單資源的方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.main_menu, menu);
        //return true;
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        // 取得選單項目物件
        add_item = menu.findItem(R.id.add_item);
        search_item = menu.findItem(R.id.search_item);
        revert_item = menu.findItem(R.id.revert_item);
        share_item = menu.findItem(R.id.share_item);
        delete_item = menu.findItem(R.id.delete_item);

        // 設定選單項目
        processMenu(null);

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
                // 使用Action名稱建立啟動另一個Activity元件需要的Intent物件
                Intent intent = new Intent("com.ysaccount.practiceproject1.ADD_ITEM");
                // 呼叫「startActivityForResult」，，第二個參數「0」表示執行新增
                startActivityForResult(intent, 0);
                break;
            case R.id.revert_item:
                for (int i = 0; i < itemAdapter.getCount(); i++) {
                    Item ri = itemAdapter.getItem(i);

                    if (ri.isSelected()) {
                        ri.setSelected(false);
                        itemAdapter.set(i, ri);
                    }
                }

                selectedCount = 0;
                processMenu(null);
                break;
            case R.id.delete_item:
                // 沒有選擇
                if (selectedCount == 0) {
                    break;
                }

                // 建立與顯示詢問是否刪除的對話框
                AlertDialog.Builder d = new AlertDialog.Builder(this);
                String message = getString(R.string.delete_item);
                d.setTitle(R.string.delete)
                        .setMessage(String.format(message, selectedCount));
                d.setPositiveButton(android.R.string.yes,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 刪除所有已勾選的項目
                                int index = itemAdapter.getCount() - 1;

                                while (index > -1) {
                                    Item item = itemAdapter.get(index);

                                    if (item.isSelected()) {
                                        itemAdapter.remove(item);
                                        // 刪除資料庫中的記事資料
                                        itemDAO.delete(item.getId());
                                    }

                                    index--;
                                }

                                // 通知資料改變
                                itemAdapter.notifyDataSetChanged();
                                selectedCount = 0;
                                processMenu(null);
                            }
                        });
                d.setNegativeButton(android.R.string.no, null);
                d.show();
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
        // 顯示訊息框，指定三個參數, Context：通常指定為「this」,String或int：設定顯示在訊息框裡面的訊息或文字資源, int：設定訊息框停留在畫面的時間
        //Toast.makeText(this, R.string.app_name, Toast.LENGTH_LONG).show();

        //從訊息窗改為About Activity
        // 建立啟動另一個Activity元件需要的Intent物件
        // 建構式的第一個參數：「this」
        // 建構式的第二個參數：「Activity元件類別名稱.class」
        Intent intent = new Intent(this, about.class);
        // 呼叫「startActivity」，參數為一個建立好的Intent物件
        // 這行敘述執行以後，如果沒有任何錯誤，就會啟動指定的元件
        startActivity(intent);

    }


    /*Activity間回傳資料 進行動作 onActivityResult 取得回傳結果並存到畫面*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            String titleText = data.getStringExtra("titleText");

            // 讀取記事物件
            Item item = (Item) data.getExtras().getSerializable(
                    "com.ysaccount.practiceproject1.Item");

            // 如果是新增記事
            if (requestCode == 0) {
                // 加入標題項目
                //this.data.add(titleText);
                // 通知資料已經改變，ListView元件才會重新顯示
                // adapter.notifyDataSetChanged();
                // 設定記事物件的編號與日期時間
                item.setId(items.size() + 1);
                item.setDatetime(new Date().getTime());

                // 新增記事資料到資料庫
                item = itemDAO.insert(item);
                // 加入新增的記事物件
                items.add(item);

                // 通知資料改變
                itemAdapter.notifyDataSetChanged();
            }
            // 如果是修改記事
            else if (requestCode == 1) {
                // 讀取記事編號
                int position = data.getIntExtra("position", -1);

                if (position != -1) {
                    // 設定標題項目
                    //this.data.set(position, titleText);
                    // 通知資料已經改變，ListView元件才會重新顯示
                    //adapter.notifyDataSetChanged();

                    // 修改資料庫中的記事資料
                    itemDAO.update(item);

                    // 設定修改的記事物件
                    items.set(position, item);
                    itemAdapter.notifyDataSetChanged();
                }

            }
        }
    }

    // 處理是否顯示已選擇項目
    private void processMenu(Item item) {
        // 如果需要設定記事項目
        if (item != null) {
            // 設定已勾選的狀態
            item.setSelected(!item.isSelected());

            // 計算已勾選數量
            if (item.isSelected()) {
                selectedCount++;
            }
            else {
                selectedCount--;
            }
        }

        // 根據選擇的狀況，設定是否顯示選單項目
        add_item.setVisible(selectedCount == 0);
        search_item.setVisible(selectedCount == 0);
        revert_item.setVisible(selectedCount > 0);
        share_item.setVisible(selectedCount > 0);
        delete_item.setVisible(selectedCount > 0);
    }

    // 設定
    public void clickPreferences(MenuItem item) {
        // 啟動設定元件
        startActivity(new Intent(this, PrefActivity.class));
    }

}
