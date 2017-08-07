package com.linjun.yunjunrui.ui.me.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.model.Usermodel;

import java.util.List;

/**
 * 作者：林俊 on 2017/8/5
 * 作用：
 */
public class AcountApater extends RecyclerView.Adapter<AcountApater.ViewHolder> implements View.OnClickListener {

    private LayoutInflater mInflater;
    private  RecyclerView recyclerView;
    private int mSelectedPos = -1;
    private List<Usermodel> list;
   // private  int size;
    public AcountApater(Context context, List list) {
        mInflater = LayoutInflater.from(context);
         this.list=list;
        //  this.size=size;
      //  this.recyclerView=recyclerView;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.iten_acount,parent,false);
        view.setOnClickListener(this);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder ;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
         holder.acount.setText(list.get(position).getUserName());
         holder.tel.setText(list.get(position).getUserTel());
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

    class  ViewHolder extends RecyclerView.ViewHolder {
        TextView acount,tel;
        public ViewHolder(View itemView) {
            super(itemView);
           acount=itemView.findViewById(R.id.account_manager);
            tel=itemView.findViewById(R.id.tel_manager);
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