package com.jcy20.demo.lect09Data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.jcy20.demo.R;

public class DataPersistenceActivity extends AppCompatActivity {
    EditText mContentET;
    SharedPreferences mSp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_persistence);
        mContentET = findViewById(R.id.et_content);
        mSp = getSharedPreferences("User", MODE_PRIVATE);
        String name = mSp.getString("name", "佚名");
        mContentET.setText(name);

    }

    @Override
    protected void onPause() {
        String content = mContentET.getText().toString();
        /** 通过shared preference 保存数据 */
        SharedPreferences.Editor editor = mSp.edit();
        editor.putString("name", content);
        editor.commit();
        super.onPause();
    }

    public void clear(View view) {
        SharedPreferences.Editor editor = mSp.edit();
        editor.remove("name");
        editor.apply();
        mContentET.setText("");

    }
}
