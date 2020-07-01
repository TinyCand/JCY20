package com.jcy20.demo.Lect10Net;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpProxy {
    private static final String TAG = "HttpProxy";
    private static final HttpProxy instance = new HttpProxy();

    private HttpProxy(){
    }

    public static HttpProxy getInstance() {
        return instance;
    }

    public void load(final String urlStr, final NetInputCallback callback) {
        // 可优化放到线程池
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Android 9 默认不支持单纯的http传输，加usesCleartextTraffic="true"
                try {
                    URL url = new URL(urlStr);
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
                        callback.onSuccess(inputStream);
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

    public interface NetInputCallback {

        void onSuccess(InputStream inputStream);
    }


}
