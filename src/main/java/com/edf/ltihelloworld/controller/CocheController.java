package com.edf.ltihelloworld.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.edf.ltihelloworld.constants.EventConstants;
import com.edf.ltihelloworld.constants.LtiConstants;
import com.edf.ltihelloworld.constants.TemplateConstants;
import com.edf.ltihelloworld.entity.Coche;
import com.edf.ltihelloworld.service.EventTrackingService;
import com.edf.ltihelloworld.service.ICocheService;
import com.edf.ltihelloworld.service.SecurityService;

import edu.ksu.lti.launch.model.LtiLaunchData;
import edu.ksu.lti.launch.model.LtiSession;
import edu.ksu.lti.launch.oauth.LtiPrincipal;

@Controller

public class CocheController {

	@Autowired
	private EventTrackingService eventTrackingService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private SessionLocaleResolver localeResolver;

	@Value("${lti-autoevaluation.url:someurl}")
	private String canvasBaseUrl;

	@Autowired
	private ICocheService cocheService;

	@GetMapping("/")
	public ModelAndView listarCoches(@ModelAttribute LtiPrincipal ltiPrincipal, LtiSession ltiSession, Model model,
			@RequestParam(required = false) Boolean errors, HttpSession httpSession,
			@RequestParam("page") Optional<Integer> page) {

		try {
			LtiLaunchData lld = ltiSession.getLtiLaunchData();

			String canvasLoginId = ltiPrincipal.getUser();
			String canvasUserId = lld.getCustom().get(LtiConstants.CANVAS_USER_ID);
			String courseId = ltiSession.getCanvasCourseId();

			eventTrackingService.postEvent(EventConstants.LTI_LOGIN, canvasUserId, courseId);

			if (lld.getRolesList() == null || lld.getRolesList().isEmpty()) {
				throw new Exception(String.format("The user %s doesn't have any valid role.", canvasLoginId));
			}
			if (securityService.isStudent(lld.getRolesList())) {
				return handleStudentView(lld, ltiSession, model);
			}

			if (securityService.isFaculty(lld.getRolesList())) {
				return handleInstructorView(lld, ltiSession, model, page.orElse(1) - 1);
			}

		} catch (Exception ex) {

		}

		return new ModelAndView(TemplateConstants.ERROR_TEMPLATE);
	}

	private ModelAndView handleInstructorView(@ModelAttribute LtiLaunchData lld, LtiSession ltiSession, Model model,
			int page) {

		String nombre = lld.getLisPersonNameFull();
		String rol = lld.getRoles();
		List<Coche> listadoCoches = cocheService.listarTodos();

		model.addAttribute("titulo", "Coches Registrados");
		model.addAttribute("coches", listadoCoches);

		model.addAttribute("nombre", nombre);
		model.addAttribute("rol", rol);

		return new ModelAndView(TemplateConstants.COCHE_TEMPLATE);
	}

	private ModelAndView handleStudentView(@ModelAttribute LtiLaunchData lld, LtiSession ltiSession, Model model) {

		String nombre = lld.getLisPersonNameFull();

		List<Coche> listadoCoches = cocheService.listarTodos();

		model.addAttribute("titulo", "Coches Registrados");
		model.addAttribute("coches", listadoCoches);
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("rol", "Alumno");

		return new ModelAndView(TemplateConstants.COCHE_TEMPLATE);
	}

	@GetMapping("/crear")
	public String crear(Model model) {

		Coche coche = new Coche();
		model.addAttribute("titulo", "Formulario: Nuevo Coche");
		model.addAttribute("coche", coche);

		return "views/cocheCrear";
	}

	@PostMapping("/guardar") // Recibe info de la vista y redirecciona
	public String guardar(@Valid @ModelAttribute Coche miCoche, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Coche");
			model.addAttribute("coche", miCoche);
			System.out.println("Errores en el formulario");
			return "views/cocheCrear";
		}

		cocheService.guardar(miCoche);
		System.out.println("Coche añadido!");
		return "redirect:/";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long idCoche, Model model) {

		Coche coche = null;

		if (idCoche > 0) {
			coche = cocheService.buscarPorId(idCoche);

			if (coche == null) {
				System.out.println("Error el id no existe");
				return "redirect:/views/";
			}
		} else {
			System.out.println("Error con el id");
			return "redirect:/views/";
		}

		model.addAttribute("titulo", "Formulario: Editar Coche");
		model.addAttribute("coche", coche);

		return "views/cocheCrear";
	}

	@PostMapping("/borrar")
	public String borrar(@RequestParam(value = "id", required = false) Long[] miLista) {

		if (miLista != null) {

			for (Long miId : miLista) {
				cocheService.eliminar(miId);
			}
		}

		return "redirect:/";
	}

}
