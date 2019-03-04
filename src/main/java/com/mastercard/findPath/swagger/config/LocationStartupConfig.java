package com.mastercard.findPath.swagger.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mastercard.findPath.ui.common.LoadFile;

@Configuration
public class LocationStartupConfig implements CommandLineRunner {

	@Autowired
	LoadFile loadFile;

	private static final Logger logger = LoggerFactory.getLogger(LocationStartupConfig.class);

	@Override
	public void run(String... args) throws Exception {
		logger.info("Loading location details..");
		loadFile.loadOriginDestination();

	}
}
