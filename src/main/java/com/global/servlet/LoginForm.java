package com.global.servlet;

import com.global.core.bean.User;
import com.global.core.facade.UserFacade;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public final class LoginForm {
    private static final String EMAIL_INPUT  = "email";
    private static final String PASSWORD_INPUT   = "password";

    private String result;
    private Map<String, String> errors = new HashMap<String, String>();

    public String getResults() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public User connectUser(HttpServletRequest request ) {
        /* Get form inputs */
        String email = request.getParameter(EMAIL_INPUT);
        String password = request.getParameter(PASSWORD_INPUT);

        User user = null;
        /* get existing user if exists */
        try {
            user = UserFacade.getUserFacade().findUserByEmail(email);
            /* Email input validation */
            try {
                validationEmail( email , user);
            } catch ( Exception e ) {
                setErrors( EMAIL_INPUT, e.getMessage() );
            }

            /* Password input validation */
            try {
                validationMotDePasse( password , user);
            } catch ( Exception e ) {
                setErrors( PASSWORD_INPUT, e.getMessage() );
            }
        } catch (Exception e) {
            setErrors(EMAIL_INPUT, e.getMessage());
        }


        /* Init the global result of validation */
        if ( errors.isEmpty() ) {
            try {
                user = UserFacade.getUserFacade().findUserByEmail(email);
            } catch (Exception e) {
                e.printStackTrace();
            }
            result = "Connexion success.";
        } else {
            result = "Connexion issue.";
        }

        return user;
    }

    private void validationEmail( String email, User existingUser) throws Exception {
        if ( email == null || email.isEmpty() || !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) || existingUser == null  ) {
            throw new Exception( "Please enter a valid e-mail adress." );
        }
    }

    private void validationMotDePasse( String password, User existingUser) throws Exception {
        if ( password != null && !password.isEmpty() ) {
            if ( password.length() < 3 ) {
                throw new Exception( "The password must be higher than 3 characters." );
            }else if(existingUser != null && !existingUser.getPassword().equals(password)){
                throw new Exception( "It's not your password." );
            }
        } else {
            throw new Exception( "Please enter your password." );
        }
    }

    private void setErrors( String input, String message ) {
        errors.put( input, message );
    }
}
