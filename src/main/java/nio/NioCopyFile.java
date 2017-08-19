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
		FileChannel readChannel = fis.getChannel();//读文件通道
		FileChannel writeChannel = fos.getChannel();//写文件通道
		ByteBuffer buffer = ByteBuffer.allocate(1024);//读入数据缓存
		while(true){
			buffer.clear();
			int len = readChannel.read(buffer); //读数据
			if(len == -1){
				break; //读完
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
