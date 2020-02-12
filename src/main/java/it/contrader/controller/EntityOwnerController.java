package it.contrader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import it.contrader.dto.EntityOwnerDTO;

@Controller
@RequestMapping("/entity")
@CrossOrigin(origins = "http://localhost:4200")
public class EntityOwnerController extends AbstractController<EntityOwnerDTO>{


}
