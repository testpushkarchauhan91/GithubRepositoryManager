package com.authentication.jms.rabbitmq;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

@Configuration
public class MessageReceiver {
	private final static String QUEUE_NAME = "Message_Queue";

	@Async
	public String receiveMessagesFromQueue() throws Exception {

		final String[] resultMessageFromQueue = {null};
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			String messageFromQueue = new String(delivery.getBody(), "UTF-8");
			 resultMessageFromQueue[0] = messageFromQueue;
			//String[] message = messageFromQueue.split(" ");
			//JwtRequest jwtRequest = new JwtRequest();
			//jwtRequest.setUsername(message[0]);
			//jwtRequest.setPassword(message[1]);
			//resultJwtRequest = jwtRequest;
		};
		channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
		});

		return resultMessageFromQueue[0];
	}
}
