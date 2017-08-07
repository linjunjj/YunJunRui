package com.linjun.yunjunrui.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lib.funsdk.support.FunSupport;
import com.lib.funsdk.support.OnFunGetUserInfoListener;
import com.lib.funsdk.support.models.FunUserInfo;
import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.db.DbHelper;
import com.linjun.yunjunrui.model.Usermodel;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.ui.device.fragment.DeviceFragment;
import com.linjun.yunjunrui.ui.discover.fragment.DiscoverFragment;
import com.linjun.yunjunrui.ui.me.fragment.MeFragment;
import com.linjun.yunjunrui.view.Backdialog;
import com.vise.xsnow.cache.SpCache;

import org.json.JSONException;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 作者：林俊 on 2017/7/27
 * 作用：主界面
 */
public class MainActivity extends BaseActivity implements OnFunGetUserInfoListener {

    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    @BindView(R.id.rgTabBar)
    RadioGroup rgMain;
    @BindView(R.id.device)
    RadioButton device;
    @BindView(R.id.discover)
    RadioButton discover;
    @BindView(R.id.me)
    RadioButton me;
    private int position = 0;
    private ArrayList<Fragment> fragments;
    private Fragment tempFragemnt;
   private Backdialog backdialog;
    private SpCache spCache;
    private FunUserInfo muserinfo;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        spCache=new SpCache(this);
        FunSupport.getInstance().registerOnFunGetUserInfoListener(this);
        tryToGetUserInfo();
        initFragment();
        initListener();
    }

    private void initListener() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.device:
                        position = 0;
                        break;
                    case R.id.discover:
                        position = 1;
                        break;
                    case R.id.me:
                        position = 2;
                        break;
                    default:
                        position = 0;
                        break;
                }
              Fragment baseFragment = getFragment(position);
                switchFragment(tempFragemnt, baseFragment);
            }
        });
        rgMain.check(R.id.device);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new DeviceFragment());
        fragments.add(new DiscoverFragment());
        fragments.add(new MeFragment());
    }

    private Fragment getFragment(int position) {
        if (fragments != null && fragments.size() > 0) {
            Fragment baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }
    private void tryToGetUserInfo(){
        if (!FunSupport.getInstance().getUserInfo()){

        }

    }

    private void switchFragment(Fragment fromFragment, Fragment nextFragment) {
        if (tempFragemnt != nextFragment) {
            tempFragemnt = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    //添加Fragment

                    transaction.add(R.id.fl_container, nextFragment).commit();
                } else {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }

    @Override
    protected void bindEvent() {

    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();
      backdialog=new Backdialog(this);
      backdialog.setYesOnclickListener(new Backdialog.onYesOnclickListener() {
          @Override
          public void onYesClick() {
              finish();
          }
      });
        backdialog.setNoOnclickListener(new Backdialog.onNoOnclickListener() {
            @Override
            public void onNoClick() {
               backdialog.dismiss();
            }
        });
        backdialog.show();
    }


    @Override
    public void onGetUserInfoSuccess(String strUserInfo) throws JSONException {
           muserinfo=new Gson().fromJson(strUserInfo,FunUserInfo.class);
         Usermodel usermodel=new Usermodel();
        usermodel.setUserId(Integer.parseInt(muserinfo.getUserId()));
        usermodel.setUserEmail(muserinfo.getEmail());
        usermodel.setUserName(muserinfo.getUserName());
        usermodel.setUserTel(muserinfo.getMobile_phone());
        usermodel.setUserPassWorld((String) spCache.get("userpsd"));
        DbHelper.getInstance().user().insert(usermodel);
    }

    @Override
    public void onGetUserInfoFailed(int errCode) {
        Toast.makeText(this,"获取账号信息失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLogoutSuccess() {

    }

    @Override
    public void onLogoutFailed(int errCode) {

    }


}
