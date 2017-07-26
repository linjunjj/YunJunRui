package com.linjun.yunjunrui.loader;

import com.vise.xsnow.loader.GlideLoader;
import com.vise.xsnow.loader.ILoader;

/**
 * Created by linjun on 2017/7/26.
 */

public class LoaderManager {
    private static ILoader innerLoader;
    private static ILoader externalLoader;
    public static void setLoader(ILoader loader) {
        if (externalLoader == null && loader != null) {
            externalLoader = loader;
        }
    }

    public static ILoader getLoader() {
        if (innerLoader == null) {
            synchronized (LoaderManager.class) {
                if (innerLoader == null) {
                    if (externalLoader != null) {
                        innerLoader = externalLoader;
                    } else {
                        innerLoader = new GlideLoader();
                    }
                }
            }
        }
        return innerLoader;
    }
}
