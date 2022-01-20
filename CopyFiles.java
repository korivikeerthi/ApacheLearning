package com.keerthi.korivi.HelloWorld;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFiles {

	private static CamelContext context;

	public static void main(String[] args)throws Exception {
		context = new DefaultCamelContext();
		
		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				// TODO Auto-generated method stub
				from("file:inputs?noop=true")
				.to("file:outputs_box");
				
			}
			
		});
		//have to start the context for it to work
		while(true) {
			context.start();
		}
	}
}
