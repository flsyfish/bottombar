package com.bottombar.yul.bottombar.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.TypedValue;

/**
 * 工具类
 */
@SuppressLint("NewApi")
public class AndyUtils {
    /**
     * sp转px
     */
    public static int sp2px(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics());
    }


    /**
     * dp转px
     */
    public static int dipToPx(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                spVal, context.getResources().getDisplayMetrics());
    }
}
