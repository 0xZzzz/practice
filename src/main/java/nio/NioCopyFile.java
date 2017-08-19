package main.java.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioCopyFile {
	public static void copyFile(String resource, String destination) throws IOException{
		FileInputStream fis = new FileInputStream(resource);
		FileOutputStream fos = new FileOutputStream(destination);
		FileChannel readChannel = fis.getChannel();//���ļ�ͨ��
		FileChannel writeChannel = fos.getChannel();//д�ļ�ͨ��
		ByteBuffer buffer = ByteBuffer.allocate(1024);//�������ݻ���
		while(true){
			buffer.clear();
			int len = readChannel.read(buffer); //������
			if(len == -1){
				break; //����
			}
			buffer.flip();
			writeChannel.write(buffer);
		}
		readChannel.close();
		writeChannel.close();
		fis.close();
		fos.close();
	}
}
