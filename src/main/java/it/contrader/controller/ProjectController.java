package it.contrader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import it.contrader.dto.ProjectDTO;

@Controller
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController extends AbstractController<ProjectDTO>{


}
