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
import com.po.reservation.form.ContainerSearchForm;
import com.po.reservation.info.ContainerInfo;
import com.po.reservation.info.UserInfo;
import com.po.reservation.service.ContainerService;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContainerController {

	private static Logger logger = LoggerFactory.getLogger(ContainerController.class);
	@Autowired
	private ContainerService containerService;

	@HystrixCommand(fallbackMethod="fallBackGetContainers")
	@PostMapping("/search/container")
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
	
	@HystrixCommand(fallbackMethod="fallBackGetContainers")
	@PostMapping("/searchByCheckBox/container")
	public ResponseEntity<List<ContainerInfo>> searchContainersBasedOnCheckBox(
			@RequestBody final ContainerSearchForm containerSearchForm) {
		List<ContainerInfo> containerList = new ArrayList<>();
		try {
			containerList = containerService.searchContainersBasedOnCheckBox(containerSearchForm);
		} catch (Exception e) {
			logger.error("Exception in searchContainersBasedOnCheckBox method" + e.getMessage());
		}
		return new ResponseEntity<List<ContainerInfo>>(containerList, HttpStatus.OK);
	}

	@PostMapping("/containersByUserInfo")
	public Map<String, Object> containerByUserInfo(@RequestBody UserInfo request) {
		logger.info("Entering into gettingContainerDetails method in Container controller");
		return containerService.containersByUserInfo(request);
	}
	

	/**
	 * @param containerId
	 * @return ContainerInfo
	 */
	@HystrixCommand(fallbackMethod="fallBackGetContainer")
	@GetMapping("/container/{containerId}")
	public ResponseEntity<ContainerInfo> containerById(@PathVariable("containerId") final int containerId) {
		ContainerInfo containerInfo = null;
		try {
			containerInfo = containerService.getContainerById(containerId);
		} catch (Exception e) {
			logger.error("Exception in containerById method" + e.toString());
		}
		return new ResponseEntity<ContainerInfo>(containerInfo, HttpStatus.OK);
	}

	/**
	 * @return List<ContainerInfo>
	 */
	@HystrixCommand(fallbackMethod="fallBackGetContainers")
	@PostMapping("/container/list")
	public ResponseEntity<List<ContainerInfo>> getContainers(@RequestBody final UserInfo userInfo) {
		List<ContainerInfo> containerInfos = new ArrayList<ContainerInfo>();
		try {
			containerInfos = containerService.getContainerList(userInfo);
		} catch (Exception e) {
			logger.error("Exception in getContainers method " + e.toString());
		}
		return new ResponseEntity<List<ContainerInfo>>(containerInfos, HttpStatus.OK);
	}
	@HystrixCommand(fallbackMethod="fallBackGetContainers")
	@PostMapping("/container/reserved")
	public ResponseEntity<List<ContainerInfo>> getReservedContainerByUser(@RequestBody final UserInfo userInfo) {
		List<ContainerInfo> reservedContainerList = new ArrayList<ContainerInfo>();
		try {
			reservedContainerList = containerService.getReservedContainerByUser(userInfo);
		} catch (Exception e) {
			logger.error("Exception in getReservedContainerByUser method " + e.toString());
		}
		return new ResponseEntity<List<ContainerInfo>>(reservedContainerList, HttpStatus.OK);
	}
	
	@HystrixCommand(fallbackMethod="fallBackGetContainer")
	@PostMapping("/reserve/container")
	public ResponseEntity<ContainerInfo> reserveContainer(@RequestBody final ContainerReserveForm containerReserveForm) {
		ContainerInfo containerInfo = new ContainerInfo();
		try {
		 containerInfo = containerService.reserveContainer(containerReserveForm);
		} catch (Exception e) {
			logger.error("Exception in reserveContainer method" + e.getMessage());
		}
		return new ResponseEntity<ContainerInfo>(containerInfo, HttpStatus.OK);
	}
	
	@HystrixCommand(fallbackMethod="fallBackGetContainer")
	@GetMapping("/unreserve/container/{containerCode}")
	public ResponseEntity<ContainerInfo> unreserveContainer(@PathVariable String containerCode) {
		ContainerInfo containerInfo = null;
		try {
		 containerInfo = containerService.unReserveContainer(containerCode);
		} catch (Exception e) {
			logger.error("Exception in unReserveContainer method" + e.getMessage());
		}
		return new ResponseEntity<ContainerInfo>(containerInfo, HttpStatus.OK);
	}
	
   public ResponseEntity<List<ContainerInfo>>  fallBackGetContainers(){
	   ContainerInfo containerInfo=new ContainerInfo();
	   List<ContainerInfo> containers= new ArrayList<>();
	   containerInfo.setId(0);
	   containerInfo.setFuzeReservationId("0");
	   containerInfo.setContainerCode("0");
	   containerInfo.setPslc("0");
	   containerInfo.setMROrderCode("0");
	   containerInfo.setMRSource("0");
	   containerInfo.setTerritory("0");
	   containerInfo.setFuzeProjectId(0);
	   containerInfo.setProjectName("0");
	   containerInfo.setMarket("0");
	   containerInfo.setSubMarket("0");
	   containerInfo.setTerritory("0");
	   containers.add(containerInfo);
    	return new ResponseEntity<List<ContainerInfo>>(containers,HttpStatus.OK);
    	    }
   public ResponseEntity<ContainerInfo>  fallBackGetContainer(){
	   ContainerInfo containerInfo=new ContainerInfo();
	   containerInfo.setId(0);
	   containerInfo.setFuzeReservationId("0");
	   containerInfo.setContainerCode("0");
	   containerInfo.setPslc("0");
	   containerInfo.setMROrderCode("0");
	   containerInfo.setMRSource("0");
	   containerInfo.setTerritory("0");
	   containerInfo.setFuzeProjectId(0);
	   containerInfo.setProjectName("0");
	   containerInfo.setMarket("0");
	   containerInfo.setSubMarket("0");
	   containerInfo.setTerritory("0");
	   return new ResponseEntity<ContainerInfo>(containerInfo,HttpStatus.OK);
    	    }
}
