package com.linjun.yunjunrui.ui.device.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;


import com.dinuscxj.refresh.RecyclerRefreshLayout;
import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseFragment;
import com.linjun.yunjunrui.ui.device.adapter.GsmAdapter;
import com.linjun.yunjunrui.ui.device.adapter.VideoApater;
import com.linjun.yunjunrui.ui.device.entry.DividerItemDecoration;

import java.util.List;

/**
 * 作者：林俊 on 2017/7/31
 * 作用：
 */
public class VideoFragment extends BaseFragment  {
    private View view;
    private RecyclerRefreshLayout refresh;
    private RecyclerView recyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private List<String> list;
    private VideoApater videoApater;
    @Override
    public void requestData() {
        mCurState = STATE_SUCCESS;
    }

    @Override
    public void showPage() {
      view=View.inflate(getActivity(), R.layout.fragment_video,null);
        init();
        initview();
        frameLayout.addView(view);
    }
private void init(){
    refresh=view.findViewById(R.id.refresh_layout);
    recyclerView=view.findViewById(R.id.recycler_view);

}
    private  void initview(){
        mLinearLayoutManager=new LinearLayoutManager(getActivity());
        videoApater=new VideoApater(getActivity());
        recyclerView.setLayoutManager(mLinearLayoutManager);
        recyclerView.setAdapter(videoApater);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL_LIST));
    }


}
