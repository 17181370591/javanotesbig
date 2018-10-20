package com.itheima.demo2;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Map<String, Float> a = new LinkedHashMap<String, Float>();
		File[] f = new File("H:\\����java�Ա�68Ԫ").listFiles();

		for (File x : f) {
			float i = 0;
			if (x.isFile()) {
				continue;
			}
			// System.out.println(x);
			for (File y : x.listFiles()) {
				if (y.isFile()) {
					i += 0.01;
				} else if (y.isDirectory()) {
					i += 1;
				}
			}
			a.put(x.getName(), i);
		}
		float l = 0;
		for (String s : a.keySet()) {
			float i = a.get(s);
			System.out.println(s + ":" + i);
			l += i;
		}
		System.out.println(l);
	}

}

/*
01-Java����:15.0
02-mysql���ݿ�:3.0
03-JDBC&�ۺϰ���:4.0
04-Webǰ��֪ʶ:7.01
05-JavaWeb֪ʶ:13.0
06-JavaWeb������ǿ:4.0
07-store��Ŀ:6.0
08-Hibernate���:4.0
09-Struts2���:4.0
10-Spring���:5.0
11-CRM-�ͻ�����ϵͳ:3.0
12-Oracle���ݿ�:4.0
13-Maven:2.0
14-��������������Ŀ:15.0
15-����ssm���_mybatis:2.0
16-SpringMvc_SSM�ۺ�ʵս:3.0
17-Lucene&solr����&����:3.0
18-���ͷֲ�ʽ������Ŀ:20.0
117.01
*/