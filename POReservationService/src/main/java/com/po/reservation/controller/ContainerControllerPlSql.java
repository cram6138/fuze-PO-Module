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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.po.reservation.exception.ContainerResourceNotFoundException;
import com.po.reservation.form.ContainerForm;
import com.po.reservation.form.ContainerReserveForm;
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
	
	
	
	 @HystrixCommand(fallbackMethod="fallBackGetContainer")
		@PostMapping("/reserve/container/v2")
		public ResponseEntity<ContainerInfo> reserveContainerV2(@RequestBody final ContainerReserveForm containerReserveForm) {
			ContainerInfo containerInfo = new ContainerInfo();
			try {
			 containerInfo = containerService.reserveContainerV2(containerReserveForm);
			} catch (Exception e) {
				logger.error("Exception in reserveContainer method" + e.getMessage());
			}
			return new ResponseEntity<ContainerInfo>(containerInfo, HttpStatus.OK);
		}
		
		@HystrixCommand(fallbackMethod="fallBackGetContainer")
		@GetMapping("/unreserve/container/v2/{containerCode}")
		public ResponseEntity<ContainerInfo> unreserveContainerV2(@PathVariable String containerCode) {
			ContainerInfo containerInfo = null;
			try {
			 containerInfo = containerService.unReserveContainerV2(containerCode);
			} catch (Exception e) {
				logger.error("Exception in unReserveContainer method" + e.getMessage());
			}
			return new ResponseEntity<ContainerInfo>(containerInfo, HttpStatus.OK);
		}
		
		
	  
		@HystrixCommand(fallbackMethod = "fallBackGetContainers")
		@PostMapping("/container/reserved/v2")
		public ResponseEntity<List<ContainerInfo>> getReservedContainerByUserV2(@RequestBody final UserInfo userInfo) {
			List<ContainerInfo> reservedContainerList = new ArrayList<ContainerInfo>();
			try {
				reservedContainerList = containerService.getReservedContainerByUserV2(userInfo);
			} catch (Exception e) {
				logger.error("Exception in getReservedContainerByUser method " + e.toString());
			}
			return new ResponseEntity<List<ContainerInfo>>(reservedContainerList, HttpStatus.OK);
		}
	   
	
}
