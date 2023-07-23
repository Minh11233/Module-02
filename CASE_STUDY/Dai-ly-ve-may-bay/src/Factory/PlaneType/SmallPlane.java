package Factory.PlaneType;

import Interface.IPlane;

public class SmallPlane implements IPlane {
    @Override
    public String getPlane() {
        return "BOEING 777";
    }
}
