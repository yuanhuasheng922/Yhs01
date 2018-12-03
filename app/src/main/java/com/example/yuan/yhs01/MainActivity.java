package com.example.yuan.yhs01;

import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.yhs01.sql.SqlDao;
import com.example.yuan.yhs01.view.CustomViewLayout;

public class MainActivity extends AppCompatActivity {
    private String[] str=new String[]{"考拉三周年人气热销榜","电动牙刷","尤佳妮","豆豆鞋","沐浴露","日东红茶","榴莲","电动牙刷","尤佳妮","雅诗兰黛","豆豆鞋"};
    private SqlDao dao;
    private ImageView del;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //dao
        dao = new SqlDao(this);
        //找控件

        CustomViewLayout faxian=findViewById(R.id.faxian);
       for (String ss : str)
       {
           //新建TextView
           final TextView text=new TextView(this);
           text.setTextSize(20);
           text.setTextColor(Color.RED);
           text.setText(ss);
           faxian.addView(text);
           text.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Toast.makeText(MainActivity.this,text.getText().toString(),Toast.LENGTH_SHORT).show();
               }
           });
       }


    }

    private void init() {

        //找控件
        final EditText input=findViewById(R.id.input);
        ImageView sousuo=findViewById(R.id.sousuo);
        final CustomViewLayout layout=findViewById(R.id.layout);
        //点击搜索
        sousuo.setOnClickListener(new View.OnClickListener() {

            private TextView textView;

            @Override
            public void onClick(View v) {
                //新建Textview
                textView = new TextView(MainActivity.this);
                //设置值
                textView.setText(input.getText());
                textView.setTextColor(Color.GREEN);
                textView.setTextSize(20);
                if (!input.getText().toString().equals(""))
                {
                    dao.add(input.getText().toString());
                    layout.addView(textView);
                }
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,textView.getText().toString(),Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        //删除
        del = findViewById(R.id.del);
        //点击清空
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //删除
                dao.delAll();
                layout.removeAllViews();
            }
        });

    }
}
