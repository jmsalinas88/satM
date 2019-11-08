package ar.com.quantum.entity;

public class Province {

    private Integer id;
    private String isoId;
    private String description;

    public  Province(){}

    public  Province(String description){
        this.description = description;
    }

    public Province(Integer id, String isoId, String description) {
        this.id = id;
        this.isoId = isoId;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsoId() {
        return isoId;
    }

    public void setIsoId(String isoId) {
        this.isoId = isoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
