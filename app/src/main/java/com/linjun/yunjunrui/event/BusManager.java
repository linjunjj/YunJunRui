package com.linjun.yunjunrui.event;

import com.vise.xsnow.event.IBus;
import com.vise.xsnow.event.RxBusImpl;

/**
 * 作者：林俊 on 2017/7/26
 * 作用：
 */
public class BusManager {
    private static IBus innerBus;
    private static IBus externalBus;

    public static void setBus(IBus bus) {
        if (externalBus == null && bus != null) {
            externalBus = bus;
        }
    }

    public static IBus getBus() {
        if (innerBus == null) {
            synchronized (BusManager.class) {
                if (innerBus == null) {
                    if (externalBus != null) {
                        innerBus = externalBus;
                    } else {
                        innerBus = new RxBusImpl();
                    }
                }
            }
        }
        return innerBus;
    }
}
