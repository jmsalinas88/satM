package ar.com.quantum.entity;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class User{

    @PrimaryKey(autoGenerate = true)
    private Long id;
    @Ignore
    private Province province;
    private Long provinceId;
    @Ignore
    private Equipment equipment;
    private Long equipmentId;
    private String namne;
    private String surname;
    private String email;
    private String phoneNumber;


    public User(){}

    public User(Province province, Equipment equipment, String namne, String surname, String email, String phoneNumber) {
        this.province = province;
        this.equipment = equipment;
        this.namne = namne;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

}
