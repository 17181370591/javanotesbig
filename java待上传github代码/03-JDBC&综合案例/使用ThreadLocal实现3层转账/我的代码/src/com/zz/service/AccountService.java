package com.zz.service;

import java.sql.SQLException;

import com.zz.dao.AccountDao;
import com.zz.utils.ConnectionManager;

public class AccountService {

	public static void main(String[] args) {
	}

	// ��ѯ���
	public static void transfer(String n1, String n2, double money) {
		try {
			ConnectionManager.getConnection();
			ConnectionManager.start();
			AccountDao.cAccount(n1, money);
			// System.out.println(1 / 0);
			AccountDao.cAccount(n2, money * -1);
			ConnectionManager.commit();
			System.out.println("ת�˳ɹ�");
		} catch (Exception e) {
			try {
				e.printStackTrace();
				ConnectionManager.rollback();
				System.out.println("ת��ʧ�ܣ��ع��ɹ�....");
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("ת��ʧ�ܣ��ع��ɹ�....");
			} finally {
				try {
					ConnectionManager.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
