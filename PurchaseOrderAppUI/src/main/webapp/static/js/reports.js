/*
The code is wrapped in an immediately invoked function expression to create a local scope.
The tableau object isn’t defined in our code, but in the WDC library. (It’s assigned to the global scope.)
The makeConnector function is a constructor that predefines some methods for our connector object.
The getSchema and getData functions are placeholders for now, but will contain the logic for getting the table schema of the data and downloading the data.
The registerConnector function validates the connector object before initialization.
*/

(function () {
    var myConnector = tableau.makeConnector();

    myConnector.getSchema = function (schemaCallback) {
    	// tableau.log("Hello from WDC!");
        var cols = [{
            id: "site_name",
            alias: "Site Name",
            dataType: tableau.dataTypeEnum.string
        }, {
            id: "numberOfPORequests",
            alias: "Number of PO Requests",
            dataType: tableau.dataTypeEnum.int
        }, {
            id: "po_status",
            alias: "PO Status",
            dataType: tableau.dataTypeEnum.string
        }, {
            id: "total_po_amount",
            alias: "Total PO Amount (in $)",
            dataType: tableau.dataTypeEnum.float
        }];

        var tableSchema = {
            id: "poRequests",
            alias: "Purchase Order Requests for different sites",
            columns: cols
        };

        schemaCallback([tableSchema]);
    };
    
    myConnector.getData = function (table, doneCallback) {
    	let tableauDataBackendUrl= "http://localhost:4040/api/tableauData";
//		 $.getScript("static/js/config.js", function(){
//			 tableauDataBackendUrl = appConfig.tableau_data_backend_url;
//		 })
    	 $.ajax({
			url: tableauDataBackendUrl,
	        dataType: "json",
	        cache: false,
	        'Access-Control-Allow-Origin': '*',
	        success: function (resp) {
	        	var feat = resp.result.data,
                tableData = [];

            // Iterate over the JSON object
            for (var i = 0, len = feat.length; i < len; i++) {
                tableData.push({
                    "site_name": feat[i].site_name,
                    "numberOfPORequests": feat[i].numberOfPORequests,
                    "po_status": feat[i].po_status,
                    "total_po_amount": feat[i].total_po_amount
                });
            }

            table.appendRows(tableData);
            doneCallback();    
	        },
	        error: function (err) {
	        	tableau.log('Error : ',err);
	        	console.log('Error : ',err);
	         }
	       });
    	
    };
    
    tableau.registerConnector(myConnector);
})();

$(document).ready(function () {
    $("#submitButton").click(function () {
    	let tableauConnectionName= "PO Request Viz";
		/* $.getScript("static/js/config.js", function(){
			 tableauConnectionName = appConfig.tableau_connection_name;
		 });*/
        tableau.connectionName = tableauConnectionName;
        tableau.submit();
    });
});