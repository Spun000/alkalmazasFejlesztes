package futoverseny.futoverseny.models.api;

public class AverageTime {

    private Integer averageTime;

    public AverageTime() {
    }

    public AverageTime(Integer averageTime) {
        this.averageTime = averageTime;
    }

    public Integer getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(Integer averageTime) {
        this.averageTime = averageTime;
    }

    @Override
    public String toString() {
        return "AverageTime{" +
                "averageTime=" + averageTime +
                '}';
    }
}
