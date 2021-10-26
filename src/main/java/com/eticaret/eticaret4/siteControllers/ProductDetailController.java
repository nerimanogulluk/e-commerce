package com.eticaret.eticaret4.siteControllers;

import com.eticaret.eticaret4.adminEntities.ProductImages;
import com.eticaret.eticaret4.adminRepositories.ContentRepository;
import com.eticaret.eticaret4.siteRepositories.BasketRepository;
import com.eticaret.eticaret4.adminEntities.Image;
import com.eticaret.eticaret4.adminEntities.Product;
import com.eticaret.eticaret4.adminRepositories.ImageRepository;
import com.eticaret.eticaret4.adminRepositories.ProductRepository;
import com.eticaret.eticaret4.siteEntities.Basket;
import com.eticaret.eticaret4.utils.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductDetailController {

    final ProductRepository pRepo;
    final ImageRepository iRepo;
    final Util util;
    final BasketRepository bRepo;
    final ContentRepository coRepo;
    public ProductDetailController(ProductRepository pRepo, ImageRepository iRepo, Util util, BasketRepository bRepo, ContentRepository coRepo) {
        this.pRepo = pRepo;
        this.iRepo = iRepo;
        this.util = util;
        this.bRepo = bRepo;
        this.coRepo = coRepo;
    }

    @GetMapping("/detail/{pid}")
    public String detail(Model model, @PathVariable int pid) {
        try {
            model.addAttribute("contents", coRepo.findAll());
            Product pr = pRepo.getByPidEquals(pid);
            List<Image> images = iRepo.findByPidEquals(pid);
            model.addAttribute("product", pr);
            model.addAttribute("images", images);
            model.addAttribute("products", util.allProduct() );

            List<ProductImages> ls = util.allBasketProduct();
            model.addAttribute("total", ls.get( ls.size() - 1 ) );
            ls.remove( ls.size() - 1 );
            model.addAttribute("baskets", ls );

        }catch (Exception ex) {
            return "redirect:/";
        }
        return "site/detail";
    }
    @GetMapping("/littleDetailScreen/{pid}")
    public String littleDetailScreen(Model model, @PathVariable int pid){
        try {
            model.addAttribute("contents", coRepo.findAll());
            Product pr = pRepo.getByPidEquals(pid);
            List<Image> images = iRepo.findByPidEquals(pid);
            model.addAttribute("product", pr);
            model.addAttribute("images", images);
            model.addAttribute("products", util.allProduct() );

            List<ProductImages> ls = util.allBasketProduct();
            model.addAttribute("total", ls.get( ls.size() - 1 ) );
            ls.remove( ls.size() - 1 );
            model.addAttribute("baskets", ls );

        }catch (Exception ex) {
            return "redirect:/";
        }
        return "site/littleDetailScreen";
    }



    @GetMapping("/addBasket/{pid}")
    public String addBasket( @PathVariable int pid) {
        String uuid =  util.uuidCookie();
        Basket basket = new Basket();
        basket.setPid(pid);
        basket.setUuid(uuid);
        bRepo.saveAndFlush(basket);
        return "redirect:/detail/"+pid;
    }

    // item delete
    @GetMapping("/deleteItem/{pid}")
    public String deleteItem( @PathVariable int pid) {
        String uuid =  util.uuidCookie();
        try {
            Basket bsk = bRepo.itemBasket(pid, uuid);
            if (bsk != null ) {
                bRepo.delete(bsk);
            }
        }catch (Exception ex) {
            System.err.println("Delete Error : " + ex);
        }
        return "redirect:/detail/"+pid;
    }

}
