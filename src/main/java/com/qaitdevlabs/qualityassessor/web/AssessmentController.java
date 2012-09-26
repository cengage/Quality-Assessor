package com.qaitdevlabs.qualityassessor.web;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.qaitdevlabs.qualityassessor.assessment.service.AssessmentService;
import com.qaitdevlabs.qualityassessor.assessmentinvitation.service.AssessmentInvitationService;
import com.qaitdevlabs.qualityassessor.domain.service.DomainService;
import com.qaitdevlabs.qualityassessor.dto.DomainDTO;
import com.qaitdevlabs.qualityassessor.model.Assessment;
import com.qaitdevlabs.qualityassessor.model.AssessmentInvitation;
import com.qaitdevlabs.qualityassessor.model.Domain;
import com.qaitdevlabs.qualityassessor.model.User;
import com.qaitdevlabs.qualityassessor.service.UserService;

@Controller
@RequestMapping("/assessments")
public class AssessmentController {

	private AssessmentService assessmentService;

	@Autowired
	public void setAssessmentService(AssessmentService assessmentService) {
		this.assessmentService = assessmentService;
	}

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private DomainService domainService;

	@Autowired
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	
	private AssessmentInvitationService assessmentInvitationService;

	@Autowired
	public void setAssessmentInvitationService(
			AssessmentInvitationService assessmentInvitationService) {
		this.assessmentInvitationService = assessmentInvitationService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getListOfRootDomains(ModelMap map) {
		List<DomainDTO> listOfRootDomains = domainService
				.getListOfRootDomains();
		map.addAttribute("listOfRootDomains", listOfRootDomains);
		return "assessments";
	}

	

	@RequestMapping(value = "/{key}", method = RequestMethod.GET)
	public String showDomainPage(ModelMap map, @PathVariable String key) {
		System.out.println("key"+key);
		return "assessmentPage";
	}

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody
	long saveRating(
			@RequestParam String key,
			@RequestParam String id,
			@RequestParam(value = "requestedUserId", required = false) String requestedUserId,
			@RequestParam(value = "invitationId", required = false) String invitationId,
			@RequestParam String score, ModelMap map, HttpServletRequest request) {
		System.out.println("id" + id);

		Long userId = (Long) request.getSession().getAttribute("USER_ID");
		User assessor = userService.getUser(userId);
		AssessmentInvitation invitation = null;
		User user = null;
		if (!requestedUserId.equals("null")) {
			user = userService.getUser(Long.valueOf(requestedUserId));
			invitation = assessmentInvitationService.getAssessmentInvitation(invitationId);
		} else {
			user = assessor;
		}
		
		Domain domain = domainService.getDomain(key);
		Long assessmentId = Long.valueOf(id);
		if (assessmentId == 0) {
			assessmentId = null;
		}
		Date assessmentDate = new Date();
		Assessment assessment = new Assessment();
		assessment.setAssessmentId(assessmentId);
		assessment.setUser(user);
		assessment.setAssessor(assessor);
		assessment.setDomain(domain);
		assessment.setScore(Integer.valueOf(score));
		assessment.setAssessmentDate(assessmentDate);
		assessment.setInvitation(invitation);
		assessment = assessmentService.saveAssessment(assessment);
		assessmentId = assessment.getAssessmentId();
		return assessmentId;
	}

}
