package com.example.demo.entity;

//checking validation 
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Max;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
//import jakarta.validation.constraints.PositiveOrZero;

@Entity 
public class Student {

    @NotBlank(message = "Name is required") 
    @Size(min = 3,max = 20) 
    private String name;

    @NotNull(message = "Skill must be not Null")  
    @Pattern(regexp = "^[A-Za-z]+$")
    private String skill;

    @Min(value = 18, message = "Age must be at least 18") 
    @Max(60)
    @Positive 
    
    private String age;

    @Email(message = "Please enter a valid email")
    private String email;

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    public Student(){
        
    }

    public Student(String name, String Skill, String age, String email,Long id){
        this.name = name;
        this.skill = Skill;
        this.age = age;
        this.email = email;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public String getSkill(){
        return skill;
    }
    public String getAge(){
        return age;
    }
    public String getEmail(){
        return email;
    }
    public Long getId(){
        return id;
    }
    public Long setId(Long id) {
        return id;
    }
}
