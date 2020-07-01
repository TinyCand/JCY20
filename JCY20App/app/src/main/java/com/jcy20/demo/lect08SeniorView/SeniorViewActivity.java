package com.jcy20.demo.lect08SeniorView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.jcy20.demo.R;

import java.util.ArrayList;
import java.util.List;

public class SeniorViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_view);

        Button dialogBtn = findViewById(R.id.btn_dialog);
        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SeniorViewActivity.this);
                builder.setIcon(R.mipmap.ic_dog)
                        .setTitle("标题")
                        .setMessage("今天学习了吗？")
                        .setPositiveButton("学了", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SeniorViewActivity.this, "你真棒", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("没有", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SeniorViewActivity.this, "为什么不学？", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        /** 以列表展示数据 3个元素，ListView 数据源 Adapter */
        ListView listView = findViewById(R.id.lv);
        /* 数据源 */
        List<News> dataList = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                News item = new News();
                item.setPicId(R.mipmap.ic_dog);
                item.setTitle(i+" 同学居然在课堂做这种事情");
                dataList.add(item);
        }
        /* Adapter 绑定ListView 和data 的桥梁 */
        NewsAdapter adapter = new NewsAdapter(SeniorViewActivity.this, dataList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });






    }
}
