package com.person.controller;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSConsumer {
    private static final  String USERNAME= ActiveMQConnection.DEFAULT_USER;
    private static final  String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD;
    //private static final  String BROKERURL=ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final  String BROKERURL="tcp://192.168.0.106:61616";



    public static void main(String[] args) {
        ConnectionFactory factory ;
        Connection connection =null;
        Session session ;
        Destination destination ;
        MessageConsumer messageConsumer;

        factory= new  ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKERURL);
        try {
            String queueName="queueMQ";
            connection=factory.createConnection();
            connection.start();
            session=connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            destination=session.createQueue(queueName);
            messageConsumer=session.createConsumer(destination);

            TextMessage textMessage= (TextMessage) messageConsumer.receive(60000);
            if(textMessage!=null){
                System.out.println(textMessage.getJMSMessageID()+"*****");
            }
            messageConsumer.setMessageListener(new Listener());

        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }


    }



}
