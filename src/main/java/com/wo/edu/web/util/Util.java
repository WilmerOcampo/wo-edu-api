package com.wo.edu.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {
    static public Date stringToDate(String fechaStr) {
        Date fecha = null;
        try {
            fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
            return fecha;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fecha;
    }

    static public Date sumaDias(Date fecha, int dias) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.DATE, dias);
        return cal.getTime();
    }

    static public long diferenciaDias(Date fecha1, Date fecha2) {
        long dif = Math.abs(fecha1.getTime() - fecha2.getTime());
        long difDias = dif / (24 * 60 * 60 * 1000);
        return difDias;
    }
}
