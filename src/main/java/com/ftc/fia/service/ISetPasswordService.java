package com.ftc.fia.service;

import com.ftc.fia.dto.NewPasswordEntryDto;

import java.util.Map;

/**
 * Created by FPerez on 1/6/2017.
 */
public interface ISetPasswordService {

    /**
     * Sets the Password for a User.
     *
     * @param dataDto - the data associated with setting a Password for a user
     * @return Flexible output: If no "errorMessage" key is in returned Map, then method executed successfully.
     *         * "errorMessage" key: Contents of an Error Message if something irregular or wrong occurs.
     */
    public Map setPassword(NewPasswordEntryDto dataDto);
}
