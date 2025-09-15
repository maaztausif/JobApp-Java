package com.maaz.JobApp_Java.service;

import com.maaz.JobApp_Java.model.JobPost;
import com.maaz.JobApp_Java.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo ;




    // Add A job

    public JobPost addJob(JobPost jobPost){
        System.out.println(jobPost);
        System.out.println("=======++++++");
        return repo.save(jobPost);
//        repo.findAll();

//        System.out.println("Add Job in Service");
//
//        repo.addJobs(jobPost);
//        System.out.println(jobPost);

    }

    //Delete A Job
    public String deleteJobList(Integer postId){
         repo.deleteById(postId);
        return "deleted";
    }

    //Get All Job
    public List<JobPost> getAllJobPost(){
//        System.out.println("Get all Job in Service");
//
        return repo.findAll();
    }

    //Get Job By Id
    public JobPost getJob(Integer postId){
        return repo.findById(postId).orElse(new JobPost());
    }

    public JobPost updateJob(JobPost updateJobPost){
        return repo.save(updateJobPost);
    }

    public boolean deleteJobPost(JobPost jobPost){
        repo.delete(jobPost);
         return true;
    }


    //Load Data in a DB
    public String loadData(){
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(

                new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),

                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                        List.of("HTML", "CSS", "JavaScript", "React")),

                new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis")),

                new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                        List.of("Networking", "Cisco", "Routing", "Switching")),

                new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
                        List.of("iOS Development", "Android Development", "Mobile App"))
        ));

        repo.saveAll(jobs);
        return "saved";
    }

    //Searching By Keyword
    public List<JobPost> searchByKeyword(String keyword) {
        return repo.findByPostProfileContainingOrPostDescriptionContainingIgnoreCase(keyword,keyword);
    }


}
