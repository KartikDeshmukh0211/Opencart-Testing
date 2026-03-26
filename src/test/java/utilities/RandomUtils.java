package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtils {
    public static String randomString(){
        return RandomStringUtils.secure().nextAlphabetic(6);
    }

    public static String randomNumber(){
        return RandomStringUtils.secure().nextNumeric(10);
    }

    public static String randomAplhaNumric(){
        return RandomStringUtils.secure().nextAlphanumeric(8);
    }
}
