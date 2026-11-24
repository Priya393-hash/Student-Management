
//ye DTO hai i mean jo user ne maaga wahi return kare ga pura data nahi isliye skill and name likhe hai
package com.example.demo.dto;

public class StudentResponse {
    private String skill;
    private String name;

    public StudentResponse(String name, String skill){
        this.name=name;
        this.skill=skill;
    }
    public String getName(){
        return name;
    }
    public String getSkill(){
        return skill;
    }
}
