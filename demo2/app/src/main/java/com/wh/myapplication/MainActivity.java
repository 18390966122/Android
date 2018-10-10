package com.wh.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity"; 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 重写菜单方法
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        ActivityCollector.addActivity(this);
        if (savedInstanceState != null) {
//            String tempData
        }
        Log.i("MainActivity", "onCreate: 1111111111111111111");
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked button1", Toast.LENGTH_SHORT).show();
            }
        });
        Button button2 = (Button) findViewById(R.id.button_2);
         // 点击按钮跳转页面，传入MainActivity.this作为上下文，然后SecondActivity.class作为目标页，通过startActivity来执行
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Hello SecondActivity";
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", data);
                startActivity(intent);
                startActivityForResult(intent, 1);
            }
        });
        Button normalActivity = (Button) findViewById(R.id.normalActivity);
        normalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });
        Button dialogActivity = (Button) findViewById(R.id.dialogActivity);
        dialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeAll();
        Log.d(TAG, "onDestroy: ");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "Something you just save";
        outState.putString("data_key", tempData);
    }
//
//    @Override
//    protected void OnActivityResult(int requestCode, int resultCode, Intent data) {
//        switch (requestCode) {
//            case 1:
//                if (resultCode == RESULT_OK) {
//                    String returnData = data.getStringExtra("data_return");
//                    Log.d("MainActivity", returnData);
//                }
//            default:
//        }
//    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 重写菜单下拉项的方法，添加点击菜单项的逻辑
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "clicked add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "clicked remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
