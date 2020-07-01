package com.jcy20.yao.Lect10Net;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.jcy20.yao.Lect10Net.bean.VideoListResponse;
import com.jcy20.yao.R;
import com.jcy20.yao.lect08SeniorView.NetInputUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetActivity extends AppCompatActivity {
    private static final String TAG = NetActivity.class.getSimpleName();

    private ImageView mLogoIV;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
        mLogoIV = findViewById(R.id.img_icon);
        mHandler = new Handler();
    }

    public void toJsonClick(View view) {
        String json = "{\n" +
                "    \"result\": \"0\",\n" +
                "    \"list\": [\n" +
                "        {\n" +
                "            \"title\": \"Big Wedding Day\",\n" +
                "            \"filePath\": \"http://ramedia.sinaapp.com/res/Video/BigWeddingDay.hlv\",\n" +
                "            \"thumbPath\": \"http://ramedia.sinaapp.com/res/Video/BigWeddingDay.png\",\n" +
                "            \"id\": 2\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        VideoListResponse videoListResponse = convertJsonToBean(json);
    }

    /** Json 字符串转成相应的java bean对象 */
    private VideoListResponse convertJsonToBean(String json) {
        Gson gson = new Gson();
        VideoListResponse response = gson.fromJson(json, VideoListResponse.class);
        return response;
    }

    /** 发起网络请求 */
    public void toRequestNet(View view) {
        //用到网络首先要检查 是否添加的 网络权限
        // 注意网络请求不能放在主线程(UI线程)，要在子线程处理
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Android 9 默认不支持单纯的http传输，加usesCleartextTraffic="true"
//                String raUrl = "http://ramedia.sinaapp.com/videolist.json";
                String imgUrl = "http://ramedia.sinaapp.com/res/Video/GetColdFeet.png";
                String movieUrl = "http://1.ramedia.sinaapp.com/res/DouBanMovie.json";
                try {
                    URL url = new URL(movieUrl);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    /** 2 设置请求参数 */
                    urlConnection.setRequestMethod("GET");
                    //这里就简单的设置了网络的读取和连接时间上线，
                    // 如果时间到了还没成功，那就不再尝试responseCode
                    urlConnection.setConnectTimeout(5000);
                    urlConnection.setReadTimeout(10000);
                    /** 3 发起连接 */
                    urlConnection.connect();
                    /** 4 获取响应  */
                    int responseCode = urlConnection.getResponseCode();
                    Log.i(TAG, "--- responseCode:" + responseCode);
                    if (200 == responseCode) {
                        /* 获取响应的输入流 eagle snail */
                        InputStream inputStream = urlConnection.getInputStream();
                        /** 读取字符串 */
//                        String respJson  = NetInputUtils.readString(inputStream);
//                        Log.i(TAG, "--- response json:\n "+ respJson);
//                        VideoListResponse videoListResponse = convertJsonToBean(respJson);
                        /** 读取图片 */
                        final Bitmap bitmap = NetInputUtils.readImg(inputStream);
                        /** 子线程里不能更新UI*/
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mLogoIV.setImageBitmap(bitmap);
                            }
                        });
                        // 关闭输入流
                        inputStream.close();
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
