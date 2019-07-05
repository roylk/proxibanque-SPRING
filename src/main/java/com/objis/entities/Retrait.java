package com.objis.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor
@DiscriminatorValue("R")
public class Retrait extends Operation{public Retrait(Date date, double montant, Compte compte) {
		super(date, montant, compte);
		// TODO Auto-generated constructor stub
	}
	

}
