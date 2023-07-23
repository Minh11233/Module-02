package Builder;

import Entity.Others.FlightTicket;
public interface FlightTicketBuilder {
    FlightTicketBuilder setPosition(String position);
    FlightTicketBuilder setPlane(String plane);
    FlightTicketBuilder setTime(String time);
    FlightTicketBuilder setSeat(String seat);
    FlightTicketBuilder setDepart(String depart);
    FlightTicketBuilder setDest(String dest);
    FlightTicketBuilder setFlightHour(String time);
    FlightTicketBuilder setPrice(int price);
    FlightTicketBuilder setDate(String date);
    FlightTicket build();
}
