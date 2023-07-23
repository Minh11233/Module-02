package Factory.Dest;

import Interface.IDepart;
import Interface.IDest;

public class DaNang implements IDest {
    @Override
    public String getDest() {
        return "Đà Nẵng";
    }
}
