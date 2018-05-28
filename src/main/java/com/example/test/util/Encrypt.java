package com.example.test.util;

/**
 * @Date:Created by luzy on 2018/5/18.
 * @Description:
 */
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {

    /**
     * 传入文本内容，返回 MD5 串
     *
     * @param strText
     * @return
     */
    public String MD5(final String strText) {
        return SHA(strText, "MD5");
    }

    /**
     * 传入文本内容，返回 SHA-1 串
     *
     * @param strText
     * @return
     */
    public String SHA1(final String strText) {
        return SHA(strText, "SHA-1");
    }

    /**
     * 传入文本内容，返回 SHA-224 串
     *
     * @param strText
     * @return
     */
    public String SHA224(final String strText) {
        return SHA(strText, "SHA-224");
    }

    /**
     * 传入文本内容，返回 SHA-256 串
     *
     * @param strText
     * @return
     */
    public String SHA256(final String strText) {
        return SHA(strText, "SHA-256");
    }

    /**
     * 传入文本内容，返回 SHA-512 串
     *
     * @param strText
     * @return
     */
    public String SHA512(final String strText) {
        return SHA(strText, "SHA-512");
    }

    /**
     * 字符串加密
     * @return
     */
    private String SHA(final String strText, final String strType) {
        // 返回值
        String strResult = null;

        // 是否是有效字符串
        if (strText != null && strText.length() > 0) {
            try {
                // SHA 加密开始
                // 创建加密对象 并傳入加密類型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes("UTF-8"));
                // 得到 byte 類型结果
                byte byteBuffer[] = messageDigest.digest();

                // 將 byte 轉換爲 string
                StringBuffer strHexString = new StringBuffer();
                // 遍歷 byte buffer
                for (int i = 0; i < byteBuffer.length; i++)
                {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1)
                    {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // 得到返回結果
                strResult = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return strResult;
    }

    public static void main(String[] ARGS){
        String str="123456435435435";
        Encrypt encrypt=new Encrypt();
        System.out.println(encrypt.MD5(str)+"    "+encrypt.MD5(str).length());
        System.out.println(encrypt.SHA1(str)+"    "+encrypt.SHA1(str).length());
        System.out.println(encrypt.SHA224(str)+"    "+encrypt.SHA224(str).length());
        System.out.println(encrypt.SHA256(str)+"    "+encrypt.SHA256(str).length());
        System.out.println(encrypt.SHA512(str)+"    "+encrypt.SHA512(str).length());
    }
}