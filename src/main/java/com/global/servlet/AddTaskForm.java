package com.global.servlet;

import com.global.core.facade.TaskFacade;
import com.global.util.RegexPattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class AddTaskForm {
    private static final String LABEL_INPUT = "label";

    private String result;
    private Map<String, String> errors = new HashMap<String, String>();

    public String getResults() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void createTask(HttpServletRequest request) {
        /* Get form inputs */
        HttpSession session = request.getSession();
        String label = request.getParameter(LABEL_INPUT);
        /* To convert in UTF-8 */
        /* /!\ to change! it's not the right way to do it */
        byte[] bytes = label.getBytes(StandardCharsets.ISO_8859_1);
        label = new String(bytes, StandardCharsets.UTF_8);

        try {
            validationLabel(label);
        } catch (Exception e) {
            setErrors(LABEL_INPUT, e.getMessage());
        }
        if (errors.isEmpty()) {
            try {
                TaskFacade.getTaskFacade().addTask(label, (String) session.getAttribute(Index.CURRENT_TASKLIST_ID));
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
