import org.testng.annotations.Test;
import pageobjects.BarCodePO;
import support.TestBase;

public class BarCodeTest extends TestBase {

    @Test
    public void BarCode(){
        BarCodePO barCode = new BarCodePO(driver);
        barCode.readQrCode();
    }
}
