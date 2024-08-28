package com.example.demo.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
  
	
	 private Integer id;
     @NotEmpty
     @Size(min=4,message="Username Must be 4 Characters")
	  private String name;
  @NotNull
     @Email(message="Email address is not valid")
	  private String email;

     @NotNull
     @Size(min=3,max=10,message="password Must be mi of 3chars and max of 10 chars")
	// @Pattern(regexp="") as per pattern we valid   
     private String password;
       @NotNull
	    private String about;
}
