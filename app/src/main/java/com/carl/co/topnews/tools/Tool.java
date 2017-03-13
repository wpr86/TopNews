package com.carl.co.topnews.tools;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by Host-0 on 2017/3/13.
 */

public class Tool {
    public final static int getWindowsWidth(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}
