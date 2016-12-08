package com.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			ServerSocket ss = new ServerSocket(5000);
			Socket server = ss.accept();
			InputStream is = server.getInputStream();
			OutputStream out = server.getOutputStream();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
