package com.maaz.JobApp_Java;

import com.maaz.JobApp_Java.model.JobPost;
import com.maaz.JobApp_Java.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public String viewJobs(Model m) {
        List<JobPost> jobs = service.getAllJobPost();
        m.addAttribute("jobPosts", jobs);

        return "viewalljobs";
    }

        @GetMapping("addjob")
        @ResponseBody
        public String addjob(){
            return "addjob";
        }


        @PostMapping("handleForm")
        @ResponseBody
        public String jobPost(JobPost jobPost){
            System.out.println("Job post in JobController where handleform");

            service.addJob(jobPost);
            return "success";
        }

        @GetMapping("handleForm")
        @ResponseBody
        public String handleFormGet() {
            // Agar GET request aayi to crash na ho, sirf redirect ya msg do
            return "redirect:/addjob"; // ya koi safe page
        }

        @GetMapping("load")
        @ResponseBody
         public String laodAllData(){
            return service.loadData();
        }
}


