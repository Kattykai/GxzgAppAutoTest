package com.nawang.autotest;

import android.app.Instrumentation;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.UiWatcher;
import androidx.test.uiautomator.Until;

import java.io.IOException;
import java.util.Random;

public class BaseCase extends NawangAppStr{
    Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
    UiDevice device = UiDevice.getInstance(instrumentation);

    //结束游戏盒进程并重启
    public void restartApp(String pkname,String acname,String waitres) throws IOException, InterruptedException {
        String amexc_pkname = "am force-stop "+pkname;
        String amexc_acname = "am start -n "+acname;
        device.executeShellCommand(amexc_pkname);
        Thread.sleep(2000);
        device.executeShellCommand(amexc_acname);
        device.wait(Until.findObject(By.res(waitres)),10000);
    }
    //滚动到指定object
    public void scrollIntoObject(String listCls,String resID) throws UiObjectNotFoundException {
        UiScrollable uiScrollable = new UiScrollable(new UiSelector().className(listCls));
        uiScrollable.setMaxSearchSwipes(500);
        uiScrollable.scrollIntoView(new UiSelector().resourceId(resID));
    }
    //注册监听器
    public void errorHandleAdd(String name_resgister, final String res_register){
        device.registerWatcher(name_resgister, new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                if (device.hasObject(By.res(res_register))){
                    device.findObject(By.res(res_register)).clickAndWait(Until.newWindow(),10000);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.i("UiWatcher","监听器已触发");
                }
                return false;
            }
        });
    }
    //找游戏tab点击
    public void tabClickHome(){
        UiObject2 tabObject = device.findObject(By.res("com.m4399.gamecenter:id/ctl_indicator"));
        int a = tabObject.getVisibleBounds().top;
        int b = tabObject.getVisibleBounds().bottom;
        int c = tabObject.getVisibleBounds().left;
        int d = tabObject.getVisibleBounds().right;
        device.click((d-c)/10,(b-a)/2+a);
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/iv_tag_icon")),1000);
    }
    //动态tab点击
    public  void tabClickZone(){
        UiObject2 tabObject = device.findObject(By.res("com.m4399.gamecenter:id/ctl_indicator"));
        int a = tabObject.getVisibleBounds().top;
        int b = tabObject.getVisibleBounds().bottom;
        int c = tabObject.getVisibleBounds().left;
        int d = tabObject.getVisibleBounds().right;
        device.click((d-c)*3/10,(b-a)/2+a);
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/zone_list_header_family")),1000);
    }
    //游戏圈tab点击
    public  void tabClickQuan(){
        UiObject2 tabObject = device.findObject(By.res("com.m4399.gamecenter:id/ctl_indicator"));
        int a = tabObject.getVisibleBounds().top;
        int b = tabObject.getVisibleBounds().bottom;
        int c = tabObject.getVisibleBounds().left;
        int d = tabObject.getVisibleBounds().right;
        device.click((d-c)*5/10,(b-a)/2+a);
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/tv_post_title")),1000);
    }
    //广场tab点击
    public  void tabClickSquare(){
        UiObject2 tabObject = device.findObject(By.res("com.m4399.gamecenter:id/ctl_indicator"));
        int a = tabObject.getVisibleBounds().top;
        int b = tabObject.getVisibleBounds().bottom;
        int c = tabObject.getVisibleBounds().left;
        int d = tabObject.getVisibleBounds().right;
        device.click((d-c)*7/10,(b-a)/2+a);
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/tv_view_all")),1000);
    }
    //我tab点击
    public void tabClickMy(){
        UiObject2 tabObject = device.findObject(By.res("com.m4399.gamecenter:id/ctl_indicator"));
        int a = tabObject.getVisibleBounds().top;
        int b = tabObject.getVisibleBounds().bottom;
        int c = tabObject.getVisibleBounds().left;
        int d = tabObject.getVisibleBounds().right;
        device.click((d-c)*9/10,(b-a)/2+a);
        device.wait(Until.findObject(By.res("com.m4399.gamecenter:id/tv_menu_logo")),1000);
    }
    //获取随机字符
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<length;i++){
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
