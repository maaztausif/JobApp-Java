package com.maaz.JobApp_Java;

import com.maaz.JobApp_Java.model.JobPost;
import com.maaz.JobApp_Java.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class JobController {

        @Autowired
        private JobService service;
        @GetMapping({"/","home"})
        public String home(){
            return "home";
        }

    @GetMapping("viewalljobs")
    public String viewJobs(Model m) {
        List<JobPost> jobs = service.getAllJobPost();
        m.addAttribute("jobPosts", jobs);

        return "viewalljobs";
    }

        @GetMapping("addjob")
        public String addjob(){
            return "addjob";
        }


        @PostMapping("handleForm")
         public String jobPost(JobPost jobPost){
            System.out.println("Job post in JobController where handleform");

            service.addJob(jobPost);
            return "success";
        }

    @GetMapping("handleForm")
    public String handleFormGet() {
        // Agar GET request aayi to crash na ho, sirf redirect ya msg do
        return "redirect:/addjob"; // ya koi safe page
    }
}


