package com.itheima.demo03_Calendar������;

import java.util.Calendar;
import java.util.Date;

/*
 * Calendar:Ҳ�Ǵ����ض���˲��,������ʱ����
 * 
 * ����Calendar��һ��������,���ǲ���ֱ����
 * 
 * Ѱ����������:
 * 		GregorianCalendar ���ǿ���������
 * 
 * ����Calendar�ľ�̬����
 * 		public static Calendar getInstance();//��ȡCalendar�ľ����ĳ������Ķ���
 * 
 * ��Ա����:
 * 		****public int get(int field);//��ȡCalendar�����е�ĳһ���ֶ�/��Ա������ֵ
 * 		public void add(int field,int amount);//��ָ�����ֶ� ���ָ����ֵ
 * 		public void set(int field,int value);// ֱ���޸�ָ���ֶε�ֵ
 * 		public Date getTime();//���ظ�Calendar�����Ӧ��Date����
 * 				DateҲ��getTime(),��ȡDate�����Ӧ�ĺ���ֵ
 * 
 */
public class CalendarDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.��ȡCalendar���������
		Calendar c = Calendar.getInstance();//��ȡ����
		//2.��ӡc��������
		printNYR(c);
		//3.��c�е��� ���1
//		c.add(Calendar.YEAR, 1);
		//4.��c�е������1
//		c.add(Calendar.MONDAY, 1);
		//5.�Ҽ�
//		c.add(Calendar.MONTH, 30);
		//c.add(Calendar.DAY_OF_MONTH, 145);
		//6.�޸�ָ���ֶε�ֵ
//		c.set(Calendar.YEAR, 1000);
//		c.set(Calendar.MONTH, 10);
//		c.set(Calendar.DAY_OF_MONTH, 10);
		printNYR(c);
		//6.getTime����,��Calendar����ת��Date����
//		Date d = c.getTime();
//		System.out.println(d);
		//7.��λ�ȡc�ľ����׼ʱ��ĺ���ֵ
//		System.out.println(c.getTime().getTime());
		
	}
	//��װһ������  ��ȡһ�����������������
	public static void printNYR(Calendar c){
		//2.��ȡCalendar�����ĳ���ֶ�
		int year = c.get(Calendar.YEAR);
		
		int month = c.get(Calendar.MONTH);
		
		int day = c.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year+"��"+(month+1)+"��"+day+"��");
	}

}
