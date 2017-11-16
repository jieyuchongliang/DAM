package info.chenghuan.com.dam.bean;

/**
 * Created by Administrator on 2017/10/24 0024.
 */

public class GatherBean {
    private String mileage;
    private String date;
    private String groutingM;
    private String groutingMpa;
    private String groutingDate;
    private String progictName;
    private String progictUnit;

    public GatherBean(String mileage, String date, String groutingM, String groutingMpa, String groutingDate, String progictName, String progictUnit) {
        this.mileage = mileage;
        this.date = date;
        this.groutingM = groutingM;
        this.groutingMpa = groutingMpa;
        this.groutingDate = groutingDate;
        this.progictName = progictName;
        this.progictUnit = progictUnit;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGroutingM() {
        return groutingM;
    }

    public void setGroutingM(String groutingM) {
        this.groutingM = groutingM;
    }

    public String getGroutingMpa() {
        return groutingMpa;
    }

    public void setGroutingMpa(String groutingMpa) {
        this.groutingMpa = groutingMpa;
    }

    public String getGroutingDate() {
        return groutingDate;
    }

    public void setGroutingDate(String groutingDate) {
        this.groutingDate = groutingDate;
    }

    public String getProgictName() {
        return progictName;
    }

    public void setProgictName(String progictName) {
        this.progictName = progictName;
    }

    public String getProgictUnit() {
        return progictUnit;
    }

    public void setProgictUnit(String progictUnit) {
        this.progictUnit = progictUnit;
    }
}
