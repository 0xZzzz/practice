package security;

import org.apache.commons.codec.binary.Base64;
/**
 * Base64加密
 * @author ZQ
 *
 */
public class Base64Demo {
	
	private static String src = "beautiful girl";

	public static void main(String[] args) {
		//jdkBase64();
		commonsCodesBase64();
		bouncyCastleBase64();
	}
	
	/* jdk的base64 不推荐使用
	public static void jdkBase64() {
		try {
			BASE64Encoder encoder = new BASE64Encoder();
			String encode = encoder.encode(src.getBytes());
			System.out.println("encode : " + encode);
			
			BASE64Decoder decoder = new BASE64Decoder();
			System.out.println("decode : " + new String(decoder.decodeBuffer(encode)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
	
	public static void commonsCodesBase64() {
		byte[] encodeBytes = Base64.encodeBase64(src.getBytes());
		System.out.println("encode : " + new String(encodeBytes));
		
		byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
		System.out.println("decode : " + new String(decodeBytes));
	}
	
	public static void bouncyCastleBase64() {
		byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		System.out.println("encode : " + new String(encodeBytes));
		
		byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes); 
		System.out.println("decode : " + new String(decodeBytes));
	}

}