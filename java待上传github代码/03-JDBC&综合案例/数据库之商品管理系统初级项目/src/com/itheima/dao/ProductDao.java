package com.itheima.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.Product;
import com.itheima.utils.C3P0Utils02;
import com.itheima.utils.ConnectionManager;

/**
 * ��ƷDao��
 * @author yingpeng
 *
 */
public class ProductDao {
	//����ɾ��
	public void deleteById(int id) throws SQLException{
		//1.����QueryRunner����
		QueryRunner qr = new QueryRunner();
		//2����qr��update
		qr.update(ConnectionManager.getConnection(),"delete from products where pid = ?", id);
	}
	//����idɾ����Ʒ
	public void deleteByOneId(int id) throws SQLException{
		//1.����QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Utils02.getDataSource());
		//2����qr��update
		qr.update(ConnectionManager.getConnection(),"delete from products where pid = ?", id);
	}
	
	//������Ʒ
	public void addProdcut(Product p) throws SQLException {
		// TODO Auto-generated method stub
		//1.����QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Utils02.getDataSource());
		//2.����qr��update����
		Object[] params = {p.getPname(),p.getPrice(),"1","c002"};
		qr.update("insert into products (pname,price,flag,category_id) values (?,?,?,?)", params);
	}

	public Product findById(int id) throws SQLException {
		// TODO Auto-generated method stub
		//1.����QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Utils02.getDataSource());
		//2.����qr��query
		Product p = qr.query("select * from products where pid = ?",new BeanHandler<Product>(Product.class), id);
		return p;
	}

	public void updateProduct(Product p) throws SQLException {
		// TODO Auto-generated method stub
		//1.����QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Utils02.getDataSource());
		//2.�޸�
		qr.update("update products set pname=?,price=? where pid=?",p.getPname(),p.getPrice(),p.getPid());
	}

	public List<Product> findAll() throws SQLException {
		//1.����QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Utils02.getDataSource());
		//2.����qr��query
		List<Product> ps = qr.query("select * from products", new BeanListHandler<Product>(Product.class));
		//����
		return ps;
	}

}
