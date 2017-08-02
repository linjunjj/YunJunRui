package com.linjun.yunjunrui.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.ui.device.fragment.DeviceFragment;
import com.linjun.yunjunrui.ui.discover.fragment.DiscoverFragment;
import com.linjun.yunjunrui.ui.me.fragment.MeFragment;
import com.linjun.yunjunrui.view.Backdialog;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 作者：林俊 on 2017/7/27
 * 作用：主界面
 */
public class MainActivity extends BaseActivity {

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
    private String[] datas = {"设备", "发现", "我的"};
   private Backdialog backdialog;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
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

}
