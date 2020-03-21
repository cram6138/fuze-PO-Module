 var oldPageSize = 0;
 var checkedProjectList=[];
        function onChange(e) {
        	var arryList =[];
        	checkedProjectList= this.selectedKeyNames().join(", ");
        	console.log(checkedProjectList);
        	console.log("The selected product ids are: [{" + this.selectedKeyNames().join(", ") + "}]" );
            //kendoConsole.log("The selected product ids are: [" + this.selectedKeyNames().join(", ") + "]");
        };
        function onClick(e) {
            var grid = $("#grid").data("kendoGrid");
            oldPageSize = grid.dataSource.pageSize();
            grid.dataSource.pageSize(grid.dataSource.data().length);
            if (grid.dataSource.data().length === grid.select().length) {
                grid.clearSelection();
            } else {
                grid.select("tr");
            };
            grid.dataSource.pageSize(oldPageSize);
        };
        	//bind click event to the checkbox
			function isNumeric(n) {
			          return !isNaN(parseFloat(n)) && isFinite(n);
			        }
			
			        function getBoolean(str) {
			          if("true".startsWith(str)){
			            return true;
			          } else if("false".startsWith(str)){
			            return false;
			          } else {
			            return null;
			          }          
			        }
									 var wnd,detailsTemplate;
									 $(document).ready(function(){
										 

										 
										
										// openPODetail();
										 selectedPODetail();
										 
										 $("#panelbar").kendoPanelBar({
											 expandMode: "multiple"
						                    });
										 $("#tabstrip").kendoTabStrip({
						                        animation:  {
						                            open: {
						                                effects: "fadeIn"
						                            }
						                        }
						                    });
										 $.getScript("static/js/config.js", function(){
											 server_name = appConfig.service_application;
										 })
										 
										 var Teritory =$("#Teritory").kendoDropDownList({
									          optionLabel: "Teritories...",
									          dataTextField: "teritory",
									          dataValueField: "id",
									          dataSource: {
									              transport: {
									                  read: function (options) {
												             readData(options);
											             }
									              }
									          }
									      }).data("kendoDropDownList");

									       var Markets =$("#Markets").kendoDropDownList({
									    	  optionLabel: "Markets...",
									          dataTextField: "market",
									          dataValueField: "id",
									          dataSource: {
									              
									              transport: {
									                  read: function (options) {
												             readData(options);
											             }
									              }
									          }
									      }).data("kendoDropDownList");

									      var Submarkets =$("#SubMarket").kendoDropDownList({
									          optionLabel: "Select SubMarket...",
									          dataTextField: "subMarket",
									          dataValueField: "id",
									          dataSource: {
									              transport: {
									                  read: function (options) {
												             readData(options);
											             }
									              }
									          }
									      }).data("kendoDropDownList");
									      var setSearchData =[];
									      var terirory =  Teritory.text(),
							              markts =  Markets.text(),
							              subMrks =Submarkets.text();
									      setSearchData.push(terirory);
									      setSearchData.push(markts);
									      setSearchData.push(subMrks);
									      console.log(setSearchData);

									     $("#get").click(function() {
									    	 var terirory =  Teritory.text(),
								              markts =  Markets.text(),
								              subMrks =Submarkets.text();
									          //alert("Order details:\n" + terirory +":"+Teritory.value() +"\n"+ markts+":"+Markets.value()  +"\n"+ subMrks +":"+Submarkets.value()+"");
									      }); 

									     var grid=$("#grid").kendoGrid({
									 		dataSource: {
									 	      transport: {
									 	         read: function (options) {
									 	             readData(options);
									 	             },
									 	        parameterMap: function (options, operation) {
									 	        		if (operation !== "read" && options.models) {
									 	              		return { models: kendo.stringify(options.models) };
									 	              		}
									 	            	}
									 	          },
									 	        schema: {
									 	        	 model: {
									                      id: "id",
									                      fields: {
									                     	 id: {type:"string"},
									                     	 siteNamee: {type:"string"},
									                     	 projectNamee: {type:"string"},
									                     	 markete: {type:"string"},
									                     	 subMarkete: {type:"string"},
									                     	 projectTypee: {type:"string"},
									                     	 fuzeProject: {type:"string"},
									                     	 pslc: {type:"string"},
									                     	 projectStatuse: {type:"string"},
									                     	 typee: {type:"string"},
									                     	 customProjectTypee: {type:"string"},
									                     	 siteTrackere: {type:"string"},
									                     	 teritorye: {type:"string"},
									                      }
									                  }
									 	        },
									 	         pageSize: 10
									 	    },
									 	  sortable: true,
									         change: onChange,
									 	    pageable: true,
									         filterable: true,
									 	    resizable:true,
									 	   columns: [
									 	    	  { field:"siteName", title:"Site Name", width: "180px" },
									             { field:" fuzeProject",title:"Fuze Project" , width: "120px",template:"<a href='javascript:openPODetail()' id='name-link1'>#=fuzeProject#</a>" },
									             { field:"projectName", title:"Project Name" ,width: "120px"},
									             { field:" market",title:"Market" , width: "120px"},
									             { field:" subMarket", title:"Sub Market" ,width: "120px"},
									             { field:" projectType",title:"Project Type" , width: "120px"},
									             { field:" pslc", title:"pslc" ,width: "120px"},
									             { field:" projectStatus", title:"Project Status" ,width: "120px"},
									             { field:" type",title:"Type" , width: "120px"},
									             { field:" customProjectType", title:"Custom ProjectType" ,width: "120px"},
									             { field:" siteTracker",title:"Site Tracker" , width: "120px"},
									         
									              ],
									    editable: "popup"
									 	   
									 	   
									 });
									     openPODetail();
										
										//var element = $("#gridPOData").data("kendoGrid");
										// element.thead.on("click", ".k-checkbox", onClick);
									 });
										
									function customBoolEditor(container, options) {
										 var guid = kendo.guid();
					                     $('<input class="k-checkbox" id="' + guid + '" type="checkbox" name="Discontinued" data-type="boolean" data-bind="checked:Discontinued">').appendTo(container);
					                     $('<label class="k-checkbox-label" for="' + guid + '">​</label>').appendTo(container);
					                 }
									function customBoolEditor1(container, options) {
										 var guid = kendo.guid();
					                     $('<input class="k-checkbox" id="' + guid + '" type="checkbox" name="Discontinued" data-type="boolean" data-bind="checked:Discontinued">').appendTo(container);
					                     $('<label class="k-checkbox-label" for="' + guid + '">​</label>').appendTo(container);
					                 }
									
									function selectedPODetail(){
										
                                      var details=$("#details").kendoGrid({
									dataSource: {
									      transport: {
									         read: function (options) {
									        	 poreadData(options);
									             },
									        parameterMap: function (options, operation) {
									        		if (operation !== "read" && options.models) {
									              		return { models: kendo.stringify(options.models) };
									              		}
									            	}
									          },
									        schema: {
									        	 model: {
				                                     id: "id",
				                                     fields: {
				                                    	 id: {type:"string"},
				                                    	 pslc: {type:"string"},
				                                    	 poName: {type:"string"},
				                                    	 teritory: {type:"string"},
				                                    	 market: {type:"string"},
				                                    	 poStatus: {type:"string"},
				                                     }
				                                 }
									        },
									         pageSize: 10
									    },
									   sortable: true,
						                change: onChange,
									    pageable: true,
				                        filterable: true,
									    resizable:true,
									    
									    detailInit: detailInit,
				                       columns: [
									    	
						                    { field:"id", title:"Id",width:"80px"},
						                    { field:"pslc", title:"pslc",width:"200px"},
						                    { field:" poName",title:"Name"},
						                    { field:" teritory", title:"Teritory" },
						                    { field:" market",title:"Market" },
						                    { field:" poStatus", title:"Po Status",customBoolEditor1},
						                    
				                             ],
				                   editable: "popup"
				                   		});
                                  
                                     
									}
									function showDetail(e) {
					                     //localStorage.removeItem('currentValue');
					                     console.log(e);
					                     localStorage.setItem('currentValue',e);
					                     //window.location.href='empInfo/'+ e;
					                 }
									
				function closeModel(){
					$("#PoRequestId").modal("hide");
				}

										
function readData(options){
	var host_name;
	 $.getScript("static/js/config.js", function(){
		 host_name = appConfig.service_application;
		 $.ajax({
			 url: host_name + "/RePO/getPoRequest",
	        contentType: "application/json",
	        type:"GET",
	        success: function (result) {
	        	 $.each(result, function(index, value) {
	        		 options.success(result[index].projects);
	 	        	//console.log(result[[index]].projects);
					}) 
	        	
	        },
	        error: function (result) {
	        	options.error(result);
	         }
	       });
	 })
	
}
function generateExcel(){
	var host_name;
	 $.getScript("static/js/config.js", function(){
		 host_name = appConfig.service_application;
		 $.ajax({
			 url: host_name + "/RePO/generatePORequestExcel",
	        contentType: "application/json",
	        type:"GET",
	        success: function (result) {
	        
	        
	        },
	        error: function (result) {
	        	options.error(result);
	         }
	       });
	 })
	}


$('#filter').on('input', function (e) {
    var grid = $('#grid').data('kendoGrid');
    var columns = grid.columns;

    var filter = { logic: 'or', filters: [] };
    columns.forEach(function (x) {
      if (x.field) {
        var type = grid.dataSource.options.schema.model.fields[x.field].type;
        if (type == 'string') {
          filter.filters.push({
            field: x.field,
            operator: 'contains',
            value: e.target.value
          })
        }
        else if (type == 'number') {
          if (isNumeric(e.target.value)) {
            filter.filters.push({
              field: x.field,
              operator: 'eq',
              value: e.target.value
            });
          }    

        } else if (type == 'date') {
          var data = grid.dataSource.data();
          for (var i=0;i<data.length ; i++){
            var dateStr = kendo.format(x.format, data[i][x.field]);
            // change to includes() if you wish to filter that way https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/includes
            if(dateStr.startsWith(e.target.value)){
              filter.filters.push({
                field: x.field,
                operator:'eq',
                value: data[i][x.field]
              })
            }
          }
        } else if (type == 'boolean' && getBoolean(e.target.value) !== null) {
          var bool = getBoolean(e.target.value);
          filter.filters.push({
            field: x.field,
            operator: 'eq',
            value: bool
          });
        }               
      }
    });
    grid.dataSource.filter(filter);
  });

function detailInit(e) {
    $("<div/>").appendTo(e.detailCell).kendoGrid({
    	dataSource: {
    	      transport: {
    	         read: function (options) {
    	        	 readDataChild(options,e.data.id);
    	        	// console.log(options);
    	             },
    	      
    	          parameterMap: function (options, operation) {
    	        		if (operation !== "read" && options.models) {
    	              		return { models: kendo.stringify(options.models) };
    	              		}
    	            	}
    	          },
    	        schema: {
    	        	 model: {
    	                 id: "id",
    	                 fields: {
    	                	
    	                	 id:{type:"string"},
    	                	 name:{type:"string"},
    	                	 model:{type:"string"},
    	                	 description:{type:"string"},
    	                	 price:{type:"string"},
    	                	 inStock:{type:"string"}
    	                  }
    	             }
    	        },
    	         pageSize: 10
    	    },
    	    
    	    sortable: true,
    	   resizable:true,
    	   filter: { field: "id", operator: "eq", value: e.data.id },
    	    columns: [
    	    	{ field:"id",title: "Id"},
    	    	{ field:"name",title: "Name"},
    	    	{ field:"description",title: "Description",width:"200px"},
    	    	{ field:"model",title: "Model"},
    	    	{ field:"price",title: "Price"},
    	    	{ field:"inStock",title: "in-Stock"}
    	    	 ],
    	editable: "popup"
    });
    
    function customBoolEditor1(container, options) {
		 var guid = kendo.guid();
        $('<input class="k-checkbox" id="' + guid + '" type="checkbox" name="Discontinued" data-type="boolean" data-bind="checked:Discontinued">').appendTo(container);
        $('<label class="k-checkbox-label" for="' + guid + '">​</label>').appendTo(container);
    }
}



var checkedIds = {};
//on click of the checkbox:
//function selectRow() {
//    var checked = this.checked,
//        row = $(this).closest("tr"),
//        grid = $("#grid").data("kendoGrid"),
//        dataItem = grid.dataItem(row);
//
//    checkedIds[dataItem.id] = checked;
//
//    if (checked) {
//        //-select the row
//        row.addClass("k-state-selected");
//
//        var checkHeader = true;
//
//        $.each(grid.items(), function (index, item) {
//            if (!($(item).hasClass("k-state-selected"))) {
//                checkHeader = false;
//            }
//        });
//
//        $("#header-chb")[0].checked = checkHeader;
//    } else {
//        //-remove selection
//        row.removeClass("k-state-selected");
//        $("#header-chb")[0].checked = false;
//    }
//}
//on dataBound event restore previous selected rows:
function onDataBound(e) {
	//this.expandRow(this.tbody.find("tr.k-master-row").first());
    var view = this.dataSource.view();
    for (var i = 0; i < view.length; i++) {
        if (checkedIds[view[i].id]) {
            this.tbody.find("tr[data-uid='" + view[i].uid + "']")
                .addClass("k-state-selected")
                .find(".k-checkbox")
                .attr("checked", "checked");
        }
    }
}
function readDataChild(options,e){
	var host_name;
	 $.getScript("static/js/config.js", function(){
		 host_name = appConfig.service_application;
		 $.ajax({
			 url: host_name + "/RePO/getPoRequest",
	        dataType: "json",
	        cache: false,
	        success: function (result) {
	        	if(result.length > 0){
	        	 $.each(result, function(index, value) {
	        		 if(result[index].id == parseInt(e)){
	        			 options.success(result[index].items);
	        		 }
	        		}) 
	        	}
	        },
	        error: function (result) {
	        	options.error(result);
	         }
	       });
	 })
}
function poreadData(options){
	var host_name;
	 $.getScript("static/js/config.js", function(){
		 host_name = appConfig.service_application;
		 $.ajax({
			 url: host_name + "/RePO/getPoRequest",
	        dataType: "json",
	        cache: false,
	        success: function (result) {
	         options.success(result);
	       },
	        error: function (result) {
	        	options.error(result);
	         }
	       });
	 })
	
}
//function getAllProjects(){
//	var host_name;
//	 $.getScript("static/js/config.js", function(){
//		 host_name = appConfig.service_application;
//		 $.ajax({
//			 url: host_name + "/RePO/getPoRequest",
//	        dataType: "json",
//	        cache: false,
//	        success: function (result) {
//	         options.success(result);
//	       },
//	        error: function (result) {
//	        	options.error(result);
//	         }
//	       });
//	 })
//	
//}


function toolbar_click() {
	console.log("Toolbar command is clicked!");
			  return false;
			}

function listofItem(){
	$("#PoRequestId").modal("show");
	var grid1=$("#grid1").kendoGrid({
		dataSource: {
	      transport: {
	         read: function (options) {
	             readData(options);
	             },
	        parameterMap: function (options, operation) {
	        		if (operation !== "read" && options.models) {
	              		return { models: kendo.stringify(options.models) };
	              		}
	            	}
	          },
	        schema: {
	        	 model: {
                     id: "id",
                     fields: {
                    	
                    	 id: {type:"string"},
                    	 siteName: {type:"string"},
                    	 projectName: {type:"string"},
                    	 market: {type:"string"},
                    	 subMarket: {type:"string"},
                    	 projectType: {type:"string"},
                    	 fuzeProject: {type:"string"},
                    	 pslc: {type:"string"},
                    	 projectStatus: {type:"string"},
                    	 type: {type:"string"},
                    	 customProjectType: {type:"string"},
                    	 siteTracker: {type:"string"},
                    	 teritory: {type:"string"},
                     }
                 }
	        },
	         pageSize: 10
	    },
	    persistSelection: true,
        sortable: true,
        change: onChange,
	    pageable: true,
        filterable: true,
	    resizable:true,
	    dataBound:onDataBound,
	   columns: [
	    	{
                selectable: true,
                width: "50px"
            },

            { field:"siteName", title:"Site Name", width: "180px" },
            { field:" fuzeProject",title:"Fuze Project" , width: "120px" },
            { field:"projectName", title:"Project Name" ,width: "120px"},
            { field:" market",title:"Market" , width: "120px"},
            { field:" subMarket", title:"Sub Market" ,width: "120px"},
            { field:" projectType",title:"Project Type" , width: "120px"},
            { field:" pslc", title:"pslc" ,width: "120px"},
            { field:" projectStatus", title:"Project Status" ,width: "120px"},
            { field:" type",title:"Type" , width: "120px"},
            { field:" customProjectType", title:"Custom ProjectType" ,width: "120px"},
            { field:" siteTracker",title:"Site Tracker" , width: "120px"},
        
             ],
   editable: "popup"
	   
	   
});
	
}
function openPODetail(){
	var panelBar = $("#panelbar").data("kendoPanelBar");
	    panelBar.expand($("#SiteProjectDetails"));
	    panelBar.collapse($("#PORequestDetails"));
	    panelBar.collapse($("#ProjectSearch"));
	    
}

function getRequestData(){
	var panelBar = $("#panelbar").data("kendoPanelBar");
	panelBar.expand($("#PORequestDetails"));
	panelBar.collapse($("#SiteProjectDetails"));
	panelBar.collapse($("#ProjectSearch"));
 }


function clearCart(){
	var poName="";
	var teritory="";
	var Market_po="";
	var pslc="";
	var siteTracker="";
	
}

