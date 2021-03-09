package br.com.assesment.peoplemanager.gateway.http;

import br.com.assesment.peoplemanager.service.interfaces.PersonService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="api/v1/person")
@ResponseBody
@CrossOrigin("*")
@Api(value="Person")
@AllArgsConstructor
public class PersonController {

    @Autowired
    private PersonService personService;


}