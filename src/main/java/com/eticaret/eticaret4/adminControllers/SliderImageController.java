package com.eticaret.eticaret4.adminControllers;

import com.eticaret.eticaret4.adminEntities.Image;
import com.eticaret.eticaret4.adminEntities.SliderImage;
import com.eticaret.eticaret4.adminRepositories.ImageRepository;
import com.eticaret.eticaret4.adminRepositories.SliderImageRepository;
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
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class SliderImageController {

    private final String UPLOAD_DIR =  "src/main/resources/static/uploads/";

    final ImageRepository iRepo;
    final SliderImageRepository sIRepo;
    public SliderImageController(ImageRepository iRepo, SliderImageRepository sIRepo) {
        this.iRepo = iRepo;
        this.sIRepo = sIRepo;
    }


    @GetMapping("/sliderImage")
    public String sliderImage(Model model){

        return "admin/sliderImage";
    }

    int sImageId = 0;
    int sSale = 0;
    @PostMapping("/sliderImageInsert")
    public String sliderImageInsert( @RequestParam("sImageName") MultipartFile file, RedirectAttributes attributes ) {

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

        SliderImage i = new SliderImage();
        i.setSImageId(sImageId);
        i.setSImageName(fileName);
        i.setSDescription("sDescription");
        i.setSSale(sSale);
        i.setSTitle("sTitle");
        SliderImage ii = sIRepo.save(i);
        System.out.println(ii.getSImageId());

        return "redirect:/admin/sliderImage/";
    }

    @GetMapping("/sliderImageDelete/{sImageId}")
    public String sliderImageDelete(@PathVariable String sImageId ){
        try{
            int id=Integer.parseInt(sImageId);
            Optional<SliderImage> sliderImage =  sIRepo.findById(id);
            File file = new File(UPLOAD_DIR + sliderImage.get().getSImageName());
            if (file.exists()) {
                file.delete();
            }
            sIRepo.deleteById(id);
        }catch (Exception ex){
            System.err.println("File Delete Error : " +  ex);
        }
        return "redirect:/admin/sliderImage/";
    }

}
