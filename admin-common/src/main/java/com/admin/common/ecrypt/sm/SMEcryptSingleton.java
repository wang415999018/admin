package com.admin.common.ecrypt.sm;

import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class SMEcryptSingleton {
    private static final Logger logger = LoggerFactory.getLogger(SMEcryptSingleton.class);
    private  final String SM3_KEY = "eptok_@@_jf_model_1188_key";
    private String privateKey = null;
    private String publicKey = null;

    private static SMEcryptSingleton singleton = new SMEcryptSingleton();

    private SMEcryptSingleton(){
        Map<String, String> keyMap = SM2Utils.generateKeyPair();
        this.privateKey = keyMap.get("privateKey");
        this.publicKey = keyMap.get("publicKey");
    }

    public static SMEcryptSingleton getSMEcryptInstance(){
        return singleton;
    }

    public String getSM2PublicKey(){
         return this.publicKey;
    }

    /**
     * SM2 加密
     * */
    public String encryptSM2(String data){
        try{
            return  SM2Utils.encrypt(Util.hexToByte(publicKey), data.getBytes());
        }catch (IOException e){
            logger.error("SM2加密失败"+e.getMessage());
        }
        return null;
    }

    /**
     * SM2 解密
     * */
    public String decryptSM2(String cipherText){
        try{
            byte [] cipherTextByte = Util.hexToByte(cipherText);
            byte [] data  = SM2Utils.decrypt(Util.hexToByte(privateKey),cipherTextByte );
            return Util.byteToString(data);
        }catch (IOException e){
            logger.error("SM2解密失败"+e.getMessage());
        }
        return null;
    }

    public String encryptSM3(String data){
        KeyParameter keyParameter = new KeyParameter(SM3_KEY.getBytes());
        byte[] dataBytes = data.getBytes();
        byte[] md = new byte[32];
        SM3Digest sm3 = new SM3Digest();
        HMac mac = new HMac(sm3);
        mac.init(keyParameter);
        mac.update(dataBytes, 0, dataBytes.length);
        mac.doFinal(md, 0);
        return new String(Hex.encode(md));
    }
}
