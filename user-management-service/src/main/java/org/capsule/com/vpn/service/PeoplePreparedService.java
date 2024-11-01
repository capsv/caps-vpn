package org.capsule.com.vpn.service;

import org.capsule.com.vpn.controller.model.response.BasedUserInformationDto;

public interface PeoplePreparedService {

    BasedUserInformationDto getBasedInformation(Long id);
}
