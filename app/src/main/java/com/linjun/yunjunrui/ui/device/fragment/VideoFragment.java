package com.linjun.yunjunrui.ui.device.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.dinuscxj.refresh.RecyclerRefreshLayout;
import com.lib.MsgContent;
import com.lib.funsdk.support.FunSupport;
import com.lib.funsdk.support.OnAddSubDeviceResultListener;
import com.lib.funsdk.support.OnFunDeviceListener;
import com.lib.funsdk.support.OnFunDeviceOptListener;
import com.lib.funsdk.support.models.FunDevType;
import com.lib.funsdk.support.models.FunDevice;
import com.lib.funsdk.support.models.FunLoginType;
import com.lib.sdk.struct.H264_DVR_FILE_DATA;
import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseFragment;
import com.linjun.yunjunrui.ui.device.adapter.GsmAdapter;
import com.linjun.yunjunrui.ui.device.adapter.VideoApater;
import com.linjun.yunjunrui.ui.device.entry.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：林俊 on 2017/7/31
 * 作用：
 */
public class VideoFragment extends BaseFragment implements OnFunDeviceListener, OnAddSubDeviceResultListener, OnFunDeviceOptListener {
    private View view;
    private RecyclerRefreshLayout refresh;
    private RecyclerView recyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private List<FunDevice> list=new ArrayList<>();
    private  List<FunDevice> videolist=new ArrayList<>();
    private VideoApater videoApater;
    private final int MESSAGE_REFRESH_DEVICE_STATUS = 0x100;

    // 设备状态刷新时间间隔,目前为3分钟
    private static final int INTERVAL_REFRESH_DEV_STATUS = 3 * 60 * 1000;
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
    FunSupport.getInstance().setLoginType(FunLoginType.LOGIN_BY_INTENTT);
    FunSupport.getInstance().registerOnFunDeviceListener(this);
    FunSupport.getInstance().registerOnAddSubDeviceResultListener(this);
}
    private  void initview(){
        mLinearLayoutManager=new LinearLayoutManager(getActivity());
        requestToGetDeviceList();
        refresh.setOnRefreshListener(new RecyclerRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestToGetDeviceList();
            }
        });
        videoApater=new VideoApater(getActivity());
        recyclerView.setLayoutManager(mLinearLayoutManager);
        recyclerView.setAdapter(videoApater);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL_LIST));
    }

 private void requestToGetDeviceList(){
     if (!FunSupport.getInstance().requestDeviceList()){
     }
 }
   private void refreshDeviceList(){
       list.clear();
       list.addAll(FunSupport.getInstance().getDeviceList());
       for (int i = 0; i <list.size() ; i++) {
           if (list.get(i).devType== FunDevType.EE_DEV_NORMAL_MONITOR){
               videolist.add(list.get(i));
           }
       }
       videoApater.notifyDataSetChanged();
       mHandler.removeMessages(MESSAGE_REFRESH_DEVICE_STATUS);

       if (list.size() > 0) {
           mHandler.sendEmptyMessageDelayed(MESSAGE_REFRESH_DEVICE_STATUS, 100);
       }
   }
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_REFRESH_DEVICE_STATUS: {
                    FunSupport.getInstance().requestAllDeviceStatus();
                    // 3分钟之后再次获取状态
                    removeMessages(MESSAGE_REFRESH_DEVICE_STATUS);
                    sendEmptyMessageDelayed(MESSAGE_REFRESH_DEVICE_STATUS, INTERVAL_REFRESH_DEV_STATUS);
                }
                break;
            }
        }

    };

    @Override
    public void onDestroy() {
        FunSupport.getInstance().removeOnFunDeviceListener(this);
        FunSupport.getInstance().removeOnFunDeviceOptListener(this);
        FunSupport.getInstance().removeOnAddSubDeviceResultListener(this);
        super.onDestroy();
    }

    @Override
    public void onDeviceListChanged() {
        refreshDeviceList();
    }

    @Override
    public void onDeviceStatusChanged(FunDevice funDevice) {
        if (null!=videoApater){
            videoApater.notifyDataSetChanged();
        }
    }

    @Override
    public void onDeviceAddedSuccess() {
        Toast.makeText(getActivity(),"设备添加成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeviceAddedFailed(Integer errCode) {

    }

    @Override
    public void onDeviceRemovedSuccess() {

    }

    @Override
    public void onDeviceRemovedFailed(Integer errCode) {

    }

    @Override
    public void onAPDeviceListChanged() {

    }

    @Override
    public void onLanDeviceListChanged() {

    }

    @Override
    public void onAddSubDeviceFailed(FunDevice funDevice, MsgContent msgContent) {

    }

    @Override
    public void onAddSubDeviceSuccess(FunDevice funDevice, MsgContent msgContent) {

    }

    @Override
    public void onDeviceLoginSuccess(FunDevice funDevice) {

    }

    @Override
    public void onDeviceLoginFailed(FunDevice funDevice, Integer errCode) {

    }

    @Override
    public void onDeviceGetConfigSuccess(FunDevice funDevice, String configName, int nSeq) {

    }

    @Override
    public void onDeviceGetConfigFailed(FunDevice funDevice, Integer errCode) {

    }

    @Override
    public void onDeviceSetConfigSuccess(FunDevice funDevice, String configName) {

    }

    @Override
    public void onDeviceSetConfigFailed(FunDevice funDevice, String configName, Integer errCode) {

    }

    @Override
    public void onDeviceChangeInfoSuccess(FunDevice funDevice) {

    }

    @Override
    public void onDeviceChangeInfoFailed(FunDevice funDevice, Integer errCode) {

    }

    @Override
    public void onDeviceOptionSuccess(FunDevice funDevice, String option) {

    }

    @Override
    public void onDeviceOptionFailed(FunDevice funDevice, String option, Integer errCode) {

    }

    @Override
    public void onDeviceFileListChanged(FunDevice funDevice) {

    }

    @Override
    public void onDeviceFileListChanged(FunDevice funDevice, H264_DVR_FILE_DATA[] datas) {

    }

    @Override
    public void onDeviceFileListGetFailed(FunDevice funDevice) {

    }
}
