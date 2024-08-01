package ru.ivanchin.centralbank.workWithXml.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    private static final ThreadLocal<DateTimeFormatter> dateFormat =
            ThreadLocal.withInitial(() -> DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    @Override
    public LocalDate unmarshal(String s) throws Exception {
        return LocalDate.from(dateFormat.get().parse(s));
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return dateFormat.get().format(localDate);
    }
}
