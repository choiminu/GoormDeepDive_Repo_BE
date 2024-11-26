package com.product.domain.user.controller;

import com.product.domain.user.model.User;
import com.product.utils.FileStore;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home(@SessionAttribute(name = "loginUser", required = false) User user, Model model) {
        if (user != null) {
            model.addAttribute("isLogin", true);
            return "main";
        }
        model.addAttribute("isLogin", false);
        return "main";
    }

    @GetMapping("/image/{profileURL}")
    public ResponseEntity<Resource> profileImage(@PathVariable("profileURL") String profileURL) throws MalformedURLException {
        Path imagePath = Paths.get("images", profileURL);
        Resource resource = new org.springframework.core.io.UrlResource(imagePath.toUri());

        String contentType;
        try {
            contentType = Files.probeContentType(imagePath);
        } catch (Exception e) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(resource);
    }

}
