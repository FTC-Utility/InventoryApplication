package com.ftc.fia.business.impl;

import com.ftc.fia.business.ISetUserPasswordBusiness;
import com.ftc.fia.business.ITwoFactorAuthValidatePINBusiness;

import com.ftc.fia.domain.User;

import com.ftc.fia.dto.NewPasswordEntryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FPerez on 1/6/2017.
 */
@Component
public class SetUserPasswordBusinessImpl implements ISetUserPasswordBusiness {

    @Autowired
    ITwoFactorAuthValidatePINBusiness iTwoFactorAuthValidatePINBusiness;

    /**
     * Sets the Password for a user given the "newPasswordEntryDto" input.
     *
     * @param newPasswordEntryDto -- Information entered by a user to set his/her password
     * @return @return Flexible output: If no "errorMessage" key is in returned Map, then method executed successfully.
     *         * "errorMessage" key: Contents of an Error Message if something irregular or wrong occurs.
     */
    public Map setPassword(NewPasswordEntryDto newPasswordEntryDto) {

        String token = newPasswordEntryDto.getToken();
        String pin = newPasswordEntryDto.getPin();
        Map returnMap = iTwoFactorAuthValidatePINBusiness.validatePIN(token, pin);
        if (returnMap.containsKey("errorMessage")) {
            return returnMap;
        }

        User user = (User) returnMap.get("user");
        String password = newPasswordEntryDto.getPwd();
        returnMap = setPasswordInDatabase(user, password);

        return returnMap;
    }

    /**
     * Sets the Password for a user inside the Database.
     *
     * @param user -- Domain User object
     * @param password -- Password to set
     * @return Flexible output: If no "errorMessage" key is in returned Map, then method executed successfully.
     *         * "errorMessage" key: Contents of an Error Message if something irregular or wrong occurs.
     */
    private Map setPasswordInDatabase(User user, String password) {

        Map returnMap = new HashMap();

        // Will put nothing for now. Will add later password update to database.

        return returnMap;
    }
}
