package com.itheima.demo05_Math��;
/*
 * Math:��ѧ��
 * 		public final class Math:����಻�ܱ��̳� �� Systemһ��
 * 
 * ���಻�ܴ�������,�������Ƿ��ָ��������еķ������Ǿ�̬��
 * 
 * 1.public static double max(double d1,double d2);//�����ֵ
 * 2.public static double min(double d1,double d2);//����Сֵ
 * 
 * 
 * 3.public static double abs(double d);//ȡ����ֵ
 * 4.public static double random();//����һ�������,��Χ [0,1)
 * 
 * 5.public static long round(double d);//��������,ֻ��С���ĵ�һλ
 * 6.public static double pow(double d1, double d2);//�����(�η�)
 * 
 * 
 * 7.public static double ceil(double a);//ceil �컨��,����ȡ��
 * 8.public static double floor(double a);//floor �ذ�.����ȡ��
 * 
 * 
 */
public class MathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.ȥ����ֵ
		double d = Math.abs(19.0);
		System.out.println(d);
		//2.��ȡα�����
		double r = Math.random();
		System.out.println(r);
		//3.��������
		long m = Math.round(4.50000001);
		System.out.println(m);
		//4.�����
//		double p = Math.pow(3, 3);//3*3*3
//		System.out.println(p);
		double p2 = Math.pow(4, 2);
		System.out.println(p2);
		//5.ceil��floor
		double c1 = Math.ceil(4.0);
		double c2 = Math.floor(4.0);
		System.out.println(c1);
		System.out.println(c2);
	}

}
