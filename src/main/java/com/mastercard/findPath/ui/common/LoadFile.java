package com.mastercard.findPath.ui.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class LoadFile {

	private static final Logger logger = LoggerFactory.getLogger(LoadFile.class);
	public List<List<String>> roads = new ArrayList<>();

	@Value("${origin.destination}")
	private String location;

	public void loadOriginDestination() throws IOException {
		logger.info("Loading Location paths...");
		ClassPathResource cpr = new ClassPathResource(location);
		BufferedReader br = new BufferedReader(new InputStreamReader(cpr.getInputStream(), "UTF-8"));
		try {

			String line = "";
			while ((line = br.readLine()) != null) {
				String[] paths = line.split(",");
				List<String> road = new ArrayList<>();
				road.add(paths[0].trim());
				road.add(paths[1].trim());
				roads.add(road);
			}
			logger.info("Location details are loaded !!!");
		} 
		catch (Exception e) {
			logger.error("Exception raised while loading loactions..");
			throw e;
		}
		finally {
			br.close();
		}
	}

}
