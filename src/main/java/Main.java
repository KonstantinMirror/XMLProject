import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String[] args) {
        ZonedDateTime departureDate = ZonedDateTime.of(2016, 7, 15, 7, 0, 0, 0, ZoneId.of("America/Caracas"));
        ZonedDateTime arriveddate = ZonedDateTime.of(2016, 7, 15, 7, 0, 0, 0, ZoneId.of("Iran"));
        Ticket ticket = new Ticket(departureDate,arriveddate,25,"JA8089","Airbus A32",3,2);
        System.out.println(ticket);
        List<Ticket> bookedTickets = new ArrayList<>();
        bookedTickets.add(ticket);

    }


}
