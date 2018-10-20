package com.itheima.demo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

//ʹ��dbcp��ܴ������ӳأ�
public class Test {

	public static void main(String[] args) {

		String sql1 = "insert t value(null,?)";
		String sql2 = "update t set tname=? where tname=?";
		String sql3 = "delete from  t where tname=?";
		String sql4 = "select * from t";
		String s1 = "go";
		String s2 = "me";

		JDBCUtils.insert(sql1, s1);
		JDBCUtils.insert(sql1, s1);
		JDBCUtils.set(sql2, s2, s1);
		JDBCUtils.delete(sql3, s2);
		JDBCUtils.select(sql4);
	}
}

class JDBCUtils {
	static DataSource ds = null;

	static {
		try {
			Properties ps = new Properties();
			//String n = "config.properties";		//ע�����ﲻ������������ļ�
			String n = "dbcpconfig.properties";

			//���ַ���������������ȡ�����ļ�����Ϣ
			// ps.load(new FileInputStream(n)); //�����ļ��ڸ�Ŀ¼
			System.out.println(Test.class + " " + JDBCUtils.class);
			// �����ļ���src
			ps.load(Test.class.getClassLoader().getResourceAsStream(n));
			ds = BasicDataSourceFactory.createDataSource(ps);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��������ʧ�ܣ�����ֹͣ");
		}
	}

	public static Connection getc() throws SQLException {
		return ds.getConnection();

	}

	public static void closeAll(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}

			if (st != null) {

				st.close();
			}
			if (con != null) {

				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void update(String sql, String... ss) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			con = JDBCUtils.getc();
			st = con.prepareStatement(sql);

			for (int i = 0; i < ss.length; i++) {
				st.setObject(i + 1, ss[i]);
			}

			int t = st.executeUpdate();
			System.out.println("t=" + t);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeAll(con, st, rs);
		}
	}

	public static void delete(String sql, String... ss) {
		update(sql, ss);
		System.out.println("ɾ���ɹ�");
	}

	public static void insert(String sql, String... ss) {
		update(sql, ss);
		System.out.println("����ɹ�");
	}

	public static void set(String sql, String... ss) {
		update(sql, ss);
		System.out.println("�޸ĳɹ�");
	}

	public static void select(String sql, String... ss) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement st = null;
		try {
			con = JDBCUtils.getc();
			st = con.prepareStatement(sql);
			if (ss != null) {
				for (int i = 0; i < ss.length; i++) {
					st.setObject(i + 1, ss[i]);
				}
			}

			rs = st.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getObject(2) + "\t" + rs.getObject(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeAll(con, st, rs);
		}
	}

}


/*
//config.properties
url = jdbc:mysql://localhost:3306/forpython
dr = java.sql.Driver
user = root
pw=				//��һ�п���ע�͵���Ҳ���Բ�ע��
*/


/*
dbcpconfig.properties
#�������� ,�������õ�
driverClassName=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/forpython
username=root
#password=				//��һ�п���ע�͵���Ҳ���Բ�ע��

#<!-- ��ʼ������ -->
initialSize=10

#�����������
maxActive=50

#<!-- ���������� -->
maxIdle=20

#<!-- ��С�������� -->
minIdle=5

#<!-- ��ʱ�ȴ�ʱ���Ժ���Ϊ��λ 60000����/1000����60�� -->
maxWait=60000


#JDBC������������ʱ�����������������Եĸ�ʽ����Ϊ������[������=property;] 
#ע�⣺"user" �� "password" �������Իᱻ��ȷ�ش��ݣ�������ﲻ��Ҫ�������ǡ�
connectionProperties=useUnicode=true;characterEncoding=utf8

#ָ�������ӳ������������ӵ��Զ��ύ��auto-commit��״̬��
defaultAutoCommit=true

#driver default ָ�������ӳ������������ӵ�ֻ����read-only��״̬��
#���û�����ø�ֵ����setReadOnly���������������á���ĳЩ��������֧��ֻ��ģʽ���磺Informix��
defaultReadOnly=

#driver default ָ�������ӳ������������ӵ����񼶱�TransactionIsolation����
#����ֵΪ����֮һ��������ɼ�javadoc����NONE,READ_UNCOMMITTED, READ_COMMITTED, REPEATABLE_READ, SERIALIZABLE
defaultTransactionIsolation=REPEATABLE_READ

*/