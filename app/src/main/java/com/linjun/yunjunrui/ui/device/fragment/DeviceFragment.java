package com.linjun.yunjunrui.ui.device.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseFragment;
import com.linjun.yunjunrui.ui.device.adapter.OneFragmentPagerAdapter;
import com.linjun.yunjunrui.ui.device.entry.MenuItems;
import com.linjun.yunjunrui.ui.device.entry.TopRightMenu;
import com.linjun.yunjunrui.utils.UnitConvert;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * 作者：林俊 on 2017/7/27
 * 作用：设备操作类
 */
public class DeviceFragment extends BaseFragment {
    @BindView(R.id.rb_video)
    RadioButton rbVideo;
    @BindView(R.id.rb_gsm)
    RadioButton rbGsm;
    @BindView(R.id.group)
    RadioGroup group;
    @BindView(R.id.line)
    ImageView line;
    @BindView(R.id.fra_tfff)
    FrameLayout fraTfff;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.iv_refresh)
    ImageView ivRefresh;
    @BindView(R.id.main_text)
    TextView mainText;
    @BindView(R.id.iv_set)
    ImageView ivSet;
    Unbinder unbinder;
    private View view;
    private Toolbar toolbar;
    private TopRightMenu topRightMenu;
    private ArrayList<Fragment> fragments;

    @Override
    public void requestData() {
        mCurState = STATE_SUCCESS;
    }

    @Override
    public void showPage() {
        fragments = new ArrayList<>();
        fragments.add(new GsmFragment());
        fragments.add(new VideoFragment());
        vp.setAdapter(new OneFragmentPagerAdapter(getChildFragmentManager(), fragments));
        vp.setOnPageChangeListener(new PageChangeListener());
        vp.setCurrentItem(0);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_video:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb_gsm:
                        vp.setCurrentItem(0);
                        break;
                }
            }
        });
        frameLayout.addView(view);
    }

    private void openItem() {
        topRightMenu = new TopRightMenu(getActivity());
        List<MenuItems> menuItems = new ArrayList<>();
        menuItems.add(new MenuItems(R.mipmap.video, "视频设备"));
        menuItems.add(new MenuItems(R.mipmap.pdevice, "设备"));
        topRightMenu
                .setHeight(480)     //默认高度480
                .setWidth(320)      //默认宽度wrap_content
                .showIcon(true)     //显示菜单图标，默认为true
                .dimBackground(true)           //背景变暗，默认为true
                .needAnimationStyle(true)   //显示动画，默认为true
                .setAnimationStyle(R.style.TRM_ANIM_STYLE)  //默认为R.style.TRM_ANIM_STYLE
                .addMenuList(menuItems)
                .setOnMenuItemClickListener(new TopRightMenu.OnMenuItemClickListener() {
                    @Override
                    public void onMenuItemClick(int position) {
                        switch (position) {
                            case 0:

                                break;
                            case 1:

                                break;

                        }
                    }
                });
        // .showAsDropDown(topRightMenu, -225, 0);
//                        .showAsDropDown(moreBtn);
    }


    @OnClick({R.id.iv_refresh, R.id.iv_set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_refresh:
                break;
            case R.id.iv_set:
                openItem();
                break;
        }
    }


    public class PageChangeListener implements ViewPager.OnPageChangeListener {
        private int currentPage;
        @Override
        public void onPageScrolled(int i, float v, int i1) {
            int width = group.getWidth() / group.getChildCount();
            //设置白色下划线的起始偏移量
            int offset = width / 7;
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) line.getLayoutParams();
            lp.width = width - offset * 2;
            lp.topMargin = group.getHeight() - UnitConvert.dip2px(mContext, 8);
            if (currentPage == i) {
                lp.leftMargin = (int) (currentPage * width + offset + v * width);
            } else if (currentPage - i == 1) {
                lp.leftMargin = (int) (currentPage * width + offset - (1 - v) * width);
            }
            line.setLayoutParams(lp);
        }

        @Override
        public void onPageSelected(int i) {
            currentPage = i;
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }
}
