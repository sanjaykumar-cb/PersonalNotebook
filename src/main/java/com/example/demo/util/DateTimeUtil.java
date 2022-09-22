package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
    public static  String convertDateToString(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("dd//mm//yyyy");
        return sdf.format(date);
    }
}
