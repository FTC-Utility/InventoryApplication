package com.ftc.fia.business.impl;

import com.ftc.fia.business.ITwoFactorAuthValidatePINBusiness;
import com.ftc.fia.domain.User;
import com.ftc.fia.domain.UserToken;

import com.ftc.fia.repository.IUserTokenRepository;
import com.ftc.fia.util.TimeBasedOneTimePasswordUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * Created by FPerez on 1/6/2017.
 */
@Component
public class TwoFactorAuthValidatePINBusinessImpl implements ITwoFactorAuthValidatePINBusiness {

    @Autowired
    IUserTokenRepository iUserTokenRepository;

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
    public Map validatePIN(String token, String pin) {

        Map returnMap = new HashMap();

        UserToken userToken = getUserToken(token);
        if (userToken == null) {
            String errorMessage = "Unable to find UserToken in Database for given Token: " + token;
            returnMap.put("errorMessage", errorMessage);
            return returnMap;
        }

        String base32SecretKey = userToken.getSecretKey();

        String correctPin = null;
        try {
            correctPin = TimeBasedOneTimePasswordUtil.generateCurrentNumber(base32SecretKey);

        } catch (Exception ex) {
            String errorMessage = "Exception occurred: " + ex.getMessage();
            returnMap.put("errorMessage", errorMessage);
            return returnMap;
        }

        if (!correctPin.equals(pin)) {
            String errorMessage = "Invalid PIN Entered!";
            returnMap.put("errorMessage", errorMessage);
            return returnMap;
        }

        User user = getUser(userToken);
        if (user == null) {
            String errorMessage = "No User found in Database for given Token: " + token;
            returnMap.put("errorMessage", errorMessage);
            return returnMap;
        }

        returnMap.put("user", user);

        return returnMap;
    }

    /**
     * Get the UserToken Domain object, which contains the Secrey Key needed assovciated with a user.
     *
     * @param token -- the Token string associated with a User
     * @return the UserToken Domain object that has the given "token" value
     */
    private UserToken getUserToken(String token) {

        // Stub code below for now... Will have to go to the database for this.
        // UserToken userToken = new UserToken();
        // userToken.setSecretKey("NY4A5CPJZ46LXZCP");

        List<UserToken> userTokenList = iUserTokenRepository.findByValue(token);
        if (userTokenList.isEmpty()) {
            return null;
        }

        UserToken userToken = userTokenList.get(0);
        return userToken;
    }

    private User getUser(UserToken userToken) {

        // Stub code below for now... Will have to go to database for this.
        // User user = new User();
        // return user;

        User user = userToken.getUser();
        return user;
    }
}
