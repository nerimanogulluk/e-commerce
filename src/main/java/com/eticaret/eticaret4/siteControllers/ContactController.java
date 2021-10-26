package com.eticaret.eticaret4.siteControllers;

import com.eticaret.eticaret4.adminEntities.Content;
import com.eticaret.eticaret4.adminEntities.ProductImages;
import com.eticaret.eticaret4.adminRepositories.CategoryRepository;
import com.eticaret.eticaret4.adminRepositories.ContentRepository;
import com.eticaret.eticaret4.utils.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Controller
public class ContactController {

    final CategoryRepository cRepo;
    final Util util;
    final ContentRepository coRepo;
    public ContactController(CategoryRepository cRepo, Util util, ContentRepository coRepo) {
        this.cRepo = cRepo;
        this.util = util;
        this.coRepo = coRepo;
    }

    @GetMapping("/contact")
    public String detail(Model model)  {

        model.addAttribute("contents", coRepo.findAll());
        model.addAttribute("category", cRepo.findAll());
        model.addAttribute("products", util.allProduct() );

        List<ProductImages> ls = util.allBasketProduct();
        model.addAttribute("total", ls.get( ls.size() - 1 ) );
        ls.remove( ls.size() - 1 );
        model.addAttribute("baskets", ls );

        return "site/contact";
    }



}
