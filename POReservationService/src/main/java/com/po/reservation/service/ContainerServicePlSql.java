package com.po.reservation.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.po.reservation.common.service.ProjectStatus;
import com.po.reservation.entity.Container;
import com.po.reservation.entity.Item;
import com.po.reservation.form.ContainerForm;
import com.po.reservation.form.ContainerReserveForm;
import com.po.reservation.info.ContainerInfo;
import com.po.reservation.info.ItemInfo;
import com.po.reservation.info.UserInfo;
import com.po.reservation.repository.ContainerRepositoryPlSql;

@Service
public class ContainerServicePlSql {

	private static Logger logger = LoggerFactory.getLogger(ContainerServicePlSql.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private ContainerRepositoryPlSql containerRepositoryProcedure;

	public Map<String, Object> containersByUserInfo(UserInfo request) {
		Map<String, Object> response = new HashMap<>();
		List<ContainerInfo> containerInfoList = new ArrayList<>();
		try {
			List<Container> dbContainersList = containerRepositoryProcedure.callProcedure(request);
			if (!CollectionUtils.isEmpty(dbContainersList) && dbContainersList != null) {
				for (Container row : dbContainersList) {
					ContainerInfo containerInfo = getContainerInfo(row);
					containerInfoList.add(containerInfo);
				}
				response.put("status", 1);
				response.put("containerInfoDetails", containerInfoList);
				return response;
			} else {
				response.put("status", 0);
				response.put("status", "Containers are empty.");
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("method :: containersByUserInfo ::: Something went wrong" + e);
		}
		return response;
	}

	private ContainerInfo getContainerInfo(Container container) {
		ContainerInfo containerInfo = new ContainerInfo();
		BeanUtils.copyProperties(container, containerInfo);
		containerInfo.setUseByDate(container.getUseBy());
		containerInfo.setFuzeProjectId(container.getProject().getId());
		containerInfo.setProjectName(container.getProject().getProjectName());
		containerInfo.setBuyerId(container.getBuyer().getId());
		containerInfo.setBuyerName(container.getBuyer().getFirstName() + " " + container.getBuyer().getLastName());
		containerInfo.setMROrderCode(container.getMrOrderCode());

		containerInfo.setItemsInfo(getItemsInfo(container.getItems()));

		return containerInfo;
	}

	private List<ItemInfo> getItemsInfo(Set<Item> items) {
		List<ItemInfo> itemsInfoList = new ArrayList<ItemInfo>();
		Iterator<Item> it = items.iterator();
		while (it.hasNext()) {
			ItemInfo itemInfo = new ItemInfo();
			Item item = it.next();
			BeanUtils.copyProperties(item, itemInfo);
			itemsInfoList.add(itemInfo);
		}
		return itemsInfoList;
	}

	public List<ContainerInfo> searchContainers(@Valid ContainerForm containerForm) {
		List<ContainerInfo> ContainerInfoList = new ArrayList<>();
		List<Container> containerList = containerRepositoryProcedure.callProcedureForSearchContainer(containerForm);

		if (!containerList.isEmpty()) {
			for (Container container : containerList) {
				ContainerInfo containerInfo = new ContainerInfo();
				BeanUtils.copyProperties(container, containerInfo);
				containerInfo.setPslc(container.getPslc());
				containerInfo.setPSProject(container.getProject().getProjectName());
				if (container.getReservationCreationDate() != null) {
					containerInfo.setReservationCreationDate(
							new SimpleDateFormat("yyyy-MM-dd").format(container.getReservationCreationDate()));
				}
				if (container.getUseBy() != null) {
					containerInfo.setUseBy(new SimpleDateFormat("dd-MMM-yy").format(container.getUseBy()));
				}
				ContainerInfoList.add(containerInfo);
			}
		}

		return ContainerInfoList;
	}

	public ContainerInfo reserveContainerV2(ContainerReserveForm containerReserveForm) {
		Date useByDate = null;
		try {
			if (containerReserveForm.getUseByDate() != null) {
				useByDate = new SimpleDateFormat("dd-MMM-yyyy").parse(containerReserveForm.getUseByDate());
			}
		} catch (ParseException e) {
			logger.info("exception due to parsing date" + e);
		}

		Calendar cal = Calendar.getInstance();
		String date = new SimpleDateFormat("ddMMyyyy").format(cal.getTime());

		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("reserveContainerDetails")
				.registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
				.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter(3, Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter(4, String.class, ParameterMode.IN)
				.registerStoredProcedureParameter(5, String.class, ParameterMode.INOUT)
				.registerStoredProcedureParameter(6, String.class, ParameterMode.INOUT)
				.registerStoredProcedureParameter(7, Date.class, ParameterMode.INOUT)
				.registerStoredProcedureParameter(8, String.class, ParameterMode.OUT)
				.registerStoredProcedureParameter(9, String.class, ParameterMode.IN)
				.registerStoredProcedureParameter(10, String.class, ParameterMode.IN)
				.registerStoredProcedureParameter(11, String.class, ParameterMode.IN)
				.registerStoredProcedureParameter(12, String.class, ParameterMode.OUT)
				.registerStoredProcedureParameter(13, String.class, ParameterMode.OUT)

				.setParameter(1, containerReserveForm.getContainerCode())
				.setParameter(2, containerReserveForm.getUserInfo().getId()).setParameter(3, useByDate)
				.setParameter(4, containerReserveForm.getUserInfo().getFirstName())
				.setParameter(5, containerReserveForm.getReservationNotes())
				.setParameter(6, ProjectStatus.FUZE + date + String.valueOf(generatePin()))
				.setParameter(7, cal.getTime()).setParameter(9, containerReserveForm.getUseAtPslc())
				.setParameter(10, containerReserveForm.getUsePsProject())
				.setParameter(11, containerReserveForm.getPsProjectStatus());

		query.execute();
		ContainerInfo containerInfo = new ContainerInfo();
		containerInfo.setFuzeReservationId((String) query.getOutputParameterValue(6));
		containerInfo.setReservationCreationDate(
				new SimpleDateFormat("yyyy-MM-dd").format((Date) query.getOutputParameterValue(7)));
		containerInfo.setReservationNotes((String) query.getOutputParameterValue(5));
		containerInfo.setMessage((String) query.getOutputParameterValue(13));
		return containerInfo;

	}

	public static int generatePin() {
		Random generator = new Random();
		return 100000 + generator.nextInt(900000);
	}

	public ContainerInfo unReserveContainerV2(String containerCode) {

		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("unreserveContainerDetails")
				.registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
				.registerStoredProcedureParameter(2, String.class, ParameterMode.OUT)
				.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT)

				.setParameter(1, containerCode);
		query.execute();
		ContainerInfo containerInfo = new ContainerInfo();

		containerInfo.setMessage((String) query.getOutputParameterValue(3));

		return containerInfo;
	}

	/**
	 * @param UserInfo userInfo
	 * @return List<ContainerInfo> containerInfoList
	 */
	public List<ContainerInfo> getReservedContainerByUserV2(final UserInfo userInfo) {
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("Myreservation")
				.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN).setParameter(1, userInfo.getId());
		query.execute();
		List<Container> containers = query.getResultList();
		List<ContainerInfo> containerInfoList = new ArrayList<ContainerInfo>();
		if (containers != null && !containers.isEmpty()) {
			for (Container container : containers) {
				ContainerInfo containerInfo = getContainerInfo(container);
				containerInfoList.add(containerInfo);
			}
		} else {
			logger.info("method :: getReservedContainerByUser ::: Containers not found");
		}
		return containerInfoList;
	}

}
