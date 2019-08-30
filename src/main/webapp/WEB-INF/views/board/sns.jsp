<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>SNS</title>
<script>

	function pagestart() {
		window.setTimeout("pagereload()", 10000);
	}
	
	function pagereload() {
		location.reload();
	}
	
    $(document).ready(function(){
    	
    	$.ajax({
    		url: "http://localhost:8080/restboard/list.do"
    		, success : function(data) {
				alert("Ajaxx sucess");
				$.each(data, function (index, item) {
					var description = $('<p>').text(item.content);
					$('#replyarea').append(description);
				})
			},
			error : function() {
				alert("Ajax error");
			}
    	});
    	
    	
    });
</script>
</head>
<body onLoad="pagestart()">
<div id="replyarea"></div>
</body>
</html>
