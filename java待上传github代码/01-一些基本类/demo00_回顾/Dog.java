package com.itheima.demo00_�ع�;

public class Dog{
	int age;
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		//�޸ıȽϹ���,�Ĳ�Ƚ�����
		Dog d = (Dog)obj;
		if(this.age == d.age){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "����һ��Dog,age="+age;
	}
}
