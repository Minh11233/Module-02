package Factory.Class;

import Interface.IClass;

public class BusinessClass implements IClass {
    @Override
    public String getPosition() {
        return "Hạng thương gia";
    }
}
