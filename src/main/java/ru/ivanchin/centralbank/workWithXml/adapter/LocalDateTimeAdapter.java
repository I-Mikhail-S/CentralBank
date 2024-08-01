package ru.ivanchin.centralbank.workWithXml.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    private static final ThreadLocal<DateTimeFormatter> dateFormat =
            ThreadLocal.withInitial(() -> DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));

    @Override
    public LocalDateTime unmarshal(String s) throws Exception {
        return LocalDateTime.from(dateFormat.get().parse(s));
    }

    @Override
    public String marshal(LocalDateTime localDateTime) throws Exception {
        return dateFormat.get().format(localDateTime);
    }
}
