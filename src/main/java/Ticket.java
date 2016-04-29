import java.time.ZonedDateTime;


public class Ticket {
    private ZonedDateTime departureDate;
    private ZonedDateTime arriveddate;
    private int gate;
    private String aircraftNumber;
    private String typePlane;
    private int row;
    private int seat;

    public Ticket() {
    }

    public Ticket(ZonedDateTime departureDate,
                  ZonedDateTime arriveddate, int gate,
                  String aircraftNumber, String typePlane,
                  int row, int seat) {
        this.departureDate = departureDate;
        this.arriveddate = arriveddate;
        this.gate = gate;
        this.aircraftNumber = aircraftNumber;
        this.typePlane = typePlane;
        this.row = row;
        this.seat = seat;
    }

    public ZonedDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(ZonedDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public ZonedDateTime getArriveddate() {
        return arriveddate;
    }

    public void setArriveddate(ZonedDateTime arriveddate) {
        this.arriveddate = arriveddate;
    }

    public int getGate() {
        return gate;
    }

    public void setGate(int gate) {
        this.gate = gate;
    }

    public String getAircraftNumber() {
        return aircraftNumber;
    }

    public void setAircraftNumber(String aircraftNumber) {
        this.aircraftNumber = aircraftNumber;
    }

    public String getTypePlane() {
        return typePlane;
    }

    public void setTypePlane(String typePlane) {
        this.typePlane = typePlane;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "departureDate=" + departureDate +
                ", arriveddate=" + arriveddate +
                ", gate=" + gate +
                ", aircraftNumber='" + aircraftNumber + '\'' +
                ", typePlane='" + typePlane + '\'' +
                ", row=" + row +
                ", seat=" + seat +
                '}';
    }
}
