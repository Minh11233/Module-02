package Factory.Seat;

import Interface.ISeat;

public class Luxury01 implements ISeat {
    @Override
    public String getSeat() {
        return "L-01";
    }
}
