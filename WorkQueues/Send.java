package com.myapp.WorkQueues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

public class Send {
    public static final String QUEUE_NAME = "work_queue";

    public static void main(String[] args) throws Exception {
        var factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()
        ) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            while (true) {
                try {
                    String message = System.console().readLine();

                    if (message.isEmpty()) {
                        System.out.println("Empty message received. Exiting...");
                        break;
                    }

                    channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
                    System.out.println(" [x] Sent '" + message + "'");
                } catch (Exception e) {
                    System.out.println("Interrupted by user. Exiting...");
                    break;
                }
            }
        }
    }
}
