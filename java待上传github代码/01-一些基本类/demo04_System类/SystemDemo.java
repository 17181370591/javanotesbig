package com.itheima.demo04_System��;
/*
 * System:ϵͳ��
 * 		�����ܱ�ʵ������ ��Ϊ���췽��˽�л���
 * 		����System���еķ������Ǿ�̬��,ͨ�������Ϳ���ֱ�ӷ���
 * System���м������÷���:
 * 		public static void exit(int code);//�˳�JVM
 * 		public static void gc();//����java������������(��������������)
 * 		public static String getProperty(String PropertyName);//��ȡĳһ�����Ե�ֵ
 * 
 * 		//ż���õõ�
 * 		public static long currentTimeMillis();//��ȡ��ǰϵͳʱ��ĺ���ֵ
 * 
 */
public class SystemDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ȡ��ǰϵͳʱ��ĺ���ֵ
		//1.ͨ��Date��getTime
		//2.ͨ��Calendar��getTime,��ȡ��Date,�ٵ���getTime()
		//3.��õķ�ʽ
//		long time = System.currentTimeMillis();
//		System.out.println(time);
		//String(���ɱ�) ��  StringBuilder(�ɱ�)
		//�����ִ������ַ���ƴ������ ʱ ��StringBuilder
		
		long start = System.currentTimeMillis();//2046
		//ʹ���ַ���ƴ��
		/*String s = "";
		for(int i = 0;i<30000;i++){
			s+=i;
		}*/
		//ʹ��StringBuilderƴ��
		StringBuilder sb = new StringBuilder();//2
		for(int i = 0;i<300000;i++){
			sb.append(i);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		
		
		
		
		
		
		
	}
	
	public static void demo01(){
		//1.����һ��System����
				//System s = new System();//���ܴ�������
				//2.exit����
				/*for (int i = 0; i < 10; i++) {
					System.out.println(i);
					System.exit(0);//�˳�JVM
				}*/
				//3.��ȡ����
				/*String s = System.getProperty("user.name");
				System.out.println(s);*/
	}

}
