package futoverseny.futoverseny.models.api;

public class RaceRunner {

    private String name;
    private Integer time;

    public RaceRunner() {
    }

    public RaceRunner(Integer time, String name) {
        this.time = time;
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RaceRunners{" +
                "time=" + time +
                ", name='" + name + '\'' +
                '}';
    }
}
