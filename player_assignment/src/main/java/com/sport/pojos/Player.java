package com.sport.pojos;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "player")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(nullable = false, length = 30)
	String name;
	@Enumerated(EnumType.STRING)
	@Column(name = "sport_type", nullable = false, length = 30)
	SportType sportType;
	@Column(name = "contact_number",length = 15,nullable = false)
	BigInteger contactNumber;
	@Column(length = 20,nullable = false)
	String email;
	@Column(length = 30 , nullable = false)
	String address;
	@Column(name = "sport_point",nullable = false)
	int sportPoints;
}
