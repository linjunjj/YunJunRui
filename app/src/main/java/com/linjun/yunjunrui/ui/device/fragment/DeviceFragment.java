package com.linjun.yunjunrui.ui.device.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseFragment;
import com.linjun.yunjunrui.ui.device.activity.ActivityAddGsm;
import com.linjun.yunjunrui.ui.device.activity.ActivityAddVideo;
import com.linjun.yunjunrui.ui.device.activity.ActivityConType;
import com.linjun.yunjunrui.ui.device.adapter.OneFragmentPagerAdapter;
import com.linjun.yunjunrui.ui.device.entry.MenuItems;
import com.linjun.yunjunrui.ui.device.entry.TopRightMenu;
import com.linjun.yunjunrui.utils.ActionUtils;
import com.linjun.yunjunrui.utils.UnitConvert;

import java.util.ArrayList;
import java.util.List;


/**
 * 作者：林俊 on 2017/7/27
 * 作用：设备操作类
 */
public class DeviceFragment extends BaseFragment implements View.OnClickListener {
   private  ViewPager vp;
    private  ImageView refresh,add,line;
    private View view;
    private Toolbar toolbar;
    private TopRightMenu topRightMenu;
    private ArrayList<Fragment> fragments;
    private RadioGroup group;
    private EditText search;
    @Override
    public void requestData() {
        mCurState = STATE_SUCCESS;
    }

    @Override
    public void showPage() {
        view=View.inflate(getActivity(),R.layout.fragment_device,null);
        init();

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
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb_gsm:
                        vp.setCurrentItem(1);
                        break;
                }
            }
        });
        frameLayout.addView(view);
    }
   private  void init(){
       vp=view.findViewById(R.id.vp);
       add=view.findViewById(R.id.iv_add);
       refresh=view.findViewById(R.id.iv_refresh);
       line=view.findViewById(R.id.line);
       group=view.findViewById(R.id.group);
       search=view.findViewById(R.id.seach);
       search.setInputType(InputType.TYPE_NULL);
         add.setOnClickListener(this);
         refresh.setOnClickListener(this);
   }
    private void openItem() {
        topRightMenu = new TopRightMenu(getActivity());
        List<MenuItems> menuItems = new ArrayList<>();
        menuItems.add(new MenuItems(R.mipmap.video, "视频设备"));
        menuItems.add(new MenuItems(R.mipmap.pdevice, "设备"));
        topRightMenu
                .setHeight(300)     //默认高度480
                .setWidth(350)      //默认宽度wrap_content
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
                                ActionUtils.actionStart(getActivity(), ActivityConType.class);
                                break;
                            case 1:
                              ActionUtils.actionStart(getActivity(), ActivityConType.class);
                                break;

                        }
                    }
                })
                .showAsDropDown(add, -200, 0);
        // .showAsDropDown(topRightMenu, -225, 0);
//                        .showAsDropDown(moreBtn);
    }

    @Override
    public void onClick(View view) {
    switch (view.getId()){
        case R.id.iv_add:
            openItem();
            break;
        case R.id.iv_refresh:

            break;
        case R.id.seach:
            search.setInputType(InputType.TYPE_CLASS_TEXT);
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
