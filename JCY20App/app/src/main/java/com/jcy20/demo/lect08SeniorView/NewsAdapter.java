package com.jcy20.demo.lect08SeniorView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jcy20.demo.R;

import java.util.List;

public class NewsAdapter extends BaseAdapter {
    private String TAG = NewsAdapter.class.getSimpleName();
    private Context mContext;
    private List<News> mDataList;
    private final LayoutInflater mInflater;


    public NewsAdapter(Context context, List<News> dataList) {
        mContext = context;
        mDataList = dataList;

        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        int count = (null == mDataList ? 0 : mDataList.size());
        Log.i(TAG, "--- getCount() "+ count);
        return count;
    }

    @Override
    public News getItem(int position) {
        Log.i(TAG, "--- getItem() "+ position);
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        Log.i(TAG, "--- getItemId() "+ position);
        return position;
    }

    /**
     * 用来分别绘制ListView 的每一个Item。
     * Position 从0开始计数 ；
     * convertView是item 对应的view，最开始null，有复用机制
     * parent就是ListView*/
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.i(TAG, "--- getView() "+ position + " convertView: "+convertView);
        /** 构建布局加载器。实际开发过程中要考虑convertView的复用，不能每次都inflate加载布局 */
        ViewHolder holder;
        if (null == convertView) {
            /** 第一次创建convertView */
            convertView = mInflater.inflate(R.layout.item_news, null);
            holder = new ViewHolder();
            holder.iconIV = convertView.findViewById(R.id.iv_icon);
            holder.tltTV = convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        } else {
            /** 复用convertView */
            holder = (ViewHolder) convertView.getTag();
        }

        News news = mDataList.get(position);
        holder.iconIV.setImageResource(news.getPicId());
//        ImageLoader.load(holder.iconIV, "htt:xxxx.png");

        holder.tltTV.setText(news.getTitle());
        holder.iconIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "点了第"+position+"个新闻icon", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    private class ViewHolder {
        ImageView iconIV;
        TextView tltTV;
    }
}
