package com.po.reservation.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.po.reservation.service.ContainerService;

@Component
public class TaskSchedular {
	
	@Autowired
	private ContainerService containerService;
	
	private static Logger LOGGER = LoggerFactory.getLogger(TaskSchedular.class);
	
	@Scheduled(fixedRate = 10000000)
	public void updateContainerAvailabilityStatus() {
		try {
			containerService.releaseReservedContainer();
		} catch (Exception e) {
			LOGGER.info("Exception in Scheduler for updateContainerAvailabilityStatus : " + e.toString());
		}
	}
	
}
