<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>게시글 작성</title>
<script>
	$(document).ready(function(){
		$("#btnSave").click(function(){
			$.formCheck = function(data) {
				if(data == ""){
					return true;
				}
				return false;
			}
			
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
				$("#form1").submit();
			}
        });
		$("#reset").click(function(){
			location.href = "list.do";
        });
		$("#del").click(function(){
			location.href = "delete.do?bno="+${param.bno};
        });
    });
</script>
</head>
<body>
	<h2>게시글 작성</h2>
	<form id="form1" method="post" action="update.do">
		<div> <input name="bno" id="bno" value="${param.bno}" type="hidden">
		</div>
		<div>
			제목 <input name="title" id="title" size="80" placeholder="제목을 입력해주세요" value="${board.title}">
		</div>
		<div>
			내용
			<textarea name="content" id="content" rows="4" cols="80" >${board.content}</textarea>
		</div>
		<div>
			이름 <input name="writer" id="writer" value="${board.writer}">
		</div>
		<div style="width: 650px; text-align: center;">
			<button type="button" id="btnSave">수정</button>
			<button type="reset" id="reset">취소</button>
			<button type="button" id="del">삭제</button>
		</div>
	</form>
</body>
</html>
