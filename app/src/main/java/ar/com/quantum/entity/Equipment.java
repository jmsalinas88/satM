package ar.com.quantum.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity
public class Equipment implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String name;
    private String description;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    public byte[] image;
    private String emei;

    public Equipment() {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmei() {
        return emei;
    }

    public void setEmei(String emei) {
        this.emei = emei;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
