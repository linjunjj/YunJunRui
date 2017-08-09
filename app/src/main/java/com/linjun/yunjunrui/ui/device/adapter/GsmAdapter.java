package com.linjun.yunjunrui.ui.device.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lib.funsdk.support.models.FunDevice;
import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.device.bean.Gsmbean;
import com.linjun.yunjunrui.ui.device.fragment.GsmFragment;
import com.linjun.yunjunrui.view.SlidingButtonView;

import java.util.List;

/**
 * 作者：林俊 on 2017/8/2
 * 作用：
 */
public class GsmAdapter extends RecyclerView.Adapter<GsmAdapter.ViewHolder> implements View.OnClickListener,SlidingButtonView.IonSlidingButtonListener {
    private LayoutInflater mInflater;
    private List<FunDevice> list;
    private  SlidingButtonView mMenu=null;
    public GsmAdapter(Context context,List<FunDevice> list) {
        mInflater = LayoutInflater.from(context);
       this.list=list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.item_video_device,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.remark.setText(list.get(position).devSn);
       holder.videoname.setText(list.get(position).devName);
        holder.time.setText(list.get(position).devIp);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener!=null){
            onItemClickListener.onItemClick(view, (Integer) view.getTag());
        }
    }

    @Override
    public void onMenuIsOpen(View view) {
   mMenu= (SlidingButtonView) view;
    }
    @Override
    public void onDownOrMove(SlidingButtonView slidingButtonView) {
    if (menuIsOpen()){
        if (mMenu!=slidingButtonView){
            closeMenu();
        }
    }
    }
    public void closeMenu() {
        mMenu.closeMenu();
        mMenu = null;

    }
    /**
     * ÅÐ¶ÏÊÇ·ñÓÐ²Ëµ¥´ò¿ª
     */
    public Boolean menuIsOpen() {
        if(mMenu != null){
            return true;
        }

        return false;
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

