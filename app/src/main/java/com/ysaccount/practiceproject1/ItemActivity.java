package com.ysaccount.practiceproject1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View;

import static com.ysaccount.practiceproject1.R.id.item_list;

/*
取得Intent物件
讀取Action名稱
取得變數放入元件
點擊確定與取消按鈕都會呼叫OnSubmit方法
if (view.getId() == R.id.ok_item) {
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
}

*/

public class ItemActivity extends AppCompatActivity {

    private EditText title_text, content_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        // 取得Intent物件
        Intent intent = getIntent();
        // 讀取Action名稱
        String action = intent.getAction();
        processViews();  //取得變數放入元件

        // 如果是修改
        if (action.equals("com.ysaccount.practiceproject1.EDIT_ITEM")) {
            // 接收與設定標題
            String titleText = intent.getStringExtra("titleText");
            title_text.setText(titleText);
        }
    }

    private void processViews() {
        title_text = (EditText) findViewById(R.id.title_text);
        content_text = (EditText) findViewById(R.id.content_text);
    }

    // 點擊確定與取消按鈕都會呼叫這個方法
    public void onSubmit(View view) {
        // 確定按鈕
        if (view.getId() == R.id.ok_item) {
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
        }

        // 結束,關閉視窗
        finish();
    }

    // 以後需要擴充的功能
    public void clickFunction(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.take_picture:
                break;
            case R.id.record_sound:
                break;
            case R.id.set_location:
                break;
            case R.id.set_alarm:
                break;
            case R.id.select_color:
                break;
        }

    }

}
