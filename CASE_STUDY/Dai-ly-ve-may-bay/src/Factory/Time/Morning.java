package Factory.Time;

import Interface.IFlightTime;

public class Morning implements IFlightTime {
    @Override
    public String getTime() {
        return "7:45 AM";
    }
}
