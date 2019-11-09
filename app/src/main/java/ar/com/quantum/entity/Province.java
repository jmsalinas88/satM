package ar.com.quantum.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Province {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String description;

    public  Province(){}

    public  Province(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
