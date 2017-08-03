package com.linjun.yunjunrui.ui.me.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseFragment;
import com.linjun.yunjunrui.ui.me.activity.ActivityAbout;
import com.linjun.yunjunrui.ui.me.activity.ActivityAcount;
import com.linjun.yunjunrui.ui.me.activity.ActivityChangPsd;
import com.linjun.yunjunrui.utils.ActionUtils;
import com.linjun.yunjunrui.view.WareView;

import cn.sharesdk.onekeyshare.OnekeyShare;
/**
 * 作者：林俊 on 2017/7/27
 * 作用：我的操作类
 */
public class MeFragment extends BaseFragment implements View.OnClickListener {
    private RelativeLayout about,share,account,changepsd;
    private View view;
    private OnekeyShare mOks;
    private WareView wareView;
    @Override
    public void requestData() {
        mCurState = STATE_SUCCESS;
    }
    @Override
    public void showPage() {
        view=View.inflate(getActivity(),R.layout.fragment_me,null);
        init();
        initView();
        frameLayout.addView(view);
    }
    private  void init(){
           about= view.findViewById(R.id.r_about);
            share=view.findViewById(R.id.r_share);
          account=view.findViewById(R.id.r_useracount);
           wareView=view.findViewById(R.id.wareview);
        changepsd=view.findViewById(R.id.r_change_psw);
         changepsd.setOnClickListener(this);
          about.setOnClickListener(this);
          share.setOnClickListener(this);
        account.setOnClickListener(this);
    }
    private  void initView(){
        final FrameLayout.LayoutParams layoutParams=new FrameLayout.LayoutParams(-2,-2);
        layoutParams.gravity= Gravity.BOTTOM|Gravity.CENTER;
        wareView.setOnWareAnimationListener(new WareView.OnWaveAnimationListener() {
            @Override
            public void OnWaveAnimation(float y) {
                layoutParams.setMargins(0,0,0,(int)y+2);
            }
        });



    }


    private void startShare() {
        mOks = new OnekeyShare();
        mOks.setTitle("云君瑞");
        mOks.setText("安防类app");
        mOks.setComment("好好");
        mOks.setSite(getString(R.string.app_name));
        mOks.show(getActivity());
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.r_about:
                ActionUtils.actionStart(getActivity(), ActivityAbout.class);
                break;
            case R.id.r_share:
                startShare();
                break;
            case R.id.r_useracount:
                ActionUtils.actionStart(getActivity(), ActivityAcount.class);
                break;
            case R.id.r_change_psw:
                ActionUtils.actionStart(getActivity(), ActivityChangPsd.class);
                  break;
        }
    }
}
