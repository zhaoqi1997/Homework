<%@ page pageEncoding="UTF-8" contentType="text/html; utf-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set scope="page" var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
		<script type="text/javascript" src="${path}/js/jquery-3.2.1.js"></script>
		<script type="text/javascript">
			  $(function () {
				  $(".down").click(function () {
					   $(this).parent().prev().text($(this).parent().prev().text()-0+1);
				  });
			  });
		</script>
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
				<div id="header">
					<div id="rightheader">
						<p>
							2009/11/20
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						${dep.name}
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								OldName
							</td>
							<td>
								NewName
							</td>
							<td>
								End
							</td>
							<td>
								Path
							</td>
							<td>
								size
							</td>
							<td>
								type
							</td>
							<td>
								ispic
							</td>
							<td>
								acount
							</td>
							<td>
								操作
							</td>
						</tr>
						<c:forEach items="${myFile}" var="file">
							<tr class="row1">
								<td>
									${file.id}
								</td>
								<td>
										${file.oldName}
								</td>
								<td>
										${file.newName}
								</td>
								<td>
										${file.end}
								</td>
								<td>
										${file.path}
								</td>
								<td>
										${file.sizes}
								</td>
								<td>
										${file.type}
								</td>
								<td>
									<c:if test="${file.isPic=='true'}">
										<img src="${path}${file.path}/${file.newName}" style="width: 20px">
									</c:if>
									<c:if test="${file.isPic!='true'}">
										${file.isPic}
									</c:if>
								</td>
								<td>
										${file.acount}
								</td>
								
								<td>
									<a href="${path}/file/download?newName=${file.newName}&type=inline">预览</a>
									<a href="${path}/file/download?newName=${file.newName}&type=attachment" class="down">下载</a>
									<a href="${path}/file/delete?newName=${file.newName}&path=${file.path}">delete emp</a>&nbsp;
								</td>
							</tr>
						</c:forEach>

					</table>
					<form action="${path}/file/upload"  method="post" enctype="multipart/form-data">
						<input type="file" name="aa">
						<input type="submit" value="上传">
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
