package org.example.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class DOMParser {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(DOMParser.class);

    public static void main(String[] args) {

        File file = new File("src/main/resources/xml/physician.xml");

        LOGGER.info(validateXMLSchema("src/main/resources/xml/xsd/physician.xsd","src/main/resources/xml/physician.xml"));
        LOGGER.info(validateXMLSchema("src/main/resources/xml/xsd/patient.xsd","src/main/resources/xml/patient.xml"));

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            Element rootElement = document.getDocumentElement();
            LOGGER.info("Root Element : " + rootElement.getNodeName());
            NodeList physicianList = rootElement.getElementsByTagName("physician");
            LOGGER.info("Number of physician :" + physicianList.getLength());
            LOGGER.info("Physician Details");
            for (int i = 0; i < physicianList.getLength(); i++) {
                Node node = physicianList.item(i);
                Element element = (Element) node;
                LOGGER.info("Physician id : " + element.getAttribute("id"));
                LOGGER.info("Physician First Name : " + element.getElementsByTagName("firstName").item(0).getTextContent( ));
                LOGGER.info("Physician Last Name : " + element.getElementsByTagName("lastName").item(0).getTextContent( ));

                NodeList departmentList = rootElement.getElementsByTagName("department");
                for (int j = 0; j < departmentList.getLength(); j++) {
                    Node departmentNode = departmentList.item(i);
                    Element departmentElement = (Element) departmentNode;
                    LOGGER.info("department id : " + departmentElement.getAttribute("id"));
                    LOGGER.info("Department Name : " + departmentElement.getElementsByTagName("name").item(0).getTextContent( ));
                }
                NodeList positionList = rootElement.getElementsByTagName("position");
                for (int k = 0; k < positionList.getLength(); k++) {
                    Node positionNode = positionList.item(i);
                    Element positionElement = (Element) positionNode;
                    LOGGER.info("Position id : " + positionElement.getAttribute("id"));
                    LOGGER.info("Position Name : " + positionElement.getElementsByTagName("name").item(0).getTextContent( ));
                }
                NodeList specializationList = rootElement.getElementsByTagName("specialization");
                for (int l = 0; l < specializationList.getLength(); l++) {
                    Node specializationNode = specializationList.item(i);
                    Element spcializationElement = (Element) specializationNode;
                    LOGGER.info("Specialization id : " + spcializationElement.getAttribute("id"));
                    LOGGER.info("Specialization Name : " + spcializationElement.getElementsByTagName("name").item(0).getTextContent( ));
                }
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            LOGGER.info(e);
        }
    }

    private static String validateXMLSchema(String xsdPath, String xmlPath) {

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
                validator.validate(new StreamSource( new File(xmlPath)));

        } catch (SAXException | IOException e) {
            LOGGER.info(e);
            return "Validation Failed";
        }
        return "Validation Successful";
    }
}
