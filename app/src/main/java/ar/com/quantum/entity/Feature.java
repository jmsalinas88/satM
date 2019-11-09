package ar.com.quantum.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Feature {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String description = null;
    private Integer image = null;

    public Feature() {}

    public Feature(String description, Integer image) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
