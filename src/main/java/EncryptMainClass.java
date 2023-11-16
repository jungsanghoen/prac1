
import service.EncryptDecrypt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class EncryptMainClass {
    public static void main(String[] args) {
        EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
        encryptDecrypt.setKEY("thisiskeyfile123");
        encryptDecrypt.setIV("thisisivkeyfile1");


        String plainText = "9888";
        System.out.println("원본 텍스트 : " + plainText);
        String oneTimeStr = oneTimeEnc(plainText, encryptDecrypt);
        String twoTimeStr = twoTimeEnc(plainText, encryptDecrypt);
        System.out.println("암호문 1번 텍스트 : " + oneTimeStr);
        System.out.println("암호문 2번 텍스트 : " + twoTimeStr);

        oneTimeStr = oneTimeDec(oneTimeStr, encryptDecrypt);
        twoTimeStr = twoTimeDec(twoTimeStr, encryptDecrypt);
        System.out.println("암호문 1번 복호화 : " + oneTimeStr);
        System.out.println("암호문 2번 복호화 : " + twoTimeStr);

        String salt = "20230503215230";
        String madeStr = salt + plainText;
        oneTimeStr = oneTimeEnc(madeStr, encryptDecrypt);
        twoTimeStr = twoTimeEnc(madeStr, encryptDecrypt);
        System.out.println("Salt + 암호문 1번 테스트 : " + oneTimeStr);
        System.out.println("Salt + 암호문 2번 테스트 : " + twoTimeStr);

        oneTimeStr = oneTimeDec(oneTimeStr, encryptDecrypt);
        twoTimeStr = twoTimeDec(twoTimeStr, encryptDecrypt);
        System.out.println("Salt + 암호문 해독 1번 테스트 : " + oneTimeStr.substring(oneTimeStr.length() - 4));
        System.out.println("Salt + 암호문 해독 2번 테스트 : " + twoTimeStr.substring(twoTimeStr.length() - 4));

        checkOtherLength(encryptDecrypt);

    }

    public static String oneTimeEnc(String plainText, EncryptDecrypt encryptDecrypt) {
        String enc = "";
        try {

            enc = encryptDecrypt.aes256Encrypt(plainText);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return enc;
    }

    public static String twoTimeEnc(String plainText, EncryptDecrypt encryptDecrypt) {
        String enc = "";
        try {
            enc = encryptDecrypt.aes256Encrypt(plainText);
            enc = encryptDecrypt.aes256Encrypt(enc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return enc;
    }

    public static void checkOtherLength(EncryptDecrypt encryptDecrypt) {
        int start_index = 0, encLength = 64, starting = 0;
        String tempEnc = null;
        //String salt = "2023050421113022";
        for(;starting < 1000; starting++) {
            String salt = makeSalt(starting);
            for (int i = 0; i < 100; i++) {
                String tempPlain = String.format("%04d", start_index);
                Random random = new Random();
                int randomNumber = random.nextInt(100000000);
                //tempPlain = String.format("%08d", randomNumber) + tempPlain;
                tempPlain = makeSaltText(salt, tempPlain);
                try {
                    //tempEnc = encryptDecrypt.aes256Encrypt(tempPlain);
                    //tempEnc = oneTimeEnc(tempPlain, encryptDecrypt);
                    tempEnc = twoTimeEnc(tempPlain, encryptDecrypt);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                //System.out.println("평문 = " + tempPlain + " 암호문 = " + tempEnc);
                if (tempEnc.length() != encLength) {
                    System.out.println("암호문 중 다른 length 발견됨 " + tempEnc);
                }
                start_index++;
            }
        }
    }

    public static String makeSalt(int index) {
        String formattedDateTime;
        LocalDateTime now = LocalDateTime.now().plusDays(index);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        formattedDateTime = now.format(formatter);
        System.out.println("salt date = " + formattedDateTime);
        return formattedDateTime;
    }

    public static String makeSaltText(String salt, String tempPlain) {
        String saltText = "";
        saltText = salt.substring(0, salt.length() / 2) + tempPlain + salt.substring(salt.length() / 2);
        //System.out.println("왼쪽 salt = " + salt.substring(0, salt.length() / 2) + " 오른쪽 salt = " + salt.substring(salt.length() / 2));
        //System.out.println("Salt 가 추가된 평문 = " + saltText);
        return saltText;
    }

    public static String oneTimeDec(String enc, EncryptDecrypt encryptDecrypt) {
        String dec = "";
        try {
            dec = encryptDecrypt.aes256Decrypt(enc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dec;
    }

    public static String twoTimeDec(String enc, EncryptDecrypt encryptDecrypt) {
        String dec = "";
        try {
            dec = encryptDecrypt.aes256Decrypt(enc);
            dec = encryptDecrypt.aes256Decrypt(dec);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dec;
    }
}
