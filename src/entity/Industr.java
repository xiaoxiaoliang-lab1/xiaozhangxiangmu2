package entity;

public class Industr {
    private Integer id;
    private String industryName;
    private String recordDate;
    private Integer recordUserId;

    public Industr(Integer id, String industryName, String recordDate, Integer recordUserId) {
        this.id = id;
        this.industryName = industryName;
        this.recordDate = recordDate;
        this.recordUserId = recordUserId;
    }

    public Industr() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public Integer getRecordUserId() {
        return recordUserId;
    }

    public void setRecordUserId(Integer recordUserId) {
        this.recordUserId = recordUserId;
    }

    @Override
    public String toString() {
        return "Industr{" +
                "id=" + id +
                ", industryName='" + industryName + '\'' +
                ", recordDate='" + recordDate + '\'' +
                ", recordUserId=" + recordUserId +
                '}';
    }
}
