package test;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

class BConverter implements Converter
{
    //@SuppressWarnings("unchecked")
    public Object convert(Class type, Object value)
    {
        try
        {
            B b = (B) type.newInstance();
            if (value != null)
            {
                b.setValue(String.valueOf(value));
            }
            return b;
        } catch (Exception ex)
        {
            throw new ConversionException(
                    "Unable   to   convert   the   FieldAttribute   object!",
                    ex);
        }
    }
}

