package ru.ivanchin.centralbank.workWithXml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.stream.Collectors;

import static ru.ivanchin.centralbank.workWithXml.Const.*;

@Component
@RequiredArgsConstructor
public class ParserXml {

    private JAXBContext getContext() throws JAXBException {
        return JAXBContext.newInstance(ROOT_CLASS_FOR_XML);
    }

    private String parseFile() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(PATH_TO_FILE_FOR_TEST));
        return br.lines().collect(Collectors.joining());
    }

    public Object unmarshalling() throws JAXBException, FileNotFoundException {
        Unmarshaller unmarshaller = getContext().createUnmarshaller();
        return unmarshaller.unmarshal(new StringReader(parseFile()));
    }

    public void marshalling(Object object) throws JAXBException {
        Marshaller marshaller = getContext().createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(object, new File(PATH_TO_FILE));
    }

}
