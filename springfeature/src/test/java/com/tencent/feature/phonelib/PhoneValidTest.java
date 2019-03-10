package com.tencent.feature.phonelib;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by andy on 2019/3/2.
 */
@Slf4j
public class PhoneValidTest {

    String oldUserPhoneNumber = "00841666170794";
    String newUserPhoneNumber = "00525611276038";

    @Test
    public void test() {
        testPhoneNumValid(oldUserPhoneNumber);
        testPhoneNumValid(newUserPhoneNumber);
    }

    @Test
    public void test1() {
        testPhoneNumValid(newUserPhoneNumber);
    }

    @Test
    public void test2() {
        testPhoneNumValid("008432170794");
    }



    @Test
    public void testGetJarVersion() throws IOException {
        getJarVersion();

    }

    private String getJarVersion() throws IOException {
        Properties properties = new Properties();
        properties.load(PhoneValidTest.class.getResourceAsStream(
                "/META-INF/maven/com.googlecode.libphonenumber/libphonenumber/pom.properties"));
        String version = (String) properties.get("version");
//        System.out.println(version);
        return version;
    }

    private void testPhoneNumValid(String phoneNum) {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber swissNumberProto = phoneUtil.parse(phoneNum, "CN");
//            boolean isPossible = phoneUtil.isPossibleNumber(swissNumberProto);
            boolean isValid = phoneUtil.isValidNumber(swissNumberProto); // returns true
            String jarVersion = getJarVersion();
            log.info("version:{} phoneNum:{} valid:{} isPossible:{}",
                    jarVersion, phoneNum, isValid);
        } catch (NumberParseException e) {
            System.err.println("NumberParseException was thrown: " + e.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
