package ar.com.quantum.mvp.model;

import android.content.Context;
import java.util.List;
import ar.com.quantum.dao.FeatureDaoImpl;
import ar.com.quantum.entity.Feature;
import ar.com.quantum.mvp.interfaces.IFeature;
import ar.com.quantum.mvp.presenter.BaseModel;

public class FeatureModel extends BaseModel implements IFeature.Model {

    private IFeature.Presenter presenter;

    public FeatureModel(IFeature.Presenter presenter, Context context) {
        this.presenter = presenter;
        this.mContext = context;
    }

    @Override
    public void showEquipmentFeatureList(Integer equipmentId) {
        FeatureDaoImpl featureDao = new FeatureDaoImpl(this.mContext);
        List<Feature> featureList = featureDao.equipmentFeatureList(equipmentId);
        this.presenter.showEquipmentFeatureList(featureList);
    }
}
