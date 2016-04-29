
import java.io.File;
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

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtils {

    /**
     * file name like testing.xml
     */

    public static void exportCatalogToXML(String fileName, List<Ticket> clothes) {

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("Catalogue");
            doc.appendChild(rootElement);

            for (Ticket item : clothes) {
                Element staff = doc.createElement("Clothes");
                rootElement.appendChild(populateClothesElement(doc, staff, item));
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(new File(fileName));
            transformer.transform(source, result);

            System.out.println("Done");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

    }

    private static Element populateClothesElement(Document doc, Element item, Ticket ticket) {

        // set attribute to staff element
        Attr attr = doc.createAttribute("id");
        attr.setValue(Integer.toString(ticket.getId()));
        item.setAttributeNode(attr);

        attr = doc.createAttribute("category");
        attr.setValue(ticket.getCategory());
        item.setAttributeNode(attr);

        /**
         * TODO Do the same for all fields of Clothes
         */
        return item;
    }

    public static List<Ticket> readCatalogFromFile(String fileName) {
        List<Ticket> clothes = new ArrayList();
        try {
            File fXmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            NodeList nList = doc.getElementsByTagName("Clothes");
            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                //System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    Ticket ticket = new Ticket();

                    ticket.setId(Integer.parseInt(eElement.getAttribute("id")));
                    ticket.setCategory(eElement.getAttribute("category"));

                    // TODO do the same for all fields of Clothes

                    clothes.add(ticket);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return clothes;

    }

}
*/