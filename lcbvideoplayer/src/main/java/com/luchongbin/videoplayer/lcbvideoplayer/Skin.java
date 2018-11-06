package com.luchongbin.videoplayer.lcbvideoplayer;

/**
 * On Created by luchongbin on 2018/3/9.
 */
class Skin {
    Skin(int titleColor, int timeColor, int seekDrawable, int bottomControlBackground, int enlargRecId, int shrinkRecId) {
        this.titleColor = titleColor;
        this.timeColor = timeColor;
        this.seekDrawable = seekDrawable;
        this.bottomControlBackground = bottomControlBackground;
        this.enlargRecId = enlargRecId;
        this.shrinkRecId = shrinkRecId;
    }

    int titleColor;
    int timeColor;
    int seekDrawable;
    int bottomControlBackground;
    int enlargRecId;
    int shrinkRecId;
}
