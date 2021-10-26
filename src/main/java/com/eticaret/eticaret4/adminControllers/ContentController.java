package com.eticaret.eticaret4.adminControllers;

import com.eticaret.eticaret4.adminEntities.Content;
import com.eticaret.eticaret4.adminRepositories.ContentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class ContentController {

    boolean updateStatus = false;
    final ContentRepository contentRepo;
    public ContentController(ContentRepository contentRepo) {
        this.contentRepo = contentRepo;
    }

    @GetMapping("/content")
    public String content(Model model) {
        updateStatus = false;
        model.addAttribute("contents",contentRepo.findAll());
        model.addAttribute("updateStatus", updateStatus);
        return "admin/content";
    }

    @PostMapping("/contentAdd")
    public String contentAdd(Content content){
        contentRepo.save(content);
        return "redirect:/admin/content";
    }

    @GetMapping("/contentDelete/{content_id}")
    public String contentDelete(@PathVariable String content_id){
        try {
            int id=Integer.parseInt(content_id);
            contentRepo.deleteById(id);
        }catch (Exception ex){
        }
        return "redirect:/admin/content";
    }
    @GetMapping("/contentUpdate/{content_id}")
    public String contentUpdate(@PathVariable String content_id, Model model){
        try{
            int id=Integer.parseInt(content_id);
            Optional<Content> oCon = contentRepo.findById(id);
            if(oCon.isPresent()){
                updateStatus = true;
                model.addAttribute("singleContent", oCon.get());
                model.addAttribute("updateStatus", updateStatus);
                model.addAttribute("contents",contentRepo.findAll());
            }
        }catch (Exception ex){ }
        return "admin/content";
    }
    @PostMapping("/contentUpdateSave")
    public String contentUpdateSave(Content content){
        contentRepo.saveAndFlush(content);
        return "redirect:/admin/content";
    }
}



