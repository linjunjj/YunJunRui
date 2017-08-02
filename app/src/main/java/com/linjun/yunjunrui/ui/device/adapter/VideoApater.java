package com.linjun.yunjunrui.ui.device.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.device.bean.Gsmbean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：林俊 on 2017/8/2
 * 作用：
 */
public class VideoApater extends RecyclerView.Adapter<VideoApater.ViewHolder> implements View.OnClickListener {
    private LayoutInflater mInflater;
    private  List<String> data=new ArrayList<>();
    public VideoApater(Context context) {
        mInflater = LayoutInflater.from(context);

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.item_video_device,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder ;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }
    @Override
    public int getItemCount() {
        return 7;
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener!=null){
            onItemClickListener.onItemClick(view, (Integer) view.getTag());
        }
    }

    class  ViewHolder extends RecyclerView.ViewHolder {
           TextView videoname,time,remark;
        public  ViewHolder(View itemView) {
            super(itemView);
            videoname=itemView.findViewById(R.id.tv_videojiesi);
            time=itemView.findViewById(R.id.tv_videotime);
            remark=itemView.findViewById(R.id.ianhao);
        }
    }
    public interface  OnItemClickListener{
        /**
         * 当点击某条的时候被回调
         * @param
         */

        void onItemClick(View view, int position);
    }
    private OnItemClickListener onItemClickListener;

    /**
     * 设置item的监听
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
