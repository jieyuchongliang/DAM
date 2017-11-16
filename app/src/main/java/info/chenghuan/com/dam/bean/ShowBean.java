package info.chenghuan.com.dam.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25 0025.
 */

public class ShowBean {

    /**
     * currentPage : 1
     * currentResult : 0
     * endRow : 20
     * entityOrField : true
     * pageNum : 1
     * pageSize : 20
     * pageStr : 	<ul class='pagination'>...
     * pages : 1
     * rows : [{"auditStatus":"1","auditTime":"2017-09-27 17:58:16.0","auditor":"Mr. Z","delFlag":"0","distance":18198,"finishTime":"2017-08-07 12:12:25.0","fixDetail":"fix_detail","fixTime":"2017-09-27 12:12:25.0","fixer":"Mr.Q","groutAmount1":"23","groutAmount2":"26","groutDuration1":"30","groutDuration2":"33","groutPressure1":"3","groutPressure2":"2","groutTime1":"2017-09-25 01:12:25.0","groutTime2":"2017-09-27 17:57:50.0","headHoffset":-40.59,"headVoffset":48.13,"horizonalOffset":"-18.39","id":417,"kPosition":1,"ovality":"2","pieceMfidA1":"aaa1","pieceMfidA2":"aaa2","pieceMfidA3":"aaa3","pieceMfidA4":"aaa4","pieceMfidA5":"aaa5","pieceMfidA6":"aaa6","pieceMfidB1":"aaa7","pieceMfidB2":"aaa8","pieceMfidK1":"aaa9","postFixPic":"2c999a035eb1ae48015eb1ae56610008","preFixPic":"2c999a035eb1ae48015eb1ae4f5f0007","problemPosition":"problem_position","qualityDetail":"quality_detail","ringId":2,"status":0,"tailGapB":2,"tailGapL":3,"tailGapR":4,"tailGapT":1,"tailHoffset":14.18,"tailVoffset":-94.64,"tsId":2,"verticalOffset":"-46.29"}]
     * startRow : 0
     * total : 1
     */

    private int currentPage;
    private int currentResult;
    private int endRow;
    private boolean entityOrField;
    private int pageNum;
    private int pageSize;
    private String pageStr;
    private int pages;
    private int startRow;
    private int total;
    private List<RowsBean> rows;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentResult() {
        return currentResult;
    }

    public void setCurrentResult(int currentResult) {
        this.currentResult = currentResult;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public boolean isEntityOrField() {
        return entityOrField;
    }

    public void setEntityOrField(boolean entityOrField) {
        this.entityOrField = entityOrField;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageStr() {
        return pageStr;
    }

    public void setPageStr(String pageStr) {
        this.pageStr = pageStr;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * auditStatus : 1
         * auditTime : 2017-09-27 17:58:16.0
         * auditor : Mr. Z
         * delFlag : 0
         * distance : 18198
         * finishTime : 2017-08-07 12:12:25.0
         * fixDetail : fix_detail
         * fixTime : 2017-09-27 12:12:25.0
         * fixer : Mr.Q
         * groutAmount1 : 23
         * groutAmount2 : 26
         * groutDuration1 : 30
         * groutDuration2 : 33
         * groutPressure1 : 3
         * groutPressure2 : 2
         * groutTime1 : 2017-09-25 01:12:25.0
         * groutTime2 : 2017-09-27 17:57:50.0
         * headHoffset : -40.59
         * headVoffset : 48.13
         * horizonalOffset : -18.39
         * id : 417
         * kPosition : 1
         * ovality : 2
         * pieceMfidA1 : aaa1
         * pieceMfidA2 : aaa2
         * pieceMfidA3 : aaa3
         * pieceMfidA4 : aaa4
         * pieceMfidA5 : aaa5
         * pieceMfidA6 : aaa6
         * pieceMfidB1 : aaa7
         * pieceMfidB2 : aaa8
         * pieceMfidK1 : aaa9
         * postFixPic : 2c999a035eb1ae48015eb1ae56610008
         * preFixPic : 2c999a035eb1ae48015eb1ae4f5f0007
         * problemPosition : problem_position
         * qualityDetail : quality_detail
         * ringId : 2
         * status : 0
         * tailGapB : 2
         * tailGapL : 3
         * tailGapR : 4
         * tailGapT : 1
         * tailHoffset : 14.18
         * tailVoffset : -94.64
         * tsId : 2
         * verticalOffset : -46.29
         */

        private String auditStatus;
        private String auditTime;
        private String auditor;
        private String delFlag;
        private String distance;
        private String finishTime;
        private String fixDetail;
        private String fixTime;
        private String fixer;
        private String groutAmount1;
        private String groutAmount2;
        private String groutDuration1;
        private String groutDuration2;
        private String groutPressure1;
        private String groutPressure2;
        private String groutTime1;
        private String groutTime2;
        private double headHoffset;
        private double headVoffset;
        private String horizonalOffset;
        private int id;
        private int kPosition;
        private String ovality;
        private String pieceMfidA1;
        private String pieceMfidA2;
        private String pieceMfidA3;
        private String pieceMfidA4;
        private String pieceMfidA5;
        private String pieceMfidA6;
        private String pieceMfidB1;
        private String pieceMfidB2;
        private String pieceMfidK1;
        private String postFixPic;
        private String preFixPic;
        private String problemPosition;
        private String qualityDetail;
        private String ringId;
        private int status;
        private int tailGapB;
        private int tailGapL;
        private int tailGapR;
        private int tailGapT;
        private double tailHoffset;
        private double tailVoffset;
        private String tsId;
        private String verticalOffset;

        public String getAuditStatus() {
            return auditStatus;
        }

        public void setAuditStatus(String auditStatus) {
            this.auditStatus = auditStatus;
        }

        public String getAuditTime() {
            return auditTime;
        }

        public void setAuditTime(String auditTime) {
            this.auditTime = auditTime;
        }

        public String getAuditor() {
            return auditor;
        }

        public void setAuditor(String auditor) {
            this.auditor = auditor;
        }

        public String getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(String delFlag) {
            this.delFlag = delFlag;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getFinishTime() {
            return finishTime;
        }

        public void setFinishTime(String finishTime) {
            this.finishTime = finishTime;
        }

        public String getFixDetail() {
            return fixDetail;
        }

        public void setFixDetail(String fixDetail) {
            this.fixDetail = fixDetail;
        }

        public String getFixTime() {
            return fixTime;
        }

        public void setFixTime(String fixTime) {
            this.fixTime = fixTime;
        }

        public String getFixer() {
            return fixer;
        }

        public void setFixer(String fixer) {
            this.fixer = fixer;
        }

        public String getGroutAmount1() {
            return groutAmount1;
        }

        public void setGroutAmount1(String groutAmount1) {
            this.groutAmount1 = groutAmount1;
        }

        public String getGroutAmount2() {
            return groutAmount2;
        }

        public void setGroutAmount2(String groutAmount2) {
            this.groutAmount2 = groutAmount2;
        }

        public String getGroutDuration1() {
            return groutDuration1;
        }

        public void setGroutDuration1(String groutDuration1) {
            this.groutDuration1 = groutDuration1;
        }

        public String getGroutDuration2() {
            return groutDuration2;
        }

        public void setGroutDuration2(String groutDuration2) {
            this.groutDuration2 = groutDuration2;
        }

        public String getGroutPressure1() {
            return groutPressure1;
        }

        public void setGroutPressure1(String groutPressure1) {
            this.groutPressure1 = groutPressure1;
        }

        public String getGroutPressure2() {
            return groutPressure2;
        }

        public void setGroutPressure2(String groutPressure2) {
            this.groutPressure2 = groutPressure2;
        }

        public String getGroutTime1() {
            return groutTime1;
        }

        public void setGroutTime1(String groutTime1) {
            this.groutTime1 = groutTime1;
        }

        public String getGroutTime2() {
            return groutTime2;
        }

        public void setGroutTime2(String groutTime2) {
            this.groutTime2 = groutTime2;
        }

        public double getHeadHoffset() {
            return headHoffset;
        }

        public void setHeadHoffset(double headHoffset) {
            this.headHoffset = headHoffset;
        }

        public double getHeadVoffset() {
            return headVoffset;
        }

        public void setHeadVoffset(double headVoffset) {
            this.headVoffset = headVoffset;
        }

        public String getHorizonalOffset() {
            return horizonalOffset;
        }

        public void setHorizonalOffset(String horizonalOffset) {
            this.horizonalOffset = horizonalOffset;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getKPosition() {
            return kPosition;
        }

        public void setKPosition(int kPosition) {
            this.kPosition = kPosition;
        }

        public String getOvality() {
            return ovality;
        }

        public void setOvality(String ovality) {
            this.ovality = ovality;
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

        public String getPostFixPic() {
            return postFixPic;
        }

        public void setPostFixPic(String postFixPic) {
            this.postFixPic = postFixPic;
        }

        public String getPreFixPic() {
            return preFixPic;
        }

        public void setPreFixPic(String preFixPic) {
            this.preFixPic = preFixPic;
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

        public String getRingId() {
            return ringId;
        }

        public void setRingId(String ringId) {
            this.ringId = ringId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getTailGapB() {
            return tailGapB;
        }

        public void setTailGapB(int tailGapB) {
            this.tailGapB = tailGapB;
        }

        public int getTailGapL() {
            return tailGapL;
        }

        public void setTailGapL(int tailGapL) {
            this.tailGapL = tailGapL;
        }

        public int getTailGapR() {
            return tailGapR;
        }

        public void setTailGapR(int tailGapR) {
            this.tailGapR = tailGapR;
        }

        public int getTailGapT() {
            return tailGapT;
        }

        public void setTailGapT(int tailGapT) {
            this.tailGapT = tailGapT;
        }

        public double getTailHoffset() {
            return tailHoffset;
        }

        public void setTailHoffset(double tailHoffset) {
            this.tailHoffset = tailHoffset;
        }

        public double getTailVoffset() {
            return tailVoffset;
        }

        public void setTailVoffset(double tailVoffset) {
            this.tailVoffset = tailVoffset;
        }

        public String getTsId() {
            return tsId;
        }

        public void setTsId(String tsId) {
            this.tsId = tsId;
        }

        public String getVerticalOffset() {
            return verticalOffset;
        }

        public void setVerticalOffset(String verticalOffset) {
            this.verticalOffset = verticalOffset;
        }
    }
}
