package com.linjun.yunjunrui.ui.device.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.dinuscxj.refresh.RecyclerRefreshLayout;
import com.lib.MsgContent;
import com.lib.funsdk.support.FunSupport;
import com.lib.funsdk.support.OnAddSubDeviceResultListener;
import com.lib.funsdk.support.OnFunDeviceListener;
import com.lib.funsdk.support.models.FunDevType;
import com.lib.funsdk.support.models.FunDevice;
import com.linjun.yunjunrui.R;
import com.linjun.yunjunrui.ui.base.BaseFragment;
import com.linjun.yunjunrui.ui.device.adapter.GsmAdapter;
import com.linjun.yunjunrui.ui.device.entry.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：林俊 on 2017/7/31
 * 作用：
 */
public class GsmFragment extends BaseFragment implements OnFunDeviceListener, OnAddSubDeviceResultListener {
    private View view;
    private RecyclerRefreshLayout refresh;
    private RecyclerView recyclerView;
    private GsmAdapter gsmAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private List<FunDevice> list=new ArrayList<>();
    private  List<FunDevice> gsmlist=new ArrayList<>();
    private final int MESSAGE_REFRESH_DEVICE_STATUS = 0x100;
    // 设备状态刷新时间间隔,目前为3分钟
    private static final int INTERVAL_REFRESH_DEV_STATUS = 3 * 60 * 1000;
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
        FunSupport.getInstance().registerOnFunDeviceListener(this);
        FunSupport.getInstance().registerOnAddSubDeviceResultListener(this);
    }
    private void  initview(){
        mLinearLayoutManager=new LinearLayoutManager(getActivity());
        requestToGetDeviceList();
        refresh.setOnRefreshListener(new RecyclerRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestToGetDeviceList();
            }
        });
        gsmAdapter=new GsmAdapter(getActivity(),gsmlist);
        recyclerView.setLayoutManager(mLinearLayoutManager);
        recyclerView.setAdapter(gsmAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL_LIST));
    }


    private void refreshDeviceList() {
        list.clear();
        list.addAll(FunSupport.getInstance().getDeviceList());
        list.addAll(FunSupport.getInstance().getAPDeviceList());
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).devType==FunDevType.EE_GSM_DEVICE){
                gsmlist.add(list.get(i));
            }
        }

        gsmAdapter.notifyDataSetChanged();
   if (list.size()>0){
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
    private void requestToGetDeviceList() {
        if (!FunSupport.getInstance().requestDeviceList()) {
            Toast.makeText(getActivity(),"sucess",Toast.LENGTH_SHORT).show();
        } else {
         Toast.makeText(getActivity(),"失败",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        FunSupport.getInstance().removeOnAddSubDeviceResultListener(this);
        FunSupport.getInstance().removeOnFunDeviceListener(this);
        super.onDestroy();
    }

    @Override
    public void onDeviceListChanged() {
      refreshDeviceList();
    }
    @Override
    public void onDeviceStatusChanged(FunDevice funDevice) {
          if (null!=gsmAdapter){
              gsmAdapter.notifyDataSetChanged();
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
}
