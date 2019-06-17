package io.handler;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.javalin.Context;
import io.javalin.Handler;

public class MainHandler implements Handler {
	private Logger log = LoggerFactory.getLogger(MainHandler.class);
		
	public void handle(Context ctx) throws Exception {
		String path = ctx.path();
		String method = ctx.method();		
		log.info(String.format("Handle %s on %s", method, path));
		
		if (method.equals("GET"))
			this.doGet(ctx);
		
		if (method.equals("POST"))
			this.doPost(ctx);
	}
	
	private void doGet(Context ctx) throws Exception {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("message", "Server response ok");
		ctx.json(result);
	}
	
	private void doPost(Context ctx) throws Exception {
		HashMap<String, Object> result = new HashMap<String, Object>();
		HashMap<String, Object> body = new HashMap<String, Object>();
		body= ctx.bodyAsClass(HashMap.class);
		result.put("message", "Server response ok");
		result.put("data", body);
		ctx.json(result);
	}
}
