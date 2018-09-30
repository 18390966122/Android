package com.wh.myapplication;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/*
 * 创建者 曹晓丽
 * 创建时间 2018/9/25 17:06
 */

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取上一个页面的数据
                Intent intent = getIntent();
                String data = intent.getStringExtra("extra_data");
                Log.d("SecondActivity", data);
                Intent intent2 = new Intent();
                // 传递数据给上一个页面
                intent2.putExtra("data_return", "Hello_FirstActvity");
                setResult(RESULT_OK, intent2);
                finish();
            }
        });
    }

//    @Override
//    public void OnBackStackChangedListener() {
//        Intent intent = new Intent();
//        intent.putExtra("data_return", "hello_firstLayout");
//        setResult(RESULT_OK, intent);
//        finish();
//    }
}