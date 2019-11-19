package ar.com.quantum.mvp.model;

import android.content.Context;
import ar.com.quantum.dao.QuestionDaoImpl;
import ar.com.quantum.entity.Question;
import ar.com.quantum.entity.Symptom;
import ar.com.quantum.mvp.interfaces.IQuestion;

public class QuestionModel extends BaseModel implements IQuestion.Model {


    private IQuestion.Presenter presenter;

    public QuestionModel(IQuestion.Presenter presenter, Context context){
        this.mContext = context;
        this.presenter = presenter;
    }


    @Override
    public void showQuestion(Symptom symptom) {
        QuestionDaoImpl questionDao = new QuestionDaoImpl(this.mContext);
        Question question = questionDao.get(symptom);
        this.presenter.showQuestion(question);
    }

    @Override
    public void performAnswer(Question question) {
        QuestionDaoImpl questionDao = new QuestionDaoImpl(this.mContext);
        Question newQuestion = questionDao.get(question);
        this.presenter.showQuestion(newQuestion);
    }
}
