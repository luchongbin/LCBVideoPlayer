# LCBVideoPlayer  
# 先来个效果图  
![效果图](https://github.com/luchongbin/LCBVideoPlayer/blob/master/gif/introduce.gif)  
# 使用说明  
1、Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```  
2、Add the dependency：  
```  
dependencies {
	        implementation 'com.github.luchongbin:LCBVideoPlayer:v1.0.0'  
	}  
  ```  
 3、在Manifest中Activity的注册文件中添加  
 ```
 android:configChanges="orientation|keyboardHidden|screenSize"/><!--重要-->
 ```  
 比如：
 ```
  <activity android:name=".VideoViewActivity"
            android:configChanges="orientation|keyboardHidden|screenSize"/><!--重要-->
```
4、在你所使用的地方调用此方法就可以  
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
