package com.linjun.yunjunrui.ui.me.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.linjun.yunjunrui.R;

/**
 * 作者：林俊 on 2017/8/5
 * 作用：
 */
public class AcountApater extends RecyclerView.Adapter<AcountApater.ViewHolder> implements View.OnClickListener {

    private LayoutInflater mInflater;
    private  RecyclerView recyclerView;
    private int mSelectedPos = -1;
    public AcountApater(Context context) {
        mInflater = LayoutInflater.from(context);

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
      //   holder.acount.setText();
     //    holder.tel.setText();
    }
    @Override
    public int getItemCount() {
        return 0;
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