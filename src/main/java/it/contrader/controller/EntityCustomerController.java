package it.contrader.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import it.contrader.dto.EntityCustomerDTO;

@RestController
@RequestMapping("/entitycustomer")
@CrossOrigin(origins = "http://localhost:4200")
public class EntityCustomerController extends AbstractController<EntityCustomerDTO>{


}
