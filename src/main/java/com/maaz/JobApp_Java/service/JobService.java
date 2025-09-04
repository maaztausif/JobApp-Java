package com.maaz.JobApp_Java.service;

import com.maaz.JobApp_Java.model.JobPost;
import com.maaz.JobApp_Java.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo ;

    public void addJob(JobPost jobPost){
        System.out.println("Add Job in Service");

        repo.addJobs(jobPost);
        System.out.println(jobPost);

    }

    public List<JobPost> getAllJobPost(){
        System.out.println("Get all Job in Service");

        return repo.getAllJobPost();
    }
}
