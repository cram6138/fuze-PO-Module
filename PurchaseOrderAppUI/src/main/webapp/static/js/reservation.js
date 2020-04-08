var psStatus ; 
var currentDatalist = [];
var listPLSC =[];
 var ReservationStatus1 = false;
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
var reservationStatusGrid = [];
var currentReserveData =[];
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
$(document).ready(function(){
	
	$("#reFreshFunc").click(function(){
		SetPSLC(psStatus);
		
	});
	 $("#useByDate").kendoDatePicker({
		  value: new Date(),
		  format:"dd-MMM-yyyy"
	 });
	var host_name;
  	 $.getScript("static/js/config.js", function(){
  		 host_name = appConfig.zuul_service;
  		 $.ajax({
  			 url: host_name + "/pos/RePO/search/project",
  	        contentType: "application/json",
  	        type:"POST",
  	     contentType : "application/json; charset=utf-8",
  	        data:JSON.stringify({
  	         "projectName":null,
  	      "teritory":null,
  	      "market": null,
  	      "subMarket": null,
  	      "siteName": null,
  	      "projectType": null
  	  }),
  	        success: function (result) {
  	        	$.each(result, function(index, value) {
  	        		listPLSC.push(result[index].pslc);
  	 	        	}) 
  					console.log(listPLSC);
  	        },
  	        error: function (result) {
  	        	options.error(result);
  	         }
  	       });
  	 })
	
	$("#useAtPslc").kendoAutoComplete({
        dataSource: listPLSC,
        select: onPslcChange,
        filter: "startswith",
        placeholder: "Select PSLC...",
    });
					$("#ReservDataList").hide();
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
						server_name = appConfig.zuul_service;
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
					//console.log(setSearchData);

					$("#get")
							.click(
									function() {
										$("#ReservDataList").show();
										var terirory = Teritory.text(), markts = Markets
												.text(), subMrks = Submarkets.text(),local;

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
										if(containerCode==""){
											containerCode = null;
										}
										if(projectId==""){
											projectId = null;
										}
										if(searchKeyId==""){
											projectId = null;
										}
										
										var grid = $("#grid").kendoGrid({
										dataSource : {
											transport : {
												read : function(options) {
													
													var host_name;
													$.getScript("static/js/config.js", function() {
														host_name = appConfig.zuul_service;
														$.ajax({
															url : host_name + "/por/reservation/search/container",
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
																reservationStatusGrid = result;
																resetSearch();
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
												        "reserved":{type:"boolean"},
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
												field : "reserved",
												title : "Action",
												width : "160px",
												//template : "<a href='javascript:openPODetail()' id='name-link1'><i class='fa fa-lock'></i>&nbsp;Reserve</a>"
												template :"#if(reserved==false){#<a href='javascript:reservedStage(#=id#,#=reserved#)' id='name-link1'><i class='fa fa-lock'></i>&nbsp;Reserve</a>#}else{#<a href='javascript:reservedStage(#=id#,#=reserved#)' id='name-link1'><i class='fa fa-lock'></i>&nbsp;UnReserve</a>#}#"
											},
											{
												field : "projectName",
												title : "View Details",
												width : "120px",
												template : "<a href='javascript:openPODetail()' id='name-link1'><i class='fa fa-eye' aria-hidden='true'></i>&nbsp;Details</a>"
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
													
											
												}],
										
										
										 dataBound: function(e) {
//											 var grid = $("#grid").data("kendoGrid");
//											    var gridData = grid.dataSource.view();
//
//											    for (var i = 0; i < gridData.length; i++) {
//											        if (gridData[i].SomeProperty == SomeValue) {
//											            grid.table.find("tr[data-uid='" + gridData[i].uid + "']").addClass("highlighted-row");
//											        }
//											    }
									            // get the index of the UnitsInStock cell
									            var columns = e.sender.columns;
									            var columnIndex = this.wrapper.find(".k-grid-header [data-field=" + "reserved" + "]").index();

									            // iterate the data items and apply row styles where necessary
									            var dataItems = e.sender.dataSource.view();
									            for (var j = 0; j < dataItems.length; j++) {
									              var reserved = dataItems[j].get("reserved");

									             var row = e.sender.tbody.find("[data-uid='" + dataItems[j].uid + "']");
									              if (reserved==true) {
									                row.addClass("Unreserved");
									              }else{
									            	  row.addClass("reserved");
									              }
									            }
									          }
										

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
	//console.log(e);
	localStorage.setItem('currentValue', e);
	// window.location.href='empInfo/'+ e;
}

function readData(options){
	var host_name;
	 $.getScript("static/js/config.js", function(){
		 host_name = appConfig.zuul_service;
		 $.ajax({
			 url: host_name + "/por/reservation/container/reserved",
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
function getContainerDetails(options){
    //alert("ContainerDetails");
  var host_name;
    $.getScript("static/js/config.js", function() {
        host_name = appConfig.zuul_service;
 var baseURL = host_name+"/por/reservation/containersByUserInfo";
  $.ajax({
      type: "POST",
      dataType:"json",
      cache: false,
      contentType : "application/json; charset=utf-8",
      url: baseURL ,
      data:JSON.stringify({
         
                "id":user.id,
                "username":user.username,
                "isActive":user.isActive,
                "firstName":user.firstName,
                "userRole": [
                    "",""
                    ],
                "lastName":user.lastName,
                "territory":user.territory,
                "Market":user.Market
            
         
      }),
      success : function(result) {
        //    options.success(result.containerInfoDetails);
//            $.each(result, function(index, value) {
//                options.success(result[index].projects);
//                console.log(result[[ index ]].projects);
//            })

 

        },
        error : function(result) {
            options.error(result.containerInfoDetails);
            //popupNotification.show(result.statusText, "error");
        }
  });

 

  });
}

function territories(options) {
	var host_name;
	$.getScript("static/js/config.js", function() {
		host_name = appConfig.zuul_service;
		$.ajax({
			url : host_name + "/por/territories",
			contentType : "application/json",
			type : "GET",
			success : function(result) {
				options.success(result);
			//	console.log(result);

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
		host_name = appConfig.zuul_service;
		$.ajax({
			url : host_name + "/por/markets",
			contentType : "application/json",
			type : "GET",
			success : function(result) {
				options.success(result);
				//console.log(result);

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
		host_name = appConfig.zuul_service;
		$.ajax({
			url : host_name + "/por/subMarkets",
			contentType : "application/json",
			type : "GET",
			success : function(result) {
				options.success(result);
				//console.log(result);

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
		host_name = appConfig.zuul_service;
		$.ajax({
			url : host_name + "/pos/RePO/getPoRequest",
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
		host_name = appConfig.zuul_service;
		$.ajax({
			url : host_name + "/pos/RePO/getPoRequest",
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

function reservedStage(selectedRow,ReservationStatus){
	$.each(reservationStatusGrid, function(index, value) {
		if(reservationStatusGrid[index].id ==selectedRow){
			currentDatalist =reservationStatusGrid[index];
			psStatus=reservationStatusGrid[index].pslc;
		}
		//console.log(currentDatalist); 		
	});
	openRUnR();
	if(ReservationStatus == false){
		document.getElementById("isReserve").innerHTML ="Reserve";
		ReservationStatus1 = ReservationStatus;
		document.getElementById("containerCode_1").innerHTML=currentDatalist.containerCode;
		document.getElementById("fuzeReservationId").innerHTML="";
		document.getElementById("reservationCreationDate").innerHTML=currentDatalist.reservationCreationDate;
//document.getElementById("reservationComments").innerHTML=currentDatalist.reserved;
		document.getElementById("reservationNotes").innerHTML="";
		document.getElementById("psProjectStatus").innerHTML="";
		document.getElementById("useByDate").innerHTML="";
		document.getElementById("usePsProject123").value="";
		document.getElementById("fuzeProjectId123").value="";
		document.getElementById("psProjectStatus").innerHTML="";
     	document.getElementById("psDescription").innerHTML="";
		document.getElementById("pslcDesc").innerHTML="";
		document.getElementById("BusinessUnit").innerHTML=currentDatalist.pslc;
		document.getElementById("LocationDetailCode").innerHTML=currentDatalist.pslc;
		document.getElementById("LocationName").innerHTML=currentDatalist.pslc;
		document.getElementById("psProjectDate").innerHTML="";
	}else{
						document.getElementById("isReserve").innerHTML ="UnReserve"
						ReservationStatus1 = ReservationStatus;
						document.getElementById("useAtPslc").value =currentDatalist.pslc;
						document.getElementById("containerCode_1").innerHTML=currentDatalist.containerCode;
						document.getElementById("fuzeReservationId").innerHTML=currentDatalist.fuzeReservationId;
						document.getElementById("reservationCreationDate").innerHTML=currentDatalist.reservationCreationDate;
			//document.getElementById("reservationComments").innerHTML=currentDatalist.reserved;
						document.getElementById("reservationNotes").innerHTML=currentDatalist.reservationNotes;
						document.getElementById("psProjectStatus").innerHTML=currentDatalist.psproject;
						document.getElementById("useByDate").value=currentDatalist.useByDate;
						document.getElementById("usePsProject123").value=currentDatalist.psproject;
						document.getElementById("fuzeProjectId123").value=currentDatalist.fuzeProjectId;
						document.getElementById("BusinessUnit").innerHTML=currentDatalist.pslc;
						document.getElementById("LocationDetailCode").innerHTML=currentDatalist.pslc;
						document.getElementById("LocationName").innerHTML=currentDatalist.pslc;
						onPslcChange(currentDatalist.pslc);
	}
	
						
						//document.getElementById("pslc").innerHTML=currentDatalist.pslc;
		
	}
	
function isReserve(){
	var host_name;
	var currentURL;
	var reservationComments =$("#reservationComments").val();
	var reservationNotes =$("#reservationNotes").val();
	//var psProjectStatus =$("#psProjectStatus").val();
	var useByDate=$("#useByDate").val();
	var usePsProject=$("#usePsProject123").val();
	var useAtPslc =$("#useAtPslc").val();
	console.log(useByDate);
	$.getScript("static/js/config.js", function() {
		host_name = appConfig.zuul_service;
		if(ReservationStatus1 == false){
			currentURL=	host_name + "/por/reservation/reserve/container"
			$.ajax({
				url : currentURL,
				type : "POST",
				contentType : "application/json; charset=utf-8",
				data:JSON.stringify({
					"containerCode" :currentDatalist.containerCode,
					"businessUnit":currentDatalist.businessUnit,
					"locationDetailCode" :currentDatalist.locationDetailCode,
					"locationName": currentDatalist.locationName,
					"useAtPslc" :useAtPslc,
					"usePsProject": usePsProject,
					"useByDate" : useByDate,
					"fuzeProjectId" : currentDatalist.fuzeProjectId,
				    "psProjectStatus" : psStatus,
					"reservationNotes" : reservationNotes,
					"reservationComments" : reservationComments,
					 "userInfo" :{
						 "id" :user.id,
						 "username" :user.username,
						 "isActive" :1,
						 "userRole" : [null,null],
						 "firstName" : user.firstName,
						 "lastName" : user.lastName,
						 "createdOn" : null,
						 "territory" :user.territory,
						 "market" :user.market
						 }
				}),
				
				success : function(result) {
					//options.success(result);
					//currentReserveData=result;
					if(result.fuzeReservationId==null){
						popupNotification.show(result.message, "error");
					}else{
						popupNotification.show(result.message, "info");
						showContainerSearch();
						$("#ReservDataList").hide();
						
						
						
					}
//					$.each(result, function(index, value) {
//						options.success(result[index].projects);
//						console.log(result[[ index ]].projects);
//					})

				},
				error : function(result) {
					//options.error(result);
					popupNotification.show("reserved Something went wrong", "error");
					//popupNotification.show(result.statusText, "error");
				}
			});
		}else{
			currentURL=host_name + "/por/reservation/unreserve/container/"+currentDatalist.containerCode;
		//	onPslcChange(useAtPslc);
			$.ajax({
				url : currentURL,
				 contentType: "application/json",
			        type:"GET",
				success : function(result) {
					//options.success(result);
					popupNotification.show(result.message, "info");
					showContainerSearch();
					$("#ReservDataList").hide();
//					$.each(result, function(index, value) {
//						options.success(result[index].projects);
//						console.log(result[[ index ]].projects);
//					})

				},
				error : function(result) {
				//	options.error(result);
					popupNotification.show("Unreserved Something went wrong", "error");
					//popupNotification.show(result.statusText, "error");
				}
			});
			
		}
		
	})
}

function toolbar_click() {
	//console.log("Toolbar command is clicked!");
	return false;
}

function listofItem() {
	var grid1 = $("#grid1").kendoGrid({
		dataSource : {
			transport : {
				read : function(options) {
					getContainerDetails(options);
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
						containerCode : {
							type : "string"
						},
						territory : {
							type : "string"
						},
						projectName : {
							type : "string"
						},
						pslc : {
							type : "string"
						},
						useByDate : {
							type : "string"
						},
						fuzeStatus : {
							type : "string"
						},
						catsStatus : {
							type : "string"
						},
						market : {
							type : "string"
						},
						localMarket : {
							type : "string"
						},
						subMarket : {
							type : "string"
						},
						buyerName : {
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
			field : "containerCode",
			title : "containerCode",
			width : "180px"
		}, {
			field : " territory",
			title : "territory",
			width : "120px"
		}, {
			field : "projectName",
			title : "projectName",
			width : "120px"
		}, {
			field : " pslc",
			title : "pslc",
			width : "120px"
		}, {
			field : " useByDate",
			title : "useByDate",
			width : "120px"
		}, {
			field : " fuzeStatus",
			title : "fuzeStatus",
			width : "120px"
		}, {
			field : " catsStatus",
			title : "catsStatus",
			width : "120px"
		}, {
			field : " market",
			title : "market",
			width : "120px"
		}, {
			field : " localMarket",
			title : "localMarket",
			width : "120px"
		}, {
			field : " subMarket",
			title : "subMarket",
			width : "120px"
		}, {
			field : " buyerName",
			title : "buyerName",
			width : "120px"
		},

		],
		editable : "popup"

	});

}
function openRUnR() {
	var panelBar = $("#panelbar").data("kendoPanelBar");
	panelBar.expand($("#containerReserve"));
	panelBar.collapse($("#ContainerDetails"));
	panelBar.collapse($("#ContainerSearch"));
	panelBar.collapse($("#myReservation"));

}

function showContainerSearch() {
	var panelBar = $("#panelbar").data("kendoPanelBar");
	panelBar.expand($("#ContainerSearch"));
	panelBar.collapse($("#containerReserve"));
	panelBar.collapse($("#ContainerDetails"));
	panelBar.collapse($("#myReservation"));
}
function resetSearch(){
	LocalMarket =null;
 containerCode=null;
 buyer=null;
searchKeyId=null;
 projectId=null;
	
}




function onPslcChange(e){
	//console.log(e.dataItem);
	var currentPSCode = null;
	if(e.dataItem){
		currentPSCode = e.dataItem;
		SetPSLC(currentPSCode);
	}else{
		currentPSCode = e;
		SetPSLC(currentPSCode);
	}
	
	
	
}


function SetPSLC(item){
	var currentPSCode=item;
	$.getScript("static/js/config.js", function(){
		 host_name = appConfig.zuul_service;
		 $.ajax({
			 url: host_name + "/por/reuseProjectDetails",
	        contentType: "application/json",
	        type:"POST",
	     contentType : "application/json; charset=utf-8",
	        data:JSON.stringify({
	           "pslcLocationCode":item
	       }),
	        success: function (result) {
      	        	
	        	document.getElementById("psProjectStatus").innerHTML=result.psProjectStatus;
	        	document.getElementById("useByDate").value=result.useByDate;
				document.getElementById("usePsProject123").value=result.psProject;
				document.getElementById("fuzeProjectId123").value=result.fuzeProjectId;
				document.getElementById("useAtPslc").innerHTML=result.pslcLocationCode;
				document.getElementById("psDescription").innerHTML=result.psProjectDescription;
				document.getElementById("pslcDesc").innerHTML=result.pslcDescription;
				document.getElementById("psProjectDate").innerHTML=result.psProjectEffectiveDate;
              psStatus =result.psProjectStatus;
				},
	        error: function (result) {
	        	console.log("errpr");
	        	//options.error(result);
	         }
	       });
	 })
}