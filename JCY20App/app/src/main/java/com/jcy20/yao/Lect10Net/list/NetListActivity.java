package com.jcy20.yao.Lect10Net.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcy20.yao.Lect10Net.HttpProxy;
import com.jcy20.yao.Lect10Net.bean.VideoInfo;
import com.jcy20.yao.Lect10Net.bean.VideoListResponse;
import com.jcy20.yao.R;
import com.jcy20.yao.lect08SeniorView.NetInputUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class NetListActivity extends AppCompatActivity {
    private static final String TAG = "NetListActivity";
    private VideoAdapter mAdapter;
    private Handler mHandler = new Handler();
    private List<VideoInfo> mDataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_list);
        /** 以列表展示数据 3个元素，ListView 数据源 Adapter */
        ListView mListView = findViewById(R.id.lv);
        /* 设置ListView的头部 */

        View headLayout = buildListHeader();
        mListView.addHeaderView(headLayout);
        /* 数据源 */
        mDataList = new ArrayList<>();
        mAdapter = new VideoAdapter(mDataList, this);
        mListView.setAdapter(mAdapter);
        initData();
    }

    private View buildListHeader() {
        View headLayout = LayoutInflater.from(this).inflate(R.layout.layout_header, null);
        TextView signTV = headLayout.findViewById(R.id.txt_sign);
        signTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NetListActivity.this, "去设置签名", Toast.LENGTH_SHORT).show();
            }
        });
        return  headLayout;
    }


    private void initData() {
        String raUrl = "http://ramedia.sinaapp.com/videolist.json";
        String movieUrl = "http://ramedia.sinaapp.com/res/DouBanMovie2.json";
        HttpProxy.getInstance().load(movieUrl, new HttpProxy.NetInputCallback() {
            @Override
            public void onSuccess(InputStream inputStream) {
                /** 读取字符串 */
                String respJson  = null;
                try {
                    respJson = NetInputUtils.readString(inputStream);
                    Log.i(TAG, "--- response json:\n "+ respJson);
                    VideoListResponse videoListResponse = convertJsonToBean(respJson);
                    final List<VideoInfo> list = videoListResponse.getList();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.setData(list);
                            /** 刷新Adapter的UI */
                            mAdapter.notifyDataSetChanged();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /** Json 字符串转成相应的java bean对象 */
    private VideoListResponse convertJsonToBean(String json) {
        Gson gson = new Gson();
        VideoListResponse response = gson.fromJson(json, VideoListResponse.class);
        return response;
    }

}
