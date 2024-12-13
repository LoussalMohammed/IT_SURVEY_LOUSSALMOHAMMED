package org.itSurvey.survey.answer;

import jakarta.persistence.*;
import org.itSurvey.survey.question.Question;

// Answer

@Entity(name = "Answer")
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private Integer selectionCount;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer(Long id, String text, Integer selectionCount, Question question) {
        this.id = id;
        this.text = text;
        this.selectionCount = selectionCount;
        this.question = question;
    }

    public Answer() {
    }

    public Long getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public Integer getSelectionCount() {
        return this.selectionCount;
    }

    public Question getQuestion() {
        return this.question;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSelectionCount(Integer selectionCount) {
        this.selectionCount = selectionCount;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Answer)) return false;
        final Answer other = (Answer) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$text = this.getText();
        final Object other$text = other.getText();
        if (this$text == null ? other$text != null : !this$text.equals(other$text)) return false;
        final Object this$selectionCount = this.getSelectionCount();
        final Object other$selectionCount = other.getSelectionCount();
        if (this$selectionCount == null ? other$selectionCount != null : !this$selectionCount.equals(other$selectionCount))
            return false;
        final Object this$question = this.getQuestion();
        final Object other$question = other.getQuestion();
        if (this$question == null ? other$question != null : !this$question.equals(other$question)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Answer;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $text = this.getText();
        result = result * PRIME + ($text == null ? 43 : $text.hashCode());
        final Object $selectionCount = this.getSelectionCount();
        result = result * PRIME + ($selectionCount == null ? 43 : $selectionCount.hashCode());
        final Object $question = this.getQuestion();
        result = result * PRIME + ($question == null ? 43 : $question.hashCode());
        return result;
    }

    public String toString() {
        return "Answer(id=" + this.getId() + ", text=" + this.getText() + ", selectionCount=" + this.getSelectionCount() + ", question=" + this.getQuestion() + ")";
    }
}