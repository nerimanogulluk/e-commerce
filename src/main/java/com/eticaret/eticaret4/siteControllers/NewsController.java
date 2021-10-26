package com.eticaret.eticaret4.siteControllers;

import com.eticaret.eticaret4.siteEntities.NewsLetter;
import com.eticaret.eticaret4.siteRepositories.NewsLetterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewsController {

    final NewsLetterRepository nRepo;
    public NewsController(NewsLetterRepository nRepo) {
        this.nRepo = nRepo;
    }


    @PostMapping("/newsLetterAdd")
    @CrossOrigin(origins = "http://localhost:8090/")
    @ResponseBody
    public String newsLetterAdd(@RequestBody NewsLetter newsLetter) {
        try {
            nRepo.saveAndFlush(newsLetter);
            return "1";
        }catch (Exception ex) {
            System.err.println("Error : " + ex);
            if (ex.toString().contains("ConstraintViolationException")) {
                return "-2";
            }
            return "-1";
        }
    }


}
