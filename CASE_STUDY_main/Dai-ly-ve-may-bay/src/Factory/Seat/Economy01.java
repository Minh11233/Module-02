package Factory.Seat;

import Interface.ISeat;

public class Economy01 implements ISeat {
    @Override
    public String getSeat() {
        return "E-01";
    }
}
