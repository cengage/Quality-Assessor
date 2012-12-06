<%@include file="/WEB-INF/pages/common-taglibs.jsp"%>
<div style = "margin-left:80px;margin-top:50px">

<table id="excelId" class="imagetable"
		style="margin-top: 15px; border-color: #999999; border-style: solid;">
	<tr><td>${templateDTO.title}</td><td colspan = "3"></td></tr>
	<c:forEach var="dto" items="${templateDTO.children}">
				<tr><td style="border-top: none; border-bottom: none;"></td><td>${dto.title}</td><td></td>
				<td id="${dto.key}" assessmentid="${dto.assessmentId}" score="${dto.score}">
					<c:forEach begin="1" end="${dto.score}">
						<img src="images/yellowstar.png" class="toggle">
					</c:forEach> 
					<c:forEach begin="1" end="${5-dto.score}">
						<img src="images/whitestar.gif" class="toggle">
					</c:forEach>
				</tr>
				<c:forEach var="dto1" items="${dto.children}">
					<tr><td style="border-top: none; border-bottom: none;"></td><td></td><td>${dto1.title}</td>
					<td id="${dto1.key}" assessmentid="${dto1.assessmentId}" score="${dto1.score}">
					<c:forEach begin="1" end="${dto1.score}">
						<img src="images/yellowstar.png" class="toggle">
					</c:forEach> 
					<c:forEach begin="1" end="${5-dto1.score}">
						<img src="images/whitestar.gif" class="toggle">
					</c:forEach>
				</tr>
				</c:forEach>
		
	</c:forEach>
	</table>
</div>


<!-- <table id="excelId" class="imagetable" -->
<!-- 	style="margin-top: 15px; border-color: #999999; border-style: solid;"> -->
<!-- 	<tbody> -->
<!-- 		<tr> -->
<!-- 			<td style="border-bottom: none">Software testing</td> -->
<!-- 			<td></td> -->
<!-- 			<td></td> -->
<!-- 			<td></td> -->
<!-- 		</tr> -->
<!-- 		<tr childcount="0"> -->
<!-- 			<td style="border-top: none; border-bottom: none;"></td> -->
<!-- 			<td>Heel (professional wrestling)</td> -->
<!-- 			<td></td> -->
<!-- 			<td id="79" assessmentid="26" score="3"><img -->
<!-- 				src="images/yellowstar.png" class="toggle"><img -->
<!-- 				src="images/yellowstar.png" class="toggle"><img -->
<!-- 				src="images/yellowstar.png" class="toggle"><img -->
<!-- 				src="images/whitestar.png" class="toggle"><img -->
<!-- 				src="images/whitestar.png" class="toggle"> -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 		<tr childcount="0"> -->
<!-- 			<td style="border-top: none; border-bottom: none;"></td> -->
<!-- 			<td>IUPAC</td> -->
<!-- 			<td></td> -->
<!-- 			<td id="62" assessmentid="27"><img -->
<!-- 				src="images/yellowstar.png" class="toggle"><img -->
<!-- 				src="images/yellowstar.png" class="toggle"><img -->
<!-- 				src="images/whitestar.png" class="toggle"><img -->
<!-- 				src="images/whitestar.png" class="toggle"><img -->
<!-- 				src="images/whitestar.png" class="toggle"> -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 		<tr childcount="0"> -->
<!-- 			<td style="border-top: none; border-bottom: none;"></td> -->
<!-- 			<td>Stress testing</td> -->
<!-- 			<td></td> -->
<!-- 			<td id="13" assessmentid="28"><img -->
<!-- 				src="images/yellowstar.png" class="toggle"><img -->
<!-- 				src="images/yellowstar.png" class="toggle"><img -->
<!-- 				src="images/yellowstar.png" class="toggle"><img -->
<!-- 				src="images/yellowstar.png" class="toggle"><img -->
<!-- 				src="images/whitestar.png" class="toggle"> -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 	</tbody> -->
<!-- </table> -->