

package epamlab.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.time.ZoneId;
import java.time.ZonedDateTime;



public class Main {
    private static final String FILE_NAME ="JAXBTicket.xml";

    public static void main(String[] args) {
        ZonedDateTime departureDate = ZonedDateTime.of(2016, 7, 15, 7, 0, 0, 0, ZoneId.of("America/Caracas"));
        ZonedDateTime arriveddate = ZonedDateTime.of(2016, 7, 16, 7, 0, 0, 0, ZoneId.of("Iran"));
        Ticket ticket = new Ticket(departureDate,arriveddate,"25","JA8089","Airbus A32",3,2);
        jaxbObjectToXml(ticket);
        Ticket ticketFromFile = jaxbXMLToObject();
        System.out.println(ticketFromFile);
    }

    private static void jaxbObjectToXml(Ticket ticket){
        try {
            JAXBContext context = JAXBContext.newInstance(Ticket.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(ticket,new File(FILE_NAME));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    private static Ticket jaxbXMLToObject(){
        try {
            JAXBContext context =JAXBContext.newInstance(Ticket.class);
            Unmarshaller unmarshaller= context.createUnmarshaller();
            Ticket ticket = (Ticket)unmarshaller.unmarshal(new File(FILE_NAME));
            return ticket;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }


}
