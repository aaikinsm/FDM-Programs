
$(document).ready(function(){
	$.ajax({
	    url: 'books.xml', 
	    dataType: "xml", 
	    success: parse, // name of the function to call upon success
		error: function(){
					alert("Error: Something went wrong");
				}
	  });
		
	function parse(document){
		  $(document).find("book").each(function(){
			  $("#tbl1").append(
				'<tr>' + 	  
				'<td>' + $(this).attr('category') + '</td>' +
				'<td>' + $(this).children('title').text() + '</td>' + //We can also use .find('title'). The .find() and .children() methods are similar, except that the latter only travels a single level down the DOM tree.
				'<td>' + $(this).children('author').text() + '</td>' +
				'<td>' + $(this).children('year').text() + '</td>' +
				'<td>' + $(this).children('price').text() + '</td>' +
				'</tr>'
			   );
		  });
		}
});