package Entity.Others;

import Interface.writeToFile;

public class FlightTicket implements writeToFile {
private String position;
private String plane;
private String time;
private String seat;
private String depart;
private String dest;
private String flightHour;
private int price;
private String date;
    public FlightTicket(String depart, String dest, String position, String plane, String time, String seat, String flightHour, int price, String date) {
        this.position = position;
        this.plane = plane;
        this.time = time;
        this.seat = seat;
        this.depart = depart;
        this.dest = dest;
        this.flightHour = flightHour;
        this.price = price;
        this.date = date;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSeat() {
        return position;
    }

    public void setSeat(String seat) {
        this.position = seat;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public String getDepart() {
        return depart;
    }
    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "\n\nTHÔNG TIN CHUYẾN BAY\nChuyến bay từ " + depart + " đến " + dest
                + "\nKhởi hành vào ngày: " + date + "\nBắt đầu vào lúc: "
                + time + "\nThời gian trung chuyển: " + flightHour + "\nMáy bay: "
                + plane  + "\nKhoang: " + position + "\nGiá vé: " + price + " VNĐ" + "\nChỗ ngồi: " + seat + "\n\n";
    }

    @Override
    public String writeToFile() {
        return date + ";" + price + ";";
    }
}
