package com.wo.edu.web.util;

import java.util.Date;

public class ActualCurrentDateGenerator implements CurrentDateGenerator {
    @Override
    public Date getCurrentDate() {
        return new Date();
    }
}
