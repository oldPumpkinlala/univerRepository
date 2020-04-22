package web.Utils;



import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConverter implements Converter {
    public DateConverter() {
    }

    public Object convert(Class type, Object value) {
        if (value == null) {
            return null;
        } else if (!(value instanceof String)) {
            return value;
        } else {
            String val = (String)value;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            try {
                return sdf.parse(val);
            } catch (ParseException var6) {
                throw new RuntimeException(var6);
            }
        }
    }

    @Override
    public Object convert(Object o) {
        return null;
    }
}