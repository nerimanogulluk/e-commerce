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
public class ContentDetailController {

    final CategoryRepository cRepo;
    final Util util;
    final ContentRepository coRepo;
    public ContentDetailController(CategoryRepository cRepo, Util util, ContentRepository coRepo) {
        this.cRepo = cRepo;
        this.util = util;
        this.coRepo = coRepo;
    }

    @GetMapping("/contentDetail/{content_id}")
    public String detail(Model model, @PathVariable int content_id) {

         Optional<Content> content = coRepo.findById(content_id);
         if ( content.isPresent() ) {
             model.addAttribute("content", content.get() );
         }

        model.addAttribute("contents", coRepo.findAll());
        model.addAttribute("category", cRepo.findAll());
        model.addAttribute("products", util.allProduct() );

        List<ProductImages> ls = util.allBasketProduct();
        model.addAttribute("total", ls.get( ls.size() - 1 ) );
        ls.remove( ls.size() - 1 );
        model.addAttribute("baskets", ls );

        return "site/contentDetail";
    }



}
