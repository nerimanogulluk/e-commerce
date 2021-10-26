package com.eticaret.eticaret4.adminControllers;

import com.eticaret.eticaret4.adminEntities.Category;
import com.eticaret.eticaret4.adminRepositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class CategoryController {

    final CategoryRepository cRepo;
    public CategoryController(CategoryRepository cRepo) {
        this.cRepo = cRepo;
    }

    @GetMapping("/category")
    public String category (Model model) {
        model.addAttribute("categories", cRepo.findAll());
        return "admin/category";
    }

    @PostMapping("/categoryAdd")
    public String categoryAdd(Category category) {
        cRepo.save(category);
        return "redirect:/admin/category";
    }


    @GetMapping("/categoryDelete/{cid}")
    public String categoryDelete(@PathVariable String cid){
        try {
            int id=Integer.parseInt(cid);
            cRepo.deleteById(id);
        }catch (Exception ex){        }

        return "redirect:/admin/category";
    }



}
