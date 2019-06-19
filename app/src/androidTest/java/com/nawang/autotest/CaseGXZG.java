package com.nawang.autotest;

import android.app.Instrumentation;
import android.util.Log;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.Until;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(AndroidJUnit4ClassRunner.class)
public class CaseGXZG extends BaseCase{
    Instrumentation instrumentation;
    UiDevice device;
    @Before
    public void setUp(){
        instrumentation = InstrumentationRegistry.getInstrumentation();
        device = UiDevice.getInstance(instrumentation);
    }

    @After
    public void tearDown(){

    }

    /**
     * Case001（首页_001--首页_005）
     * @throws IOException
     * @throws
     */
    @Test
    public void autoTestCase001() throws IOException, InterruptedException {
        restartApp(PKG,NWACTIVITY,ET);
        Assert.assertTrue(device.hasObject(By.res(rbMerchant).text("查企业")));
        Assert.assertTrue(device.hasObject(By.res(rbWebSite).text("查网站")));
        Assert.assertTrue(device.hasObject(By.res(rbProduct).text("查产品")));
        Log.i("自动化测试","查企业、查网站、查产品校验成功");
        Assert.assertTrue(device.hasObject(By.res(ET).text("请输入企业名、法人、信用代码等")));
        Log.i("自动化测试","查企业输入框默认文案校验成功");
        device.findObject(By.res(rbWebSite)).click();
        device.wait(Until.findObject(By.res(ET).text("请输入网站名、网址、备案号等")),5000);
        Assert.assertTrue(device.hasObject(By.res(ET).text("请输入网站名、网址、备案号等")));
        Log.i("自动化测试","查网站输入框默认文案校验成功");
        device.findObject(By.res(rbProduct)).click();
        device.wait(Until.findObject(By.res(ET).text("请输入产品名、商家名、条形码等")),5000);
        Assert.assertTrue(device.hasObject(By.res(ET).text("请输入产品名、商家名、条形码等")));
        Log.i("自动化测试","查产品输入框默认文案校验成功");
    }

    /**
     * Case001（首页_008--首页_010）
     * @throws IOException
     */
    @Test
    public void autoTestCase002() throws IOException, InterruptedException {
        restartApp(PKG,NWACTIVITY,ET);
        device.findObject(By.res(ET)).click();
        device.wait(Until.findObject(By.res(etContent)),5000);
        device.findObject(By.res(etContent)).setText("纳网");
        device.findObject(By.clazz("android.support.v7.app.ActionBar$Tab").desc("网站")).click();
        device.wait(Until.findObject(By.res(tvName)),10000);
        Assert.assertTrue(device.hasObject(By.res(tvName).text("厦门纳网科技股份有限公司官网")));
        device.findObject(By.clazz("android.support.v7.app.ActionBar$Tab").desc("产品")).click();
        device.wait(Until.findObject(By.res(tvProductName)),10000);
        Assert.assertTrue(device.hasObject(By.res(tvProductName).text("信用官网-安全可信赖的官网形象")));
        device.findObject(By.clazz("android.support.v7.app.ActionBar$Tab").desc("企业")).click();
        device.wait(Until.findObject(By.res(tvCompany)),10000);
        Assert.assertTrue(device.hasObject(By.res(tvCompany).text("北京纳网科技有限公司")));
    }

    /**
     *
     * @throws IOException
     * @throws
     */
    @Test
    public void autoTestCase003() throws IOException, InterruptedException {
        restartApp(PKG,NWACTIVITY,ET);
        device.findObject(By.res(rbProduct)).click();
        device.findObject(By.res(ET)).click();
        device.wait(Until.findObject(By.res(etContent).text("请输入产品名、商家名、条形码等")),5000);
        device.findObject(By.res(etContent)).setText("6924241101682");
        device.findObject(By.clazz("android.support.v7.app.ActionBar$Tab").desc("网站")).click();
        device.findObject(By.clazz("android.support.v7.app.ActionBar$Tab").desc("产品")).click();
        device.wait(Until.findObject(By.res(tvProductName)),5000);
        Assert.assertTrue(device.hasObject(By.res(tvProductName).text("晾晒收纳网袋")));
        Assert.assertTrue(device.hasObject(By.res(tvBarCode).text("条形码：6924241101682 (注册已通报)")));
    }

}
