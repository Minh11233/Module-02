import java.util.Date;
public class StopWatch {
    private Date startTime;
    private Date endTime;
    private long currentMilliseconds;

    public Date getStartTime() {
        return this.startTime;
    }
    public Date getEndTime() {
        return this.endTime;
    }
    public Date start() {
        return this.startTime = new Date();
    }
    public Date end() {
        return this.endTime = new Date();
    }
    public long getElapsedTime() {
        return currentMilliseconds = endTime.getTime() - startTime.getTime();
    }
}


