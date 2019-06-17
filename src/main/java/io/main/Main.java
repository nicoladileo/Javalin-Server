package io.main;

import io.handler.MainHandler;
import io.javalin.Javalin;

public class Main {
	public static void main(String args[]) {
		Javalin app = Javalin.create().start(7000);
		app.get("/test", new MainHandler());
		app.post("/test", new MainHandler());
	}
}
