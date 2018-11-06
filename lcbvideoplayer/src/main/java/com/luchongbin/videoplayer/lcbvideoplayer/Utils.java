package com.luchongbin.videoplayer.lcbvideoplayer;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Formatter;
import java.util.Locale;

/**
 * On Created by luchongbin on 2018/3/9.
 */
class Utils {
    public static void loadImage(Context context, String imgUrl, ImageView iv) {
        Glide.with(context)
                .load(imgUrl)
                .placeholder(new ColorDrawable(Color.parseColor("#f0f0f0")))
                .error(new ColorDrawable(Color.parseColor("#f0f0f0")))
                .crossFade().into(iv);


    }

    public static String stringForTime(int timeMs) {
        if (timeMs <= 0 || timeMs >= 24 * 60 * 60 * 1000) {
            return "00:00";
        }
        int totalSeconds = timeMs / 1000;
        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;
        StringBuilder mFormatBuilder = new StringBuilder();
        Formatter mFormatter = new Formatter(mFormatBuilder, Locale.getDefault());
        if (hours > 0) {
            return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
        } else {
            return mFormatter.format("%02d:%02d", minutes, seconds).toString();
        }
    }

}
