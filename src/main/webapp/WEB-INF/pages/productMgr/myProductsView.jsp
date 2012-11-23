
<%@include file="/WEB-INF/pages/common-taglibs.jsp"%>




<div style="margin: 3%">

	<table>
		<tr>
			<th ><img src="images/new.png" class="newDomain"></th><th></th>
			<th style="width:140px;text-align:left">Product Name</th>
			<th>Product Description</th>
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td><img src="images/edit.png" class="deleteDomain"></td>
				<td><img src="images/cross.png" class="deleteDomain"></td>
				<td style="width:140px">
					${product.productName}
				</td>
				<td>
				${product.productDescription}
				</td>
			</tr>
		</c:forEach>
	</table>

</div>