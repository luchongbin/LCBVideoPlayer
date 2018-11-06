# LCBVideoPlayer  
# 先来个效果图  
![效果图](https://github.com/luchongbin/LCBVideoPlayer/blob/master/gif/introduce.gif)  
# 使用说明  
### 1、Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```  
### 2、Add the dependency：  
```  
dependencies {
	        implementation 'com.github.luchongbin:LCBVideoPlayer:v1.0.0'  
	}  
  ```  
### 3、在Manifest中Activity的注册文件中添加  
 ```
 android:configChanges="orientation|keyboardHidden|screenSize"/><!--重要-->
 ```  
 比如：
 ```
  <activity android:name=".VideoViewActivity"
            android:configChanges="orientation|keyboardHidden|screenSize"/><!--重要-->
```  
### 4、在xml布局文件中使用如下：  
```
<FrameLayout
        android:id="@+id/video_layout"
        android:layout_width="match_parent"
        android:layout_marginTop="30dp"
        android:layout_height="200dp"
        android:background="#00000000">
        <com.luchongbin.videoplayer.lcbvideoplayer.LCBVideoPlayer
            android:id="@+id/videoView"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
    </FrameLayout>
 ```
### 5、在你所使用的地方调用此方法就可以  
```
/**
     * <p>配置要播放的内容</p>
     * <p>Configuring the Content to Play</p>
     *
     * @param url         视频地址 | Video address
     * @param thumb       缩略图地址 | Thumbnail address
     * @param title       标题 | title
     * @param ifShowTitle 是否在非全屏下显示标题 | The title is displayed in full-screen under
     */
    public void setUp(String url, String thumb, String title, boolean ifShowTitle)  
   ```  
   如下所示：
   ```
   LCBVideoPlayer mLCBVideoPlayer = findViewById(R.id.videoView);
        String mImageUri = "https://pic.vjshi.com/2018-11-06/be3d03b4cf7e8468461de294db0757c2/online/puzzle.jpg?x-oss-process=style/watermark";
        String mVideoUri = "https://mp4.vjshi.com/2018-11-06/be3d03b4cf7e8468461de294db0757c2.mp4";
       
        mLCBVideoPlayer.setUp(mVideoUri,mImageUri,"标题",false);
```
