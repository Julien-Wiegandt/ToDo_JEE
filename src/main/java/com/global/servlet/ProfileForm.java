package com.global.servlet;

import com.global.core.bean.User;
import com.global.core.facade.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class ProfileForm {
    private static final String EMAIL_INPUT = "email";
    private static final String PASSWORD1_INPUT = "password1";
    private static final String PASSWORD2_INPUT = "password2";

    private String result;
    private Map<String, String> errors = new HashMap<String, String>();

    public String getResults() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void updateUser(HttpServletRequest request) {
        /* Get form inputs */
        String email = request.getParameter(EMAIL_INPUT);
        String password1 = request.getParameter(PASSWORD1_INPUT);
        String password2 = request.getParameter(PASSWORD2_INPUT);

        /* Email input validation */
        try {
            validationEmail(email);
        } catch (Exception e) {
            setErrors(EMAIL_INPUT, e.getMessage());
        }

        /* Password input validation */
        try {
            validationMotDePasse(password1, password2);
        } catch (Exception e) {
            setErrors(PASSWORD1_INPUT, e.getMessage());
        }

        if (errors.isEmpty()) {
            try {
                HttpSession session = request.getSession();
                User user = (User) (session.getAttribute(Login.ATT_USER_SESSION));
                UserFacade.getUserFacade().updateUser(user.getId(), email, password1);
            } catch (Exception e) {
                setErrors(EMAIL_INPUT, e.getMessage());
            }
        }

        /* Init the global result of validation */
        if (errors.isEmpty()) {
            result = "Creation success.";
        } else {
            result = "Creation issue.";
        }
    }

    private void validationEmail(String email) throws Exception {
        if (email == null || email.isEmpty() || !email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
            throw new Exception("Please enter a valid e-mail adress.");
        }
    }

    private void validationMotDePasse(String password1, String password2) throws Exception {
        if (password1 != null && !password1.isEmpty() && password1.equals(password2)) {
            if (password1.length() < 3) {
                throw new Exception("The password must be higher than 3 characters.");
            }
        } else if (!password1.equals(password2)) {
            throw new Exception("Please enter same passwords.");
        } else {
            throw new Exception("Please enter a password.");
        }
    }

    private void setErrors(String input, String message) {
        errors.put(input, message);
    }
}
