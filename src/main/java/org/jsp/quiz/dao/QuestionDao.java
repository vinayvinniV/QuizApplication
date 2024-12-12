package org.jsp.quiz.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.quiz.entity.Question;

public interface QuestionDao {

	Question saveQuestion(Question question);

	List<Question> findAllQusetions();

	Optional<Question> findQuestionById(int id);

	List<Question> findAllActiveQusetions();

	List<Question> takeQuiz();

}
