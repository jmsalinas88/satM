package ar.com.quantum.entity;

import java.io.Serializable;
import java.util.List;

public class Feature implements Serializable {

    private Integer id;
    private String description = null;
    private String image;
    private List<Symptom> symptoms;

    public Feature() {}

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

}
