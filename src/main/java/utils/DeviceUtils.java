package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DeviceUtils {

    private static String udid = "";

    public static String getDeviceNameAndroid() {
        Runtime runtime = Runtime.getRuntime();
        Process process = null;
        try {
            process = runtime.exec("adb devices");
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            while ((udid = br.readLine()) != null) {
                if(udid.contains("\t")){
                    return (udid.substring(0, udid.lastIndexOf("\t")));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return udid;
    }
}
