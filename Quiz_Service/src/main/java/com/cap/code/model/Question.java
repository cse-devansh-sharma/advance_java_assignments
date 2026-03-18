package com.cap.code.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

	private Long questionId;
	private String question;
	private Long quizId;

}
