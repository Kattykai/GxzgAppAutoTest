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
     * @throws InterruptedException
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

    @Test
    public void autoTestCase002(){

    }


}
