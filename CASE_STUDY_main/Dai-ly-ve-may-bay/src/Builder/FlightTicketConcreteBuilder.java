package Builder;

import Entity.Others.FlightTicket;

public class FlightTicketConcreteBuilder implements FlightTicketBuilder {
    private String position;
    private String plane;
    private String time;
    private String seat;
    private String depart;
    private String dest;
    private String flightHour;
    private int price;
    private String date;

    @Override
    public FlightTicketBuilder setPosition(String position) {
        this.position = position;
        return this;
    }

    @Override
    public FlightTicketBuilder setPlane(String plane) {
        this.plane = plane;
        return this;
    }

    @Override
    public FlightTicketBuilder setTime(String time) {
        this.time = time;
        return this;
    }

    @Override
    public FlightTicketBuilder setSeat(String seat) {
        this.seat = seat;
        return this;
    }

    @Override
    public FlightTicketBuilder setDepart(String depart) {
        this.depart = depart;
        return this;
    }

    @Override
    public FlightTicketBuilder setDest(String dest) {
        this.dest = dest;
        return this;
    }

    @Override
    public FlightTicketBuilder setFlightHour(String flightHour) {
        this.flightHour = flightHour;
        return this;
    }

    @Override
    public FlightTicketBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    @Override
    public FlightTicketBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    @Override
    public FlightTicket build() {
        return new FlightTicket(depart,dest,position,plane,time,seat,flightHour,price,date);
    }
}
