package com.person.controller;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSProducer {



    private static final  String USERNAME= ActiveMQConnection.DEFAULT_USER;
    private static final  String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD;
    //private static final  String BROKERURL=ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final  String BROKERURL="tcp://192.168.0.106:61616";
    private static final  int SENDNUM=5;


    public static void main(String[] args) {
        String queueName="queueMQ";
        ConnectionFactory  factory ; //链接工厂
        Connection connection = null; //链接
        Session session ; //会话,时长
        Destination destination ; //消息的目的地
        MessageProducer messageProducer ; //消息生产者
        factory=new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKERURL); //通过链接工厂获取工厂链接
        try {
            connection=factory.createConnection();
            connection.start();
            session=connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            destination=session.createQueue(queueName);
            messageProducer=session.createProducer(destination);
            sendMessage(session,messageProducer);
            session.commit();
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }


        }



    }

    private static void sendMessage(Session session, MessageProducer messageProducer) throws JMSException {

        for(int  i=0;i<SENDNUM ;i++){
            TextMessage message=session.createTextMessage("ActiveMQ 发送消息"+i);
            System.out.println("发送消息：Activemq 发送消息" + i);
            messageProducer.send(message);
        }
    }


}
