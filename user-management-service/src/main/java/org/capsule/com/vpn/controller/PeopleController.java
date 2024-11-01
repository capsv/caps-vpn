package org.capsule.com.vpn.controller;

import lombok.RequiredArgsConstructor;
import org.capsule.com.vpn.controller.model.response.BasedUserInformationDto;
import org.capsule.com.vpn.service.PeoplePreparedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class PeopleController {

    private final PeoplePreparedService peoplePreparedService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BasedUserInformationDto> getIntegration(@PathVariable long id) {

        return new ResponseEntity<>(peoplePreparedService.getBasedInformation(id), HttpStatus.OK);
    }
}