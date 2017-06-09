<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Upload Multiple Files</title>
<script
    src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script>
    $(document)
      .ready(
          function() {
              //add more file components if Add is clicked
              $('#addFile')
               .click(
                  function() {
                      fileIndex = $('#fileTable tr').children().length;
                      $('#fileTable').append(
                         '<tr><td>'
                         + '   <input type="file" name="files['+ fileIndex +']" />'
                         + '</td></tr>');
                  });
       });
</script>

</head>
<body>
    <br>
    <br>
    <div align="center">
        <h1>Spring MVC Upload Multiple Files</h1>
 
        <sf:form method="post" action="savefiles"
            modelAttribute="uploadForm" enctype="multipart/form-data">
 
            <p>Select files to upload. Press Add button to add more file inputs.</p>
 
            <table id="fileTable">
                <tr>
                    <td><input name="files[0]" type="file" /></td>
                </tr>
                <tr>
                    <td><input name="files[1]" type="file" /></td>
                </tr>
            </table>
            <br />
            <input type="submit" value="Upload" />
            <input id="addFile" type="button" value="Add File" />
        </sf:form>
 
        <br />
    </div>
</body>
</html>