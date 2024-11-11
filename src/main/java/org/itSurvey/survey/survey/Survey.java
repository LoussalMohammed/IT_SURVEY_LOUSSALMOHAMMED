package org.itSurvey.survey.survey;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.itSurvey.survey.owner.Owner;
import org.itSurvey.survey.surveyEdition.SurveyEdition;

import java.util.List;

@Entity(name = "Survey")
@Table(name = "surveys")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 6,
            message = "Title Should Contain at Least 6 Letters")
    private String title;

    @NotBlank
    @Size(max = 550
            , min = 10, message = "Description Size Should Be Between 100 and 550")
    private String description;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SurveyEdition> surveyEditions;

    public Survey(Long id, @NotBlank @Size(min = 6,
            message = "Title Should Contain at Least 6 Letters") String title, @NotBlank @Size(max = 550
            , min = 10, message = "Description Size Should Be Between 100 and 550") String description, Owner owner, List<SurveyEdition> surveyEditions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.surveyEditions = surveyEditions;
    }

    public Survey() {
    }

    public Long getId() {
        return this.id;
    }

    public @NotBlank @Size(min = 6,
            message = "Title Should Contain at Least 6 Letters") String getTitle() {
        return this.title;
    }

    public @NotBlank @Size(max = 550
            , min = 10, message = "Description Size Should Be Between 100 and 550") String getDescription() {
        return this.description;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public List<SurveyEdition> getSurveyEditions() {
        return this.surveyEditions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(@NotBlank @Size(min = 6,
            message = "Title Should Contain at Least 6 Letters") String title) {
        this.title = title;
    }

    public void setDescription(@NotBlank @Size(max = 550
            , min = 10, message = "Description Size Should Be Between 100 and 550") String description) {
        this.description = description;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setSurveyEditions(List<SurveyEdition> surveyEditions) {
        this.surveyEditions = surveyEditions;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Survey)) return false;
        final Survey other = (Survey) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$owner = this.getOwner();
        final Object other$owner = other.getOwner();
        if (this$owner == null ? other$owner != null : !this$owner.equals(other$owner)) return false;
        final Object this$surveyEditions = this.getSurveyEditions();
        final Object other$surveyEditions = other.getSurveyEditions();
        if (this$surveyEditions == null ? other$surveyEditions != null : !this$surveyEditions.equals(other$surveyEditions))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Survey;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $owner = this.getOwner();
        result = result * PRIME + ($owner == null ? 43 : $owner.hashCode());
        final Object $surveyEditions = this.getSurveyEditions();
        result = result * PRIME + ($surveyEditions == null ? 43 : $surveyEditions.hashCode());
        return result;
    }

    public String toString() {
        return "Survey(id=" + this.getId() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", owner=" + this.getOwner() + ", surveyEditions=" + this.getSurveyEditions() + ")";
    }
}
