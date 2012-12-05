
<%@include file="/WEB-INF/pages/common-taglibs.jsp"%>




<div style="margin: 3%">

	<table id="productTableId">
		<tr id = "productTableHeadId">
			<th ><img src="images/new.png" id="addNewProductDomain"></th><th></th>
			<th style="width:140px;text-align:left">Product Name</th>
			<th>Product Description</th>
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td><input class="productId" type = "hidden" value = "${product.productId}"><img src="images/edit.png" class="editImage"></td>
				<td><img src="images/cross.png" class="deleteImage"></td>
				<td style="width:140px"><input class="productName" readonly style="border:none" type = "text"
					value = "${product.productName}">
				</td>
				<td>
				<input class="productDescription" type = "text" readonly style="border:none"
				value = "${product.productDescription}">
				</td>
				<td><a href ="templateSelectionView?productId=${product.productId}" >Get this product to be reviewed</a></td>
			</tr>
		</c:forEach>
	</table>

</div>