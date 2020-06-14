package com.jcy20.demo.let08SeniorView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jcy20.demo.R;

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

    }
}
