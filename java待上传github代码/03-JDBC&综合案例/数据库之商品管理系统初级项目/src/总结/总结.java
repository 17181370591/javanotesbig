/**
 * һ.SQL���
 * 
 * 1.����:
 * 		DDL:���ݿⶨ������,��Ҫ�����ݿ�,��,��,������ɾ�Ĳ�
 * 			a.�������ݿ�
 * 			create database ������   [charset �ַ�����];
 * 			***b.������
 * 			create table ����(
 * 				�ֶ��� ��������(����) [Լ��],
 * 				�ֶ��� ��������(����) [Լ��]
 * 			);
 * 			SQL�е���������:
 * 			����:int
 * 			С��:double
 * 			�ַ���:varchar(����),���� ��2��������
 * 			����:date  ��ʽ: 'YYYY-MM-DD'
 * 			SQL�е�Լ��:
 * 			a.����Լ��:primary key, Ψһ�ҷǿ�
 * 			b.�Զ�������Լ��:auto_increment,��������ֵ����,����һ�����ǻ����������������Լ��
 * 			c.ΨһԼ��:Unique, �����¼�ĸ��е�ֵ������ͬ
 * 			d.�ǿ�Լ��: Not Null,����Ϊnull
 * 			e.Ĭ��Լ��: default Ĭ��ֵ,Ϊĳһ���ֶ�����Ĭ��ֵ
 * 			f.���Լ��: foreign key  ����ѯ
 * 		DCL:���ݿ��������
 * 			�˽�(Oracleʱ˵����)
 * 		**DML:���ݿ�������� : �����ݿ��б��е����ݽ�����ɾ��
 * 			��:
 * 			insert into ����  (�ֶ�1,�ֶ�2...) values (ֵ1,ֵ2,ֵ3);
 * 			ע������:
 * 			1.�ֶκ�ֵҪһһ��Ӧ
 * 			2.�����ȫ�ֶ�,����������Բ�д,����values����д��ȫ���ֶε�ֵ
 * 			3.ֵ��д��: ������ֵ���͵�ֵ,����ֵ������''����""������
 * 			ɾ:
 * 			delete from ���� [where����];
 * 			trancate table ����:
 * 			��������ɾ���������ݵ�����:
 * 			delete from ����:ֻ��ɾ����¼,���������Զ�����ֵ,�´β�������ʱ,���������Զ�����ֵ
 * 			trancate table ����: �ݻٱ�,���ؽ�,����ɾ�����м�¼,Ҳ�������Զ�����ֵ(����Ϊ1)
 * 			��:
 * 			update ���� set �ֶ�=ֵ,�ֶ�=ֵ [where ����]
 * 			
 * 		**DQL:���ݿ��ѯ����: �����ݿ��б��е����ݽ��л�ʽ��ѯ
 * 		�����ѯ:
 * 			a.������ѯ:
 * 				select * from ����  where ����:
 * 				����: 
 * 					��С: > < >= <= = != <>
 * 				����:
 * 					between .. and .. ע��:ֻ���ж���ֵ������
 * 					����: between '1990-05-30' and '2000-10-10'
 * 					age in (10,20)===> age=10 or age = 20;
 * 				Ϊ��:
 * 					is null;
 * 					is not null
 * 				ģ����ѯ:
 * 					like '���ʽ',  ����_��ʾ����һ���ַ�  ����%��ʾ����������ַ�
 * 			b.�����ѯ
 * 				select * from ���� order by �ֶ�  ASC(Ĭ��,����)|DESC(����);
 * 			c.�ۺϲ�ѯ:
 * 				select count(*)|max(��ֵ�ֶ�)|min(��ֵ�ֶ�)|sum(��ֵ�ֶ�)|avg(��ֵ�ֶ�)	from ����
 * 				ע������:�ۺϺ�����ѯ������ֻ��һ��ֵ,�����nullֵ
 * 			d.�����ѯ:
 * 				select �����ֶ�,�ۺϺ��� from ���� group by ĳ���ֶ�;
 * 				�ڷ����ѯ��,Ҫ��ѯ���ֶα����Ƿ����ֶ�,Ҳ�����ǾۺϺ���
 * 			e.��ҳ��ѯ
 * 				select * from ���� limit �ڼ�����¼,Ҫ��ѯ��������¼
 * 				����: ��Ҫ��ѯ��mҳ,ÿҳ��n����¼
 * 				��һҳ: limit (1-1)*n,n;
 * 				�ڶ�ҳ: limit (2-1)*n,n;
 * 				��mҳ:  limit  (m-1)*n;n
 * 			f.ȥ�ظ���ѯ
 * 				select distinct �ֶ� from ����;
 * 				��ѯ�����и��ֶ�,����ȥ���ظ�ֵ
 * 			���:
 * 				1.Ϊʲôʹ�ö��? �ع˵ڶ�����Ƶ
 * 				2.�����֮��Ĺ�ϵ:
 * 					һ�Զ�:��Ʒ���� �� ��Ʒ��Ϣ, ѧ���Ϳ��Գɼ�,ʡ����
 * 							�������ű�,һ������,һ�Ŵӱ�,
 * 							ԭ��:�ӱ������һ�����,������ ���� ���������
 * 							��θ��ӱ�������Լ��
 * 							Alter table �ӱ� add constraint ����_�ӱ�_fk
 * 							foreign key (�ӱ������) references ���� (������);
 * 					��Զ�: ѧ���Ϳγ�, ��Ա�ͽ�ɫ , ��ʦ��ѧ��
 * 						   ���������ű�,����������,һ���м��
 * 						 ԭ��: �м��,�����������ֶ�,�ֱ������,�������ŵ�����
 * 						Alter table �м��  add constraint _fk
 * 							foreign key (��һ�������) references ��һ�ű� (������);
 * 						Alter table �м��  add constraint _fk
 * 							foreign key (�ڶ��������) references �ڶ��ű� (������);
 * 					һ��һ: QQ����,��QQ��ϸ��Ϣ
 * 							������һ�ű�ʾ
 * 				����ѯ���:
 * 				1.�����ѯ: �����д���� ,ʵ������һ�������ѿ������Ķ���
 * 					select * from ��1,��2;
 * 				2.������:�ڽ������ӵĻ����� �������(һ��������.����=�ӱ�.���)
 * 					��ʽ������: ��дinner join �����������where�ж�
 * 						select * from ��A,��B where ��A.����=��B.���
 * 					��ʾ������: д��inner join �����������on�ж�
 * 						select * from ��A inner join ��B on ��A.����=��B.���
 * 
 * 				3.������:�ؼ��� outer join
 * 					��������: left outer join,�������Ϊ,����ұ���û�к����ƥ���������¼
 * 						��ôҲ�Ὣ������¼��ѯ����,û��ֵ�ĵط����null;
 * 					��������: right outer join
 * 						���ұ���Ϊ,��������û�к��ұ�ƥ���������¼
 * 						��ôҲ�Ὣ������¼��ѯ����,û��ֵ�ĵط����null;
 * 				4.�Ӳ�ѯ:
 * 					һ��select���Ľ��,��Ϊ����һ��select����һ����
 * 					����: ��Ʒ������ ��Ʒ�����Ϊ��
 * 					��ѯ ��Ʒ����Ϊ "����" ����Ʒ�ķ�����
 * 					select cname from ��Ʒ����� where ����id = 
 * 							(select ��Ʒ����id from ��Ʒ����� where ��Ʒ��="����");
 * 					
 * 
 * ��.JDBC:
 * 		1.JDBCԭ��API
 * 			����:
 * 			1.ע������:
 * 			Class.forName("com.mysql.jdbc.Driver");
 * 			2.��ȡ����: 
 * 			Connection conn = 
 * 			DriverManager.getConnection("jdbc:mysql://ip:3306/���ݿ���","�û���","����");
 * 			3.��ȡsqlִ�ж���
 * 				Statement st = conn.createStatement();
 * 			4.ִ��sql���,���һ�ȡ�����(ֻ�в�ѯ�н����,��������int����ֵ)
 * 				int rows = st.excuteUpdate(sql);
 * 				ResultSet rs = st.excuteQuery(sql);
 * 			5.��������
 * 				������е���������
 * 				next();//�ж���û����һ����¼
 * 				getXxx(int colid),getXxx(String colname);
 * 				����Xxx������int,String,Double,Object
 * 			6.�ͷ���Դ
 * 				conn.close(),st.close(),rs.close();
 * 		2.JDBCUtils������
 * 			//�ĸ�Ҫ��
 * 			private static String driverName = "com.mysql.jdbc.Driver";
 * 			private static String url = "jdbc:mysql://localhost:3306/day04";
 * 			private static String username = "root";
 * 			private static String password = "123";
 * 			//static
 * 			static{
 * 				Class.forName(driverName);
 * 			}
 * 			//��ȡ����:
 * 			public static Connection getConnection(){
 * 				DriverManager.getConnecton(url,username,password);
 * 			}
 * 			//�ر���Դ
 * 			public static void closeAll(Connection conn,Statement st,ResultSet rs){..}
 *		
 *		3.���ӳ�: ��һ������,Ԥ�Ȼ�ȡһЩ���Ӷ���,���浽�������Ա��´�ʹ��
 *			JDBC�й涨:���е����ӳض���,����ʵ�� DataSource�ӿ�
 *			DBCP���ӳ�:
 *				public class BasicDataSource implements DataSource;
 *				==================================================
 *				DBCPUtils������: ��ʹ�������ļ�
 *				//�ĸ�Ҫ��
 *				private static String driverName = "com.mysql.jdbc.Driver";
 *				private static String url = "jdbc:mysql://localhost:3306/day04";
 *				private static String username = "root";
 *				private static String password = "123";
 *				//���ӳ�
 *				private static BasicDataSource ds = new BasicDataSource();
 *				static{
 *					//�����Ĵ�Ҫ��
 *					ds.setDriverClassName(driverName);
 *					ds.setUrl(url);
 *					ds.setUsername(username);
 *					ds.setPassword(password);
 *				}
 *				public static Connection getConnection(){
 *					ds.getConnection();	
 *				}
 *				//�ر���Դ
 * 				public static void closeAll(Connection conn,Statement st,ResultSet rs){..}
 *				==================================================
 *				DBCPUtils������: ʹ�������ļ�(�Ƽ�ʹ��Properties�����ļ�)
 *				//�����ļ���д�ĸ�Ҫ��
 *				driverName=com.mysql.jdbc.Driver
 *				url=jdbc:mysql://localhost:3306/day04
 *				username=root
 *				password=123
 *				//���ӳ�
 *				private static DataSource ds;
 *				static{
 *					Properties ps =  new Properties();
 *					ps.load(new FIleInputStream("dbcpconfig.properties"))
 *					//�õ�һ������BasicDataSource�Ĺ�����
 *					ds = BasicDataSourceFactory.createDataSource(ps);
 *					//�����Ĵ�Ҫ��
 *					//ds.setDriverClassName(ps.get("driverName"));
 *					//ds.setUrl(ps.get("url"));
 *					//ds.setUsername(ps.get("username"));
 *					//ds.setPassword(ps.get("password"));
 *				}
 *				public static Connection getConnection(){
 *					ds.getConnection();	
 *				}
 *				//�ر���Դ
 * 				public static void closeAll(Connection conn,Statement st,ResultSet rs){..}
 *				=============================================			
 *				C3P0���ӳ�:��ʹ�������ļ�
 *				//�ĸ�Ҫ��
 *				private static String driverName = "com.mysql.jdbc.Driver";
 *				private static String url = "jdbc:mysql://localhost:3306/day04";
 *				private static String username = "root";
 *				private static String password = "123";
 *				//���ӳض���
 *				ComboPooledDataSource ds = new ComboPooledDataSource();
 *				//��̬�����
 *				static{
 *					ds.setDriverClass(driverName);
 *					ds.setJdbcurl(url);
 *					ds.setUser(username);
 *					ds.setPassword(password);
 *				}
 *				public static Connection getConnection(){
 *					ds.getConnection();	
 *				}
 *				//�ر���Դ
 * 				public static void closeAll(Connection conn,Statement st,ResultSet rs){..}
 *				=============================================			
 *				C3P0���ӳ�:ʹ�������ļ�
 *				//�ĸ�Ҫ��д��XMl�ļ���
 *				 <default-config><!-- Ĭ������ -->
 *					<property name="driverClass">com.mysql.jdbc.Driver</property>
 *					<property name="jdbcUrl">jdbc:mysql://localhost:3306/day04</property>
 *					<property name="user">root</property>
 *					<property name="password">123</property>
 *					<property name="initialPoolSize">10</property>
 *				</default-config>
 *				//���ӳض���
 *				//�ڴ���ComboPooledDataSource����ʱ,�ײ��ȥ�Զ���ȡ������XML
 *				//�������XML����Src��Ŀ¼��,�ļ����ֱ������c3p0-config.xml
 *				ComboPooledDataSource ds = new ComboPooledDataSource();
 *				
 *				public static Connection getConnection(){
 *					ds.getConnection();	
 *				}
 *				//�ر���Դ
 * 				public static void closeAll(Connection conn,Statement st,ResultSet rs){..}
 *			���������: DBUtils������
 *			DBUtils: ��Ҫ�ǹ�ϵ��Դ
 *				public static void closeQuietly(Connection conn,Statement st,ResultSet rs);
 *				
 *			QueryRunner:SQL���ִ�ж���
 *				��֧������
 *				����:QueryRunner(DataSource ds)
 *				1.int  update(String sql,Object... params)
 *				2. query(String sql,ResultSetHandler�ӿ� rsh, Object...params)
 *				֧������
 *				����:QueryRunner()
 *				1.int  update(Connection conn,String sql,Object... params)
 *				2. query(Connection conn,String sql,ResultSetHandler�ӿ� rsh, Object...params)
 *			ResultSetHandler�ӿ� ��ʵ����
 *				Object[]  ArrayHandler:
 *					�ѽ�����еĵ�һ����¼,��װ��һ��������,�����е�ÿ��Ԫ�ض����ֶε�ֵ
 *				List<Object[]>  ArrayListHandler:
 *					�ѽ�����е�ÿһ����¼,�ֱ��װ��һ��������,�����е�ÿ��Ԫ�ض����ֶε�ֵ
 *					�����������ٷ�װ��List������,�������������
 *				JavaBean BeanHandler:
 *					�ѽ�����еĵ�һ����¼,��װ��һ��JavaBean������,�������������
 *				List<JavaBean> BeanListHandler:
 *					�ѽ�����е�ÿһ����¼,�ֱ��װ��һ��JavaBean������,
 *					����Щ���󱣴浽������,�������������
 *				Map<String,Object> MapHandler:
 *				List<Map<String,Object>> MapListHandler
 *				List<Object> ColumnHandler:
 *				Object Scalarhandler:
 *		����:
 *			��ʼ����: 
 *				try{
 *					conn.setAutoCommit(false);
 *					insert(..)
 *					insert(..)
 *					insert(..)
 *					conn.commit();
 *				}catch(Exception ex){
 *					conn.rollback();
 *				}
 *			ThreadLocal:�ײ���һ��Map<Thread,Object>
 *				set(Object ֵ);==> map.set(��ǰ�̶߳���,ֵ)
 *				get();===>map.get(��ǰ�̶߳���)
 *				remove();====>map.remove(��ǰ�̶߳���)
 *				
 */