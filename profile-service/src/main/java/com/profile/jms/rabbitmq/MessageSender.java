package com.profile.jms.rabbitmq;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@Configuration
public class MessageSender
{

	private final static String QUEUE_NAME = "Message_Queue";

	@Async
	public void sendMessage(String username, String password) throws Exception
	{
		ConnectionFactory factory = new ConnectionFactory();

		factory.setHost("localhost");
		try (
				Connection connection = factory.newConnection();
				Channel channel = connection.createChannel())

		{
			channel.queueDeclare(QUEUE_NAME, false, false, false,
					null);
			String message = username + " " + password;
			channel.basicPublish("", QUEUE_NAME, null,
					message.getBytes("UTF-8"));
			System.out.println(" [x] Sent '" + message + "'");
		}
		catch (Exception exe)
		{
			exe.printStackTrace();
		}

	}
}
