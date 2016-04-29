package epamlab.simpler;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtils {
    private static final Logger log = Logger.getLogger(XmlUtils.class);

    /**
     * file name like testing.xml
     */

    public static void exportCatalogToXML(String fileName, List<Ticket> clothes) {

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("tickets");
            doc.appendChild(rootElement);

            for (Ticket item : clothes) {
                Element staff = doc.createElement("ticket");
                rootElement.appendChild(populateClothesElement(doc, staff, item));
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(new File(fileName));
            transformer.transform(source, result);

            log.info("Done");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

    }

    private static Element populateClothesElement(Document doc, Element item, Ticket ticket) {

        // set attribute to staff element
        Attr attr = doc.createAttribute("departuredate");
        attr.setValue(ticket.getDepartureDate().toString());
        item.setAttributeNode(attr);

        attr = doc.createAttribute("arrivedate");
        attr.setValue(ticket.getArrivedDate().toString());
        item.setAttributeNode(attr);

        attr = doc.createAttribute("gate");
        attr.setValue(ticket.getGate());
        item.setAttributeNode(attr);

        attr = doc.createAttribute("aircraftnumber");
        attr.setValue(ticket.getAircraftNumber());
        item.setAttributeNode(attr);

        attr = doc.createAttribute("typeplane");
        attr.setValue(ticket.getTypePlane());
        item.setAttributeNode(attr);

        attr = doc.createAttribute("row");
        attr.setValue(Integer.toString(ticket.getRow()));
        item.setAttributeNode(attr);

        attr = doc.createAttribute("seat");
        attr.setValue(Integer.toString(ticket.getSeat()));
        item.setAttributeNode(attr);

        return item;
    }

    public static List<Ticket> readCatalogFromFile(String fileName) {
        List<Ticket> tickets = new ArrayList();
        try {
            File fXmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            NodeList nList = doc.getElementsByTagName("ticket");
            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                //System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    Ticket ticket = new Ticket();
                    ticket.setDepartureDate(ZonedDateTime.parse(eElement.getAttribute("departuredate")));
                    ticket.setArrivedDate(ZonedDateTime.parse(eElement.getAttribute("arrivedate")));
                    ticket.setGate(eElement.getAttribute("gate"));
                    ticket.setAircraftNumber(eElement.getAttribute("aircraftnumber"));
                    ticket.setTypePlane(eElement.getAttribute("typeplane"));
                    ticket.setRow(Integer.parseInt(eElement.getAttribute("row")));
                    ticket.setSeat(Integer.parseInt(eElement.getAttribute("seat")));

                    // TODO do the same for all fields of Clothes

                    tickets.add(ticket);
                }
            }
        } catch (Exception e) {
            log.error(e);
        }
        return tickets;
    }

}