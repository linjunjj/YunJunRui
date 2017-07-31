package com.linjun.yunjunrui.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.linjun.yunjunrui.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：林俊 on 2017/7/27
 * 作用：Fragment基类
 */
public abstract class BaseFragment extends Fragment {
    public static final int STATE_UNKNOWN = 0;
    public static final int STATE_ERR = 1;
    public static final int STATE_LOADING = 2;
    public static final int STATE_EMPTY = 3;
    public static final int STATE_SUCCESS = 4;
    public int mCurState;
    protected static FragmentActivity mContext;
    public FrameLayout frameLayout;
    private View errPageView;
    private View loadingPageView;
    private View emptyPageView;
    private View rootview;
      private  Unbinder unbinder;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        init();
        showLoadingState();
        return frameLayout;
    }
    private void init() {
        mContext = getActivity();
        frameLayout = new FrameLayout(getActivity());
        errPageView = View.inflate(getActivity(), R.layout.page_err_state, null);
        loadingPageView = View.inflate(getActivity(),
                R.layout.page_loading_state, null);
        emptyPageView = View.inflate(getActivity(), R.layout.page_empty_state,
                null);
        frameLayout.addView(errPageView);
        frameLayout.addView(loadingPageView);
        frameLayout.addView(emptyPageView);
        //初始化为未知状态
        mCurState = STATE_LOADING;
        requestData();

        Button bt = ((Button) errPageView.findViewById(R.id.bt_reload));
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 重新加载
                mCurState = STATE_LOADING;
                showLoadingState();
                requestData();
            }
        });
    }


    /**
     * 显示请求数据的状态
     */
    public void showLoadingState() {
        emptyPageView.setVisibility(mCurState == STATE_EMPTY ? View.VISIBLE
                : View.INVISIBLE);
        errPageView.setVisibility(mCurState == STATE_ERR ? View.VISIBLE
                : View.INVISIBLE);
        loadingPageView.setVisibility(mCurState == STATE_UNKNOWN
                || mCurState == STATE_LOADING ? View.VISIBLE : View.INVISIBLE);
        if (mCurState == STATE_SUCCESS) {
            rootview=View.inflate(getActivity(),getLayoutResId(),null);
            unbinder=ButterKnife.bind(this,rootview);
            frameLayout.addView(rootview);
            showPage();
        }
    }

    /**
     * 如果要显示加载完成页面必须将mCurState设置为STATE_SUCCESS
     */
    public abstract void requestData();
    /**
     * 如果STATE_SUCCESS加载成功将会调用此方法用于显示加载成功后的页面
     */
    public abstract void showPage();
    public abstract int getLayoutResId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
