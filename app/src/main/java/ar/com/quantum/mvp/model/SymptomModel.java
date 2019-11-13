package ar.com.quantum.mvp.model;

import android.content.Context;
import java.util.List;
import ar.com.quantum.dao.SymptomDaoImpl;
import ar.com.quantum.entity.Feature;
import ar.com.quantum.entity.Symptom;
import ar.com.quantum.mvp.interfaces.ISymptom;

public class SymptomModel extends BaseModel implements ISymptom.Model {

    private ISymptom.Presenter symptomPresenter;

    public SymptomModel(ISymptom.Presenter symptomPresenter, Context context) {
        this.mContext = context;
        this.symptomPresenter = symptomPresenter;
    }

    @Override
    public void showSymptomList(Feature feature) {
        SymptomDaoImpl symptomDao = new SymptomDaoImpl(this.mContext);
        List<Symptom> symptomList = symptomDao.getFeatureSymtomList(feature);
        this.symptomPresenter.showSymptomList(symptomList);
    }
}
