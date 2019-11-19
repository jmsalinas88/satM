package ar.com.quantum.entity;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;


public class Equipment implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private String image;
    private String imei;
    private Map<Integer, Feature> features;
    private User user;

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

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Map<Integer, Feature> getFeatures() {
        return features;
    }

    public void setFeatures(Map<Integer, Feature> features) {
        this.features = features;
    }

    public void addFeature(Feature feature){
        if(this.features == null)
        {
            this.features = new TreeMap<>();
        }
        this.features.put(feature.getId(), feature);
    }
}
