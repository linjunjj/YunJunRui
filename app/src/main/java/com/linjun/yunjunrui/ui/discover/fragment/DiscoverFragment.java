package com.linjun.yunjunrui.ui.discover.fragment;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;

import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseFragment;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：林俊 on 2017/7/27
 * 作用：发现操作类
 */
public class DiscoverFragment extends BaseFragment implements View.OnClickListener {
    public static final int []RES = new int[]{R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image6,R.drawable.image7,R.drawable.image8};
    private  View view;
    private MZBannerView banan;
    private RelativeLayout Scan;
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
       Scan=view.findViewById(R.id.r_lanSan);
      Scan.setOnClickListener(this);
      setBan();
  }
  private  void setBan(){
      List<Integer> list = new ArrayList<>();
      for(int i=0;i<RES.length;i++){
          list.add(RES[i]);
      }
      banan.setIndicatorVisible(false);
      banan.setPages(list, new MZHolderCreator<BannerViewHolder>() {
          @Override
          public BannerViewHolder createViewHolder() {
              return new BannerViewHolder();
          }
      });
  }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.r_lanSan:

                break;
        }
    }

    public static class BannerViewHolder implements MZViewHolder<Integer> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局文件
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item,null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }
        @Override
        public void onBind(Context context, int position, Integer data) {
            // 数据绑定
            mImageView.setImageResource(data);
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        banan.pause();
        banan.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        banan.start();
        banan.start();
    }
}
