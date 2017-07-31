package com.linjun.yunjunrui.ui.me.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseFragment;
import com.linjun.yunjunrui.ui.me.activity.ActivityAbout;
import com.linjun.yunjunrui.ui.me.activity.ActivityAcount;
import com.linjun.yunjunrui.utils.ActionUtils;
import com.linjun.yunjunrui.view.UISwitchButton;
import com.linjun.yunjunrui.view.WareView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.sharesdk.onekeyshare.OnekeyShare;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * 作者：林俊 on 2017/7/27
 * 作用：我的操作类
 */
public class MeFragment extends BaseFragment {
    @BindView(R.id.wareview)
    WareView wareview;
    @BindView(R.id.ci_usericon)
    CircleImageView ciUsericon;
    @BindView(R.id.tv_tips)
    TextView tvTips;
    @BindView(R.id.header)
    LinearLayout header;
    @BindView(R.id.tv_tel)
    TextView tvTel;
    @BindView(R.id.im)
    ImageView im;
    @BindView(R.id.r_useracount)
    RelativeLayout rUseracount;
    @BindView(R.id.r_user_icon)
    RelativeLayout rUserIcon;
    @BindView(R.id.r_change_psw)
    RelativeLayout rChangePsw;
    @BindView(R.id.newsubbmit)
    UISwitchButton newsubbmit;
    @BindView(R.id.intent_switch)
    UISwitchButton intentSwitch;
    @BindView(R.id.r_about)
    RelativeLayout rAbout;
    @BindView(R.id.r_share)
    RelativeLayout rShare;
    Unbinder unbinder;
    Unbinder unbinder1;
    private View view;
    private OnekeyShare mOks;

    @Override
    public void requestData() {
        mCurState = STATE_SUCCESS;
    }

    @Override
    public void showPage() {


    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_me;
    }

    @OnClick({R.id.r_user_icon, R.id.r_change_psw, R.id.newsubbmit, R.id.intent_switch, R.id.r_about, R.id.r_share,R.id.r_useracount})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.r_user_icon:
                break;
            case R.id.r_change_psw:
                break;
            case R.id.newsubbmit:
                break;
            case R.id.intent_switch:
                break;
            case R.id.r_about:
                ActionUtils.actionStart(getActivity(), ActivityAbout.class);
                break;
            case R.id.r_share:
                startShare();
                break;
            case R.id.r_useracount:
                ActionUtils.actionStart(getActivity(), ActivityAcount.class);
                break;
        }
    }


    private void startShare() {
        mOks = new OnekeyShare();
        mOks.setTitle("云君瑞");
        mOks.setText("安防类app");
        mOks.setImageUrl(getResources().getDrawable(R.mipmap.logo));
        mOks.setComment("好好");
        mOks.setSite(getString(R.string.app_name));
        mOks.show(getActivity());
    }




}
