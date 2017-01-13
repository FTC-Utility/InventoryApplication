package com.ftc.fia.service.impl;

import com.ftc.fia.business.ISetUserPasswordBusiness;
import com.ftc.fia.dto.NewPasswordEntryDto;
import com.ftc.fia.service.ISetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by FPerez on 1/6/2017.
 */
@Service
@Transactional
public class SetPasswordServiceImpl implements ISetPasswordService {

    @Autowired
    ISetUserPasswordBusiness iSetUserPasswordBusiness;

    /**
     * Sets the Password for a User.
     *
     * @param dataDto - the data associated with setting a Password for a user
     * @return Flexible output: If no "errorMessage" key is in returned Map, then method executed successfully.
     *         * "errorMessage" key: Contents of an Error Message if something irregular or wrong occurs.
     */
    @Override
    public Map setPassword(NewPasswordEntryDto dataDto) {

        Map returnedMap = iSetUserPasswordBusiness.setPassword(dataDto);
        return returnedMap;
    }
}
