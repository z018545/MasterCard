package com.mastercard.findPath.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mastercard.findPath.search.GraphManager;
import com.mastercard.findPath.ui.common.LoadFile;
import com.mastercard.findPath.ui.common.ServiceResponse;

@RestController
public class FindPathController {

	private static final Logger logger = LoggerFactory.getLogger(FindPathController.class);

	@Autowired
	LoadFile loadFile;

	@RequestMapping(name = "/findPath", method = RequestMethod.GET)
	public ServiceResponse<Boolean> findPath(@RequestParam(name = "origin", required = false) String origin,
			@RequestParam(name = "destination", required = false) String destination) {
		logger.info("Source :{},Destination :{}", origin, destination);
		try {
			if (StringUtils.isEmpty(origin) || StringUtils.isEmpty(destination)) {
				return new ServiceResponse<>("Origin or Destinatuion are not valid");
			}
			List<List<String>> roads = loadFile.roads;
			GraphManager graphManger = new GraphManager(roads);

			Boolean path = graphManger.isPathPresent(origin, destination);

			return new ServiceResponse<Boolean>(path);
		} catch (Exception e) {
			logger.error("Exception raised while finding path {}", e.getMessage());
			return new ServiceResponse<Boolean>("Exception raised while finding path");
		}

	}

}
