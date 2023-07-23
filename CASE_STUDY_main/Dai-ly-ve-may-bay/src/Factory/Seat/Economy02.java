package Factory.Seat;

import Interface.ISeat;

public class Economy02 implements ISeat {
    @Override
    public String getSeat() {
        return "E-02";
    }
}
