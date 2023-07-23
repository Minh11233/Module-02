package Factory.PlaneType;

import Interface.IPlane;

public class LargePlane implements IPlane {
    @Override
    public String getPlane() {
        return "AIRBUS A330";
    }
}
