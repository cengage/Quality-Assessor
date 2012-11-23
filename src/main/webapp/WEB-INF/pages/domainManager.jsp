<%@include file="/WEB-INF/pages/common-taglibs.jsp"%>
	<div>
	<div style='color: white;
    text-align: center;height:40px;background:white;margin-top:2%;margin-left:2%;
    text-shadow: none;float:left;color:white;width:7%'><div><a style='text-decoration:none'  href="">Product Domains</a></div></div>
	<div class="background container" style='float:left;margin:2%;border-top-left-radius:4px;border-top-right-radius:4px'>
	
	
	<div style="background: white; margin: 20px auto auto;
    width: 90%;">

	<div style="display:inline">
			<input class="btn primary" id="addMoreWorkExpbtn" type="button"
					onclick="location.reload();" value="My Domains">
				
		</div>
		<c:choose>
			<c:when test="${param.type=='product'}">
				<div style="display:inline">
					<input class="btn primary"  type="button"
					onclick="showAddRootDomainView('product')" value="Add Product Domain">
				</div>
			</c:when>
			<c:otherwise>
				<div style="display:inline">
					<input class="btn primary"  type="button"
						onclick="showAddRootDomainView('skill')" value="Add Skill Domain">
				</div>
			</c:otherwise>
		</c:choose>
		<div  style="margin-right:10px;float:right;display:inline">
			<input id="searchDomain" type="text" style="width:180px">
			<input id="searchDomainType" type="hidden" value="${param.type}">
		</div>
		</div>
		<p></p>
		<!-- Add a <div> element where the tree should appear: -->
		<div style="width:90%;margin:auto;" id="domainDivId"></div>
		<div style="display:none;margin-top:25px;margin-left:15px;margin-right:15px" id="existingDomainDiv">
		</div>
	</div>
	<div style='float:left;color:white'>users</div>
	</div>
