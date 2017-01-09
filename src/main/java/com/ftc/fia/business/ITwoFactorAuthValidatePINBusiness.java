package com.ftc.fia.business;

import java.util.Map;

/**
 * Created by FPerez on 1/6/2017.
 */
public interface ITwoFactorAuthValidatePINBusiness {

    /**
     * Validates that as part of a Two-Factor Authentication.. that given a "token" string associated with a User, the
     * the "pin" is valid.
     *
     * @param token - the token associated with a User
     * @param pin - the Number PIN that a User enters
     * @return Flexible output: If no "errorMessage" key is in returned Map, then method executed successfully.
     *         1) "errorMessage" key: Contents of an Error Message if something irregular or wrong occurs.
     *         2) "user" key: The User Domain object associated with the "token"
     */
    public Map validatePIN(String token, String pin);
}
