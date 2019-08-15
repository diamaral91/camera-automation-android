package support;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.DeviceUtils;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    public AppiumDriver<?> driver;

    private static final String URL_STRING = "http://0.0.0.0:4723/wd/hub";
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private String udidLocal = DeviceUtils.getDeviceNameAndroid();

    @BeforeTest
    public void setUp() throws MalformedURLException {
        capabilities.setCapability(MobileCapabilityType.UDID, udidLocal);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, udidLocal);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.zxing.client.android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "CaptureActivity");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        driver = new AndroidDriver<>(new URL(URL_STRING), capabilities);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
