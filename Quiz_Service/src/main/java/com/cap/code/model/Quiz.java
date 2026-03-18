package com.cap.code.model;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  Long id;
	private String title;
	
	
	transient private List<Question> questions;

}
