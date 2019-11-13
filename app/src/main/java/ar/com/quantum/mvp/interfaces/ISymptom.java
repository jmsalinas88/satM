package ar.com.quantum.mvp.interfaces;

import java.util.List;
import ar.com.quantum.entity.Feature;
import ar.com.quantum.entity.Symptom;

public interface ISymptom {

    interface  Model{
        void showSymptomList(Feature feature);
    }

    interface  View {
        void showSymptomList(List<Symptom> symptomList);
    }

    interface Presenter{
        void showSymptomList(List<Symptom> symptomList);
        void showSymptomList(Feature feature);
    }
}
