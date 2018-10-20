package com.itheima.demo2;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/*
��sqlע��,�������ļ�,�������ӳذ汾��
��preparedStatementʵ�ַ�sqlע�룻
��config�ļ�+properties.loadʵ���������ļ��������ã�
�� ArrayList<Connection> cons ʵ���������ӳأ�

con.setAutoCommit(false);con.commit();con.rollback();�����������
��Ҫ��ͬһ��connection��

*/

public class Test {

	public static void main(String[] args) {
		Connection con = null;
		try {
			con = JDBCUtils.getc();
			con.setAutoCommit(false);
			JDBCUtils.select(con, "select * from db");

			JDBCUtils.update(con, "update db set money=money+100 where dname='a'");
			JDBCUtils.select(con, "select * from db");
			System.out.println(1 / 0);
			JDBCUtils.update(con, "update db set money=money-100 where dname='b'");
			con.commit();
			JDBCUtils.select(con, "select * from db");
		} catch (Exception e) {
			try {
				con.rollback();
				System.out.println("�ع�....");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}
}

class JDBCUtils {
	static String url = null;
	static String dr = null;
	static String user = null;
	static String pw = null;
	static ArrayList<Connection> cons = new ArrayList<Connection>();
	static int size = 8;
	static {
		try {
			Properties ps = new Properties();
			ps.load(new FileInputStream("config.properties"));
			url = ps.getProperty("url");
			dr = ps.getProperty("dr");
			user = ps.getProperty("user");
			pw = ps.getProperty("pw");
			Class.forName(dr);
			for (int i = 0; i < size; i++) {
				Connection c = DriverManager.getConnection(url, user, pw);
				cons.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��������ʧ�ܣ�����ֹͣ");
		}
	}

	public static Connection getc() throws SQLException {
		// return DriverManager.getConnection(url, user, pw);
		// return cons.get(0);
		// ����ʹ��get(0)���ᱨ��No operations allowed after connection closed.
		return cons.remove(0);
		// ÿ���Ƴ�һ������Ϊ������ʹ�ú�ᱻ�رղ��ܶ��ʹ��

	}

	public static void closeAll(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}

			if (st != null) {

				st.close();
			}
			// if (con != null) {
			//
			// con.close();
			// }
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void update(Connection con, String sql, String... ss) {
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(sql);

			for (int i = 0; i < ss.length; i++) {
				st.setObject(i + 1, ss[i]);
			}

			int t = st.executeUpdate();
			if (sql.startsWith("delete")) {
				System.out.println("ɾ��" + t + "����¼�ɹ�");
			} else if (sql.startsWith("select")) {
				System.out.println("����" + t + "����¼�ɹ�");
			} else if (sql.startsWith("update")) {
				System.out.println("�޸�" + t + "����¼�ɹ�");
			} else {
				System.out.println(sql + t + "����¼�ɹ�");
			}
			System.out.println("���ӳػ���" + cons.size());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeAll(con, st, rs);
		}
	}

	public static void select(Connection con, String sql, String... ss) {

		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(sql);
			if (ss != null) {
				for (int i = 0; i < ss.length; i++) {
					st.setObject(i + 1, ss[i]);
				}
			}

			rs = st.executeQuery();

			while (rs.next()) {
				for (int i = 1; i < 4; i++) {

					System.out.print(rs.getObject(i) + "\t");
				}
				System.out.println();

			}
			System.out.println("���ӳػ���" + cons.size());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeAll(con, st, rs);
		}
	}

}

/*
 * //config.properties url = jdbc:mysql://localhost:3306/forpython dr =
 * java.sql.Driver user = root pw= //��һ�п���ע�͵���Ҳ���Բ�ע��
 */