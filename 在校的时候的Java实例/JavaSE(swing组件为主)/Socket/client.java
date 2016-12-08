package com.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Socket client = new Socket("127.0.0.1",5000);
			
			InputStream is = client.getInputStream();
			OutputStream out = client.getOutputStream();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
