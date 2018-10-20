package com.itheima.demo2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

//T1��T2��T3�ֱ��ʾ3���նˣ�˼·��send���������������б���Լ���Ȼ������б����Ⱥ����
//��tcp��ʵ�ֲ�һ�����ǣ�udp�ķ�����ֻ��һ��
public class T {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Send implements Runnable {
	// po��i�ǽ������б�d1���Լ�
	int[] po;
	InetAddress i;
	DatagramSocket d1;

	public Send(int[] po, InetAddress i, DatagramSocket d1) {
		super();
		this.po = po;
		this.i = i;
		this.d1 = d1;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			while (true) {
				System.out.println(this.d1.getLocalPort() + "������Ҫ���͵�����:");
				Scanner bi = new Scanner(System.in);
				//����bufʹ�ø�ֵ�ķ���������new DatagramPacket��ֱ��ʹ��buf.length������������Ⱦ������ݵ���ʵ����
				byte[] buf = bi.nextLine().getBytes();
				for (int p1 : po) {
					DatagramPacket p = new DatagramPacket(buf, buf.length, i, p1);
					d1.send(p);
				}

				System.out.println("����ok!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			d1.close();
		}

	}

}

class Reic implements Runnable {
	// po��i�ǽ����ߣ�d1���Լ�
	// int po;
	// InetAddress i;
	DatagramSocket d1;
	int o = 1024;
	DatagramPacket p = new DatagramPacket(new byte[o], o);

	public Reic(DatagramSocket d1) {
		super();
		// this.po = po;
		// this.i = i;
		this.d1 = d1;
	}

	@Override
	public void run() {
		try {
			while (true) {
				d1.receive(p);
				//System.out.println(p.getAddress().getHostAddress() + ":" + p.getPort());
				//o�����������ݣ���������new String��ĳ��ȱ�����ÿ�ν��յ����ݳ��ȣ�
				//ֻ����p.getLength������o.length��p.getData().length
				System.out.println(p.getPort()+"˵��"+new String(p.getData(), 0, p.getLength()));
				// System.out.println(new String(p.getData()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			d1.close();
		}
	}
}