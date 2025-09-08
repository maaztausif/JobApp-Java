package com.maaz.JobApp_Java.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Scope("prototype")
@Entity
public class JobPost {

    @Id
    private int postId;
    private String postProfile;
    private String postDescription;
    private Integer reqExp;
//    @ElementCollection
    private List<String> postTechStack;
}
