package ar.com.quantum.model;

public class Symptom {

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

}
