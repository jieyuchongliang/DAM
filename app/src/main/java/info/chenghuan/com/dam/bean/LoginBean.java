package info.chenghuan.com.dam.bean;

/**
 * Created by Administrator on 2017/10/26 0026.
 */

public class LoginBean {

    /**
     * message : ok
     * result : true
     * emp : {"account":"zhangsan","createDate":1447084800000,"depFlag":"1","departmentId":"32246","fixedphone":"","id":"151661","idNo":"","loginaccount":"zhangsan","mobile":"13211112222","modifyDate":1502208000000,"name":"张三","password":"96e79218965eb72c92a549dd5a330112","priority":"1.0","proName":"","relatedepId":"14022","sex":"男","useFlag":"1","userlevel":"3","usertype":"2","virtualaccount":"1"}
     */

    private String message;
    private boolean result;
    private EmpBean emp;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public EmpBean getEmp() {
        return emp;
    }

    public void setEmp(EmpBean emp) {
        this.emp = emp;
    }

    public static class EmpBean {
        /**
         * account : zhangsan
         * createDate : 1447084800000
         * depFlag : 1
         * departmentId : 32246
         * fixedphone :
         * id : 151661
         * idNo :
         * loginaccount : zhangsan
         * mobile : 13211112222
         * modifyDate : 1502208000000
         * name : 张三
         * password : 96e79218965eb72c92a549dd5a330112
         * priority : 1.0
         * proName :
         * relatedepId : 14022
         * sex : 男
         * useFlag : 1
         * userlevel : 3
         * usertype : 2
         * virtualaccount : 1
         */

        private String account;
        private long createDate;
        private String depFlag;
        private String departmentId;
        private String fixedphone;
        private String id;
        private String idNo;
        private String loginaccount;
        private String mobile;
        private long modifyDate;
        private String name;
        private String password;
        private String priority;
        private String proName;
        private String relatedepId;
        private String sex;
        private String useFlag;
        private String userlevel;
        private String usertype;
        private String virtualaccount;

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public String getDepFlag() {
            return depFlag;
        }

        public void setDepFlag(String depFlag) {
            this.depFlag = depFlag;
        }

        public String getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
        }

        public String getFixedphone() {
            return fixedphone;
        }

        public void setFixedphone(String fixedphone) {
            this.fixedphone = fixedphone;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIdNo() {
            return idNo;
        }

        public void setIdNo(String idNo) {
            this.idNo = idNo;
        }

        public String getLoginaccount() {
            return loginaccount;
        }

        public void setLoginaccount(String loginaccount) {
            this.loginaccount = loginaccount;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public long getModifyDate() {
            return modifyDate;
        }

        public void setModifyDate(long modifyDate) {
            this.modifyDate = modifyDate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPriority() {
            return priority;
        }

        public void setPriority(String priority) {
            this.priority = priority;
        }

        public String getProName() {
            return proName;
        }

        public void setProName(String proName) {
            this.proName = proName;
        }

        public String getRelatedepId() {
            return relatedepId;
        }

        public void setRelatedepId(String relatedepId) {
            this.relatedepId = relatedepId;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getUseFlag() {
            return useFlag;
        }

        public void setUseFlag(String useFlag) {
            this.useFlag = useFlag;
        }

        public String getUserlevel() {
            return userlevel;
        }

        public void setUserlevel(String userlevel) {
            this.userlevel = userlevel;
        }

        public String getUsertype() {
            return usertype;
        }

        public void setUsertype(String usertype) {
            this.usertype = usertype;
        }

        public String getVirtualaccount() {
            return virtualaccount;
        }

        public void setVirtualaccount(String virtualaccount) {
            this.virtualaccount = virtualaccount;
        }
    }
}
