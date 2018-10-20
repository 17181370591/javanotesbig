package com.itheima.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;


public class ProductView {
	public static void main(String[] args) throws SQLException {
		//1.��ʾ�˵�
		System.out.println("��ӭ������Ʒ����ϵͳ,������һ��������в���:");
		while(true){
		System.out.println("C:����  U:�޸�  D:ɾ��  DA:����ɾ��   FI:��ѯ  FA:��ѯ����  Q:�˳�");
		//2.��ȡ�û��ļ�������
		Scanner sc = new Scanner(System.in);
		String userSelect = sc.nextLine();
			//3.�ж��û�����ĵ�������һ������
			switch (userSelect.toUpperCase()) {
				case "C":
					//������Ʒ
					addProduct();
					break;
				case "U":
					//�޸���Ʒ
					editProduct();
					break;
				case "D":
					//����IDɾ����Ʒ
					deleteProduct();
					break;
				case "DA":
					//����ɾ��
					deleteAllProducts();
					break;
				case "FI":
					//����id��ѯ
					findById();
					break;
				case "FA":
					//��ѯ������Ʒ
					findAll();
					break;
				case "Q":
					System.out.println("��ӭ���´�����Ŷ~~ôô��");
					System.exit(0);//�����������е�JVM 
					break;
				default:
					System.out.println("��ɵ��?�����ɶ����...");
					break;
			}
		}
	}

	private static void findAll() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("��ѡ���˲鿴������Ʒ����!");
		ProductService service = new ProductService();
		List<Product> ps = service.findAll();
		//�ж���û����Ʒ
		if(ps.isEmpty()){
			System.out.println("���ݿ�����ʱû������,����Ӻ��ٲ鿴Ӵ~~~");
		}else{
			for (Product p : ps) {
				System.out.println(p);
			}
			System.out.println("������Ʒ��ʾ���!");
		}
	}

	private static void findById() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("��ѡ���˲�ѯ��Ʒ����!");
		//1.������Ҫ�޸ĵ���Ʒ�ı��
		System.out.println("������Ҫ��ѯ����Ʒ�ı��:");
		int id = Integer.parseInt(sc.nextLine());
		//2.����service�Ĳ�ѯ����
		ProductService service = new ProductService();
		Product p = service.findById(id);
		//3.չʾ
		if(p==null){
			System.out.println("��ѯ����Ʒ������..��ȷ�Ϻ�����...");
		}else{
			System.out.println("����ѯ����Ʒ��:"+p);
			System.out.println("��ʾ��Ʒ�ɹ�!");
		}
	}

	private static void deleteAllProducts() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ProductService service = new ProductService();
		System.out.println("��ѡ��������ɾ����Ʒ����!");
		//1.�ȴ���һ������ ����Ҫɾ������Ʒ��id
		List<Integer> ids = new ArrayList<Integer>();
		//2.��������Ҫɾ������Ʒ�ı��(-1��ʾ����)
		while(true){
			System.out.println("��������Ҫɾ������Ʒ�ı��(-1��ʾ����):");
			int deleteId = Integer.parseInt(sc.nextLine());
			if(deleteId == -1){
				break;
			}
			//3.�ж���û�д�id����Ʒ
			Product p = service.findById(deleteId);
			if(p!=null){
				//����д���Ʒ
				ids.add(deleteId);
				System.out.println("�Ѿ���Ǵ���Ʒ..");
			}else{
	//			���û�д���Ʒ
				System.out.println("����Ʒ������,����������");
				
			}
		}
		//5.����service�ķ���
		if(ids.isEmpty()){
			System.out.println("����ɾ�������Ѿ�ȡ��...");
		}else{
			//������ʾ
			System.out.println("��һ�������"+ids.size()+"��Ҫɾ������Ʒ");
			System.out.println("��ȷ����Ҫɾ����? y/n");
			String isOrNot = sc.nextLine();
			if("y".equals(isOrNot)){
				service.deleteAll(ids);
				System.out.println("����ɾ��"+ids.size()+"����Ʒ�ɹ�!");
			}else{
				System.out.println("ȡ������..");
			}
			//....
		}
	}

	private static void deleteProduct() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("��ѡ����ɾ����Ʒ����!");
		//1.������Ҫɾ������Ʒ���
		System.out.println("������Ҫɾ������Ʒ���:");
		int id = Integer.parseInt(sc.nextLine());
		//2.�ж���û�д�id����Ʒ
		ProductService service = new ProductService();
		Product p = service.findById(id);
		if(p==null){
			//���û�� �����û� û�д���Ʒ
			System.out.println("���޴���Ʒ....");
		}else{
			//����� �ȸ����û� ��id��Ʒ�ľ�����Ϣ
			System.out.println("��Ҫɾ������Ʒ��Ϣ����:");
			System.out.println(p);
			System.out.println("��ȷ��Ҫɾ����? y/n");
			String isOrNot = sc.nextLine();
			if("y".equals(isOrNot)){
				service.deleteById(id);
				System.out.println("ɾ����Ʒ�ɹ�!");
			}else{
				System.out.println("����ȡ��..");
			}
		}
		
		//....
	}

	private static void editProduct() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("��ѡ�����޸���Ʒ����!");
		//1.������Ҫ�޸ĵ���Ʒ�ı��
		System.out.println("������Ҫ�޸ĵ���Ʒ�ı��:");
		int id = Integer.parseInt(sc.nextLine());
		//2.��ѯ���ݿ�,����и����û�ѡ�����Ʒ��ʲô��Ϣ
		// 			���û��Ҫ��ʾ�û���Ʒ������
		ProductService service = new ProductService();
		Product p = service.findById(id);
		if(p==null){
			System.out.println("��Ҫ�޸ĵ���Ʒ���"+id+",����Ʒ������");
		}else{
			//˵������Ʒ����
			System.out.println("��Ҫ�޸ĵ���Ʒ��Ϣ����:");
			System.out.println(p);
			//��������Ʒ���µ�����
			System.out.println("��������Ʒ���µ�����:");
			String newName = sc.nextLine();
			//��������Ʒ���µļ۸�
			System.out.println("��������Ʒ���µļ۸�:");
			int newPrice = Integer.parseInt(sc.nextLine());
			//�����µ����ֺͼ۸�
			p.setPname(newName);
			p.setPrice(newPrice);
			//����servicee��
			service.updateProduct(p);
			System.out.println("�޸���Ʒ�ɹ�!");
		}
		//....
	}
	//�����Ʒ
	private static void addProduct() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("��ѡ����������Ʒ����!");
		//1.�������µ���Ʒ����
		System.out.println("�������µ���Ʒ����:");
		String name = sc.nextLine();
		//2.�������µ���Ʒ�۸�
		System.out.println("�������µ���Ʒ�۸�:");
		int price = Integer.parseInt(sc.nextLine());
		//3.��װ����Ʒ����
		Product p = new Product(name,price);
		//4.����service��������Ʒ����
		ProductService service = new ProductService();
		service.addProduct(p);
		
		
		System.out.println("�����Ʒ�ɹ�!");
	}
}
