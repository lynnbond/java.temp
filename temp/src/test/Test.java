package test;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.sql.Date;

//Ĭ��֧��8��ԭ�����ͣ�int...����String,   BigDecimal,   BigInteger,   java.sql.Date,   java.sql.Time,   java.sql.Timestamp��  
public class Test
{
    int x;

    Date date;

    B b;

    public Date getDate()
    {
        return date;
    }

    public int getX()
    {
        return x;
    }

    public B getB()
    {
        return b;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setB(B b)
    {
        this.b = b;
    }

    public static void main(String[] args)
    {
//        ConvertUtils.deregister();
//        ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class); // ���ת��������null,Ĭ�ϱ���
//        ConvertUtils.register(new BigIntegerConverter(null), BigInteger.class);
//        ConvertUtils.register(new BooleanConverter(null), Boolean.class);
//        ConvertUtils.register(new ByteConverter(null), Byte.class);
//        ConvertUtils.register(new CharacterConverter(null), Character.class);
//        ConvertUtils.register(new DoubleConverter(null), Double.class);
//        ConvertUtils.register(new FloatConverter(null), Float.class);
//        ConvertUtils.register(new IntegerConverter(null), Integer.class);
//        ConvertUtils.register(new LongConverter(null), Long.class);
//        ConvertUtils.register(new ShortConverter(null), Short.class);
//        ConvertUtils.register(new SqlDateConverter(null), Date.class);
//        ConvertUtils.register(new SqlTimeConverter(null), Time.class);
//        ConvertUtils.register(new SqlTimestampConverter(null), Timestamp.class);
//        ConvertUtils.register(new BConverter(), B.class); // ע��
//        try
//        {
//            Test t = new Test();
//        
//            Map properties = new HashMap();
//            properties.put("x", "123");
//            properties.put("date", "2005-10-11");
//            properties.put("b", "value   in   b");
//            BeanUtils.populate(t, properties); // ����JavaBean����
//            BeanUtils.setProperty(t, "x", "12345"); // ������������
//            System.out.println(BeanUtils.describe(t)); // ��populate�෴
//        } catch (Exception ex)
//        {
//            ex.printStackTrace();
//        }
        
    	PropertyEditorManager pm = new PropertyEditorManager();

    	PropertyEditor propEditor =  pm.findEditor(B.class);

    	System.out.println(propEditor.getValue());

    	propEditor.setAsText("1234567890");

//    	action.setPropertyOne((PropertyOne) propEditor.getValue());
//
//    	System.out.println(action);
//    	System.out.println(action.getPropertyOne());
//    	System.out.println(action.getPropertyOne().getProperty());
    }
}
