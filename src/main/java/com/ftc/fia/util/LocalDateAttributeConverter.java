package com.ftc.fia.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.sql.Date;

/**
 * Created by Eyuel Tadesse on 12/28/2016.
 */
@Converter()
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        return (localDate == null ? null : java.sql.Date.valueOf(localDate));
    }

    @Override
    public LocalDate convertToEntityAttribute(java.sql.Date date) {
        return (date == null ? null : date.toLocalDate());
    }
}
