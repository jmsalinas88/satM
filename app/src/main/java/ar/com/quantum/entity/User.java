package ar.com.quantum.entity;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class User{

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private Integer provinceId;
    private Integer equipmentId;
    private String namne;
    private String surname;
    private String email;
    private String phoneNumber;
    private String emei;

    public User(){}

    public String getNamne() {
        return namne;
    }

    public void setNamne(String namne) {
        this.namne = namne;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEmei() {
        return emei;
    }

    public void setEmei(String emei) {
        this.emei = emei;
    }
}
