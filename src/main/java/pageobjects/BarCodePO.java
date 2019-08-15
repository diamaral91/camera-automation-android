package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.temporal.ChronoUnit;

public class BarCodePO {

    public BarCodePO(AppiumDriver<?> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean readQrCode(){
        this.link.click();
        return this.page.isDisplayed();
    }

    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    @FindBy(id = "com.google.zxing.client.android:id/contents_text_view")
    private MobileElement link;

    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    @FindBy(className = "android.webkit.WebView")
    private MobileElement page;
}
