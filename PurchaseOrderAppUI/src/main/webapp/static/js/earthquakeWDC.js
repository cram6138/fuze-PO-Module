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
        tableau.log("Hello WDC!");
        var cols = [{
            id: "id",
            dataType: tableau.dataTypeEnum.string
        }, {
            id: "mag",
            alias: "magnitude",
            dataType: tableau.dataTypeEnum.float
        }, {
            id: "title",
            alias: "title",
            dataType: tableau.dataTypeEnum.string
        }, {
            id: "location",
            dataType: tableau.dataTypeEnum.geometry
        }];

        var tableSchema = {
            id: "earthquakeFeed",
            alias: "Earthquakes with magnitude greater than 4.5 in the last seven days",
            columns: cols
        };

        schemaCallback([tableSchema]);
    };

    myConnector.getData = function (table, doneCallback) {
        $.getJSON("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/4.5_week.geojson", function (resp) {
            var feat = resp.features,
                tableData = [];

            // Iterate over the JSON object
            for (var i = 0, len = feat.length; i < len; i++) {
                tableData.push({
                    "id": feat[i].id,
                    "mag": feat[i].properties.mag,
                    "title": feat[i].properties.title,
                    "location": feat[i].geometry
                });
            }

            table.appendRows(tableData);
            doneCallback();
        });
    };

    tableau.registerConnector(myConnector);
})();

$(document).ready(function () {
    $("#submitButton").click(function () {
        tableau.connectionName = "USGS Earthquake Feed";
        tableau.submit();
    });
});