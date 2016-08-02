package com.alenbeyond.androidutils.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil extends Toast {
    private static Toast toast;

    public ToastUtil(Context context) {
        super(context);
    }

    public static void showToast(Context context, String str, int time) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(context, str, time);
        toast.show();
    }
}