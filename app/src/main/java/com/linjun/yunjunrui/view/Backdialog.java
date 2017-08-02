package com.linjun.yunjunrui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.linjun.yunjunrui.R;

/**
 * 作者：林俊 on 2017/8/2
 * 作用：
 */
public class Backdialog extends Dialog implements View.OnClickListener {
    private TextView sure,cancel;
    private  Context context;
    private onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器
    private onYesOnclickListener yesOnclickListener;//确定按钮被点击了的监听器
    public Backdialog( Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popw_back);
        init();

    }
  private void init(){
      sure=findViewById(R.id.sure);
      cancel=findViewById(R.id.cancel);
      sure.setOnClickListener(this);
      cancel.setOnClickListener(this);
  }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sure:
                if (yesOnclickListener != null) {
                    yesOnclickListener.onYesClick();
                }
               // ((Activity)context).finish();
                break;
            case R.id.cancel:
                if (noOnclickListener != null) {
                noOnclickListener.onNoClick();
            }
                //dismiss();
                break;
        }
    }


    public interface onYesOnclickListener {
        public void onYesClick();
    }

    public interface onNoOnclickListener {
        public void onNoClick();
    }
    public void setNoOnclickListener(onNoOnclickListener onNoOnclickListener) {

        this.noOnclickListener = onNoOnclickListener;
    }

    /**
     * 设置确定按钮的显示内容和监听
     *
     * @param str
     * @param onYesOnclickListener
     */
    public void setYesOnclickListener( onYesOnclickListener onYesOnclickListener) {
        this.yesOnclickListener = onYesOnclickListener;
    }
}
