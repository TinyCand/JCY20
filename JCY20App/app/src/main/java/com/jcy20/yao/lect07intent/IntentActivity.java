package com.jcy20.yao.lect07intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jcy20.yao.R;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "IntentActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "--- onCreate: " + this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        findViewById(R.id.btn_dial).setOnClickListener(this);
        findViewById(R.id.btn_start_flag).setOnClickListener(this);



    }

    @Override
    protected void onStart() {
        Log.i(TAG, "--- onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "--- onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "--- onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "--- onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "--- onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "--- onDestroy: " + this);
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_dial:{
                //隐式意图
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:15012345678"));
                startActivity(intent);
            } break;
            case R.id.btn_start_flag : {
                Intent intent = new Intent(IntentActivity.this, FlagActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);

                startActivity(intent);
            } break;
            default:
                break;


        }

    }


    public void toWeb(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        Intent chooser = Intent.createChooser(intent, "选浏览器！");
        // 确认是否有应用可以处理这个Intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        } else {
            Toast.makeText(this, "手机没有app支持打开该链接", Toast.LENGTH_SHORT).show();
        }
    }
}
