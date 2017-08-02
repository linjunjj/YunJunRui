package com.linjun.yunjunrui.ui.device.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.dinuscxj.refresh.RecyclerRefreshLayout;
import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseFragment;
import com.linjun.yunjunrui.ui.device.adapter.GsmAdapter;
import com.linjun.yunjunrui.ui.device.bean.Gsmbean;
import com.linjun.yunjunrui.ui.device.entry.DividerItemDecoration;

import java.util.List;

/**
 * 作者：林俊 on 2017/7/31
 * 作用：
 */
public class GsmFragment extends BaseFragment  {
    private View view;
    private RecyclerRefreshLayout refresh;
    private RecyclerView recyclerView;
    private GsmAdapter gsmAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private List<String> list;
    @Override
    public void requestData() {
        mCurState = STATE_SUCCESS;
    }

    @Override
    public void showPage() {
         view=View.inflate(getActivity(),R.layout.fragment_gsm,null);
         init();
        initview();
        frameLayout.addView(view);
    }
    private  void init(){
        refresh=view.findViewById(R.id.refresh_lgsm);
        recyclerView=view.findViewById(R.id.recycler_gsmrecycler_gsm);
    }
    private void  initview(){
        mLinearLayoutManager=new LinearLayoutManager(getActivity());
        gsmAdapter=new GsmAdapter(getActivity());
        recyclerView.setLayoutManager(mLinearLayoutManager);
        recyclerView.setAdapter(gsmAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL_LIST));
    }



}
