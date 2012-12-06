<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div style="margin: 30px">
	<form:form method="post" action="templateSelectionView">
		<div style="margin: 10px">
			<div style="display: inline-block; width: 160px">Product</div>
			<div style="display: inline">
				<form:input  readonly="true" path="productName" value="${requestScope.productName}" />
				<form:hidden path="productId" />
			</div>
		</div>
		<div style="margin: 10px">
			<div style="display: inline-block; width: 160px">Choose
				Template</div>


			<div style="display: inline">
				<input type="radio" name="chooseTemplate" value="existing"  checked="checked">
				<label>Existing</label>
			</div>

			<div style="display: inline">
				<input type="radio" name="chooseTemplate" value="new"> <label>New</label>
			</div>
		</div>
		<div id = "existTempId"style="margin: 10px">
			<div style="display: inline-block; width: 160px">
				<label>Type Template Name</label>
			</div>
			<div id="selectTemplateSecId"
				style="display: inline; font-size: 0.9em;" class="ui-widget">
				<form:input path="domainName" style="width:200px" />
				<form:hidden path="domainId" />

			</div>

		</div>

		<div class = "newTemp" style="margin: 10px;display:none">
			<div style="display: inline-block; width: 160px"
				id="showTemplateTypes">
				<label>Select type of template </label>
			</div>
			<div style="display: inline">
				<select>
					<option value="1">Product Template</option>
					<option value="2">Environment Template</option>
					<option value="3">Skill Template</option>
					<option value="4">Practice Template</option>
				</select>
			</div>
		</div>
		
		<div style="margin:10px">
<!-- 		<div  class = "newTemp"  style="display:inline;">Create New Template -->
<!-- 		</div> -->
		<div class = "newTemp" style="display:inline">
		
		<table><tr pid="0" id="new" type="product" class="currentSelectedRow"><td class="iconWidth"><a href="http://en.wikipedia.org/wiki/" target="_blank" class="wikiLink" style="display:none"><img src="images/wiki.png" class="wikiLink"></a></td><td class="iconWidth"><img src="images/new.png" class="newDomain" style="display:none"></td><td class="iconWidth"><img src="images/save.png" class="saveDomain"></td><td class="iconWidth"><img src="images/cross.png" class="deleteDomain"></td><td class="titleClass"><span class="spanTitle rootTitle expandDomain"></span><input type="text" size="30" class="autoCompleteWiki"></td><td></td><td></td><td></td></tr>
		</table>
		</div>
		
		</div>
<div>
<div style = "display:inline"><input type = "submit" name ="selfReview" value = "Self Review"></div>
<div style = "display:inline"><input type = "submit" name ="sendInvitation" value = "Send Invitation"></div>
<div style = "display:inline"><input type = "submit" name ="save&ReviewLater" value = "Save & Review Later"></div>
</div>
	</form:form>
</div>