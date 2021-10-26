package entity;

public class TaxSource {
    private Integer id;
    private Integer payerId;
    private String taskName;
    private Integer subOrganId;
    private String organName;
    private String payerCode;
    private  String payerName;
    private String bizScope;
    private Integer approverId;
    private Integer executeId;
    private String executeTime;
    private String taskFrom;
    private String taskState;
    private String idea;
    private Integer riskLevel;
    private String recordTaskDate;
    private Integer recordUserId;
    private String industryName;
    private int timeOut;
    private Integer removeState = 0;
    public TaxSource() {
        super();
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public TaxSource(Integer id, Integer payerId, String taskName, Integer subOrganId, String organName, String payerCode, String payerName, String bizScope, Integer approverId, Integer executeId, String executeTime, String taskFrom, String taskState, String idea, Integer riskLevel, String recordTaskDate, Integer recordUserId, String industryName, Integer removeState) {
        this.id = id;
        this.payerId = payerId;
        this.taskName = taskName;
        this.subOrganId = subOrganId;
        this.organName = organName;
        this.payerCode = payerCode;
        this.payerName = payerName;
        this.bizScope = bizScope;
        this.approverId = approverId;
        this.executeId = executeId;
        this.executeTime = executeTime;
        this.taskFrom = taskFrom;
        this.taskState = taskState;
        this.idea = idea;
        this.riskLevel = riskLevel;
        this.recordTaskDate = recordTaskDate;
        this.recordUserId = recordUserId;
        this.industryName = industryName;
        this.removeState = removeState;
    }

    public String getOrganName() {
        return organName;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getPayerCode() {
        return payerCode;
    }

    public void setPayerCode(String payerCode) {
        this.payerCode = payerCode;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }

    public TaxSource(Integer id, Integer payerId, String taskName, Integer subOrganId, String organName, String payerCode, String payerName, String bizScope, Integer approverId, Integer executeId, String executeTime, String taskFrom, String taskState, String idea, Integer riskLevel, String recordTaskDate, Integer recordUserId, Integer removeState) {
        this.id = id;
        this.payerId = payerId;
        this.taskName = taskName;
        this.subOrganId = subOrganId;
        this.organName = organName;
        this.payerCode = payerCode;
        this.payerName = payerName;
        this.bizScope = bizScope;
        this.approverId = approverId;
        this.executeId = executeId;
        this.executeTime = executeTime;
        this.taskFrom = taskFrom;
        this.taskState = taskState;
        this.idea = idea;
        this.riskLevel = riskLevel;
        this.recordTaskDate = recordTaskDate;
        this.recordUserId = recordUserId;
        this.removeState = removeState;
    }

    public TaxSource(Integer id, Integer payerId, String taskName,
                     Integer subOrganId, Integer approverId, Integer executeId,
                     String executeTime, String taskFrom, String taskState, String idea,
                     Integer riskLevel, String recordTaskDate, Integer recordUserID,
                     Integer removeState) {
        super();
        this.id = id;
        this.payerId = payerId;
        this.taskName = taskName;
        this.subOrganId = subOrganId;
        this.approverId = approverId;
        this.executeId = executeId;
        this.executeTime = executeTime;
        this.taskFrom = taskFrom;
        this.taskState = taskState;
        this.idea = idea;
        this.riskLevel = riskLevel;
        this.recordTaskDate = recordTaskDate;
        this.recordUserId = recordUserId;
        this.removeState = removeState;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPayerId() {
        return payerId;
    }
    public void setPayerId(Integer payerId) {
        this.payerId = payerId;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public Integer getSubOrganId() {
        return subOrganId;
    }
    public void setSubOrganId(Integer subOrganId) {
        this.subOrganId = subOrganId;
    }
    public Integer getApproverId() {
        return approverId;
    }
    public void setApproverId(Integer approverId) {
        this.approverId = approverId;
    }
    public Integer getExecuteId() {
        return executeId;
    }
    public void setExecuteId(Integer executeId) {
        this.executeId = executeId;
    }
    public String getExecuteTime() {
        return executeTime;
    }
    public void setExecuteTime(String executeTime) {
        this.executeTime = executeTime;
    }
    public String getTaskFrom() {
        return taskFrom;
    }
    public void setTaskFrom(String taskFrom) {
        this.taskFrom = taskFrom;
    }
    public String getTaskState() {
        return taskState;
    }
    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }
    public String getIdea() {
        return idea;
    }
    public void setIdea(String idea) {
        this.idea = idea;
    }
    public Integer getRiskLevel() {
        return riskLevel;
    }
    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }
    public String getRecordTaskDate() {
        return recordTaskDate;
    }
    public void setRecordTaskDate(String recordTaskDate) {
        this.recordTaskDate = recordTaskDate;
    }
    public Integer getRecordUserId() {
        return recordUserId;
    }
    public void setRecordUserId(Integer recordUserId) {
        this.recordUserId = recordUserId;
    }
    public Integer getRemoveState() {
        return removeState;
    }
    public void setRemoveState(Integer removeState) {
        this.removeState = removeState;
    }

    @Override
    public String toString() {
        return "TaxSource{" +
                "id=" + id +
                ", payerId=" + payerId +
                ", taskName='" + taskName + '\'' +
                ", subOrganId=" + subOrganId +
                ", organName='" + organName + '\'' +
                ", payerCode='" + payerCode + '\'' +
                ", payerName='" + payerName + '\'' +
                ", bizScope='" + bizScope + '\'' +
                ", approverId=" + approverId +
                ", executeId=" + executeId +
                ", executeTime='" + executeTime + '\'' +
                ", taskFrom='" + taskFrom + '\'' +
                ", taskState='" + taskState + '\'' +
                ", idea='" + idea + '\'' +
                ", riskLevel=" + riskLevel +
                ", recordTaskDate='" + recordTaskDate + '\'' +
                ", recordUserId=" + recordUserId +
                ", industryName='" + industryName + '\'' +
                ", timeOut=" + timeOut +
                ", removeState=" + removeState +
                '}';
    }
}
