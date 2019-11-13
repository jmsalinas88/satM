package ar.com.quantum.entity;


import java.io.Serializable;

public class Province implements Serializable {

    private Integer id;
    private String description;

    public  Province(){}

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
