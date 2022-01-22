package com.ActiveMq.filesharing;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class sendFilesviaActiveMq {

	public static void main(String[] args) throws Exception{
		CamelContext context = new DefaultCamelContext();
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		context.addComponent("jms",JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		context.addRoutes(new RouteBuilder() {	
		
			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				from("file:D:\\File_location?noop=true")
				.to("activemq:queue:Queue_name");
			}
			
		});
		while(true) {
			context.start();
		}
	}
}
