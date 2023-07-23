package Factory.PlaneType;

import Interface.IPlane;

public class MediumPlane implements IPlane {
    @Override
    public String getPlane() {
        return "AIRBUS A350";
    }
}
