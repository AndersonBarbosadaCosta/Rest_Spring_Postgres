package com.projetos.anderson.Rest_Spring_Postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetos.anderson.Rest_Spring_Postgres.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

}
