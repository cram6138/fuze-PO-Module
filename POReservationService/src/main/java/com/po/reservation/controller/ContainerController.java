package com.po.reservation.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.po.reservation.form.ContainerForm;
import com.po.reservation.form.ContainerSearchForm;
import com.po.reservation.info.ContainerInfo;
import com.po.reservation.service.ContainerService;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContainerController {
	
	private static Logger logger = LoggerFactory.getLogger(ContainerController.class);
	@Autowired
	private ContainerService containerService;
	
	@PostMapping("/search/container")
	public ResponseEntity<List<ContainerInfo>> searchContainers(@RequestBody final ContainerForm containerForm) {
		logger.info("Entering into searchContainers method in Container controller");
		List<ContainerInfo> containerList = new ArrayList<>();
		try {
			containerList = containerService.searchContainers(containerForm);
		} catch (Exception e) {
			logger.error("Exception in searchContainers method" + e.getMessage());
		}
		logger.info("Completed searchContainers functionality in Container controller");
		return new ResponseEntity<List<ContainerInfo>>(containerList, HttpStatus.OK);
	}
	
	@PostMapping("/searchByCheckBox/container")
	public ResponseEntity<List<ContainerInfo>> searchContainersBasedOnCheckBox(@RequestBody final ContainerSearchForm containerSearchForm) {
		logger.info("Entering into searchContainersBasedOnCheckBox method in Container controller");
		List<ContainerInfo> containerList = new ArrayList<>();
		try {
			containerList = containerService.searchContainersBasedOnCheckBox(containerSearchForm);
		} catch (Exception e) {
			logger.error("Exception in searchContainersBasedOnCheckBox method" + e.getMessage());
		}
		logger.info("Completed searchContainersBasedOnCheckBox functionality in Container controller");
		return new ResponseEntity<List<ContainerInfo>>(containerList, HttpStatus.OK);
	}
}
