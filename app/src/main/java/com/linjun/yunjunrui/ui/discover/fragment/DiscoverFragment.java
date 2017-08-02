package com.linjun.yunjunrui.ui.discover.fragment;

import android.view.View;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseFragment;
import com.zhouwei.mzbanner.MZBannerView;

/**
 * 作者：林俊 on 2017/7/27
 * 作用：发现操作类
 */
public class DiscoverFragment extends BaseFragment {
    private  View view;
    private MZBannerView banan;
    @Override
    public void requestData() {
      mCurState=STATE_SUCCESS;
    }

    @Override
    public void showPage() {
        view=View.inflate(getActivity(),R.layout.fragment_discover,null);
        init();
        frameLayout.addView(view);
    }
  private  void init(){
      banan=view.findViewById(R.id.banner);
  }

}
