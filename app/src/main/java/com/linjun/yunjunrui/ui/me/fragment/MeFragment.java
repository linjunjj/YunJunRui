package com.linjun.yunjunrui.ui.me.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseFragment;
import cn.sharesdk.onekeyshare.OnekeyShare;
/**
 * 作者：林俊 on 2017/7/27
 * 作用：我的操作类
 */
public class MeFragment extends BaseFragment implements View.OnClickListener {
    private RelativeLayout about,share,account;
    private View view;
    private OnekeyShare mOks;

    @Override
    public void requestData() {
        mCurState = STATE_SUCCESS;
    }
    @Override
    public void showPage() {
        view=View.inflate(getActivity(),R.layout.fragment_me,null);
        init();

        frameLayout.addView(view);
    }


    private  void init(){
           about= view.findViewById(R.id.r_about);
            share=view.findViewById(R.id.r_share);
          account=view.findViewById(R.id.r_useracount);
          about.setOnClickListener(this);
          share.setOnClickListener(this);
        account.setOnClickListener(this);
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
                break;
            case R.id.r_share:
                startShare();
                break;
            case R.id.user_account:
                break;

        }
    }
}
