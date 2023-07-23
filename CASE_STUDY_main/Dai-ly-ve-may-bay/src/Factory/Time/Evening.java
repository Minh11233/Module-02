package Factory.Time;

import Interface.IFlightTime;

public class Evening implements IFlightTime {
    @Override
    public String getTime() {
        return "10:45 PM";
    }
}
