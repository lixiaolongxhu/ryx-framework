package com.sample.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class ServerTest {

	
	public static  void   main(String[] args) throws IOException{
		java.net.ServerSocket ss = new java.net.ServerSocket(9999);  
	        Socket socket = ss.accept();  
	          
	        InputStream is = socket.getInputStream();  
	        OutputStream os = socket.getOutputStream();  
	          
	        byte[] buffer = new byte[100];  
	          
	        int length = is.read(buffer);  
	          
	        String content = new String(buffer,0,length);  
	          
	        System.out.println("read from client:" + content);  
	          
	        int strLength = content.length();  
	          
	        String str = String.valueOf(strLength);  
	          
	        os.write(str.getBytes());  
	          
	        is.close();  
	        os.close();  
	        socket.close();     
		 
	}
}
