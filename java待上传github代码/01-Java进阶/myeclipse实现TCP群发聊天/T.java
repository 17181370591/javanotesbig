package com.itheima.demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//ע�⣺������byte[]���յ����ݣ����ܶ�д��Ҫ��(byte[],0,length)�ķ�����
//����Send��b���ǽ��ն��Ǹ�ֵ�����Բ��ã�Re���ǽ��գ������á�
//��udp��˼·����һ���������Ƿ�����ÿ����һ�����ʣ��ʹ���һ���̣߳�
//���·��������͵���Ϣֻ�ᱻһ���ͻ�������
public class T {
}

class Send implements Runnable {
	OutputStream out;
	ServerSocket s;
	Socket c;
	String n1;

	byte[] b = new byte[1024];

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			b = sc.nextLine().getBytes();
			//û���κ�����Ļ����½���ѭ��
			if (b.length == 0) {
				continue;
			}
			try {
				out.write(b);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(n1 + "������Ϣ�ɹ�");
		}
	}

	public Send(OutputStream out, ServerSocket s, Socket c) {
		super();
		this.out = out;
		this.s = s;
		this.c = c;
		if (s != null) {
			n1 = s.getInetAddress().getHostAddress() + ":" + s.getLocalPort();
		} else {
			n1 = "�ͻ�"+c.getInetAddress().getHostAddress() + ":" + c.getLocalPort();
		}
	}
}

class Re implements Runnable {

	InputStream in;
	String n2;
	ServerSocket s;
	Socket c;
	byte[] b = new byte[1024];

	@Override
	public void run() {
		while (true) {
			try {
				int len = in.read(b);
				System.out.println(n2 + "˵:" + new String(b, 0, len));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Re(InputStream in, ServerSocket s, Socket c) {
		super();
		this.in = in;
		this.s = s;
		this.c = c;
		if (s != null) {
			n2 = "�ͻ�" + c.getInetAddress().getHostAddress() + ":" + c.getPort();
		} else {
			n2 = "������";
		}
	}
}