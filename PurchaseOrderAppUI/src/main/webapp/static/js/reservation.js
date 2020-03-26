//var userData =localStorage.setItem('UserData', user);
//var cat = localStorage.getItem(userData);

var popupNotification = $("#popupNotification").kendoNotification({
		 position: {
             pinned: true,
             top: 30,
             right: 30,
             appendTo: "#appendto"
         }
         }).data("kendoNotification");

var oldPageSize = 0;
var checkedProjectList = [];
function onChange(e) {
	var arryList = [];
	checkedProjectList = this.selectedKeyNames().join(", ");
	console.log("The selected product ids are: [{"
			+ this.selectedKeyNames().join(", ") + "}]");
	// kendoConsole.log("The selected product ids are: [" +
	// this.selectedKeyNames().join(", ") + "]");
};
function onClick(e) {
	var grid = $("#grid").data("kendoGrid");
	oldPageSize = grid.dataSource.pageSize();
	grid.dataSource.pageSize(grid.dataSource.data().length);
	if (grid.dataSource.data().length === grid.select().length) {
		grid.clearSelection();
	} else {
		grid.select("tr");
	}
	;
	grid.dataSource.pageSize(oldPageSize);
};
// bind click event to the checkbox
function isNumeric(n) {
	return !isNaN(parseFloat(n)) && isFinite(n);
}

function getBoolean(str) {
	if ("true".startsWith(str)) {
		return true;
	} else if ("false".startsWith(str)) {
		return false;
	} else {
		return null;
	}
}
var LocalMarket=null;
var containerCode=null;
var buyer=null;
var searchKeyId=null;
var projectId=null;

var wnd, detailsTemplate;
$(document)
		.ready(
				function() {
					$("#ReservDataList").hide();
					detailInit();
					// selectedPODetail();
					listofItem();

					$("#panelbar").kendoPanelBar({
						expandMode : "multiple"
					});
					$("#tabstrip").kendoTabStrip({
						animation : {
							open : {
								effects : "fadeIn"
							}
						}
					});
					var server_name;
					$.getScript("static/js/config.js", function() {
						server_name = appConfig.service_application;
					})

					var Teritory = $("#Teritory").kendoDropDownList({
						optionLabel : "Teritories...",
						dataTextField : "name",
						dataValueField : "id",
						dataSource : {
							transport : {
								read : function(options) {
									territories(options);
								}
							}
						}
					}).data("kendoDropDownList");

					var Markets = $("#Markets").kendoDropDownList({
						cascadeFrom : "Teritory",
						optionLabel : "Markets...",
						dataTextField : "name",
						dataValueField : "id",
						dataSource : {

							transport : {
								read : function(options) {
									market(options);
								}
							}
						}
					}).data("kendoDropDownList");

					var Submarkets = $("#SubMarket").kendoDropDownList({
						cascadeFrom : "Markets",
						optionLabel : "Select SubMarket...",
						dataTextField : "name",
						dataValueField : "id",
						dataSource : {
							transport : {
								read : function(options) {
									submarket(options);
								}
							}
						}
					}).data("kendoDropDownList");
					var setSearchData = [];
					var terirory = Teritory.text(), markts = Markets.text(), subMrks = Submarkets
							.text();
					setSearchData.push(terirory);
					setSearchData.push(markts);
					setSearchData.push(subMrks);
					console.log(setSearchData);

					$("#get")
							.click(
									function() {
										$("#ReservDataList").show();
										var terirory = Teritory.text(), markts = Markets
												.text(), subMrks = Submarkets.text(),local;
//										alert("Order details:\n" + terirory
//												+ ":" + Teritory.value() + "\n"
//												+ markts + ":"
//												+ Markets.value() + "\n"
//												+ subMrks + ":"
//												+ Submarkets.value() + "");
										if($("#LocalMarket").val()!=""){
											LocalMarket=$("#LocalMarket").val();
										}
										if($("#containerCode").val()!=""){
											containerCode=$("#containerCode").val();
										}
										if($("#buyer").val()!=""){
											buyer=$("#buyer").val();
										}
										if($("#projectID").val()!=""){
											projectId=$("#projectID").val();
										}
										if($("#searchKeyId").val()!=""){
											searchKeyId=$("#searchKeyId").val();
										}
										if(terirory=="Teritories..."){
											terirory = null;
										}
										if(markts=="Markets..."){
											markts = null;
										}
										if(subMrks=="Select SubMarket..."){
											subMrks = null;
										}
										var grid = $("#grid").kendoGrid({
										dataSource : {
											transport : {
												read : function(options) {
													
													var host_name;
													$.getScript("static/js/config.js", function() {
														host_name = appConfig.reservation_application;
														$.ajax({
															url : host_name + "/reservation/search/container",
															type : "POST",
															contentType : "application/json; charset=utf-8",
															data:JSON.stringify({
																"territory" : terirory,
																 "market" : markts,
																 "subMarket" : subMrks,
																 "localMarket" : LocalMarket,
																 "containerCode" : containerCode,
																 "buyer" : buyer,
																 "projectId" : projectId,
																 "searchKey" : searchKeyId,
																 "userInfo" :{
																 "id" :user.id,
																 "username" :user.username,
																 "isActive" :1,
																 "userRole" : [null,null],
																 "firstName" : user.firstName,
																 "lastName" : user.lastName,
																 "createdOn" : null,
																 "territory" :terirory,
																 "market" :markts
																 }
															}),
															
															success : function(result) {
																options.success(result);
//																$.each(result, function(index, value) {
//																	options.success(result[index].projects);
//																	console.log(result[[ index ]].projects);
//																})

															},
															error : function(result) {
																options.error(result);
																//popupNotification.show(result.statusText, "error");
															}
														});
													})
												},
												parameterMap : function(
														options, operation) {
													if (operation !== "read"
															&& options.models) {
														return {
															models : kendo
																	.stringify(options.models)
														};
													}
												}
											},
											schema : {
												model : {
													id : "id",
													fields : {
														"id":{type : "string"},
												        "containerCode": {type : "string"},
												        "territory": {type : "string"},
												        "fuzeReservationId": {type : "string"},
												        "fuzeProjectId": {type : "string"},
												        "projectName": {type : "string"},
												        "pslc":{type : "string"},
												        "reservedUsername": {type : "string"},
												        "useByDate": {type : "string"},
												        "reservationCreationDate":{type : "string"},
												        "fuzeStatus":{type : "string"},
												        "catsStatus": {type : "string"},
												        "market":{type : "string"},
												        "localMarket":{type : "string"},
												        "subMarket":{type : "string"},
												        "buyerId":{type : "string"},
												        "buyerName": {type : "string"},
												        "itemsInfo":{type : "string"},
												        "psproject":{type : "string"},
												        "mrorderCode":{type : "string"},
												        "mrsource": {type : "string"},
														
														
													}
												}
											},
											pageSize : 10
										},
										groupable: true,
				                        sortable: true,
				                        resizable: true,
				                        reorderable: true,
				                        pageable: true,
				                        columnMenu: true,
										filterable : true,
										
										columns : [
											{
												field : " id",
												title : "Action",
												width : "120px",
												template : "<a href='javascript:openPODetail()' id='name-link1'><i class='fa fa-lock'></i>unReserve</a>"
											},
											{
												field : "projectName",
												title : "View Details",
												width : "120px",
												template : "<a href='javascript:openPODetail()' id='name-link1'><i class='fa fa-eye' aria-hidden='true'></i>Details</a>"
											},
											{
												field : "containerCode",
												title : "ContainerCode",
												width : "180px"
											},
											
												{ title: "Reserving",
												 columns: [{
													field : "fuzeReservationId",
													title : "fuzeReservationId",
													width : "180px"
												},
												{
													field : " fuzeProjectId",
													title : "fuzeProjectId",
													width : "120px"
													
												},
												
												{
													field : "psproject",
													title : "psproject",
													width : "120px"
												},
												{
													field : "pslc",
													title : "pslc",
													width : "120px"
												},
												{
													field : " reservedUsername",
													title : "reservedUsername",
													width : "120px"
												},
												{
													field : " fuzeStatus",
													title : "fuzeStatus",
													width : "120px"
												}]
												},
													{
														field : " catsStatus",
														title : "catsStatus",
														width : "120px"
													},
													{
														field : " localMarket",
														title : "localMarket",
														width : "120px"
													},
													{
														field : " buyerId",
														title : "buyerId",
														width : "120px"
													},
													{
														field : " buyerName",
														title : "buyerName",
														width : "120px"
													
											
												}]
										

									});

					// var element = $("#gridPOData").data("kendoGrid");
					// element.thead.on("click", ".k-checkbox", onClick);
				});
				});

function customBoolEditor(container, options) {
	var guid = kendo.guid();
	$(
			'<input class="k-checkbox" id="'
					+ guid
					+ '" type="checkbox" name="Discontinued" data-type="boolean" data-bind="checked:Discontinued">')
			.appendTo(container);
	$('<label class="k-checkbox-label" for="' + guid + '">​</label>').appendTo(
			container);
}
function customBoolEditor1(container, options) {
	var guid = kendo.guid();
	$(
			'<input class="k-checkbox" id="'
					+ guid
					+ '" type="checkbox" name="Discontinued" data-type="boolean" data-bind="checked:Discontinued">')
			.appendTo(container);
	$('<label class="k-checkbox-label" for="' + guid + '">​</label>').appendTo(
			container);
}

function showDetail(e) {
	// localStorage.removeItem('currentValue');
	console.log(e);
	localStorage.setItem('currentValue', e);
	// window.location.href='empInfo/'+ e;
}

function readData(options){
	var host_name;
	 $.getScript("static/js/config.js", function(){
		 host_name = appConfig.reservation_application;
		 $.ajax({
			 url: host_name + "reservation/container/reserved",
	        contentType: "application/json",
	        type:"GET",
	        success: function (result) {
	        	 options.success(result);
	 	    },
	        error: function (result) {
	        	options.error(result);
	         }
	       });
	 })
	
}

function territories(options) {
	var host_name;
	$.getScript("static/js/config.js", function() {
		host_name = appConfig.reservation_application;
		$.ajax({
			url : host_name + "/territories",
			contentType : "application/json",
			type : "GET",
			success : function(result) {
				options.success(result);
				console.log(result);

			},
			error : function(result) {
				options.error(result);
			}
		});
	})

}

function market(options) {
	var host_name;
	$.getScript("static/js/config.js", function() {
		host_name = appConfig.reservation_application;
		$.ajax({
			url : host_name + "/markets",
			contentType : "application/json",
			type : "GET",
			success : function(result) {
				options.success(result);
				console.log(result);

			},
			error : function(result) {
				options.error(result);
			}
		});
	})

}

function submarket(options) {
	var host_name;
	$.getScript("static/js/config.js", function() {
		host_name = appConfig.reservation_application;
		$.ajax({
			url : host_name + "/subMarkets",
			contentType : "application/json",
			type : "GET",
			success : function(result) {
				options.success(result);
				console.log(result);

			},
			error : function(result) {
				options.error(result);
			}
		});
	})

}

$('#filter')
		.on(
				'input',
				function(e) {
					var grid = $('#grid').data('kendoGrid');
					var columns = grid.columns;

					var filter = {
						logic : 'or',
						filters : []
					};
					columns
							.forEach(function(x) {
								if (x.field) {
									var type = grid.dataSource.options.schema.model.fields[x.field].type;
									if (type == 'string') {
										filter.filters.push({
											field : x.field,
											operator : 'contains',
											value : e.target.value
										})
									} else if (type == 'number') {
										if (isNumeric(e.target.value)) {
											filter.filters.push({
												field : x.field,
												operator : 'eq',
												value : e.target.value
											});
										}

									} else if (type == 'date') {
										var data = grid.dataSource.data();
										for (var i = 0; i < data.length; i++) {
											var dateStr = kendo.format(
													x.format, data[i][x.field]);
											// change to includes() if you wish
											// to filter that way
											// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/includes
											if (dateStr
													.startsWith(e.target.value)) {
												filter.filters.push({
													field : x.field,
													operator : 'eq',
													value : data[i][x.field]
												})
											}
										}
									} else if (type == 'boolean'
											&& getBoolean(e.target.value) !== null) {
										var bool = getBoolean(e.target.value);
										filter.filters.push({
											field : x.field,
											operator : 'eq',
											value : bool
										});
									}
								}
							});
					grid.dataSource.filter(filter);
				});
function detailInit() {
	$("#childPart").kendoGrid({
		dataSource : {
			transport : {
				read : function(options) {
					readDataChild(options);
					// console.log(options);
				},

				parameterMap : function(options, operation) {
					if (operation !== "read" && options.models) {
						return {
							models : kendo.stringify(options.models)
						};
					}
				}
			},
			schema : {
				model : {
					id : "id",
					fields : {

						id : {
							type : "string"
						},
						siteName : {
							type : "string"
						},
						projectName : {
							type : "string"
						},
						market : {
							type : "string"
						},
						subMarket : {
							type : "string"
						},
						projectType : {
							type : "string"
						},
						fuzeProject : {
							type : "string"
						},
						pslc : {
							type : "string"
						},
						projectStatus : {
							type : "string"
						},
						type : {
							type : "string"
						},
						customProjectType : {
							type : "string"
						},
						siteTracker : {
							type : "string"
						},
						teritory : {
							type : "string"
						},
					}
				}
			},
			pageSize : 10
		},

		sortable : true,
		resizable : true,
		columns : [ {
			field : "siteName",
			title : "siteName",
			width : "180px"
		}, {
			field : " fuzeProject",
			title : "fuzeProject",
			width : "120px"
		}, {
			field : "projectName",
			title : "projectName",
			width : "120px"
		}, {
			field : " market",
			title : "market",
			width : "120px"
		}, {
			field : " subMarket",
			title : "subMarket",
			width : "120px"
		}, {
			field : " projectType",
			title : "projectType",
			width : "120px"
		}, {
			field : " pslc",
			title : "pslc",
			width : "120px"
		}, {
			field : " projectStatus",
			title : "projectStatus",
			width : "120px"
		}, {
			field : " type",
			title : "type",
			width : "120px"
		}, {
			field : " customProjectType",
			title : "customProjectType",
			width : "120px"
		}, {
			field : " siteTracker",
			title : "siteTracker",
			width : "120px"
		},

		],
		editable : "popup"
	});

	function customBoolEditor1(container, options) {
		var guid = kendo.guid();
		$(
				'<input class="k-checkbox" id="'
						+ guid
						+ '" type="checkbox" name="Discontinued" data-type="boolean" data-bind="checked:Discontinued">')
				.appendTo(container);
		$('<label class="k-checkbox-label" for="' + guid + '">​</label>')
				.appendTo(container);
	}
}

var checkedIds = {};

function onDataBound(e) {
	// this.expandRow(this.tbody.find("tr.k-master-row").first());
	var view = this.dataSource.view();
	for (var i = 0; i < view.length; i++) {
		if (checkedIds[view[i].id]) {
			this.tbody.find("tr[data-uid='" + view[i].uid + "']").addClass(
					"k-state-selected").find(".k-checkbox").attr("checked",
					"checked");
		}
	}
}
function readDataChild(options) {
	var host_name;
	$.getScript("static/js/config.js", function() {
		host_name = appConfig.service_application;
		$.ajax({
			url : host_name + "/RePO/getPoRequest",
			dataType : "json",
			cache : false,
			success : function(result) {
				$.each(result, function(index, value) {
					options.success(result[index].items);
				})

			},
			error : function(result) {
				options.error(result);
			}
		});
	})
}
function poreadData(options) {
	var host_name;
	$.getScript("static/js/config.js", function() {
		host_name = appConfig.service_application;
		$.ajax({
			url : host_name + "/RePO/getPoRequest",
			dataType : "json",
			cache : false,
			success : function(result) {
				options.success(result);
			},
			error : function(result) {
				options.error(result);
			}
		});
	})

}

function toolbar_click() {
	console.log("Toolbar command is clicked!");
	return false;
}

function listofItem() {
	var grid1 = $("#grid1").kendoGrid({
		dataSource : {
			transport : {
				read : function(options) {
					readData(options);
				},
				parameterMap : function(options, operation) {
					if (operation !== "read" && options.models) {
						return {
							models : kendo.stringify(options.models)
						};
					}
				}
			},
			schema : {
				model : {
					id : "id",
					fields : {

						id : {
							type : "string"
						},
						siteName : {
							type : "string"
						},
						projectName : {
							type : "string"
						},
						market : {
							type : "string"
						},
						subMarket : {
							type : "string"
						},
						projectType : {
							type : "string"
						},
						fuzeProject : {
							type : "string"
						},
						pslc : {
							type : "string"
						},
						projectStatus : {
							type : "string"
						},
						type : {
							type : "string"
						},
						customProjectType : {
							type : "string"
						},
						siteTracker : {
							type : "string"
						},
						teritory : {
							type : "string"
						},
					}
				}
			},
			pageSize : 10
		},
		sortable : true,

		pageable : true,
		filterable : true,
		resizable : true,
		columns : [ {
			field : "siteName",
			title : "siteName",
			width : "180px"
		}, {
			field : " fuzeProject",
			title : "fuzeProject",
			width : "120px"
		}, {
			field : "projectName",
			title : "projectName",
			width : "120px"
		}, {
			field : " market",
			title : "market",
			width : "120px"
		}, {
			field : " subMarket",
			title : "subMarket",
			width : "120px"
		}, {
			field : " projectType",
			title : "projectType",
			width : "120px"
		}, {
			field : " pslc",
			title : "pslc",
			width : "120px"
		}, {
			field : " projectStatus",
			title : "projectStatus",
			width : "120px"
		}, {
			field : " type",
			title : "type",
			width : "120px"
		}, {
			field : " customProjectType",
			title : "customProjectType",
			width : "120px"
		}, {
			field : " siteTracker",
			title : "siteTracker",
			width : "120px"
		},

		],
		editable : "popup"

	});

}
function openPODetail() {
	var panelBar = $("#panelbar").data("kendoPanelBar");
	panelBar.expand($("#SiteProjectDetails"));
	panelBar.collapse($("#PORequestDetails"));
	panelBar.collapse($("#ProjectSearch"));

}

function getRequestData() {
	var panelBar = $("#panelbar").data("kendoPanelBar");
	panelBar.expand($("#PORequestDetails"));
	panelBar.collapse($("#SiteProjectDetails"));
	panelBar.collapse($("#ProjectSearch"));
}
