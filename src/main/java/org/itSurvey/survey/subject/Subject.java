package org.itSurvey.survey.subject;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.itSurvey.survey.surveyEdition.SurveyEdition;
import org.itSurvey.survey.question.Question;

import java.util.ArrayList;
import java.util.List;

@Table(name = "subjects")
@Entity(name = "Subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 6,
            message = "Title Should Contain at Least 6 Letters")
    private String title;

    @ManyToOne
    @JoinColumn(name = "survey_edition_id")
    private SurveyEdition surveyEdition;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_subject")
    private Subject parentSubject;

    @OneToMany(mappedBy = "parentSubject", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Subject> subjects = new ArrayList<>();

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question> questions = new ArrayList<>();

    public Subject(Long id, @NotBlank @Size(min = 6,
            message = "Title Should Contain at Least 6 Letters") String title, SurveyEdition surveyEdition, Subject parentSubject, List<Subject> subjects, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.surveyEdition = surveyEdition;
        this.parentSubject = parentSubject;
        this.subjects = subjects;
        this.questions = questions;
    }

    public Subject() {
    }

    public Long getId() {
        return this.id;
    }

    public @NotBlank @Size(min = 6,
            message = "Title Should Contain at Least 6 Letters") String getTitle() {
        return this.title;
    }

    public SurveyEdition getSurveyEdition() {
        return this.surveyEdition;
    }

    public Subject getParentSubject() {
        return this.parentSubject;
    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }

    public List<Question> getQuestions() {
        return this.questions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(@NotBlank @Size(min = 6,
            message = "Title Should Contain at Least 6 Letters") String title) {
        this.title = title;
    }

    public void setSurveyEdition(SurveyEdition surveyEdition) {
        this.surveyEdition = surveyEdition;
    }

    public void setParentSubject(Subject parentSubject) {
        this.parentSubject = parentSubject;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Subject)) return false;
        final Subject other = (Subject) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$surveyEdition = this.getSurveyEdition();
        final Object other$surveyEdition = other.getSurveyEdition();
        if (this$surveyEdition == null ? other$surveyEdition != null : !this$surveyEdition.equals(other$surveyEdition))
            return false;
        final Object this$parentSubject = this.getParentSubject();
        final Object other$parentSubject = other.getParentSubject();
        if (this$parentSubject == null ? other$parentSubject != null : !this$parentSubject.equals(other$parentSubject))
            return false;
        final Object this$subjects = this.getSubjects();
        final Object other$subjects = other.getSubjects();
        if (this$subjects == null ? other$subjects != null : !this$subjects.equals(other$subjects)) return false;
        final Object this$questions = this.getQuestions();
        final Object other$questions = other.getQuestions();
        if (this$questions == null ? other$questions != null : !this$questions.equals(other$questions)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Subject;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $surveyEdition = this.getSurveyEdition();
        result = result * PRIME + ($surveyEdition == null ? 43 : $surveyEdition.hashCode());
        final Object $parentSubject = this.getParentSubject();
        result = result * PRIME + ($parentSubject == null ? 43 : $parentSubject.hashCode());
        final Object $subjects = this.getSubjects();
        result = result * PRIME + ($subjects == null ? 43 : $subjects.hashCode());
        final Object $questions = this.getQuestions();
        result = result * PRIME + ($questions == null ? 43 : $questions.hashCode());
        return result;
    }

    public String toString() {
        return "Subject(id=" + this.getId() + ", title=" + this.getTitle() + ", surveyEdition=" + this.getSurveyEdition() + ", parentSubject=" + this.getParentSubject() + ", subjects=" + this.getSubjects() + ", questions=" + this.getQuestions() + ")";
    }
}
