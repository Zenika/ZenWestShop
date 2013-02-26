package org.zenika.skillz.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping(method = RequestMethod.POST)
    public String processUpload(@RequestParam MultipartFile file, WebRequest webRequest, Model model) {
        String orgFileName = file.getOriginalFilename();
        String filePath = "img/consultants/" + orgFileName;
        ModelMap modelMap = new ModelMap();
        LOGGER.info("*******************************************");
        File dest = new File(filePath);
        LOGGER.info("chemin absolue : {}", dest.getAbsolutePath());
        if (!dest.exists()) {
            dest.mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            LOGGER.error("Error to upload :", e);
            modelMap.addAttribute("result", "File uploaded failed:" + orgFileName);
            return "fail";
        } catch (IOException e) {
            LOGGER.error("Error to upload :", e);
            modelMap.addAttribute("result", "File uploaded failed:" + orgFileName);
            return "fail";
        }


        modelMap.addAttribute("result", "File uploaded " + orgFileName);
        return "uploaded";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorMessage handleException(Exception ex) {

        LOGGER.error("Erreur : ",ex);
        List<String> errors = new ArrayList<String>();
        return new ErrorMessage(errors);
    }

    @XmlRootElement
    public class ErrorMessage {

        private List<String> errors;

        public ErrorMessage() {
        }

        public ErrorMessage(List<String> errors) {
            this.errors = errors;
        }

        public List<String> getErrors() {
            return errors;
        }

        public void setErrors(List<String> errors) {
            this.errors = errors;
        }
    }

}