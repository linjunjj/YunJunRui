package com.linjun.yunjunrui.utils;

import android.content.Context;

/**
 * Created by linjun on 2017/1/20.
 */

public class UnitConvert {
    public static int dip2px(Context context, int dip){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dip*scale);
    }

    public static int px2dip(Context context, int px){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px/scale);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @param fontScale
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @param fontScale
     *            （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
