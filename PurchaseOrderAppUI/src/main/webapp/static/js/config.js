appConfig = {
	enabled : true,
	// for prod
	 //service_application:'http://localhost:8080/PurchaseOrderAppServices-0.0.1-SNAPSHOT',
	//ui_application:'http://localhost:8090/PurchaseOrderAppUI-0.0.1-SNAPSHOT',
	//reservation_application:'http://localhost:8088/POReservationService-0.0.1-SNAPSHOT',

	// for dev
	service_application : 'http://localhost:8080',
	ui_application : 'http://localhost:8090',
	reservation_application : 'http://localhost:8088',
	
	/* Common for all environment */
	tableau_data_backend_url : 'http://localhost:4040/api/tableauData',
	tableu_visualization_url : 'https://public.tableau.com/views/PO_Request_Visualizatioon/PO_Request_Visualization?:display_count=y&publish=yes&:origin=viz_share_link',
	tableau_connection_name: 'PO Request Viz'
}