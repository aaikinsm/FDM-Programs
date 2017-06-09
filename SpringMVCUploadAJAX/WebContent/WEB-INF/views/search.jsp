<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="<c:url value="/resources/js/core/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/js/core/jquery.autocomplete.min.js" />"></script>
<link href="<c:url value="/resources/js/core/main.css" />" rel="stylesheet">

</head>
<body>
  <h2>Autocomplete Search</h2>

  <div>
	<input type="text"  id="w-input-search" value="">
	<input type="hidden" id="userId">
	<span>
	  <button id="button-id" type="button">Search</button>
	</span>
  </div>
	
  <script>
  $(document).ready(function() {
	  
	$('#w-input-search').autocomplete({
		serviceUrl: 'search',
		paramName: "query",
		delimiter: ",",
		minChars: "2",
		width: 500,
		onSearchStart: function (query) {
			$('#w-input-search').css("background", "white url('${pageContext.request.contextPath}/resources/img/ui-anim_basic_16x16.gif') right center no-repeat"); 
		},
		onSearchComplete: function (query, suggestions) {
			$('#w-input-search').css("background", "white");
		},
	    transformResult: function(response) {
		return {      	
		    //must convert json to javascript object before process
		    suggestions: $.map($.parseJSON(response), function(item) { 
		    $('#userId').val(item.id);
		    return { value: "<img src='${pageContext.request.contextPath}/resources/img/nopic.png'> " + item[0].fullname + ", " + item[0].company.name + "<hr/>", data: item };
		   })
   		 };
       },
	   onSelect: function (suggestion) {
		   $('#userId').val(suggestion.data[0].id);
		   $('#w-input-search').val(suggestion.data[0].fullname);
	   }
	 });
  });
  </script>
	
</body>
</html>