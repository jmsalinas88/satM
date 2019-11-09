package ar.com.quantum.entity;

public class SupportDetail {

    private Long idFeature;
    private Long idSymptom;
    private Long idQuestion;
    private Integer answer;
    private Long idDiagnostic;

    public SupportDetail(){}

    public SupportDetail(Long idFeature, Long idSymptom, Long idQuestion, Integer answer, Long idDiagnostic) {
        this.idFeature = idFeature;
        this.idSymptom = idSymptom;
        this.idQuestion = idQuestion;
        this.answer = answer;
        this.idDiagnostic = idDiagnostic;
    }

    public Long getIdFeature() {
        return idFeature;
    }

    public void setIdFeature(Long idFeature) {
        this.idFeature = idFeature;
    }

    public Long getIdSymptom() {
        return idSymptom;
    }

    public void setIdSymptom(Long idSymptom) {
        this.idSymptom = idSymptom;
    }

    public Long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Long getIdDiagnostic() {
        return idDiagnostic;
    }

    public void setIdDiagnostic(Long idDiagnostic) {
        this.idDiagnostic = idDiagnostic;
    }
}
