package info.chenghuan.com.dam.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31 0031.
 */

public class ProjectInfoBean {
    @SerializedName("currentPage")
    private int _$CurrentPage72; // FIXME check this code
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

    public int get_$CurrentPage72() {
        return _$CurrentPage72;
    }

    public void set_$CurrentPage72(int _$CurrentPage72) {
        this._$CurrentPage72 = _$CurrentPage72;
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
         * delFlag : 0
         * lineName : 京张铁路
         * projectName : 清华园隧道
         * tsId : 1
         * workCompany : 中铁十四局集团有限公司
         * worksiteName : 清华园隧道盾构段-1
         */

        private String delFlag;
        private String lineName;
        private String projectName;
        private String tsId;
        private String workCompany;
        private String worksiteName;

        public String getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(String delFlag) {
            this.delFlag = delFlag;
        }

        public String getLineName() {
            return lineName;
        }

        public void setLineName(String lineName) {
            this.lineName = lineName;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public String getTsId() {
            return tsId;
        }

        public void setTsId(String tsId) {
            this.tsId = tsId;
        }

        public String getWorkCompany() {
            return workCompany;
        }

        public void setWorkCompany(String workCompany) {
            this.workCompany = workCompany;
        }

        public String getWorksiteName() {
            return worksiteName;
        }

        public void setWorksiteName(String worksiteName) {
            this.worksiteName = worksiteName;
        }
    }
}
