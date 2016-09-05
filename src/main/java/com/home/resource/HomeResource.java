package com.home.resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.home.domain.person;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/getPerson")
@Api(value = "Person")
public class HomeResource {
	@ApiOperation(value = "Find Person")
	@RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public person home() {
		com.home.domain.person person = new person();
		person.setName("Marinus");
		person.setSurname("Pretorius");
        return person;
    }

}
