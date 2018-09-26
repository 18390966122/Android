package com.wh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 重写菜单方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
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
            public void OnClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    // 重写菜单下拉项的方法，添加点击菜单项的逻辑
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
