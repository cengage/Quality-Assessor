<%@include file="/WEB-INF/pages/common/common-taglibs.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form class="box login" style="top: 36%;" action="getProductList"
	name="dataDTOName" id="dataFormId" method="get" commandName="dataDTO">

	<div style='margin-left: 50px'>
		<br>
		<div>
			<label
				style="margin: 2px 9px 2px 2px; font-size: 12px; position: absolute; right: 0;"></label>
			<label class="userform-box-name">Select Product</label><br>
		</div>

		<div>
			<form:select path="selectedProductId" id="selectedProductId"
				onchange="submit()">
				<form:option value="" label="--Select Product--" />
				<form:options items="${dataDTO.productDTOList}"
					itemLabel="productCode" itemValue="id" />
			</form:select>
		</div>
	</div>
	<c:if test="${not empty dataDTO.selectedProductId}">
		<div id="categoryDivId" style='margin-left: 50px'>
			<br>
			<div>
				<label
					style="margin: 2px 9px 2px 2px; font-size: 12px; position: absolute; right: 0;"></label>
				<label class="userform-box-name">Select Category</label><br>
			</div>

			<div>
				<form:select path="selectedCategoryId" id="selectedCategoryId"
					onchange="submit()">
					<form:option value="" label="--Select Category--" />
					<form:options items="${dataDTO.categoryDTOList}"
						itemLabel="categoryName" itemValue="categoryId" />
				</form:select>
			</div>
		</div>
	</c:if>
	<c:if test="${not empty dataDTO.selectedCategoryId}">
		<div id="subCategoryDivId" style='margin-left: 50px'>
			<br>
			<div>
				<label
					style="margin: 2px 9px 2px 2px; font-size: 12px; position: absolute; right: 0;"></label>
				<label class="userform-box-name">Select SubCategory</label><br>
			</div>

			<div>
				<form:select path="selectedSubCategoryId" id="selectedSubCategoryId"
					onchange="submit()">
					<form:option value="" label="--Select SubCategory--" />
					<form:options items="${dataDTO.subCategoryDTOList}"
						itemLabel="subCategoryName" itemValue="subCategoryId" />
				</form:select>
			</div>
		</div>
	</c:if>
	<c:if test="${not empty dataDTO.selectedSubCategoryId}">
		<div id="subCategoryDataDivId" style='margin-left: 50px'>
			<br>
			<div>
				<label
					style="margin: 2px 9px 2px 2px; font-size: 12px; position: absolute; right: 0;"></label>
				<label class="userform-box-name">${dataDTO.selectedSubCategoryName} Data Table</label><br>
			</div>

			<div>
				<table width="50%" border="1">
					<tr>
						<th>S.No.</th>
						<th>Sub Category Raw Data</th>
						<th>Created Date</th>
						<th>Last Modified Date</th>
					</tr>
					<c:forEach items="${dataDTO.subCategoryDataDTOList}"
						var="subCategoryData" varStatus="status">
						<tr>
							<td align="center">${status.count}</td>
							<td>${subCategoryData.subCategoryRawData}</td>
							<td>${subCategoryData.createdDate}</td>
							<td>${subCategoryData.lastModifiedDate}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</c:if>

</form:form>