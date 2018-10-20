package com.itheima.demo2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//ע�⣺������byte[]���յ����ݣ����ܶ�д��Ҫ��(byte[],0,length)�ķ���������SS��CC���õ�b��
//SS�Ƿ������࣬CC�ǿͻ����࣬��Ϊ�������������ұ��������з�����������Ϊ�˷���һ��.java�����У�
//�ƺ�����ʹ�ö��̡߳�run�����������쳣�����Ը���д��ss������cc����
//����flush�ƺ����һ�ε����ݻᶪʧһЩ
//����Ҫע��һ��bug�����������ڽ������ļ�������Ϣa���ͻ��ˣ��ͻ���Ҳ��ȴ�a��
//�ͻ��˴����ļ��˳�while�����ڵȴ�a�����������Ƿ������ڽ������ļ���ȴ�޷��˳�while��
//��Ϊ����֪���Ѿ������ˡ�������Ҫ�ͻ��˹ر�outputstream��
//��������ǿͻ���c.getOutputStream�����ģ��޷���out.close()�رա�
//����Ҫ��c.shutdownOutput()�رգ����и�������c.shutdownInput()��


public class Test {

	public static void main(String[] args) throws IOException {
		new Thread(new SS()).start();
		new Thread(new CC()).start();
		new Thread(new CC()).start();
		new Thread(new CC()).start();
	}
}

class SS implements Runnable {
	static int po = 11111;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ss();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ss() throws IOException {
		ServerSocket s = new ServerSocket(po);
		System.out.println("�ȴ�����........");
		while (true) {
			Socket c = s.accept();
			System.out.println("��������");
			InputStream in = c.getInputStream();
			byte[] b = new byte[1024];
			int lo = 0;
			String na = System.currentTimeMillis() + ".jpg";
			File f = new File(na);
			BufferedOutputStream o = new BufferedOutputStream(new FileOutputStream(f));
			int len = 0;
			try {
				while ((len = in.read(b)) != -1) {
					lo += len;
					// System.out.println("getting....." + len);
					o.write(b, 0, len);
					o.flush();
				}
				String end = "�����ļ����,���ֽ�" + na + "   " + lo;
				// System.out.println(end);
				OutputStream out = c.getOutputStream();
				out.write(end.getBytes());
				out.close();
			} finally {
				o.close();

			}

		}
	}
}

class CC implements Runnable {
	static int po = 11111;
	static InetAddress i;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			cc();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cc() throws IOException {

		i = InetAddress.getByName("localhost");
		Socket c = new Socket(i, po);
		OutputStream out = c.getOutputStream();
		byte[] b = new byte[1024];
		File f = new File("1.jpg");
		BufferedInputStream i = new BufferedInputStream(new FileInputStream(f));
		int w = 0;
		try {
			while ((w = i.read(b)) != -1) {
				out.write(b,0,w);
			}
			// out.close();
			c.shutdownOutput();
			System.out.println("���ͳɹ�");

			InputStream in = c.getInputStream();
			byte[] b1 = new byte[1024];
			int b1l = in.read(b1);
			System.out.println("������˵��" + new String(b1, 0, b1l));
		} finally {
			i.close();
			c.close();
		}
	}
}