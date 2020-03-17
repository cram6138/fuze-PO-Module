package com.po.reservation.form;

public class ContainerSearchForm {

	private String isReserved;
	private String containerOnMrOrder;
	private String searchContainerNationwide;
	private String fspm;
	private String includeContainersOnReceived;

	public String getIsReserved() {
		return isReserved;
	}

	public void setIsReserved(String isReserved) {
		this.isReserved = isReserved;
	}

	public String getContainerOnMrOrder() {
		return containerOnMrOrder;
	}

	public void setContainerOnMrOrder(String containerOnMrOrder) {
		this.containerOnMrOrder = containerOnMrOrder;
	}

	public String getSearchContainerNationwide() {
		return searchContainerNationwide;
	}

	public void setSearchContainerNationwide(String searchContainerNationwide) {
		this.searchContainerNationwide = searchContainerNationwide;
	}

	public String getFspm() {
		return fspm;
	}

	public void setFspm(String fspm) {
		this.fspm = fspm;
	}

	public String getIncludeContainersOnReceived() {
		return includeContainersOnReceived;
	}

	public void setIncludeContainersOnReceived(String includeContainersOnReceived) {
		this.includeContainersOnReceived = includeContainersOnReceived;
	}

}
