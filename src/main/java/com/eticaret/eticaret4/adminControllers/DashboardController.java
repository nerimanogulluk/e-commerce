package com.eticaret.eticaret4.adminControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class DashboardController {

    @GetMapping("/index")
    public String dashboard () {
        return "admin/index";
    }


}
