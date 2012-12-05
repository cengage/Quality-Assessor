<%@include file="/WEB-INF/pages/common-taglibs.jsp"%>
<table>
<c:forEach items="${list}" var="item">
			<tr>
				
				<td style="width:140px"><input class="productName" readonly style="border:none" type = "text"
					value = "${item.product.productName}">
				</td>
				<td>
				<input type ="button" value = "Self Review" />
				</td>
				<td><input type ="button" value = "Send Invitation" /></td>
			</tr>
		</c:forEach></table>