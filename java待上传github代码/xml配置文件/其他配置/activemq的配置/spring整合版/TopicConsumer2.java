package cn.me.jms.consumer;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.stereotype.Component;

@Component
public class TopicConsumer2 implements MessageListener {

	@Override
	public void onMessage(Message arg0) {
		System.out.println(arg0);
	}

}
