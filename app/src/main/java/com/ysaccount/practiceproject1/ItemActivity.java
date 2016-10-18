package com.ysaccount.practiceproject1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View;

import java.util.Date;

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

    // 啟動功能用的請求代碼
    private static final int START_CAMERA = 0;
    private static final int START_RECORD = 1;
    private static final int START_LOCATION = 2;
    private static final int START_ALARM = 3;
    private static final int START_COLOR = 4;

    // 記事物件
    private Item item;
    private color Colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        // 取得Intent物件
        Intent intent = getIntent();
        // 讀取Action名稱
        String action = intent.getAction();
        processViews();  //取得變數放入元件

        // 如果是修改記事
        if (action.equals("com.ysaccount.practiceproject1.EDIT_ITEM")) {
            // 接收與設定記事標題
            //String titleText = intent.getStringExtra("titleText");
            //title_text.setText(titleText);

            // 接收記事物件與設定標題、內容
            item = (Item) intent.getExtras().getSerializable(
                    "com.ysaccount.practiceproject1.Item");
            title_text.setText(item.getTitle());
            content_text.setText(item.getContent());
        }
        // 新增記事
        else {
            item = new Item();
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

            // 設定記事物件的標題與內容
            item.setTitle(titleText);
            item.setContent(contentText);

            // 如果是修改記事
            if (getIntent().getAction().equals(
                    "com.ysaccount.practiceproject1.EDIT_ITEM")) {
                item.setLastModify(new Date().getTime());
            }
            // 新增記事
            else {
                item.setDatetime(new Date().getTime());
            }

            Intent result = getIntent();
            // 設定回傳的記事物件
            result.putExtra("com.ysaccount.practiceproject1.Item", item);
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
                // 啟動設定顏色的Activity元件
                startActivityForResult(
                        new Intent(this, ColorActivity.class), START_COLOR);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case START_CAMERA:
                    break;
                case START_RECORD:
                    break;
                case START_LOCATION:
                    break;
                case START_ALARM:
                    break;
                // 設定顏色
                case START_COLOR:
                    int colorId = data.getIntExtra(
                            "colorId", Colors.LIGHTGREY.parseColor());
                    item.setColor(getColors(colorId));
                    break;
            }
        }
    }

    private color getColors(int color) {
        color result = Colors.LIGHTGREY;

        if (color == Colors.BLUE.parseColor()) {
            result = Colors.BLUE;
        }
        else if (color == Colors.PURPLE.parseColor()) {
            result = Colors.PURPLE;
        }
        else if (color == Colors.GREEN.parseColor()) {
            result = Colors.GREEN;
        }
        else if (color == Colors.ORANGE.parseColor()) {
            result = Colors.ORANGE;
        }
        else if (color == Colors.RED.parseColor()) {
            result = Colors.RED;
        }

        return result;
    }

}
