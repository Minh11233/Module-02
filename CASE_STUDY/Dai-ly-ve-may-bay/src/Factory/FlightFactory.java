package Factory;
import Factory.Dest.*;
import Interface.*;
import Factory.Class.*;
import Factory.PlaneType.*;
import Factory.Route.HanoiToSaigon;
import Factory.Route.SaigonToHanoi;
import Factory.Seat.*;
import Factory.Time.Evening;
import Factory.Time.Morning;

public class FlightFactory {
    public IPlane getType(String type) {
        if ("AIRBUS A330".equals(type)) {
            return new LargePlane();
        } else if ("AIRBUS A350".equals(type)) {
            return new MediumPlane();
        } else {
            return new SmallPlane();
        }
    }
    public IClass getClass(String type) {
        if ("Hạng thương gia".equals(type)) {
            return new BusinessClass();
        } else {
            return new EconomyClass();
        }
    }

    public IDest getDest(String type) {
        if ("Hà Nội".equals(type)) {
            return new HaNoi();
        } else if ("Sài Gòn".equals(type)) {
            return new SaiGon();
        } else if ("Nha Trang".equals(type)) {
            return new NhaTrang();
        } else {
            return new DaNang();
        }
    }

    public IDepart getDepart(String type) {
        if ("Hà Nội".equals(type)) {
            return new Factory.Depart.HaNoi();
        } else if ("Sài Gòn".equals(type)) {
            return new Factory.Depart.SaiGon();
        } else if ("Nha Trang".equals(type)) {
            return new Factory.Depart.NhaTrang();
        } else {
            return new Factory.Depart.DaNang();
        }
    }
    public IRoute getRoute(String type) {
        if ("Sài Gòn - Hà Nội".equals(type)) {
            return new SaigonToHanoi();
        } else {
            return new HanoiToSaigon();
        }
    }
    public IFlightTime getTime(String type) {
        if ("10:45 PM".equals(type)) {
            return new Evening();
        } else {
            return new Morning();
        }
    }
    public ISeat getSeat(String type) {
        if ("E-01".equals(type)) {
            return new Economy01();
        } else if ("E-02".equals(type)) {
            return new Economy02();
        } else if ("E-03".equals(type)) {
            return new Economy03();
        } else if ("E-04".equals(type)) {
            return new Economy04();
        } else if ("L-01".equals(type)) {
            return new Luxury01();
        } else {
            return new Luxury02();
        }
    }
}
