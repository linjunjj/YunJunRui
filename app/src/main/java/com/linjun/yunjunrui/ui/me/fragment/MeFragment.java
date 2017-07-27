package com.linjun.yunjunrui.ui.me.fragment;

import android.view.View;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseFragment;

/**
 * 作者：林俊 on 2017/7/27
 * 作用：我的操作类
 */
public class MeFragment extends BaseFragment {
    private View view;
    @Override
    public void requestData() {
   mCurState=STATE_SUCCESS;
    }

    @Override
    public void showPage() {
  view=View.inflate(getActivity(), R.layout.fragment_me,null);
    }
}
