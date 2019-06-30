package security;

import org.apache.commons.codec.binary.Hex;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA数字签名
 *
 * @author ZQ
 */
public class RSADemo {

    private static String str = "beautiful girl";

    public static void jdkRsa() {
        try {
            // 返回生成指定算法的 public/private 密钥对的 KeyPairGenerator 对象
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(512);
            KeyPair keyPair = kpg.generateKeyPair();
            RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic(); // 公钥: 用于验证签名
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate(); // 私钥: 用于执行签名

            //执行签名
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec); // 根据提供的密钥规范（密钥材料）生成私钥对象。
            Signature signature = Signature.getInstance("MD5withRSA"); // 提供指定数字签名算法功能的对象
            signature.initSign(privateKey); // 初始化这个用于签名的对象。
            signature.update(str.getBytes()); // 更新要签名或验证的数据
            byte[] result = signature.sign(); // 返回所有已更新数据的签名字节。
            System.out.println("jdk rsa sign: " + Hex.encodeHexString(result));

            //验证签名
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec); // 根据提供的密钥规范（密钥材料）生成公钥对象。
            signature.initVerify(publicKey); // 初始化此用于验证的对象。
            signature.update(str.getBytes());
            boolean bool = signature.verify(result);
            System.out.println("jdk rsa verify: " + bool);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        jdkRsa();
    }
}
