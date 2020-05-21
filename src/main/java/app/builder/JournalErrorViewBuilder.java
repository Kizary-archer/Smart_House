package app.builder;

import app.entityes.JournalErrorViewEntity;
import app.entityes.JournalEventViewEntity;

import javax.servlet.http.HttpServletRequest;

public final class JournalErrorViewBuilder {
    JournalErrorViewEntity journalErrorViewEntity = new JournalErrorViewEntity();

    public JournalErrorViewBuilder(HttpServletRequest request) {
        if ((request.getParameter("idError") != null)&&(!request.getParameter("idError").equals("")))
            journalErrorViewEntity.setIdError(Long.valueOf(request.getParameter("idError")));
        if ((request.getParameter("nameError") != null)&&(!request.getParameter("nameError").equals("")))
            journalErrorViewEntity.setNameError(request.getParameter("nameError"));
        if ((request.getParameter("nameFunction") != null)&&(!request.getParameter("nameFunction").equals("")))
            journalErrorViewEntity.setNameFunction(request.getParameter("nameFunction"));
        if ((request.getParameter("userRequest") != null)&&(!request.getParameter("userRequest").equals("")))
            journalErrorViewEntity.setUserRequest(Long.valueOf(request.getParameter("userRequest")));
        if ((request.getParameter("description") != null)&&(!request.getParameter("description").equals("")))
            journalErrorViewEntity.setDescription((request.getParameter("description")));
    }
    public JournalErrorViewEntity build() {
        return journalErrorViewEntity;
    }
}
