package com.linjun.yunjunrui.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseActivity;
import com.linjun.yunjunrui.ui.base.BaseFragment;
import com.linjun.yunjunrui.ui.device.fragment.DeviceFragment;
import com.linjun.yunjunrui.ui.discover.fragment.DiscoverFragment;
import com.linjun.yunjunrui.ui.me.fragment.MeFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 作者：林俊 on 2017/7/27
 * 作用：主界面
 */
public class MainActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fl_container)
    FrameLayout flContainer;
    @BindView(R.id.rgTabBar)
    RadioGroup rgMain;
    @BindView(R.id.main_text)
    TextView mainText;
    private int position = 0;
    private ArrayList<BaseFragment> fragments;
    private Fragment tempFragemnt;
    private String[] datas = {"设备", "发现", "我的"};

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    protected void initView() {
        mainText.setText(datas[position]);
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
                BaseFragment baseFragment = getFragment(position);
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

    private BaseFragment getFragment(int position) {
        if (fragments != null && fragments.size() > 0) {
            BaseFragment baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }

    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {
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

}
