package com.qaitdevlabs.qualityassessor.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.qaitdevlabs.qualityassessor.assessmentinvitation.service.AssessmentInvitationService;
import com.qaitdevlabs.qualityassessor.model.Assessment;
import com.qaitdevlabs.qualityassessor.model.User;
import com.qaitdevlabs.qualityassessor.service.UserService;

@Controller
public class AssessOthersController {

	private AssessmentInvitationService assessmentInvitationService;

	@Autowired
	public void setAssessmentInvitationService(
			AssessmentInvitationService assessmentInvitationService) {
		this.assessmentInvitationService = assessmentInvitationService;
	}
	
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/assessmentrequests", method = RequestMethod.GET)
	public String getAssessmentRequests(HttpServletRequest request) {
		Long userId = (Long) request.getSession().getAttribute("USER_ID");
		User assessor = userService.getUser(userId);
		List<Assessment> assessmentList = assessmentInvitationService
				.getAssessmentInvitations(assessor);
		request.setAttribute("assessmentRequestList", assessmentList);
		return "assessmentRequests";

	}
}
