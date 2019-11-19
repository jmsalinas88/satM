package ar.com.quantum.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Feature implements Serializable {

    private Integer id;
    private String description = null;
    private String image;
    private Map<Integer, Symptom> symptoms;

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

    public Map<Integer, Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Map<Integer, Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public void addSymptom(Symptom symptom){
        if(this.symptoms == null)
        {
            this.symptoms = new TreeMap<>();
        }
        this.symptoms.put(symptom.getId(), symptom);
    }
}
