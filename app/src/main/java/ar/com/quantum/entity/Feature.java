package ar.com.quantum.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Feature {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String description = null;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    public byte[] image;

    public Feature() {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
