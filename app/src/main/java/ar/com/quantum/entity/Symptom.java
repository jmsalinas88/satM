package ar.com.quantum.entity;

public class Symptom {

    private Integer id;
    private String description = null;

    public Symptom() {}

    public Symptom(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
