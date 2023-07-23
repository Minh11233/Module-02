package Factory.Route;

import Interface.IRoute;

public class HanoiToSaigon implements IRoute {
    @Override
    public String getRoute() {
        return "Hà Nội - Sài Gòn";
    }
}
