package com.edf.ltihelloworld.controller;

import edu.ksu.lti.launch.model.LtiLaunchData;
import edu.ksu.lti.launch.model.LtiSession;
import edu.ksu.lti.launch.oauth.LtiPrincipal;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.edf.ltihelloworld.constants.EventConstants;
import com.edf.ltihelloworld.constants.LtiConstants;
import com.edf.ltihelloworld.constants.TemplateConstants;
import com.edf.ltihelloworld.entity.*;
import com.edf.ltihelloworld.service.EventTrackingService;
import com.edf.ltihelloworld.service.SecurityService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Controller
public class IndexController {



    @Autowired
    private EventTrackingService eventTrackingService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private SessionLocaleResolver localeResolver;

    @Value("${lti-autoevaluation.url:someurl}")
    private String canvasBaseUrl;

    @GetMapping("/")
    public ModelAndView index(@ModelAttribute LtiPrincipal ltiPrincipal, LtiSession ltiSession, Model model) {
    	log.info("aaa");
        LtiLaunchData lld = ltiSession.getLtiLaunchData();
        localeResolver.setDefaultLocale(new Locale(lld.getLaunchPresentationLocale()));
        return new ModelAndView(TemplateConstants.INDEX_TEMPLATE);
    }

    @GetMapping("/index")
    public ModelAndView index(
            @ModelAttribute LtiPrincipal ltiPrincipal,
            LtiSession ltiSession,
            Model model,
            @RequestParam(required=false) Boolean errors,
            HttpSession httpSession,
            @RequestParam("page") Optional<Integer> page
    ) {
    	log.info("bbb");
        try {
            LtiLaunchData lld = ltiSession.getLtiLaunchData();
            log.debug("Debugging ltiLaunch Object:\n"+ReflectionToStringBuilder.toString(lld));
            String canvasLoginId = ltiPrincipal.getUser();
            String canvasUserId = lld.getCustom().get(LtiConstants.CANVAS_USER_ID);
            String courseId = ltiSession.getCanvasCourseId();

            eventTrackingService.postEvent(EventConstants.LTI_LOGIN, canvasUserId, courseId);

            if(lld.getRolesList() == null || lld.getRolesList().isEmpty()) {
                throw new Exception(String.format("The user %s doesn't have any valid role.", canvasLoginId));
            }

            if(securityService.isStudent(lld.getRolesList())) {
                return handleStudentView(lld, ltiSession, model);
            }

            if (securityService.isFaculty(lld.getRolesList())) {
                return handleInstructorView(lld, ltiSession, model, page.orElse(1) - 1);
            }

        } catch(Exception ex) {
            log.error("Error displaying the LTI tool content.", ex);
        }

        return new ModelAndView(TemplateConstants.ERROR_TEMPLATE);
    }

  

    private ModelAndView handleInstructorView(@ModelAttribute LtiLaunchData lld, LtiSession ltiSession,
			Model model, int page) {
        
    	String nombre = lld.getLisPersonContactEmailPrimary();
        log.info("isInstructor");
        model.addAttribute("nombre",nombre);
        model.addAttribute("rol","Profesor");
        
        return new ModelAndView(TemplateConstants.INSTRUCTOR_TEMPLATE);
    }

    private ModelAndView handleStudentView(@ModelAttribute LtiLaunchData lld, LtiSession ltiSession,
			Model model) {
       
    	String nombre = lld.getLisPersonContactEmailPrimary();
    	log.info("isStudent");
    	model.addAttribute("nombre",nombre);
        model.addAttribute("rol","Alumno");
      
        return new ModelAndView(TemplateConstants.STUDENT_TEMPLATE);
    }

}
