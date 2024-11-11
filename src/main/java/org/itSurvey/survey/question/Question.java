package org.itSurvey.survey.question;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.itSurvey.survey.answer.Answer;
import org.itSurvey.survey.subject.Subject;
import org.itSurvey.survey.utils.enums.QuestionType;

import java.util.List;

@Entity(name = "Question")
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String text;

    private Integer answerCount;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;

    public Question(Long id, @NotBlank String text, Integer answerCount, QuestionType questionType, Subject subject, List<Answer> answers) {
        this.id = id;
        this.text = text;
        this.answerCount = answerCount;
        this.questionType = questionType;
        this.subject = subject;
        this.answers = answers;
    }

    public Question() {
    }

    public Long getId() {
        return this.id;
    }

    public @NotBlank String getText() {
        return this.text;
    }

    public Integer getAnswerCount() {
        return this.answerCount;
    }

    public QuestionType getQuestionType() {
        return this.questionType;
    }

    public Subject getSubject() {
        return this.subject;
    }

    public List<Answer> getAnswers() {
        return this.answers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(@NotBlank String text) {
        this.text = text;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Question)) return false;
        final Question other = (Question) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$text = this.getText();
        final Object other$text = other.getText();
        if (this$text == null ? other$text != null : !this$text.equals(other$text)) return false;
        final Object this$answerCount = this.getAnswerCount();
        final Object other$answerCount = other.getAnswerCount();
        if (this$answerCount == null ? other$answerCount != null : !this$answerCount.equals(other$answerCount))
            return false;
        final Object this$questionType = this.getQuestionType();
        final Object other$questionType = other.getQuestionType();
        if (this$questionType == null ? other$questionType != null : !this$questionType.equals(other$questionType))
            return false;
        final Object this$subject = this.getSubject();
        final Object other$subject = other.getSubject();
        if (this$subject == null ? other$subject != null : !this$subject.equals(other$subject)) return false;
        final Object this$answers = this.getAnswers();
        final Object other$answers = other.getAnswers();
        if (this$answers == null ? other$answers != null : !this$answers.equals(other$answers)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Question;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $text = this.getText();
        result = result * PRIME + ($text == null ? 43 : $text.hashCode());
        final Object $answerCount = this.getAnswerCount();
        result = result * PRIME + ($answerCount == null ? 43 : $answerCount.hashCode());
        final Object $questionType = this.getQuestionType();
        result = result * PRIME + ($questionType == null ? 43 : $questionType.hashCode());
        final Object $subject = this.getSubject();
        result = result * PRIME + ($subject == null ? 43 : $subject.hashCode());
        final Object $answers = this.getAnswers();
        result = result * PRIME + ($answers == null ? 43 : $answers.hashCode());
        return result;
    }

    public String toString() {
        return "Question(id=" + this.getId() + ", text=" + this.getText() + ", answerCount=" + this.getAnswerCount() + ", questionType=" + this.getQuestionType() + ", subject=" + this.getSubject() + ", answers=" + this.getAnswers() + ")";
    }

    // Add constructors, getters, and setters
} 