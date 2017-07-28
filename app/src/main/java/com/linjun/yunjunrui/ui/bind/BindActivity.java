package com.linjun.yunjunrui.ui.bind;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.view.EditTextWithDeleteButton;
import com.vise.xsnow.cache.SpCache;

import butterknife.BindView;


/**
 * 作者：林俊 on 2017/7/28
 * 作用：绑定地址
 */
public class BindActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.cancel)
    TextView cancel;
    @BindView(R.id.btn_band)
    Button btnBand;
    @BindView(R.id.ed_address)
    EditTextWithDeleteButton edAddress;
    private SpCache spCache;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_bound;
    }

    @Override
    protected void initView() {
          spCache = new SpCache(this);
          btnBand.setOnClickListener(this);
          cancel.setOnClickListener(this);
    }
    @Override
    protected void bindEvent() {

    }
    @Override
    public void onClick(View view) {
         switch (view.getId()){
             case R.id.cancel:
                 this.finish();
                 break;
             case R.id.btn_band:
               spCache.put("address",edAddress.getText().toString().trim());
                 break;
         }
    }
}
