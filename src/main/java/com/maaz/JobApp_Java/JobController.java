package com.maaz.JobApp_Java;

import com.maaz.JobApp_Java.model.JobPost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class JobController {


        @GetMapping({"/","home"})
        public String home(){
            return "home";
        }

        @GetMapping("viewalljobs")
        public String viewalljobs(){
            return "viewalljobs";
        }

        @GetMapping("addjob")
        public String addjob(){
            return "addjob";
        }

//        @RequestMapping("success")
//        public String success(){
//            return "success";
//        }

        @PostMapping("handleForm")
         public String jobPost(JobPost jobPost){
            return "success";
        }
}
