package Entity;

import javax.persistence.*;

@Entity
@Table(name = "evaluation_classes", schema = "public", catalog = "Gestionscolaire")
public class EvaluationClasses {
    private long id;
    private Long classebyidclasseIdClasse;
    private Long evaluationbyevaluationidevaluationIdEvaluation;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "classebyidclasse_id_classe")
    public Long getClassebyidclasseIdClasse() {
        return classebyidclasseIdClasse;
    }

    public void setClassebyidclasseIdClasse(Long classebyidclasseIdClasse) {
        this.classebyidclasseIdClasse = classebyidclasseIdClasse;
    }

    @Basic
    @Column(name = "evaluationbyevaluationidevaluation_id_evaluation")
    public Long getEvaluationbyevaluationidevaluationIdEvaluation() {
        return evaluationbyevaluationidevaluationIdEvaluation;
    }

    public void setEvaluationbyevaluationidevaluationIdEvaluation(Long evaluationbyevaluationidevaluationIdEvaluation) {
        this.evaluationbyevaluationidevaluationIdEvaluation = evaluationbyevaluationidevaluationIdEvaluation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluationClasses that = (EvaluationClasses) o;

        if (id != that.id) return false;
        if (classebyidclasseIdClasse != null ? !classebyidclasseIdClasse.equals(that.classebyidclasseIdClasse) : that.classebyidclasseIdClasse != null)
            return false;
        if (evaluationbyevaluationidevaluationIdEvaluation != null ? !evaluationbyevaluationidevaluationIdEvaluation.equals(that.evaluationbyevaluationidevaluationIdEvaluation) : that.evaluationbyevaluationidevaluationIdEvaluation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (classebyidclasseIdClasse != null ? classebyidclasseIdClasse.hashCode() : 0);
        result = 31 * result + (evaluationbyevaluationidevaluationIdEvaluation != null ? evaluationbyevaluationidevaluationIdEvaluation.hashCode() : 0);
        return result;
    }
}
