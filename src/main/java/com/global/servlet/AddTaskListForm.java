package com.global.servlet;

import com.global.core.bean.TaskList;
import com.global.core.bean.User;
import com.global.core.facade.TaskListFacade;
import com.global.util.RegexPattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class AddTaskListForm {
    private static final String LABEL_INPUT = "label";

    private String result;
    private Map<String, String> errors = new HashMap<String, String>();

    public String getResults() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void createTaskList(HttpServletRequest request) {
        /* Get form inputs */
        String label = request.getParameter(LABEL_INPUT);

        try {
            validationLabel(label);
        } catch (Exception e) {
            setErrors(LABEL_INPUT, e.getMessage());
        }

        if (errors.isEmpty()) {
            try {
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute(Login.ATT_USER_SESSION);
                TaskListFacade.getTaskListFacade().addTaskList(label, user.getId());
            } catch (Exception e) {
                setErrors(LABEL_INPUT, e.getMessage());
            }
        }

        /* Init the global result of validation */
        if (errors.isEmpty()) {
            result = "Creation success.";
        } else {
            result = "Creation issue.";
        }
    }

    private void validationLabel(String label) throws Exception {
        if (label == null || label.trim().isEmpty()) {
            throw new Exception("Please enter a valid label.");
        }
    }

    private void setErrors(String input, String message) {
        errors.put(input, message);
    }
}
