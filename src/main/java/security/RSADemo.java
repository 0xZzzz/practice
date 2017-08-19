package security;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Hex;
/**
 * RSA����ǩ��
 * @author ZQ
 *
 */
public class RSADemo {
	
	private static String str = "beautiful girl";
	
	public static void jdkRsa(){
		try {
			//��������ָ���㷨�� public/private ��Կ�Ե� KeyPairGenerator ����
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(512);
			KeyPair keyPair = kpg.generateKeyPair();
			RSAPublicKey rsaPublicKey = (RSAPublicKey)keyPair.getPublic(); //��Կ: ������֤ǩ��
			RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate(); //˽Կ: ����ִ��ǩ��
			
			//ִ��ǩ��
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec); //�����ṩ����Կ�淶����Կ���ϣ�����˽Կ����
			Signature signature = Signature.getInstance("MD5withRSA"); // �ṩָ������ǩ���㷨���ܵĶ���
			signature.initSign(privateKey);//��ʼ���������ǩ���Ķ���
			signature.update(str.getBytes());//����Ҫǩ������֤������
			byte[] result = signature.sign();//���������Ѹ������ݵ�ǩ���ֽڡ�
			System.out.println("jdk rsa sign: "+Hex.encodeHexString(result));
			
			//��֤ǩ��
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
			PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);//�����ṩ����Կ�淶����Կ���ϣ����ɹ�Կ����
			signature.initVerify(publicKey);// ��ʼ����������֤�Ķ���
			signature.update(str.getBytes());
			boolean bool = signature.verify(result);
			System.out.println("jdk rsa verify: "+bool);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		jdkRsa();
	}
}
