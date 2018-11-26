package com.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbUtils {

    /**
     * 对象转为xml文件
     * 
     * @param obj
     * @param beanClass 对象的class
     * @return
     */
    public static String beanToXml(Object obj, Class<?> beanClass) {

        StringWriter writer = null;
        try {
            JAXBContext context = JAXBContext.newInstance(beanClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            writer = new StringWriter();
            marshaller.marshal(obj, writer);
            return writer.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 
     * @param xmlStr
     *            xml字符串
     * @param beanClass
     *            对象的Class
     * @return
     */

    public static <T> T xmlToBean(String xmlStr, Class<T> beanClass) {
        StringReader reader = null;
        try {
            JAXBContext context = JAXBContext.newInstance(beanClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            reader = new StringReader(xmlStr);
            @SuppressWarnings("unchecked")
            T t = (T) unmarshaller.unmarshal(reader);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return null;
    }
}
