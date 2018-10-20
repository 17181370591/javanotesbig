package com.itheima.demo2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.domain.Cato;
import com.mchange.v2.c3p0.ComboPooledDataSource;

//ʹ��C3P0��ܴ������ӳأ�ʹ��DBUtils��ܽ�����ɾ�Ĳ飻

public class JDBCUtils {
	public static void main(String[] args) throws SQLException {

		String sql1 = "insert t value(null,?)";
		String sql2 = "update t set tname=? where tname=?";
		String sql3 = "delete from t where tname=?";
		String sql4 = "select * from t where tid=?";
		String s1 = "go";
		String s2 = "me";
		JDBCUtils.insert(sql1, s1);
		JDBCUtils.insert(sql1, s1);
		JDBCUtils.set(sql2, s2, s1);
		JDBCUtils.delete(sql3, s2);
		System.out.println("-------------------");
		JDBCUtils.selectArrayHandler("select * from t where tid>? and tname like ?", "5", "%u%");
		System.out.println("-------------------");
		JDBCUtils.selectArrayListHandler("select * from t where tid>?", "3");
		System.out.println("-------------------");
		JDBCUtils.selectBeanHandler("select * from t where tid>?", "3");
		System.out.println("-------------------");
		JDBCUtils.selectBeanListHandler("select * from t where tid>?", "3");
		System.out.println("-------------------");
		JDBCUtils.selectColumnListHandler("select * from t where tid>?", "3");
		System.out.println("-------------------");
		JDBCUtils.selectMapHandler("select * from t where tid>?", "3");
		System.out.println("-------------------");
		JDBCUtils.selectMapListHandler("select * from t where tid>?", "3");
		System.out.println("-------------------");
		JDBCUtils.selectScalarHandler("select max(tid) from t where tid>?", "3");
		System.out.println("-------------------");

	}

	private static ComboPooledDataSource ds = new ComboPooledDataSource();

	// ����C3P0���������ӳ�
	public static DataSource getds() throws SQLException {
		return ds;

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

		try {
			QueryRunner qr = new QueryRunner(JDBCUtils.getds());
			System.out.println(qr.update(sql, ss));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	// ��ResultSet�ĵ�һ�����ݷ�װ��Object[]���������ÿһ��Ԫ���Ǹ����ݵ�ÿһ���ֶε�ֵ
	public static void selectArrayHandler(String sql, String... ss) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getds());
		Object[] objs = qr.query(sql, new ArrayHandler(), ss);
		System.out.println(Arrays.toString(objs));

	}

	// ��ResultSet��ÿһ�����ݷ�װ�����Ե�Object[]�����Ȼ�������װ��list������
	public static void selectArrayListHandler(String sql, String... ss) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getds());
		List<Object[]> list = qr.query(sql, new ArrayListHandler(), ss);
		for (Object[] o : list) {
			System.out.println(Arrays.toString(o));
		}
	}

	// ��Ҫ����ResultSet��ÿһ�����ݷ�װ��javaBean��
	public static void selectBeanHandler(String sql, String... ss) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getds());
		// ���Cato���������ݿ���ֶε����ֺ�����һһ��Ӧ
		Cato c = qr.query(sql, new BeanHandler<Cato>(Cato.class), ss);
		System.out.println(c + " " + c.getTid() + " " + c.getTname());

	}

	// ��ResultSet��ÿһ�����ݷ�װ��javaBean��
	public static void selectBeanListHandler(String sql, String... ss) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getds());
		// ���Cato���������ݿ���ֶε����ֺ�����һһ��Ӧ
		List<Cato> c = qr.query(sql, new BeanListHandler<Cato>(Cato.class), ss);
		System.out.println(c);

	}

	// ��ResultSet��ÿһ�����ݵ�ָ���з�װ��list��
	public static void selectColumnListHandler(String sql, String... ss) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getds());
		List lc = qr.query(sql, new ColumnListHandler<>("tname"), ss);
		System.out.println(lc);

	}

	// ��ResultSet��ÿһ�����ݷ�װ��Map<String,Object>�key���ֶ���value���ֶ�ֵ
	public static void selectMapHandler(String sql, String... ss) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getds());
		Map m = qr.query(sql, new MapHandler(), ss);
		System.out.println(m);

	}

	// ��ResultSet��ÿһ�����ݵķ�װ��Map<String,Object>��ٰ�map��װ��list����
	public static void selectMapListHandler(String sql, String... ss) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getds());
		List lm = qr.query(sql, new MapListHandler(), ss);
		System.out.println(lm);

	}

	// ���ڵ������ݣ�����count(*)
	public static void selectScalarHandler(String sql, String... ss) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getds());
		Long lm = qr.query(sql, new ScalarHandler<Long>(), ss);
		System.out.println(lm);

	}
}