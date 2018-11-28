package cn.itcast.test;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(value = "classpath:applicationContext.xml")
@RunWith(value = SpringJUnit4ClassRunner.class)
public class SpringMQ1 {
	
	//这里jq和jt都是JmsTemplate对象，所以用了@Qualifier来表示各自的引用。
	@Autowired
	@Qualifier(value="jmsQueueTemplate")
	private JmsTemplate jq;
	@Autowired
	@Qualifier(value="jmsTopicTemplate")
	private JmsTemplate jt;
	
	@Test
	public void test1() {				//spring整合的生产者
		MessageCreator m=new MessageCreator() {			
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage m1= session.createTextMessage("fuck spring queue");
				return m1;
			}
		};
//		for(int i=0;i<9;i++){
			jq.send("itcast_spring_queue",m);
//		}
	}
	@Test				//spring整合的手动消费者
	public void test2() throws JMSException {
		TextMessage m = (TextMessage)jq.receive("itcast_spring_queue");
		System.out.println(m.getText());
	}
	@Test				
	//spring整合的监听者，配置完成后直接运行就会创建监听者，
	//由于这是个测试类，为了测试类不关闭所以死循环。
	public void test3() throws JMSException {
		while(true);
	}
}


---------------------------------------------------------


需要在applicationContext.xml里导入mq的xml，配置如下：
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:jdbc="http://www.springframework.org/schema/jdbc" xmlns:tx="http://www.springframework.org/schema/tx"
	xmlns:jpa="http://www.springframework.org/schema/data/jpa" xmlns:task="http://www.springframework.org/schema/task"
	xmlns:amq="http://activemq.apache.org/schema/core"
	xmlns:jms="http://www.springframework.org/schema/jms"
	xsi:schemaLocation="
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
		http://www.springframework.org/schema/jdbc http://www.springframework.org/schema/jdbc/spring-jdbc.xsd
		http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd
		http://www.springframework.org/schema/data/jpa 
		http://www.springframework.org/schema/data/jpa/spring-jpa.xsd
		http://www.springframework.org/schema/jms
        http://www.springframework.org/schema/jms/spring-jms.xsd
		http://activemq.apache.org/schema/core
        http://activemq.apache.org/schema/core/activemq-core.xsd">
	
	<!-- 扫描当前模块的对应路径的包，下面的ref=queue1等就是这里扫出来的 -->	
	<context:component-scan base-package="cn.itcast.jms" />
	
	<!-- ActiveMQ 连接工厂 -->
    <amq:connectionFactory id="amqConnectionFactory"
        brokerURL="tcp://localhost:61616" userName="admin" password="admin"  />

    <!-- Spring Caching连接工厂 -->
    <bean id="connectionFactory" class="org.springframework.jms.connection.CachingConnectionFactory">
        <property name="targetConnectionFactory" ref="amqConnectionFactory"></property>
        <property name="sessionCacheSize" value="100" />
    </bean>
	
	<!-- 定义JmsTemplate的Queue类型 -->
    <bean id="jmsQueueTemplate" class="org.springframework.jms.core.JmsTemplate">
        <!-- 这个connectionFactory对应的是我们定义的Spring提供的那个ConnectionFactory对象 -->  
        <constructor-arg ref="connectionFactory" />
        <!-- 非pub/sub模型（发布/订阅），即队列模式 -->
        <property name="pubSubDomain" value="false" />
    </bean>

    <!-- 定义JmsTemplate的Topic类型 -->
    <bean id="jmsTopicTemplate" class="org.springframework.jms.core.JmsTemplate" >
         <!-- 这个connectionFactory对应的是我们定义的Spring提供的那个ConnectionFactory对象 -->  
        <constructor-arg ref="connectionFactory" />
        <!-- pub/sub模型（发布/订阅） -->
        <property name="pubSubDomain" value="true"  />
    </bean>
	
    
     <!-- Spring JmsTemplate 的消息生产者 start-->
    <jms:listener-container  destination-type="queue" container-type="default" connection-factory="connectionFactory">
       <jms:listener destination="itcast_spring_queue" ref="queue1"/>
    </jms:listener-container>
    
<!--		下面是topic的配置   
   <jms:listener-container  destination-type="topic" container-type="default" connection-factory="connectionFactory">
       <jms:listener destination="spring_topic" ref="topicConsumer1"/>
       <jms:listener destination="spring_topic" ref="topicConsumer2" />
    </jms:listener-container> -->
    
</beans>

---------------------------------------------------------
上面被扫描的包cn.itcast.jms里，有如下类：
基本版的代码里，是用消费者创建监听(tMessageListener)时要传一个MessageListener对象，
new这个对象时要实现onMessage方法来对收到信息进行处理。类似的，
<jms:listener destination="itcast_spring_queue" ref="queue1"/>表示：
用"itcast_spring_queue"生成queue对象q，用q生成消费者c，
用c创建监听，而创建的监听必须实现onMouse方法，ref就是这个方法的实现类。


package cn.itcast.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component(value="queue1")
public class QueueListener implements MessageListener{

	@Override
	public void onMessage(Message arg0) {
		TextMessage m=(TextMessage)arg0;
		try {
			System.out.println(m.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}