package app.builder;

import app.entityes.JournalEventViewEntity;

import javax.servlet.http.HttpServletRequest;

public final class JournalEventViewBuilder {
    JournalEventViewEntity journalEventViewEntity = new JournalEventViewEntity();

    public JournalEventViewBuilder(HttpServletRequest request) {
        if ((request.getParameter("idEvent") != null)&&(!request.getParameter("idEvent").equals("")))
            journalEventViewEntity.setIdEvent(Long.valueOf(request.getParameter("idEvent")));
        if ((request.getParameter("nameEvent") != null)&&(!request.getParameter("nameEvent").equals("")))
                journalEventViewEntity.setNameEvent(request.getParameter("nameEvent"));
        if ((request.getParameter("nameFunction") != null)&&(!request.getParameter("nameFunction").equals("")))
            journalEventViewEntity.setNameFunction(request.getParameter("nameFunction"));
        if ((request.getParameter("userRequest") != null)&&(!request.getParameter("userRequest").equals("")))
            journalEventViewEntity.setUserRequest(Long.valueOf(request.getParameter("userRequest")));
        if ((request.getParameter("data") != null)&&(!request.getParameter("data").equals("")))
            journalEventViewEntity.setData(Long.valueOf(request.getParameter("data")));
    }
    public JournalEventViewEntity build() {
        return journalEventViewEntity;
    }
}
