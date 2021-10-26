package com.eticaret.eticaret4.adminControllers;


import com.eticaret.eticaret4.adminEntities.Product;
import com.eticaret.eticaret4.adminRepositories.CategoryRepository;
import com.eticaret.eticaret4.adminRepositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class ProductController {

    boolean updateStatus = false;
    final CategoryRepository cRepo;
    final ProductRepository pRepo;
    public ProductController(CategoryRepository cRepo, ProductRepository pRepo) {
        this.cRepo = cRepo;
        this.pRepo = pRepo;
    }


    @GetMapping("/product")
    public String product(Model model) {
        updateStatus = false;
        model.addAttribute("categories", cRepo.findAll());
        model.addAttribute("products", pRepo.findAll());
        model.addAttribute("updateStatus", updateStatus);
        return "admin/product";
    }

    @PostMapping("/productAdd")
    public String productAdd(Product product) {
        pRepo.save(product);
        return "redirect:/admin/product";
    }


    @GetMapping("/productDelete/{pid}")
    public String productDelete(@PathVariable String pid){
        try {
            int id=Integer.parseInt(pid);
            pRepo.deleteById(id);
        }catch (Exception ex){        }

        return "redirect:/admin/product";
    }


    @GetMapping("/productUpdate/{pid}")
    public String productUpdate(@PathVariable String pid, Model model){
        try {
            int id=Integer.parseInt(pid);
            Optional<Product> oPro = pRepo.findById(id);
            if ( oPro.isPresent() ) {
                updateStatus = true;

                model.addAttribute("singleProduct", oPro.get());
                model.addAttribute("updateStatus", updateStatus);
                model.addAttribute("categories", cRepo.findAll());
                model.addAttribute("products", pRepo.findAll());
            }
        }catch (Exception ex){        }
        return "admin/product";
    }


    @PostMapping("/productUpdateSave")
    public String productUpdateSave(Product product) {
        pRepo.saveAndFlush(product);
        return "redirect:/admin/product";
    }

}
