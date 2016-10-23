package com.ysaccount.practiceproject1;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.util.Date;

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

    // 檔案名稱
    private String fileName;
    // 照片
    private ImageView picture;

    // 錄音檔案名稱
    private String recFileName;

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

        // 取得顯示照片的ImageView元件
        picture = (ImageView) findViewById(R.id.picture);
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
                // 啟動相機元件用的Intent物件
                Intent intentCamera =
                        new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                // 照片檔案名稱
                File pictureFile = configFileName("P", ".jpg");
                Uri uri = Uri.fromFile(pictureFile);
                // 設定檔案名稱
                intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                // 啟動相機元件
                startActivityForResult(intentCamera, START_CAMERA);
                break;
            case R.id.record_sound:
                // 錄音檔案名稱
                final File recordFile = configRecFileName("R", ".mp3");

                // 如果已經有錄音檔，詢問播放或重新錄製
                if (recordFile.exists()) {
                    // 詢問播放還是重新錄製的對話框
                    AlertDialog.Builder d = new AlertDialog.Builder(this);

                    d.setTitle(R.string.title_record)
                            .setCancelable(false);
                    d.setPositiveButton(R.string.record_play,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // 播放
                                    Intent playIntent = new Intent(
                                            ItemActivity.this, PlayActivity.class);
                                    playIntent.putExtra("fileName",
                                            recordFile.getAbsolutePath());
                                    startActivity(playIntent);
                                }
                            });
                    d.setNeutralButton(R.string.record_new,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    goToRecord(recordFile);
                                }
                            });
                    d.setNegativeButton(android.R.string.cancel, null);

                    // 顯示對話框
                    d.show();
                }
                // 如果沒有錄音檔，啟動錄音元件
                else {
                    goToRecord(recordFile);
                }
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
                    // 設定照片檔案名稱
                    item.setFileName(fileName);
                    break;
                case START_RECORD:
                    // 設定錄音檔案名稱
                    item.setRecFileName(recFileName);
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

    public static color getColors(int color1) {
        color result = color.LIGHTGREY;

        if (color1 == color.BLUE.parseColor()) {
            result = color.BLUE;
        }
        else if (color1 == color.PURPLE.parseColor()) {
            result = color.PURPLE;
        }
        else if (color1 == color.GREEN.parseColor()) {
            result = color.GREEN;
        }
        else if (color1 == color.ORANGE.parseColor()) {
            result = color.ORANGE;
        }
        else if (color1 == color.RED.parseColor()) {
            result = color.RED;
        }

        return result;
    }

    private File configFileName(String prefix, String extension) {
        // 如果記事資料已經有檔案名稱
        if (item.getFileName() != null && item.getFileName().length() > 0) {
            fileName = item.getFileName();
        }
        // 產生檔案名稱
        else {
            fileName = FileUtil.getUniqueFileName();
        }

        return new File(FileUtil.getExternalStorageDir(FileUtil.APP_DIR),
                prefix + fileName + extension);
    }

    private File configRecFileName(String prefix, String extension) {
        // 如果記事資料已經有檔案名稱
        if (item.getRecFileName() != null && item.getRecFileName().length() > 0) {
            recFileName = item.getRecFileName();
        }
        // 產生檔案名稱
        else {
            recFileName = FileUtil.getUniqueFileName();
        }

        return new File(FileUtil.getExternalStorageDir(FileUtil.APP_DIR),
                prefix + recFileName + extension);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 如果有檔案名稱
        if (item.getFileName() != null && item.getFileName().length() > 0) {
            // 照片檔案物件
            File file = configFileName("P", ".jpg");

            // 如果照片檔案存在
            if (file.exists()) {
                // 顯示照片元件
                picture.setVisibility(View.VISIBLE);
                // 設定照片
                FileUtil.fileToImageView(file.getAbsolutePath(), picture);
            }
        }
    }
    private void goToRecord(File recordFile) {
        // 錄音
        Intent recordIntent = new Intent(this, RecordActivity.class);
        recordIntent.putExtra("fileName", recordFile.getAbsolutePath());
        startActivityForResult(recordIntent, START_RECORD);
    }
}
