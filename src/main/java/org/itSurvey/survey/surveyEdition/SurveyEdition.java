package org.itSurvey.survey.surveyEdition;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.itSurvey.survey.subject.Subject;
import org.itSurvey.survey.survey.Survey;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "SurvetEdition")
@Table(name = "survetEditions")
public class SurveyEdition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private LocalDate startDate;

    @NotNull
    @Column(name = "year")
    private int year;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @OneToMany(mappedBy = "surveyEdition", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Subject> subjects;


    public SurveyEdition(Long id, LocalDate creationDate, LocalDate startDate, @NotNull int year, Survey survey, List<Subject> subjects) {
        this.id = id;
        this.creationDate = creationDate;
        this.startDate = startDate;
        this.year = year;
        this.survey = survey;
        this.subjects = subjects;
    }

    public SurveyEdition() {
    }

    public Long getId() {
        return this.id;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public @NotNull int getYear() {
        return this.year;
    }

    public Survey getSurvey() {
        return this.survey;
    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setYear(@NotNull int year) {
        this.year = year;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof SurveyEdition)) return false;
        final SurveyEdition other = (SurveyEdition) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$creationDate = this.getCreationDate();
        final Object other$creationDate = other.getCreationDate();
        if (this$creationDate == null ? other$creationDate != null : !this$creationDate.equals(other$creationDate))
            return false;
        final Object this$startDate = this.getStartDate();
        final Object other$startDate = other.getStartDate();
        if (this$startDate == null ? other$startDate != null : !this$startDate.equals(other$startDate)) return false;
        if (this.getYear() != other.getYear()) return false;
        final Object this$survey = this.getSurvey();
        final Object other$survey = other.getSurvey();
        if (this$survey == null ? other$survey != null : !this$survey.equals(other$survey)) return false;
        final Object this$subjects = this.getSubjects();
        final Object other$subjects = other.getSubjects();
        if (this$subjects == null ? other$subjects != null : !this$subjects.equals(other$subjects)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SurveyEdition;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $creationDate = this.getCreationDate();
        result = result * PRIME + ($creationDate == null ? 43 : $creationDate.hashCode());
        final Object $startDate = this.getStartDate();
        result = result * PRIME + ($startDate == null ? 43 : $startDate.hashCode());
        result = result * PRIME + this.getYear();
        final Object $survey = this.getSurvey();
        result = result * PRIME + ($survey == null ? 43 : $survey.hashCode());
        final Object $subjects = this.getSubjects();
        result = result * PRIME + ($subjects == null ? 43 : $subjects.hashCode());
        return result;
    }

    public String toString() {
        return "SurveyEdition(id=" + this.getId() + ", creationDate=" + this.getCreationDate() + ", startDate=" + this.getStartDate() + ", year=" + this.getYear() + ", survey=" + this.getSurvey() + ", subjects=" + this.getSubjects() + ")";
    }
}
