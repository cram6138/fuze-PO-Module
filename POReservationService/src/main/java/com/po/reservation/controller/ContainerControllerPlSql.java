package com.po.reservation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.po.reservation.exception.ContainerResourceNotFoundException;
import com.po.reservation.form.ContainerForm;
import com.po.reservation.info.ContainerInfo;
import com.po.reservation.info.UserInfo;
import com.po.reservation.service.ContainerServicePlSql;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContainerControllerPlSql {

	private static Logger logger = LoggerFactory.getLogger(ContainerControllerPlSql.class);
	@Autowired
	private ContainerServicePlSql containerService;


	@PostMapping("/containersByUserInfoV1plsql")
	public Map<String, Object> containerByUserInfo(@RequestBody UserInfo request) {
		logger.info("Entering into gettingContainerDetails method in Container controller");
		return containerService.containersByUserInfo(request);
	}
	
	@PostMapping("/search/containerV1plsql")
	public ResponseEntity<List<ContainerInfo>> searchContainers(@Valid @RequestBody final ContainerForm containerForm) {
		List<ContainerInfo> containerList = new ArrayList<>();
		try {
			containerList = containerService.searchContainers(containerForm);
			if (containerList.isEmpty()) {
				throw new ContainerResourceNotFoundException("No Containers Found.");
			}
		} catch (Exception e) {
			logger.error("Exception in searchContainers method" + e.getMessage());
		}
		return new ResponseEntity<List<ContainerInfo>>(containerList, HttpStatus.OK);
	}
	
}
