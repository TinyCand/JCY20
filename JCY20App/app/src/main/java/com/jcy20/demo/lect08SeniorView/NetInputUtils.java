package com.jcy20.demo.lect08SeniorView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NetInputUtils {
    private static final String TAG = "NetInputUtils";
    public static String readString(InputStream inputStream) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
        // TODO 一行一行地去读取服务器响应内容
        String line = null;
        StringBuilder sb = new StringBuilder();
        do {
            // 读取一行数据
            line = bf.readLine();
            Log.i(TAG, "--- 服务器响应的数据:"+line);
            if (null != line) {
                sb.append(line);
            }
        } while (line != null);
        return sb.toString();
    }

    public static Bitmap readImg(InputStream inputStream) {
        /** 将输入流转成位图 */
        return BitmapFactory.decodeStream(inputStream);
    }
}
