package com.ftc.fia.business;

import com.ftc.fia.dto.NewPasswordEntryDto;

import java.util.Map;

/**
 * Created by FPerez on 1/6/2017.
 */
public interface ISetUserPasswordBusiness {

    /**
     * Sets the Password for a user given the "newPasswordEntryDto" input.
     *
     * @param newPasswordEntryDto -- Information entered by a user to set his/her password
     * @return @return Flexible output: If no "errorMessage" key is in returned Map, then method executed successfully.
     *         * "errorMessage" key: Contents of an Error Message if something irregular or wrong occurs.
     */
    public Map setPassword(NewPasswordEntryDto newPasswordEntryDto);
}
