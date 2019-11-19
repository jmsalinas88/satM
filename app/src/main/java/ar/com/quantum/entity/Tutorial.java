package ar.com.quantum.entity;

import java.io.Serializable;

public class Tutorial implements Serializable {

    private String title = null;

    public Tutorial() {}

    public Tutorial(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
