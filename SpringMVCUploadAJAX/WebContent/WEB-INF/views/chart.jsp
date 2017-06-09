<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Chart</title>

		<script src="${pageContext.request.contextPath}/resources/js/core/jquery.1.10.2.min.js"></script>
		<script type="text/javascript">
$(function () {

    // Radialize the colors
    Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function (color) {
        return {
            radialGradient: {
                cx: 0.5,
                cy: 0.3,
                r: 0.7
            },
            stops: [
                [0, color],
                [1, Highcharts.Color(color).brighten(-0.3).get('rgb')] // darken
            ]
        };
    });

    // Build the chart
    $('#container').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Exam System'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    },
                    connectorColor: 'silver'
                }
            }
        },
        credits: {
            enabled: false
        }
    });
});
		</script>
	</head>
	<body>
	<script src="${pageContext.request.contextPath}/resources/js/chart/highcharts.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/chart/exporting.js"></script>
	<script>
		$(document).ready(function(){
			var chart = $('#container').highcharts();
		    chart.addSeries({
		        name: 'Marks',
		        data: [
		               { name: 'Fail', y: Number('${marks.Fail}'), sliced: true, selected: true},
		               { name: 'Pass', y: Number('${marks.Pass}'), sliced: true, selected: true}
		        ]
		    });
		});
	</script>

<div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>

	</body>
</html>
