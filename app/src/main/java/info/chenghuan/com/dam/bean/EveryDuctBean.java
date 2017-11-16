package info.chenghuan.com.dam.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25 0025.
 */

public class EveryDuctBean {


    @SerializedName("result")
    private String _$Result266; // FIXME check this code
    private PieceListBean pieceList;

    public String get_$Result266() {
        return _$Result266;
    }

    public void set_$Result266(String _$Result266) {
        this._$Result266 = _$Result266;
    }

    public PieceListBean getPieceList() {
        return pieceList;
    }

    public void setPieceList(PieceListBean pieceList) {
        this.pieceList = pieceList;
    }

    public static class PieceListBean {
        @SerializedName("currentPage")
        private int _$CurrentPage226; // FIXME check this code
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

        public int get_$CurrentPage226() {
            return _$CurrentPage226;
        }

        public void set_$CurrentPage226(int _$CurrentPage226) {
            this._$CurrentPage226 = _$CurrentPage226;
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
             * strippingHeight : 0.0,-0.1,-0.24
             * pieceType : A1
             * pieceStatus : 堆场存放
             * lineName : 京张客运专线
             * ringNum : 1
             * status : 0
             * materialFlag : 0
             * isDamage : 0
             * baitingPerson : 田兴卫
             * ringWidth : 2
             * ringThickness : 0.55
             * designModel : Ⅰ
             * projectName : 清华园隧道
             * strippingDiagonal : 0.2,-0.3,0.0
             * productionDate : 2017-2-17
             * templateArcLength : 0.2,0.2,-0.2,0.32,0.2,0.2
             * id : 2c999ae15ebbb1ef015ebbb1ef370000
             * productionUnit : 中铁十四局集团京张高铁管片预制厂
             * templateDiagonal : 0.3,0.3,-0.2,-0.4,-0.2,-0.3
             * manufacturingCode : Ⅰ-1-1-1
             * rebarDiePerson : 李卫东
             * strippingArcLength : 0.0,0.0,0.0,0.0,0.0,0.0
             * templateInnerHeight : 0.6,0.6,-0.2,0.3,0.2,0.4
             * templateWidth : 0.2,-0.3,-0.1,-0.1,-0.04,0.1
             * manufacturingRingCode : Ⅰ-A1-1-1-1-2017-2-17
             * qrPath : uploadFile\2017-09-26\piece\qrImg\A1-1-1-1-2017-2-17.jpg
             * steamCuringPerson : 马达
             * templetNum : 1
             * rebarWeldingPerson : 程伟涛
             * tender : 1
             * part : C
             */

            private String strippingHeight;
            private String pieceType;
            private String pieceStatus;
            private String lineName;
            private String ringNum;
            private int status;
            private int materialFlag;
            private int isDamage;
            private String baitingPerson;
            private String ringWidth;
            private String ringThickness;
            private String designModel;
            private String projectName;
            private String strippingDiagonal;
            private String productionDate;
            private String templateArcLength;
            private String id;
            private String productionUnit;
            private String templateDiagonal;
            private String manufacturingCode;
            private String rebarDiePerson;
            private String strippingArcLength;
            private String templateInnerHeight;
            private String templateWidth;
            private String manufacturingRingCode;
            private String qrPath;
            private String steamCuringPerson;
            private String templetNum;
            private String rebarWeldingPerson;
            private String tender;
            private String part;

            public String getStrippingHeight() {
                return strippingHeight;
            }

            public void setStrippingHeight(String strippingHeight) {
                this.strippingHeight = strippingHeight;
            }

            public String getPieceType() {
                return pieceType;
            }

            public void setPieceType(String pieceType) {
                this.pieceType = pieceType;
            }

            public String getPieceStatus() {
                return pieceStatus;
            }

            public void setPieceStatus(String pieceStatus) {
                this.pieceStatus = pieceStatus;
            }

            public String getLineName() {
                return lineName;
            }

            public void setLineName(String lineName) {
                this.lineName = lineName;
            }

            public String getRingNum() {
                return ringNum;
            }

            public void setRingNum(String ringNum) {
                this.ringNum = ringNum;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getMaterialFlag() {
                return materialFlag;
            }

            public void setMaterialFlag(int materialFlag) {
                this.materialFlag = materialFlag;
            }

            public int getIsDamage() {
                return isDamage;
            }

            public void setIsDamage(int isDamage) {
                this.isDamage = isDamage;
            }

            public String getBaitingPerson() {
                return baitingPerson;
            }

            public void setBaitingPerson(String baitingPerson) {
                this.baitingPerson = baitingPerson;
            }

            public String getRingWidth() {
                return ringWidth;
            }

            public void setRingWidth(String ringWidth) {
                this.ringWidth = ringWidth;
            }

            public String getRingThickness() {
                return ringThickness;
            }

            public void setRingThickness(String ringThickness) {
                this.ringThickness = ringThickness;
            }

            public String getDesignModel() {
                return designModel;
            }

            public void setDesignModel(String designModel) {
                this.designModel = designModel;
            }

            public String getProjectName() {
                return projectName;
            }

            public void setProjectName(String projectName) {
                this.projectName = projectName;
            }

            public String getStrippingDiagonal() {
                return strippingDiagonal;
            }

            public void setStrippingDiagonal(String strippingDiagonal) {
                this.strippingDiagonal = strippingDiagonal;
            }

            public String getProductionDate() {
                return productionDate;
            }

            public void setProductionDate(String productionDate) {
                this.productionDate = productionDate;
            }

            public String getTemplateArcLength() {
                return templateArcLength;
            }

            public void setTemplateArcLength(String templateArcLength) {
                this.templateArcLength = templateArcLength;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getProductionUnit() {
                return productionUnit;
            }

            public void setProductionUnit(String productionUnit) {
                this.productionUnit = productionUnit;
            }

            public String getTemplateDiagonal() {
                return templateDiagonal;
            }

            public void setTemplateDiagonal(String templateDiagonal) {
                this.templateDiagonal = templateDiagonal;
            }

            public String getManufacturingCode() {
                return manufacturingCode;
            }

            public void setManufacturingCode(String manufacturingCode) {
                this.manufacturingCode = manufacturingCode;
            }

            public String getRebarDiePerson() {
                return rebarDiePerson;
            }

            public void setRebarDiePerson(String rebarDiePerson) {
                this.rebarDiePerson = rebarDiePerson;
            }

            public String getStrippingArcLength() {
                return strippingArcLength;
            }

            public void setStrippingArcLength(String strippingArcLength) {
                this.strippingArcLength = strippingArcLength;
            }

            public String getTemplateInnerHeight() {
                return templateInnerHeight;
            }

            public void setTemplateInnerHeight(String templateInnerHeight) {
                this.templateInnerHeight = templateInnerHeight;
            }

            public String getTemplateWidth() {
                return templateWidth;
            }

            public void setTemplateWidth(String templateWidth) {
                this.templateWidth = templateWidth;
            }

            public String getManufacturingRingCode() {
                return manufacturingRingCode;
            }

            public void setManufacturingRingCode(String manufacturingRingCode) {
                this.manufacturingRingCode = manufacturingRingCode;
            }

            public String getQrPath() {
                return qrPath;
            }

            public void setQrPath(String qrPath) {
                this.qrPath = qrPath;
            }

            public String getSteamCuringPerson() {
                return steamCuringPerson;
            }

            public void setSteamCuringPerson(String steamCuringPerson) {
                this.steamCuringPerson = steamCuringPerson;
            }

            public String getTempletNum() {
                return templetNum;
            }

            public void setTempletNum(String templetNum) {
                this.templetNum = templetNum;
            }

            public String getRebarWeldingPerson() {
                return rebarWeldingPerson;
            }

            public void setRebarWeldingPerson(String rebarWeldingPerson) {
                this.rebarWeldingPerson = rebarWeldingPerson;
            }

            public String getTender() {
                return tender;
            }

            public void setTender(String tender) {
                this.tender = tender;
            }

            public String getPart() {
                return part;
            }

            public void setPart(String part) {
                this.part = part;
            }
        }
    }
}
