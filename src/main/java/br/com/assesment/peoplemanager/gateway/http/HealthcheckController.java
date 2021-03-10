package br.com.assesment.peoplemanager.gateway.http;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api/v1/health")
@ResponseBody
@CrossOrigin(origins = "*")
@Api(value = "health")
public class HealthcheckController {

    @ApiOperation(value = "Return github source address")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity get() {
        return ResponseEntity.ok("Go to -> " + "github.com/kbsantiago/people-manager");
    }

}
