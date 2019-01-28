package app.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

@Component
public class XmlParserImpl {


    public <O> void marshallXml( O object, Class<O> klass, String filePath) throws JAXBException{
         JAXBContext context = JAXBContext.newInstance(klass);
         Marshaller marshaller = context.createMarshaller();
         marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
         marshaller.marshal(object, new File(filePath));
     }

     public <E> E fromXml(Class<E> klass, String filePath) throws JAXBException {
         JAXBContext context = JAXBContext.newInstance(klass);
         Unmarshaller unmarshaller = context.createUnmarshaller();
         InputStream inputStream = getClass().getResourceAsStream(filePath);
         BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
         return (E) unmarshaller.unmarshal(reader);
     }

     @Bean
     public XmlParserImpl xmlParser(){
         return new XmlParserImpl();
     }

}
