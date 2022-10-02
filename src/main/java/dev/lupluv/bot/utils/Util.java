package dev.lupluv.bot.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {

    public static String getDateFormatted(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        Date date = Calendar.getInstance().getTime();
        return sdf.format(date);
    }

}
