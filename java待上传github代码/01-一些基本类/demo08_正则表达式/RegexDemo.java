package com.itheima.demo08_������ʽ;
/*
 * ������ʽ:
 * 		����java��,�����б�����Ի�������֧�ֵ�
 * 
 * 1.������ʽ��ʲô?
 * 		��һ���ַ���,"������ʽ����"
 * 		"��ͨ���ַ���":��������ݾ�������
 * 		"������ʽ����":����д�˹���
 * 	��ͨ�ַ���������ʾ����,��������ʽ��ʾ����
 * 2.������ʽ��ʲô��?
 * 		����ƥ����ͨ�ַ�����
 * 		boolean b = "��ͨ�ַ���" ƥ��  "������ʽ"
 * 3.����ʵ��:
 * 		��String����
 * 		public boolean matches(String regex)
 * 		boolean b = "��ͨ�ַ���".matches("������ʽ");
 * 4.��ϰ1:������У��qq����.
 * 	��ϰ2������У���ֻ�����
 * 
 * 5.��д������ʽ�ļ���:
 * 		5.1 ������ʽ ��Ҫһλһλ���ж�
 * 	
 * 
 * 6.��String������һ������
 * 		public String[] split(String regex);//�и��ַ���,�����и����ַ�������
 */
public class RegexDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		split02();
	}
	/*
	 * QQ������Ҫ����Ĺ���:
	 * 1.������0-9������
	 * 2.��ͷ����1-9�е�һ������
	 * 3.λ������ 5-12λ
	 */
	public static void qq(){
		String qq = "12355a63564";
		boolean b = qq.matches("[1-9][0-9]{4,11}");
		System.out.println(b);
	}
	/*
	 * ������У���ֻ�����
	 * 1��Ҫ��Ϊ11λ0-9������
	 * 2����1λΪ1����2λΪ3��4��5��7��8�е�һ��������9λΪ0��9֮����������֡�
	 */
	public static void phone(){
		String phone = "18600363521";
		boolean b = phone.matches("1[34578][0-9]{9}");
		System.out.println(b);
	}
	
	/*
	 * 
	 * ����:�и�绰
	 */
	public static void split01(){
		String phone = "2345--4564----6546-----1345";
		
		//�и�phone  �Ѻ����и����
		//+�� ��������ʽ������������,��ʾ�����Ķ����ͬ���ַ�
		String[] phones = phone.split("-+");
		for (int i = 0; i < phones.length; i++) {
			System.out.println(phones[i]);
		}
	}
	/*
	 * ����:�и�ip
	 */
	public static void split02(){
		String ip = "192...168....123......110";
		//"."�� ��������ʽ�� ��ʾ �����ַ�
		//ת���ַ�
		//\t
		//\n
		String[] ips = ip.split("\\.+");//��������ʽ�� "\\" ����һ��"\"
		System.out.println(ips.length);
		for (int i = 0; i < ips.length; i++) {
			System.out.println(ips[i]);
		}
	}

}
