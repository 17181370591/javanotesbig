package com.itheima.demo01_������Date;

import java.util.Date;

/*
 * Date��:������
 * 		��ʾ�ض���˲�䣬��ȷ������,(1��=1000����)
 * 
 * ����:
 * 	****public Date();//�޲ι���,����һ������ǰϵͳʱ���Date����
 * 	public Date(long time);//��ָ���ĺ���ֵ����һ��Date����
 * 					����ֵ������� ��׼ʱ��(1970.01.01 00:00:00)�ĺ���ֵ
 * ��Ա����:
 * 	toString();//��Date����д��Object���toString:���ڼ� �·� �� ʱ:��:��  CST ��
 * 	public long getTime();//���ص��ǵ�ǰ��Date����,�����׼ʱ��ĺ���ֵ
 * ע��:
 * 	public Date(long time);//�Ѻ���ֵ ת����Date����
 * 	public long getTime();//��Date���� ת�ɺ���ֵ
 * 
 * 
 */
public class DateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.����һ��Date����
		//Date d1 = new Date();
		
		//System.out.println(d1);//��ӡ���˵����Date����д��toString����
		//��ӡ���:Fri Oct 06 08:54:33 CST 2017
		//2.����һ��Date����,ʹ�ú���ֵ
		/*Date d2 = new Date(0);
		System.out.println(d2);*/
		/*Date d3 = new Date(1501383854384L);
		System.out.println(d3);*/
		//3.���ص�ǰDate��������׼ʱ��ĺ���ֵ
		Date d4 = new Date();
		long time =  d4.getTime();
		System.out.println(time);//1507252128450
		
		
	}

}
