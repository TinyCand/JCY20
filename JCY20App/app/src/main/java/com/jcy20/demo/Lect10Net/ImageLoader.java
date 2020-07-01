package com.jcy20.demo.Lect10Net;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import com.jcy20.demo.lect08SeniorView.NetInputUtils;

import java.io.InputStream;

public class ImageLoader {
    private static final ImageLoader instance = new ImageLoader();
    private Handler mHandler;
    private ImageLoader(){
        /* 构建一个主线程的Handler */
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static ImageLoader getInstance() {
        return instance;
    }

    public void load(final ImageView iconIV, final String thumbPath) {
        iconIV.setTag(thumbPath);
        iconIV.setBackgroundColor(Color.GRAY);
        HttpProxy.getInstance().load(thumbPath, new HttpProxy.NetInputCallback() {
            @Override
            public void onSuccess(InputStream inputStream) {
                /** 读取图片 */
                final Bitmap bitmap = NetInputUtils.readImg(inputStream);
                /* 子线程里不能更新UI, 通过Handler切换到主线程里更新 */
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        String tag = (String) iconIV.getTag();
                        if (tag.equals(thumbPath)) {
                            iconIV.setImageBitmap(bitmap);
                        }
                    }
                });
            }
        });


    }
}
