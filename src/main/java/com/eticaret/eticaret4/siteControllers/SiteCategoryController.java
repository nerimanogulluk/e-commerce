package com.eticaret.eticaret4.siteControllers;


import com.eticaret.eticaret4.adminEntities.ProductImages;
import com.eticaret.eticaret4.adminRepositories.CategoryRepository;
import com.eticaret.eticaret4.adminRepositories.ContentRepository;
import com.eticaret.eticaret4.adminRepositories.ImageRepository;
import com.eticaret.eticaret4.adminRepositories.ProductRepository;
import com.eticaret.eticaret4.siteRepositories.BasketRepository;
import com.eticaret.eticaret4.utils.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class SiteCategoryController {

    final CategoryRepository cRepo;
    final ProductRepository pRepo;
    final ImageRepository iRepo;
    final Util util;
    final BasketRepository bRepo;
    final ContentRepository coRepo;

    public SiteCategoryController(CategoryRepository cRepo, ProductRepository pRepo, ImageRepository iRepo, Util util, BasketRepository bRepo, ContentRepository coRepo) {
        this.cRepo = cRepo;
        this.pRepo = pRepo;
        this.iRepo = iRepo;
        this.util = util;
        this.bRepo = bRepo;
        this.coRepo = coRepo;
    }

    @GetMapping("/category/{cid}")
    public String cart( Model model, @PathVariable int cid ) {

        model.addAttribute("contents", coRepo.findAll());
        model.addAttribute("allCatProduct", util.allCatID(cid));
        model.addAttribute("category", cRepo.findAll());
        model.addAttribute("products", util.allProduct() );
        List<ProductImages> ls = util.allBasketProduct();
        model.addAttribute("total", ls.get( ls.size() - 1 ) );
        ls.remove( ls.size() - 1 );
        model.addAttribute("baskets", ls );
        return "site/category";
    }
}
