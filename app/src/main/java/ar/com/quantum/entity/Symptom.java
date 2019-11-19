package ar.com.quantum.entity;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class Symptom implements Serializable {

    private Integer id;
    private String description;
    private Map<Integer, Question> questions;

    public Symptom() {}

    public Symptom(String description) {
        this.description = description;
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

    public Map<Integer, Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Map<Integer, Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Integer id, Question question){
        if(this.questions == null){
            this.questions = new TreeMap<>();
        }
        this.questions.put(id, question);
    }

}
