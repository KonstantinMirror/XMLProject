package epamlab.simpler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ZonedDateTime departureDate = ZonedDateTime.of(2016, 7, 15, 7, 0, 0, 0, ZoneId.of("America/Caracas"));
        ZonedDateTime arriveddate = ZonedDateTime.of(2016, 7, 16, 7, 0, 0, 0, ZoneId.of("Iran"));
        Ticket ticket = new Ticket(departureDate, arriveddate, "25", "JA8089", "Airbus A32", 3, 2);
        List<Ticket> bookedTickets = new ArrayList<>();
        bookedTickets.add(ticket);
        bookedTickets.add(ticket);
        XmlUtils.exportCatalogToXML("Tickets.xml", bookedTickets);
        List<Ticket> readFromFile = XmlUtils.readCatalogFromFile("Tickets.xml");
        System.out.println(readFromFile);
    }


}
