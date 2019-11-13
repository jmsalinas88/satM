package ar.com.quantum.mvp.presenter;

import android.content.Context;
import java.util.List;
import ar.com.quantum.entity.Feature;
import ar.com.quantum.entity.Symptom;
import ar.com.quantum.mvp.interfaces.ISymptom;
import ar.com.quantum.mvp.model.SymptomModel;

public class SymptomPresenter extends BasePresenter implements ISymptom.Presenter {

    private ISymptom.Model symptomModel;
    private ISymptom.View symptomView;


    public SymptomPresenter(ISymptom.View symptomView, Context context) {
        this.mContext = context;
        this.symptomView = symptomView;
        this.symptomModel = new SymptomModel(this, context);
    }

    @Override
    public void showSymptomList(List<Symptom> symptomList) {
        this.symptomView.showSymptomList(symptomList);
    }

    @Override
    public void showSymptomList(Feature feature) {
        this.symptomModel.showSymptomList(feature);
    }
}
