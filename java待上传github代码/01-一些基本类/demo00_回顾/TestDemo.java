package com.itheima.demo00_�ع�;
/*
 * �쳣�����2�ַ�ʽ:
 * 1.�����׳� throws
 * 2.������ try{...���ܳ��ֵĴ���} catch(Exception e){...}finally{...}
 * Object��,
 * 1.equals����:
 * 			Ĭ���ǱȽϵ��ǵ�ַ,��Object���� equals������ '=='��һ��
 * 			���ǿ�����дequals����,�޸ıȽϵĹ���,һ��Ƚ϶���ĳ�Ա����ֵ
 * 2.toString����:
 * 			��ȡ�ĸö�����ַ�����ʾ��ʽ,Ĭ�ϵı�ʾ��ʽ: ����.����@��ֵַ
 * 			����Ҳ������дtoString����,�޸ķ��ص��ַ����ĸ�ʽ,һ��ö������Ϣ
 * 
 * 
 * 
 */
public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����Dog����
		Dog d1 = new Dog();//d1:0x111
		d1.age = 10;
		Dog d2 = new Dog();//d2:0x222
		d2.age = 20;
	/*	boolean b1 = d1.equals(d2);
		boolean b2 = (d1 == d2);
		
		System.out.println(b1);
		System.out.println(b2);*/
		
		
		System.out.println(d2);//��ӡһ������ʱ,JVM���ȵ��ö����toString����
		//System.out.println(d1.toString());
		
	}

}
