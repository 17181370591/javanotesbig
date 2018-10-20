package com.gl.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.gl.dao.ProductDao;
import com.gl.utils.ManagerConnection;

public class Service {
	private static Scanner sc = new Scanner(System.in);
	private final static String sql1 = "select * from t where tid=?";

	public static void main(String[] args) {
		while (true) {
			System.out.println("�����룺c����\tu�޸�\tdɾ��\tdaɾ�����\tqi��id��ѯ\tfa��ѯ����\tq�˳�");
			String s = sc.nextLine().toLowerCase();
			if (s.equals("q")) {
				System.exit(0);
				;
			} else {
				f(s);
			}
		}
	}

	public static void f(String s) {
		if (s.equals("qi")) {
			select1();
		} else if (s.equals("fa")) {
			selectAll();
		} else if (s.equals("c")) {
			charu();
		} else if (s.equals("u")) {
			xiugai();
		} else if (s.equals("d")) {
			shanchu();
		} else if (s.equals("da")) {
			shanchu2();
		}

	}

	public static int select1() {
		System.out.println("������id");
		try {
			String s1 = sc.nextLine();
			int re = ProductDao.select(sql1, s1);
			if (re == 0) {
				System.out.println("��ѯʧ��");
			}
			return re;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} catch (ArrayIndexOutOfBoundsException e1) {
			System.out.println("��ѯʧ��");
			return 0;
		}
	}

	public static void selectAll() {
		try {
			ProductDao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void xiugai() {
		System.out.println("������id");
		String s1 = sc.nextLine();
		System.out.println("����������");
		String s2 = sc.nextLine();
		System.out.println("������۸�");
		String s3 = sc.nextLine();
		try {
			int re = ProductDao.update("update t set tname=?,price=? where tid=? ", s2, s3, s1);
			if (re > 0) {
				System.out.println("�޸ĳɹ�");
			} else {
				System.out.println("�޸�ʧ��");
			}
		} catch (SQLException e) {
			System.out.println("�޸�ʧ�ܣ����ݴ���");
		}
	}

	public static void charu() {
		System.out.println("����������");
		String s2 = sc.nextLine();
		System.out.println("������۸�");
		String s3 = sc.nextLine();
		try {
			ProductDao.update("insert t value(null,?,?)", s2, s3);
			System.out.println("����ɹ�");
		} catch (SQLException e) {
			System.out.println("����ʧ�ܣ����ݴ���");
		}
	}

	public static void shanchu() {
		System.out.println("������id");
		String s2 = sc.nextLine();
		try {
			if (ProductDao.select(sql1, s2) < 1) {
				return;
			}
			System.out.println("�Ƿ�ɾ��y/n");
			String s3 = sc.nextLine().toLowerCase();
			if (s3.equals("y")) {
				ProductDao.update("delete from t where tid=?", s2);
				System.out.println("ɾ���ɹ�");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void shanchu2() {
		ArrayList<String> l = new ArrayList<String>();
		while (true) {
			System.out.println("������id");
			String s2 = sc.nextLine();
			if (s2.equals("-1")) {
				break;
			} else {
				l.add(s2);
				try {
					int re = ProductDao.select(sql1, s2);
					if (re == 0) {
						l.remove(s2);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("�Ƿ�ɾ��y/n");
		String s3 = sc.nextLine().toLowerCase();

		if (s3.equals("y")) {

			try {
				ManagerConnection.start();
				// for (String o : l) {
				// ProductDao.update("delete from t where tid=?", o);
				// }
				// System.out.println(1 / 0);
				System.out.println("ɾ���ɹ�");
				ManagerConnection.commit();
			} catch (Exception e) {
				try {
					ManagerConnection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			} finally {
				try {
					ManagerConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}
