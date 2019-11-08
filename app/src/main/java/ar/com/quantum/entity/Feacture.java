package ar.com.quantum.entity;

public class Feacture {

    private String description = null;
    private Integer image = null;

    public Feacture() {}

    public Feacture(String description, Integer image) {
        this.description = description;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
