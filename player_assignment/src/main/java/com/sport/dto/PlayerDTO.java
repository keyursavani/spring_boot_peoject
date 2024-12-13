package com.sport.dto;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.sport.pojos.SportType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PlayerDTO {
	@JsonProperty(access = Access.READ_ONLY)
	Long id;
	@NotBlank(message = "Name must be supplied !")
	String name;
	@NotNull	(message = "Sport type must be supplied !")
	SportType sportType;
	@NotNull(message = "Contact number must be supplied !")
	BigInteger contactNumber;
	@NotBlank(message = "Email must be supplied !")
	@Email(message = "Invalid Email format")
	String email;
	@NotBlank(message = "Address must be supplied !")
	String address;
	@NotNull(message = "Sport point must be supplied !")
	int sportPoints;
}
