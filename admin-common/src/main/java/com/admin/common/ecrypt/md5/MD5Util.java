package com.admin.common.ecrypt.md5;

import com.admin.common.log.LogUtil;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	private static final String HEX_DIGITS[]	= { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	private static String byteArrayToHexString(byte b[]) {
		StringBuilder resultSb = new StringBuilder();
		for (int i = 0; i < b.length; i++){
			resultSb.append(byteToHexString(b[i]));
		}

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0){
			n += 256;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return HEX_DIGITS[d1] + HEX_DIGITS[d2];
	}

	public static String md5Encode(String origin) {
		String resultString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(origin.getBytes("GB2312")));
		} catch (Exception e) {
            LogUtil.ERROR.error(e.getMessage(), e);
		}
		return resultString;
	}
	
	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}
	
	public static String encodeMD5Hex(String text)  {
		StringBuffer md5 = null;
		try {
			MessageDigest md1 = MessageDigest.getInstance("MD5");
			md1.update(text.getBytes("GB2312"));
			byte[] digest = md1.digest();
			md5 = new StringBuffer();
			for (int i = 0; i < digest.length; i++) {
				md5.append(Character.forDigit((digest[i] & 0xF0) >> 4, 16));
				md5.append(Character.forDigit((digest[i] & 0xF), 16));
			}
		} catch (NoSuchAlgorithmException e) {
            LogUtil.ERROR.error(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
            LogUtil.ERROR.error(e.getMessage(), e);
		}
		if(md5 == null){
			return null;
		}else{
			return md5.toString();
		}
		
	}
	
	public static void main(String[] args) {
		
		// CardNumber=11111111111&PhoneNumber=&UserId=20110001&NotifyURL=test&OrderTime=20071120111111&OrderType=02&OrderMone
//		y=100&OrderId=11111111&Reserve=&CardPassword=c7928c486424adce3c344062f1340a46&OrderDesc=OrderDesc&Sign=
//			a3898349ee3879ebab1c455651802ff7
//			b868eed699c7a04651a148879751a97c
		
		
//		System.out.println( md5Encode("1111111s鏄槸鏄槸sss11111111110"));
	}
	
    public static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes("utf-8"));
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
/*            System.out.println("MD5(" + sourceStr + ",32) = " + result);
            System.out.println("MD5(" + sourceStr + ",16) = " + buf.toString().substring(8, 24));*/
        } catch (NoSuchAlgorithmException e) {
        	LogUtil.ERROR.error(e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
        	LogUtil.ERROR.error(e.getMessage(), e);
		}
        return result;
    }
    
	public final static String md5_yszf(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		try {
			byte[] btInput = s.getBytes();

			MessageDigest mdInst = MessageDigest.getInstance("MD5");

			mdInst.update(btInput);

			byte[] md = mdInst.digest();

			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
