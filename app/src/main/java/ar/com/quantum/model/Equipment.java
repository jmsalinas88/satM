package ar.com.quantum.model;

public class Equipment {

    private String name = null;
    private String description = null;
    private Integer image = null;

    public Equipment() {}

    public Equipment(String name, String description, Integer image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
