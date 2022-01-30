package Files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

	static Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		System.out.println("Hello World");
		logger.trace("This is a trace message");
		logger.info("This is info message");
		logger.error("This is error message");
		logger.warn("Warning");
		logger.fatal("Fatal error");
	}
}
