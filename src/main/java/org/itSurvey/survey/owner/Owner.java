package org.itSurvey.survey.owner;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.itSurvey.survey.survey.Survey;

import java.util.List;

@Entity(name = "Owner")
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3,
            message = "Name Should Contain At Least 3 Letters")
    private String name;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Survey> surveys;

    public Owner(Long id, @NotBlank @Size(min = 3,
            message = "Name Should Contain Atleast 3 Letters") String name, List<Survey> surveys) {
        this.id = id;
        this.name = name;
        this.surveys = surveys;
    }

    public Owner() {
    }

    public Long getId() {
        return this.id;
    }

    public @NotBlank @Size(min = 3,
            message = "Name Should Contain Atleast 3 Letters") String getName() {
        return this.name;
    }

    public List<Survey> getSurveys() {
        return this.surveys;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(@NotBlank @Size(min = 3,
            message = "Name Should Contain Atleast 3 Letters") String name) {
        this.name = name;
    }

    public void setSurveys(List<Survey> surveys) {
        this.surveys = surveys;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Owner)) return false;
        final Owner other = (Owner) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$surveys = this.getSurveys();
        final Object other$surveys = other.getSurveys();
        if (this$surveys == null ? other$surveys != null : !this$surveys.equals(other$surveys)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Owner;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $surveys = this.getSurveys();
        result = result * PRIME + ($surveys == null ? 43 : $surveys.hashCode());
        return result;
    }

    public String toString() {
        return "Owner(id=" + this.getId() + ", name=" + this.getName() + ", surveys=" + this.getSurveys() + ")";
    }
}
