package com.linjun.yunjunrui.ui.device.fragment;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseFragment;
import com.linjun.yunjunrui.ui.device.entry.MenuItems;
import com.linjun.yunjunrui.ui.device.entry.TopRightMenu;
import com.linjun.yunjunrui.utils.ActionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：林俊 on 2017/7/27
 * 作用：设备操作类
 */
public class DeviceFragment extends BaseFragment {
    private  View view;
    private  Toolbar toolbar;
    private TopRightMenu topRightMenu;
    @Override
    public void requestData() {
        mCurState = STATE_SUCCESS;
    }

    @Override
    public void showPage() {
        view = View.inflate(getActivity(), R.layout.fragment_device, null);
        toolbar=getActivity().findViewById(R.id.toolbar);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.device_item, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {

            switch (menuItem.getItemId()) {
                case R.id.action_add:
                    openItem();
                    break;
            }
            return true;
        }
    };
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
                       switch (position){
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
}
