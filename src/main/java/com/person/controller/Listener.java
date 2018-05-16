package com.person.controller;

import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.text.DecimalFormat;

public class Listener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            if(message instanceof ActiveMQTextMessage){
                ActiveMQTextMessage activeMQTextMessage=(ActiveMQTextMessage)message;

                    System.out.println("收到的消息1111:" + activeMQTextMessage.getText());
            }


            if(message instanceof MapMessage){
                MapMessage mapMessage =(MapMessage)message;
                String stock = mapMessage.getString("stock");
                double price = mapMessage.getDouble("price");
                double offer = mapMessage.getDouble("offer");
                boolean up = mapMessage.getBoolean("up");
                DecimalFormat df = new DecimalFormat("#,###,###,##0.00");
                System.out.println(stock + "\t" + df.format(price) + "\t" + df.format(offer) + "\t" + (up ? "up" : "down"));
            }


        } catch (JMSException e) {
            e.printStackTrace();
        }

    }



}
