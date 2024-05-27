package com.example.hmapi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HmapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmapiApplication.class, args);

		Logger _logger = LogManager.getLogger(HmapiApplication.class);
		_logger.debug("Debugging log");
		_logger.info("Info log");
		_logger.warn("Hey, This is a warning!");
		_logger.error("Oops! We have an Error. OK");
		_logger.fatal("Damn! Fatal error. Please fix me.");
	}

}
