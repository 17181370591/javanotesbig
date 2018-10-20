package com.itheima.demo02_���ڸ�ʽ����;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * DateFormat:���ڸ�ʽ����
 * 
 * 1.DateFormat��һ�������� ���ǲ�������
 * 
 * 2.����ʹ������һ������:SimpleDateFormat 
 *
 * SimpleDateFormat:�򵥵����ڸ�ʽ����
 * 
 * 1.����:
 * 		public SimpleDateFormat(String pattern);//��ָ����ģʽ ����һ�����ڸ�ʽ������
 * 2.��Ա����:
 * 		public String format(Date d);//��ʽ��һ�����ڶ���,���ظ�ʽ�����һ���ַ���
 * 		public Date parse(String s);//��һ���ַ�����ʽ������,������Date����
 * 		ע��:
 * 		public String format(Date d);�����ڶ���ת���ַ�����ʽ������
 * 		public Date parse(String s);���ַ�����ʽ������,ת�س����ڶ���
 * 		
 * 	
 */
public class DateFormatDemo {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
//		demo01();
		demo02();
	}
	//�������ڶ���
	public static void demo02() throws ParseException{
		//1.����SimpleDateFormat����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��  HH��mm��ss��");
		//2.ʹ��sdf����һ���ַ���
		Date d = sdf.parse("2017��10��06��  20��18��25��");
		//3.��ӡ
		System.out.println(d);
	}
	//��ʽ�����ڶ���
	public static void demo01(){
		//1.����SimpleDateFormat����
		//����:����Ҫ�����ڸ�ʽ���� 2000��10��20�� 20��18��55��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��  HH��mm��ss��");
		//2.����һ�����ڶ���
		Date d = new Date();
		//3.ʹ��sdf ����ʽ�����ڶ���
		String s = sdf.format(d);
		System.out.println(s);
	}
}
