<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div id='cssmenu'>
	<ul>

		<li><a href='/qualityassessor/home'><span>Home</span></a></li>
		<li class="has-sub"><a href='domains?domainType=product'><span>Domain
					Management</span></a>

			<ul>
				<li class="level-2"><a href="domains?domainType=product"><span>Product
							Domains</span></a></li>
				<li class="level-2"><a href="domains?domainType=skill"><span>Skill
							Domains</span></a></li>
				<li class="level-2"><a href="domains?domainType=practice"><span>Practice
							Domains</span></a></li>
				<li class="level-2"><a href="domains?domainType=environment"><span>Environment
							Domains</span></a></li>		
			</ul></li>

		<%-- 			<c:if test="${sessionScope.group=='AdminGroup'}"> --%>
		<li class="has-sub"><a href='domains?domainType=product'><span>Product
					Management</span></a>

			<ul>
				<li><a href="domains?domainType=product"><span>Product
							Domains</span></a></li>
				<li><a href="myProducts"><span>My Products</span></a></li>
				<li><a href="domains?domainType=environment"><span>Environment
							Domains</span></a></li>
				<li><a href="#"><span>Product Reviews</span></a></li>
				<li><a href="#"><span>Environment Reviews</span></a></li>
			</ul></li>
		<li class="has-sub"><a href='domains?domainType=skill'><span>Colleague/Skill
					Management</span></a>

			<ul>
				<li><a href="domains?domainType=skill">Skill Domains</a></li>
				<li><a href="domains?domainType=practice">Practice Domains</a></li>
				<li><a href="#">Colleague Reviews</a></li>
				<li><a href="#">My Colleagues</a></li>
			</ul></li>
		<%-- 			</c:if> --%>



		<li class="has-sub"><a href='/qualityassessor/assessmentRequests'><span>Reviews</span></a>

			<ul>
				<li><a href="#">Review Requests</a></li>
				<li><a href="#">Product Reviews</a></li>
				<li><a href="#">Colleague Reviews</a></li>
				<li><a href="#">Environment Reviews</a></li>
				<li><a href="#">Practice Reviews</a></li>
			</ul></li>


	</ul>
	<div style="padding: 3px 10px; position: absolute; right: 220px;">
		<img style="width: 12px; height: 12px" class="newDomain"
			src="images/plus.png"> <label style="color: white;">Create
			Review</label>
	</div>
	<div style="position: absolute; color: white; right: 10px;" id="search">
		<input size="30" type="text">
	</div>
</div>
