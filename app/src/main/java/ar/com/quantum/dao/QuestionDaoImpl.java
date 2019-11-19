package ar.com.quantum.dao;

import android.content.Context;
import java.util.List;
import ar.com.quantum.entity.Question;
import ar.com.quantum.entity.Symptom;

public class QuestionDaoImpl extends BaseDao<Question> implements IDao<Question> {


    public QuestionDaoImpl(Context context) {
        super(context);
    }

    @Override
    public boolean insert(Question entity) {
        return false;
    }

    @Override
    public Question get(Integer id) {
        return null;
    }

    @Override
    public Boolean update(Question entity) {
        return null;
    }

    @Override
    public Boolean delete(Question entity) {
        return null;
    }

    @Override
    public List<Question> getAll() {
        return null;
    }

    public Question get(Symptom symptom) {

        Question question = new Question();
        question.setText("¿La bateria dura mas de cuatro horas?");
        question.setYes("P");
        question.setNo("P");

        return question;
    }

    public Question get(Question Question) {

        Question q = new Question();
        q.setText("¿La bateria dura mas de cuatro horas FFFF ?");
        q.setYes("P");
        q.setNo("P");

        return q;
    }


}
