package com.fuze.po.fuzesoap.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.addcontainerdetails.addcontainerdetails.AddContainerDetailsRequest;
import com.addcontainerdetails.addcontainerdetails.AddContainerDetailsResponse;
import com.application.reservation.fuze.reuseprojectdetails.ReuseProjectDetailsRequest;
import com.application.reservation.fuze.reuseprojectdetails.ReuseProjectDetailsResponse;
import com.cartproduceritem.cartdetails.CartDetailsRequest;
import com.cartproduceritem.cartdetails.CartItemsDetailsResponse;
import com.cartproduceritem.cartdetails.Cartitems;
import com.cartproduceritem.cartdetails.Item;
import com.createpocartproducer.createpo.AddPODetailsRequest;
import com.createpocartproducer.createpo.AddPODetailsResponse;
import com.createpocartproducer.createpo.Itempojo;
import com.createpocartproducer.createpo.Pores;
import com.fuze.po.fuzesoap.application.entity.CartEntity;
import com.fuze.po.fuzesoap.application.entity.CartItemsEntity;
import com.fuze.po.fuzesoap.application.entity.ContainerEntity;
import com.fuze.po.fuzesoap.application.entity.ItemEntity;
import com.fuze.po.fuzesoap.application.entity.POItemsEntity;
import com.fuze.po.fuzesoap.application.entity.PORequestEntity;
import com.fuze.po.fuzesoap.application.entity.ProjectEntity;
import com.fuze.po.fuzesoap.application.entity.UserEntity;
import com.fuze.po.fuzesoap.application.repository.CartEntityRepository;
import com.fuze.po.fuzesoap.application.repository.CartItemRepository;
import com.fuze.po.fuzesoap.application.repository.ContainerEntityRepository;
import com.fuze.po.fuzesoap.application.repository.ItemEntityRepository;
import com.fuze.po.fuzesoap.application.repository.POItemsEntityRepository;
import com.fuze.po.fuzesoap.application.repository.PORequestEntityRepository;
import com.fuze.po.fuzesoap.application.repository.ProjectEntityRepository;
import com.fuze.po.fuzesoap.application.repository.UserEntityRepository;
import com.poaddcartitemsproducer.addcartitems.AddCartItemsRequest;
import com.poaddcartitemsproducer.addcartitems.AddCartItemsResponse;
import com.poaddcartitemsproducer.addcartitems.ItemIdsPojo;
import com.polistproduceritem.polist.POListRequest;
import com.polistproduceritem.polist.POListResponse;
import com.polistproduceritem.polist.Porespojo;
import com.poreqeditproducer.poreqedit.POReqEditRequest;
import com.poreqeditproducer.poreqedit.POReqEditResponse;
import com.poreqeditproducer.poreqedit.Poreqeditpojo;
import com.poreqstatusproducer.poreqstatus.POReqStatusRequest;
import com.poreqstatusproducer.poreqstatus.POReqStatusResponse;

@Endpoint
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PODetailsEndpoint {

	private static final String NAMESPACE_URI_CART_DETAILS = "http://www.cartproduceritem.com/cartdetails";

	private static final String NAMESPACE_URI_CREATE_PO = "http://www.createpocartproducer.com/createpo";

	private static final String NAMESPACE_URI_PO_LIST = "http://www.polistproduceritem.com/polist";

	private static final String NAMESPACE_URI_CHANGE_PO_REQUEST_STATUS = "http://www.poreqstatusproducer.com/poreqstatus";

	private static final String NAMESPACE_URI_EDIT_PO_REQUEST = "http://www.poreqeditproducer.com/poreqedit";

	private static final String NAMESPACE_URI_ADD_CART_ITEMS = "http://www.poaddcartitemsproducer.com/addcartitems";

	private static final String NAMESPACE_URI_ADD_CONTAINER_DETAILS = "http://www.addcontainerdetails.com/addcontainerdetails";

	private static final String NAMESPACE_URI_REUSE_PROJECT_DETAILS = "http://www.fuze.reservation.application.com/reuseprojectdetails";

	@Autowired
	private CartItemRepository cartItemRepository;

	@Autowired
	private PORequestEntityRepository poRequestEntityRepository;

	@Autowired
	private POItemsEntityRepository poItemsEntityRepository;

	@Autowired
	private ItemEntityRepository itemEntityRepository;

	@Autowired
	private CartEntityRepository cartEntityRepository;

	@Autowired
	private ProjectEntityRepository projectEntityRepository;

	@Autowired
	private ContainerEntityRepository containerEnityRepository;

	@Autowired
	private UserEntityRepository userEntityRepository;

	@ResponsePayload
	@PayloadRoot(namespace = NAMESPACE_URI_CART_DETAILS, localPart = "CartDetailsRequest")
	public CartItemsDetailsResponse getCarts(@RequestPayload CartDetailsRequest request) {
		CartItemsDetailsResponse cartItemsDetailsResponse = new CartItemsDetailsResponse();
		List<Cartitems> cartItemsList = new ArrayList<Cartitems>();
		try {
			List<CartItemsEntity> cartItems = cartItemRepository.findByCartId(request.getId());
			for (CartItemsEntity loopci : cartItems) {
				XMLGregorianCalendar xmlDate = null;
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTime(new Date());
				xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);

				Item item = new Item();
				item.setId(loopci.getItem().getId());
				item.setName(loopci.getItem().getName());
				item.setContractId(loopci.getItem().getContractId());
				item.setDueDate(xmlDate);
				item.setShipToId(loopci.getItem().getShipToId());
				item.setActivity(loopci.getItem().getActivity());
				item.setComments(loopci.getItem().getComments());
				item.setModel(loopci.getItem().getModel());
				item.setPrice(loopci.getItem().getPrice());
				item.setDescription(loopci.getItem().getDescription());
				item.setInStock(loopci.getItem().isInStock());

				Cartitems cartItemsRes = new Cartitems();
				cartItemsRes.setItem(item);
				cartItemsRes.setQuantity(loopci.getQuantity());
				cartItemsList.add(cartItemsRes);
			}
			cartItemsDetailsResponse.setCartitems(cartItemsList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartItemsDetailsResponse;
	}

	@ResponsePayload
	@PayloadRoot(namespace = NAMESPACE_URI_CREATE_PO, localPart = "AddPODetailsRequest")
	public AddPODetailsResponse createPO(@RequestPayload AddPODetailsRequest request) {
		AddPODetailsResponse cartItemsDetailsResponse = new AddPODetailsResponse();
		Pores poRes = new Pores();
		try {
			Optional<PORequestEntity> dbPORequestEntity = poRequestEntityRepository
					.findById(request.getPoreq().getId());
			if (dbPORequestEntity.isPresent()) {
				POItemsEntity poItemsEntity = new POItemsEntity();
				poItemsEntity.setPoRequestEntity(dbPORequestEntity.get());

				for (Itempojo row : request.getPoreq().getItempojo()) {
					POItemsEntity poItemsEntityrow = new POItemsEntity();
					poItemsEntityrow.setItemEntity(itemEntityRepository.getOne(row.getId()));
					poItemsEntityrow
							.setPoRequestEntity(poRequestEntityRepository.findById(request.getPoreq().getId()).get());
					poItemsEntityRepository.save(poItemsEntityrow);
					cartItemRepository.deleteAllCartItemsByCartId();
				}
				poRes.setMessage("PO Created Successfully.");
				poRes.setStatus(true);
				cartItemsDetailsResponse.setPores(poRes);
			} else {
				poRes.setMessage("PO's not available.");
				poRes.setStatus(false);
				cartItemsDetailsResponse.setPores(poRes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartItemsDetailsResponse;
	}

	@ResponsePayload
	@PayloadRoot(namespace = NAMESPACE_URI_PO_LIST, localPart = "POListRequest")
	public POListResponse poList(@RequestPayload POListRequest request) {
		POListResponse response = new POListResponse();
		List<Porespojo> list = new ArrayList<>();
		try {
			List<PORequestEntity> dbList = poRequestEntityRepository.findAll();
			if (!CollectionUtils.isEmpty(dbList)) {
				for (PORequestEntity row : dbList) {
					Porespojo porespojo = new Porespojo();
					porespojo.setId(row.getId());
					BeanUtils.copyProperties(row, porespojo);
					list.add(porespojo);
				}
				response.setPorespojo(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@ResponsePayload
	@PayloadRoot(namespace = NAMESPACE_URI_CHANGE_PO_REQUEST_STATUS, localPart = "POReqStatusRequest")
	public POReqStatusResponse changePORrqStatus(@RequestPayload POReqStatusRequest request) {
		POReqStatusResponse response = new POReqStatusResponse();
		try {
			Optional<PORequestEntity> dbPOReqEntity = poRequestEntityRepository.findByIdAndStatus(request.getId());
			if (dbPOReqEntity.isPresent()) {
				dbPOReqEntity.get().setStatus(request.getStatus());
				poRequestEntityRepository.save(dbPOReqEntity.get());
				response.setId(dbPOReqEntity.get().getId());
				response.setStatus(dbPOReqEntity.get().getStatus());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@ResponsePayload
	@PayloadRoot(namespace = NAMESPACE_URI_EDIT_PO_REQUEST, localPart = "POReqEditRequest")
	public POReqEditResponse editPORequest(@RequestPayload POReqEditRequest request) {
		POReqEditResponse response = new POReqEditResponse();
		try {
			Optional<PORequestEntity> dbPOReq = poRequestEntityRepository.findById(request.getId());
			if (dbPOReq.isPresent()) {
				Poreqeditpojo poReqEditPojo = new Poreqeditpojo();
				dbPOReq.get().setSiteName(request.getSiteName());
				dbPOReq.get().setProjectName(request.getProjectName());
				dbPOReq.get().setProjectId(request.getProjectId());
				dbPOReq.get().setPslc(request.getPslc());
				dbPOReq.get().setPsProject(request.getPsProject());
				dbPOReq.get().setProjectStatus(request.getProjectStatus());
				dbPOReq.get().setType(request.getType());
				dbPOReq.get().setProjectType(request.getProjectType());
				dbPOReq.get().setCustomerProjectType(request.getCustomerProjectType());
				dbPOReq.get().setSiteTracker(request.getSiteTracker());
				dbPOReq.get().setStatus(request.getStatus());
				poRequestEntityRepository.save(dbPOReq.get());
				BeanUtils.copyProperties(dbPOReq.get(), poReqEditPojo);
				response.setPoreqeditpojo(poReqEditPojo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@ResponsePayload
	@PayloadRoot(namespace = NAMESPACE_URI_ADD_CART_ITEMS, localPart = "AddCartItemsRequest")
	public AddCartItemsResponse addCartItems(@RequestPayload AddCartItemsRequest request) {
		AddCartItemsResponse response = new AddCartItemsResponse();
		try {
			Optional<CartEntity> dbCart = cartEntityRepository.findById(request.getCartId());
			if (dbCart.isPresent()) {
				if (!CollectionUtils.isEmpty(request.getItemIds())) {
					for (ItemIdsPojo row : request.getItemIds()) {
						CartItemsEntity cartItemsEntity = new CartItemsEntity();
						ItemEntity itemEntity = new ItemEntity();
						itemEntity.setId(row.getItemId());
						Integer quantityValue = 5;
						cartItemsEntity.setCart(dbCart.get());
						cartItemsEntity.setItem(itemEntity);
						cartItemsEntity.setQuantity(quantityValue);
						cartItemRepository.save(cartItemsEntity);
					}
					response.setMessage("Successfully saved.");
					response.setStatus("success");
				} else {
					response.setMessage("Items are can't be empty.");
					response.setStatus("failed");
					return response;
				}
			} else {
				response.setMessage("Cart Id not exist.");
				response.setStatus("failed");
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	// save the container details in container table

	@ResponsePayload
	@PayloadRoot(namespace = NAMESPACE_URI_ADD_CONTAINER_DETAILS, localPart = "AddContainerDetailsRequest")
	public AddContainerDetailsResponse addContainerDetails(@RequestPayload AddContainerDetailsRequest request) {

		AddContainerDetailsResponse response = new AddContainerDetailsResponse();
		try {

			Optional<PORequestEntity> dbPORequest = poRequestEntityRepository.findById(request.getPoRequestId());

			Optional<ProjectEntity> dbProject = projectEntityRepository
					.findById(Integer.parseInt(dbPORequest.get().getProjectId()));
			Optional<UserEntity> dbUserEntity = userEntityRepository.findById(request.getUserId());

			if (dbPORequest.isPresent()) {
				if (dbUserEntity.isPresent()) {
					ContainerEntity containerEntity = new ContainerEntity();

					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMyyyyhhmmss");
					LocalDateTime now = LocalDateTime.now();

					String containercode = dbPORequest.get().getTeritory().substring(0, 2).toUpperCase()
							+ dbProject.get().getMarket().substring(0, 2).toUpperCase()
							+ dbProject.get().getSubMarket().substring(0, 2).toUpperCase()
							+ dbProject.get().getLocalMarket().substring(0, 2).toUpperCase() + dtf.format(now);

					containerEntity.setMarket(dbProject.get().getMarket());
					containerEntity.setTerritory(dbPORequest.get().getTeritory());
					containerEntity.setSubMarket(dbProject.get().getSubMarket());
					containerEntity.setLocalMarket(dbProject.get().getLocalMarket());
					containerEntity.setProject(dbProject.get());
					containerEntity.setBuyer(dbUserEntity.get());
					containerEntity.setContainerCode(containercode);
					containerEntity.setPslc(dbProject.get().getPslc());
					containerEntity.setPSProject(dbPORequest.get().getPsProject());

					containerEnityRepository.save(containerEntity);
					response.setMessage("Successfully saved.");
					response.setStatus(1);
				} else {
					response.setMessage("User not exists");
					response.setStatus(0);
				}
			} else {
				response.setMessage("Purchase Order not exists");
				response.setStatus(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	// Getting the project details

	@ResponsePayload

	@PayloadRoot(namespace = NAMESPACE_URI_REUSE_PROJECT_DETAILS, localPart = "ReuseProjectDetailsRequest")
	public ReuseProjectDetailsResponse getReuseProjectDetails(@RequestPayload ReuseProjectDetailsRequest request)
			throws DatatypeConfigurationException {
		ReuseProjectDetailsResponse response = new ReuseProjectDetailsResponse();

		try {

			/*
			 * Optional<ContainerEntity> dbContainer =
			 * containerEnityRepository.findByPslc(request.getPslcLocationCode());
			 */

			Optional<ProjectEntity> dbProjectByProjectName = projectEntityRepository
					.findByProjectName(request.getPsProject());

			XMLGregorianCalendar xmlDate = null;
			GregorianCalendar gc = new GregorianCalendar();
			gc.add((GregorianCalendar.DAY_OF_WEEK), 135);
			xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);

			XMLGregorianCalendar xmlDate1 = null;
			GregorianCalendar gc1 = new GregorianCalendar();
			xmlDate1 = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc1);

//			if (dbContainer.isPresent()) {
				Optional<ProjectEntity> dbProject = projectEntityRepository.findByPslc(request.getPslcLocationCode());

				gc.setTime(dbProject.get().getEffectiveDate());
				if (dbProject.isPresent()) {
					response.setPslcLocationCode(dbProject.get().getPslc());
					response.setFuzeProjectId(dbProject.get().getFuzeProject());
					response.setPslcDescription(dbProject.get().getPslc_description());
					response.setPsProject(dbProject.get().getProjectName());
					response.setPsProjectDescription(dbProject.get().getProject_description());
					response.setPsProjectEffectiveDate(xmlDate);
					response.setUseByDate(xmlDate1);
					response.setPsProjectStatus(dbProject.get().getProjectStatus());
					response.setStatus(1);
					response.setMessage("success");

				} else {

					response.setStatus(0);
					response.setMessage("project not mapped.");

				}

//			}
			if (dbProjectByProjectName.isPresent()) {

				response.setPslcLocationCode(dbProjectByProjectName.get().getPslc());
				response.setFuzeProjectId(dbProjectByProjectName.get().getFuzeProject());
				response.setPslcDescription(dbProjectByProjectName.get().getPslc_description());
				response.setPsProject(dbProjectByProjectName.get().getProjectName());
				response.setPsProjectDescription(dbProjectByProjectName.get().getProject_description());
				response.setPsProjectEffectiveDate(xmlDate);
				response.setUseByDate(xmlDate1);
				response.setPsProjectStatus(dbProjectByProjectName.get().getProjectStatus());
				response.setStatus(1);
				response.setMessage("success");

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

}
