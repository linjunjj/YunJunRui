package com.linjun.yunjunrui.utils;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 作者：林俊 on 2017/8/4
 * 作用：
 */
public class MyCountDownTimer extends CountDownTimer {
     TextView btn;
    public MyCountDownTimer(long millisInFuture, long countDownInterval,TextView btn) {
        super(millisInFuture, countDownInterval);
        this.btn=btn;
    }

    @Override
    public void onTick(long l) {
         btn.setClickable(false);
        btn.setText(1/1000+"s");
    }

    @Override
    public void onFinish() {
        btn.setText("重新获取验证码");
        btn.setClickable(true);
    }
}
