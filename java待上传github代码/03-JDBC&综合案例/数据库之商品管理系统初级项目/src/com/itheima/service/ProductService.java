package com.itheima.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.utils.C3P0Utils02;
import com.itheima.utils.ConnectionManager;
/**
 * ��Ʒ��Service��
 * @author yingpeng
 *
 */
public class ProductService {

	//����ɾ����Ʒ
	public void deleteAll(List<Integer> ids){
		ProductDao dao = new ProductDao();
		//ѭ������dao.deleteById();
		
		try {
			//��������
			ConnectionManager.start();
			for (int id : ids) {
				dao.deleteById(id);
				System.out.println(1/0);
			}
			//�ύ����
			ConnectionManager.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//�ع�����
			try {
				ConnectionManager.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			try {
				ConnectionManager.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//����idɾ����Ʒ
	public void deleteById(int id){
		ProductDao dao = new ProductDao();
		try {
			
			dao.deleteByOneId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�����Ʒ
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		try {
			dao.addProdcut(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Product findById(int id) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		Product p = null;
		try {
			p = dao.findById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	//�޸���Ʒ
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		try {
			dao.updateProduct(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Product> findAll() {
		// TODO Auto-generated method stub
		ProductDao dao = new ProductDao();
		List<Product> ps = null;
		try {
			ps = dao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}

}
