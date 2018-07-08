package com.projetos.anderson.Rest_Spring_Postgres.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetos.anderson.Rest_Spring_Postgres.model.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
	
	List<Answer> findByQuestionId(Long questionId);

}
