package com.wo.edu.web.util;

import java.util.Date;

public class ActualStubCurrentDateGenerator implements CurrentDateGenerator {
    Date date = null;

    public void setCurrentDate(Date date) {
        this.date = date;
    }

    @Override
    public Date getCurrentDate() {
        return date;
    }
}
