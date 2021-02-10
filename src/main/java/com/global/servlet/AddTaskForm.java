package com.global.servlet;

import com.global.core.bean.Task;
import com.global.core.bean.User;
import com.global.core.facade.TaskFacade;
import com.global.core.facade.TaskListFacade;
import com.global.util.RegexPattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class AddTaskForm {
    private static final String LABEL_INPUT  = "label";

    private String result;
    private Map<String, String> errors = new HashMap<String, String>();

    public String getResults() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public String createTask(HttpServletRequest request ) {
        /* Get form inputs */
        String label = request.getParameter(LABEL_INPUT);

        try {
            validationLabel( label );
        } catch ( Exception e ) {
            setErrors( LABEL_INPUT, e.getMessage() );
        }
        String tasklist_id = request.getParameter(Index.CURRENT_TASKLIST_ID);
        if ( errors.isEmpty() ) {
            try {
                TaskFacade.getTaskFacade().addTask(label, tasklist_id);
            } catch (Exception e) {
                setErrors(LABEL_INPUT, e.getMessage());
            }
        }

        /* Init the global result of validation */
        if ( errors.isEmpty() ) {
            result = "Creation success.";
        } else {
            result = "Creation issue.";
        }
        return tasklist_id;
    }

    private void validationLabel( String label) throws Exception {
        if ( label == null || label.isEmpty() || !RegexPattern.labelPattern.matcher(label).find()) {
            throw new Exception( "Please enter a valid label." );
        }
    }

    private void setErrors( String input, String message ) {
        errors.put( input, message );
    }
}
