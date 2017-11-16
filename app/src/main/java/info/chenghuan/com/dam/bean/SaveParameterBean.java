package info.chenghuan.com.dam.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31 0031.
 */

public class SaveParameterBean {

    /**
     * tsId : 2
     * status : 1
     * ringId : 657
     * finishTime : 1509330360000
     * groutTime2 : 1509330420000
     * groutPressure2 : 3.3
     * groutDuration2 : 4
     * groutAmount2 : 3.3
     * kPosition : 2
     * problemPosition : 问题位置
     * qualityDetail : 质量问题描述
     * fixDetail : 修复措施
     * fixer : 修复人
     * fixTime : 1509330480000
     * auditor : 审核人
     * auditStatus : 1
     * pieceMfidA1 : a1
     * pieceMfidA2 : a2
     * pieceMfidA3 : a3
     * pieceMfidA4 : a4
     * pieceMfidA5 : a5
     * pieceMfidA6 : a6
     * pieceMfidB1 : b1
     * pieceMfidB2 : b2
     * pieceMfidK1 : k1
     * preFixList : ["9288808e5f6b1239015f6b1c4e5a0002","9288808e5f6b1239015f6b1c4eb40003","9288808e5f6b1239015f6b1c4ee50004"]
     * postFixList : ["9288808e5f6b1239015f6b1c4e590001","9288808e5f6b1239015f6b1c4fdb0005","9288808e5f6b1239015f6b1c50090006"]
     */

    private String tsId;
    private String status;
    private String ringId;
    private String finishTime;
    private String groutTime2;
    private String groutPressure2;
    private String groutDuration2;
    private String groutAmount2;
    private String kPosition;
    private String problemPosition;
    private String qualityDetail;
    private String fixDetail;
    private String fixer;
    private String fixTime;
    private String auditor;
    private String auditStatus;
    private String pieceMfidA1;
    private String pieceMfidA2;
    private String pieceMfidA3;
    private String pieceMfidA4;
    private String pieceMfidA5;
    private String pieceMfidA6;
    private String pieceMfidB1;
    private String pieceMfidB2;
    private String pieceMfidK1;
    private String distance;
    private String horizonalOffset;//成环隧道轴线水平偏差
    private String verticalOffset;//成环隧道轴线垂直偏差
    private List<String> preFixList;
    private List<String> postFixList;

    public String getHorizonalOffset() {
        return horizonalOffset;
    }

    public void setHorizonalOffset(String horizonalOffset) {
        this.horizonalOffset = horizonalOffset;
    }

    public String getVerticalOffset() {
        return verticalOffset;
    }

    public void setVerticalOffset(String verticalOffset) {
        this.verticalOffset = verticalOffset;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTsId() {
        return tsId;
    }

    public void setTsId(String tsId) {
        this.tsId = tsId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRingId() {
        return ringId;
    }

    public void setRingId(String ringId) {
        this.ringId = ringId;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getGroutTime2() {
        return groutTime2;
    }

    public void setGroutTime2(String groutTime2) {
        this.groutTime2 = groutTime2;
    }

    public String getGroutPressure2() {
        return groutPressure2;
    }

    public void setGroutPressure2(String groutPressure2) {
        this.groutPressure2 = groutPressure2;
    }

    public String getGroutDuration2() {
        return groutDuration2;
    }

    public void setGroutDuration2(String groutDuration2) {
        this.groutDuration2 = groutDuration2;
    }

    public String getGroutAmount2() {
        return groutAmount2;
    }

    public void setGroutAmount2(String groutAmount2) {
        this.groutAmount2 = groutAmount2;
    }

    public String getKPosition() {
        return kPosition;
    }

    public void setKPosition(String kPosition) {
        this.kPosition = kPosition;
    }

    public String getProblemPosition() {
        return problemPosition;
    }

    public void setProblemPosition(String problemPosition) {
        this.problemPosition = problemPosition;
    }

    public String getQualityDetail() {
        return qualityDetail;
    }

    public void setQualityDetail(String qualityDetail) {
        this.qualityDetail = qualityDetail;
    }

    public String getFixDetail() {
        return fixDetail;
    }

    public void setFixDetail(String fixDetail) {
        this.fixDetail = fixDetail;
    }

    public String getFixer() {
        return fixer;
    }

    public void setFixer(String fixer) {
        this.fixer = fixer;
    }

    public String getFixTime() {
        return fixTime;
    }

    public void setFixTime(String fixTime) {
        this.fixTime = fixTime;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getPieceMfidA1() {
        return pieceMfidA1;
    }

    public void setPieceMfidA1(String pieceMfidA1) {
        this.pieceMfidA1 = pieceMfidA1;
    }

    public String getPieceMfidA2() {
        return pieceMfidA2;
    }

    public void setPieceMfidA2(String pieceMfidA2) {
        this.pieceMfidA2 = pieceMfidA2;
    }

    public String getPieceMfidA3() {
        return pieceMfidA3;
    }

    public void setPieceMfidA3(String pieceMfidA3) {
        this.pieceMfidA3 = pieceMfidA3;
    }

    public String getPieceMfidA4() {
        return pieceMfidA4;
    }

    public void setPieceMfidA4(String pieceMfidA4) {
        this.pieceMfidA4 = pieceMfidA4;
    }

    public String getPieceMfidA5() {
        return pieceMfidA5;
    }

    public void setPieceMfidA5(String pieceMfidA5) {
        this.pieceMfidA5 = pieceMfidA5;
    }

    public String getPieceMfidA6() {
        return pieceMfidA6;
    }

    public void setPieceMfidA6(String pieceMfidA6) {
        this.pieceMfidA6 = pieceMfidA6;
    }

    public String getPieceMfidB1() {
        return pieceMfidB1;
    }

    public void setPieceMfidB1(String pieceMfidB1) {
        this.pieceMfidB1 = pieceMfidB1;
    }

    public String getPieceMfidB2() {
        return pieceMfidB2;
    }

    public void setPieceMfidB2(String pieceMfidB2) {
        this.pieceMfidB2 = pieceMfidB2;
    }

    public String getPieceMfidK1() {
        return pieceMfidK1;
    }

    public void setPieceMfidK1(String pieceMfidK1) {
        this.pieceMfidK1 = pieceMfidK1;
    }

    public List<String> getPreFixList() {
        return preFixList;
    }

    public void setPreFixList(List<String> preFixList) {
        this.preFixList = preFixList;
    }

    public List<String> getPostFixList() {
        return postFixList;
    }

    public void setPostFixList(List<String> postFixList) {
        this.postFixList = postFixList;
    }
}
