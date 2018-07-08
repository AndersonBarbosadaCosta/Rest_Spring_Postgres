package com.projetos.anderson.Rest_Spring_Postgres.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetos.anderson.Rest_Spring_Postgres.exception.ResourceNotFoundException;
import com.projetos.anderson.Rest_Spring_Postgres.model.Question;
import com.projetos.anderson.Rest_Spring_Postgres.repository.QuestionRepository;

@RestController

public class QuestionController {

	@Autowired
	private QuestionRepository repository;

	@GetMapping("/questions")
	public Page<Question> getQuestions(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@PostMapping("/questions")
	public Question createQuestion(@Valid @RequestBody Question question) {
		return repository.save(question);

	}

@PutMapping("/questions/{questionId}")
public Question updateQuestion(@PathVariable Long questionId,@Valid @RequestBody Question questionRequest) {
	
	return repository.findById(questionId)
			.map(question ->{
				question.setTitle(questionRequest.getTitle());
				question.setDescription(questionRequest.getDescription());
				return repository.save(question);
			}).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));

	
}

@DeleteMapping("/questions/{questionId}")
public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
    return repository.findById(questionId)
            .map(question -> {
            	repository.delete(question);
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
}







}
