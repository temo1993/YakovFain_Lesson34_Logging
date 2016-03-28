package com.lesson34;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloWorldHandlers {
	
	private static Logger helloLogger = 		
			Logger.getLogger(HelloWorldClassLogger.class.getName());

	public static void main(String[] args) {
        /***
         The program HelloWorldHandlers uses a default console handler of the global logger
         to publish messages on the console. If you add an instance of the ConsoleHandler
         object to helloLogger, you have two console handlers: one on the class level and one
         global. This results in displaying duplicate messages on the console because the
         global logger is a parent of helloLogger, and all handlers in this hierarchy are
         invoked. If you want to turn the parent loggers off, use the method
         setUseParentHandlers():*/
        //helloLogger.setUseParentHandlers(false);

        FileHandler helloFileHandler;
		try {
			helloFileHandler = new FileHandler("logs/helloWorld.log");
			helloLogger.addHandler(helloFileHandler);
			helloFileHandler.setLevel(Level.WARNING);
		} catch (SecurityException | IOException se) {
			System.out.println(se.getMessage());
		}

        helloLogger.fine("Hello from the fine world");
		helloLogger.info("Trying to divide by zero");
		try{
			int result = 25/0;
		} catch(Exception e){
			helloLogger.severe("Division by zero");	
		}
	}
}
