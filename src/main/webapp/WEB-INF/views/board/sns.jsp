<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<style media="screen">
  .form-control.form-control-lg.rounded-1.test {
    height: 100px;
  }
</style>
    <meta charset="utf-8">
    
    <script>

	function pagestart() {
		window.setTimeout("pagereload()", 10000);
	}
	
	function pagereload() {
		location.reload();
	}
	
    $(document).ready(function(){
    	
    	$.formCheck = function(data) {
			if(data == ""){
				return true;
			}
			return false;
		}
    	
    	$.ajax({
    		url: "http://localhost:8080/restboard/list.do"
    		
    		, success : function(data) {
				$.each(data, function (index, item) {
					var description = $('<p>').text(item.content);
					$('#replyarea').append(description);
				})
			},
			error : function() {
			}
    	});
    	
		$("#btnSave").click(function() {
			if($.formCheck($("#title").val())){
				alert("제목없음");
				return;
			}else if($.formCheck($("#content").val())){
				alert("내용없음");
				return;
			}
			else if($.formCheck($("#writer").val())){
				alert("작성자 없음");
				return;
			}else{
				$.ajax({
					url: "http://localhost:8080/restboard/insert.do"
			    		, data: $("dataForm").serialize()
			    		, data: {
			    			content : $("#content").val(),
			    			writer : $("#writer").val(),
			    			title : $("#title").val()
			    		}		
		    		, success : function(data) {
						location.reload();
					},
					error : function() {
						alert("에러");
					}
				})
			}
			
		});
    	
    	
    });
</script>

  </head>
  <body class="bg-dark">
  	<div class="container py-5">
      <div class="row">
          <div class="col-md-12">
              <h1 id="header" class="text-center text-white mb-4">e-hr SNS</h1>
              <div class="row">
                  <div class="col-md-6 mx-auto">
                      <!-- form card login -->
                      <div class="card rounded-1">
                          <div class="card-header">
                              <h3 class="mb-0" >제목 : </h3>
                          </div>
                          <div class="card-body">
                              <form class="form" id="formLogin"  method="POST">
                                  <div class="form-group">
                                      <label>위치정보</label>
                                      <input type="text" class="form-control form-control-lg rounded-1" id="id">
                                  </div>

                                  <div class="form-group">
                                      <label>내용</label>
                                      <input class="form-control form-control-lg rounded-1 test" height="100px" >
                                  </div>
                                  <button type="button" class="btn btn-success btn-lg float-right" id="btn" >등록</button>
                              </form>
                          </div>
                          <!--/card-block-->
                      </div>
                      <!-- /form card login -->

                  </div>

              </div>
          </div>
          <!--/col-->
      </div>
      <!--/row-->
  </div>
  </body>
  </html>

