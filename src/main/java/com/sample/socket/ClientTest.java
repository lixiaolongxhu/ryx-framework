package com.sample.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientTest {
	 public static void main(String[] args) throws Exception  
	    {  
	        Socket socket = new Socket("localhost",9999);  
	          
	        InputStream is = socket.getInputStream();  
	          
	        OutputStream os = socket.getOutputStream();  
	          
	        String content = "This comes from client";  
	        os.write(content.getBytes());  
	          
	          
	        byte[] b = new byte[100];  
	        int length = is.read(b);  
	        String str = new String(b,0,length);  
	        System.out.println("string's  length:" + str);  
	          
	        is.close();  
	        os.close();  
	        socket.close();  
	    }  
	  
}
