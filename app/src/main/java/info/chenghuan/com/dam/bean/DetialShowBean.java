package info.chenghuan.com.dam.bean;

/**
 * Created by Administrator on 2017/10/25 0025.
 */

public class DetialShowBean {
    private String ringNumber;//成隧环号
    private String mileage;//所在里程
    private String installDate; // 拼装时间
    private String groutingOneM;//同步注浆m
    private String groutingOneMpa;//同步注浆mpa
    private String groutingOneDate;//同步注浆时间
    private String groutingTwoM;//二次注浆m
    private String groutingTwoMpa;//二次注浆默哀mpa
    private String groutingTwoDate;//二次注浆时间
    private String appearanceCheck;//外观检查
    private String constructionMeasure;//施工测量
    private String number;//出厂编号
    private String projectName;//工程名称
    private String lineName;//线路名称
    private String unit;//施工单位

    public DetialShowBean(String ringNumber, String mileage, String installDate, String groutingOneM, String groutingOneMpa, String groutingOneDate, String groutingTwoM, String groutingTwoMpa, String groutingTwoDate, String appearanceCheck, String constructionMeasure, String number, String projectName, String lineName, String unit) {
        this.ringNumber = ringNumber;
        this.mileage = mileage;
        this.installDate = installDate;
        this.groutingOneM = groutingOneM;
        this.groutingOneMpa = groutingOneMpa;
        this.groutingOneDate = groutingOneDate;
        this.groutingTwoM = groutingTwoM;
        this.groutingTwoMpa = groutingTwoMpa;
        this.groutingTwoDate = groutingTwoDate;
        this.appearanceCheck = appearanceCheck;
        this.constructionMeasure = constructionMeasure;
        this.number = number;
        this.projectName = projectName;
        this.lineName = lineName;
        this.unit = unit;
    }

    public String getRingNumber() {
        return ringNumber;
    }

    public void setRingNumber(String ringNumber) {
        this.ringNumber = ringNumber;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getInstallDate() {
        return installDate;
    }

    public void setInstallDate(String installDate) {
        this.installDate = installDate;
    }

    public String getGroutingOneM() {
        return groutingOneM;
    }

    public void setGroutingOneM(String groutingOneM) {
        this.groutingOneM = groutingOneM;
    }

    public String getGroutingOneMpa() {
        return groutingOneMpa;
    }

    public void setGroutingOneMpa(String groutingOneMpa) {
        this.groutingOneMpa = groutingOneMpa;
    }

    public String getGroutingOneDate() {
        return groutingOneDate;
    }

    public void setGroutingOneDate(String groutingOneDate) {
        this.groutingOneDate = groutingOneDate;
    }

    public String getGroutingTwoM() {
        return groutingTwoM;
    }

    public void setGroutingTwoM(String groutingTwoM) {
        this.groutingTwoM = groutingTwoM;
    }

    public String getGroutingTwoMpa() {
        return groutingTwoMpa;
    }

    public void setGroutingTwoMpa(String groutingTwoMpa) {
        this.groutingTwoMpa = groutingTwoMpa;
    }

    public String getGroutingTwoDate() {
        return groutingTwoDate;
    }

    public void setGroutingTwoDate(String groutingTwoDate) {
        this.groutingTwoDate = groutingTwoDate;
    }

    public String getAppearanceCheck() {
        return appearanceCheck;
    }

    public void setAppearanceCheck(String appearanceCheck) {
        this.appearanceCheck = appearanceCheck;
    }

    public String getConstructionMeasure() {
        return constructionMeasure;
    }

    public void setConstructionMeasure(String constructionMeasure) {
        this.constructionMeasure = constructionMeasure;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
