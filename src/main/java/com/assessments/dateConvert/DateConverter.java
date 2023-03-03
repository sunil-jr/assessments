package com.assessments.dateConvert;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateConverter {

    public static LocalDateTime toUtc(LocalDateTime localDateTime) {
        return  localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();

    }

    public static LocalDateTime toLocalDateTime(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();

    }

    public static void main(String[] args) {
        System.out.println("UTC: " +DateConverter.toUtc(LocalDateTime.now()));
        System.out.println("Local Date: " + DateConverter.toLocalDateTime(DateConverter.toUtc(LocalDateTime.now())));
    }
}
