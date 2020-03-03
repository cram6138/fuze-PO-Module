<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PO REQUEST REPORTS</title>
<script type="text/javascript"
	src="https://public.tableau.com/javascripts/api/tableau-2.min.js"></script>
<script src="static/js/config.js"></script>
<script type="text/javascript">
        function initViz() {
            var containerDiv = document.getElementById("vizContainer"),
                url = appConfig.tableu_visualization_url,
                options = {
                    hideTabs: true,
                    onFirstInteractive: function () {
                        console.log("Run this code when the viz has finished loading.");
                    }
                };
            var viz = new tableau.Viz(containerDiv, url, options);
            // Create a viz object and embed it in the container div.
        }
    </script>
</head>
<body onload="initViz();">
	<%@ include file="header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div id="vizContainer" style="width: 800px; height: 700px;"></div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>