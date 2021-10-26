package com.eticaret.eticaret4.adminControllers;

import com.eticaret.eticaret4.adminEntities.Image;
import com.eticaret.eticaret4.adminRepositories.ImageRepository;
import com.eticaret.eticaret4.adminRepositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class ImageController {

    private final String UPLOAD_DIR =  "src/main/resources/static/uploads/";

    final ImageRepository iRepo;
    final ProductRepository pRepo;
    public ImageController(ImageRepository iRepo, ProductRepository pRepo) {
        this.iRepo = iRepo;
        this.pRepo = pRepo;
    }

    @GetMapping("/image")
    public String image(Model model){
        this.pid = 0;
        return "admin/image";
    }

    int pid = 0;
    @GetMapping("/image/{pid}")
    public String image(@PathVariable int pid, Model model){
        List<Image> imageList = iRepo.findByPidEquals(pid);
        model.addAttribute("imageList", imageList);
        model.addAttribute("products",pRepo.findAll());
        this.pid = pid;
        return "admin/image";
    }

    @PostMapping("/insertImage")
    public String insertImage( @RequestParam("image_Name") MultipartFile file, RedirectAttributes attributes ) {

        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/";
        }

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String ext = fileName.substring(fileName.length()-4, fileName.length());
        String uui = UUID.randomUUID().toString();
        fileName = uui + ext;
        try {
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');

        Image i = new Image();
        i.setPid(pid);
        i.setImage_Name(fileName);
        i.setImage_Date(new Date());
        Image ii =  iRepo.save(i);
        System.out.println(ii.getImage_Id());

        return "redirect:/admin/image/"+this.pid;
    }

    @GetMapping("/imageDelete/{image_Id}")
    public String imageDelete(@PathVariable String image_Id ){
        try{
            int id=Integer.parseInt(image_Id);
            Optional<Image> image =  iRepo.findById(id);
            File file = new File(UPLOAD_DIR + image.get().getImage_Name());
            if (file.exists()) {
                file.delete();
            }
            iRepo.deleteById(id);
        }catch (Exception ex){
            System.err.println("File Delete Error : " +  ex);
        }
        return "redirect:/admin/image/"+this.pid;
    }

}
