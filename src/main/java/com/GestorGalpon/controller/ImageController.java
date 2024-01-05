package com.GestorGalpon.controller;

import com.GestorGalpon.models.image.Image;
import com.GestorGalpon.service.implementation.ImageServiceImp;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageServiceImp imageServiceImp;

    @PostMapping
    public ResponseEntity<?> uploadImages(@RequestBody List<MultipartFile> multipartFiles, @NotBlank @RequestBody Long id) throws IOException {
        List<Image> images = imageServiceImp.uploadImages(multipartFiles,id);
        if (images != null) return new ResponseEntity<>(images, HttpStatus.CREATED);
        return new ResponseEntity<>("Somnthing well be whrong", HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> uploadImage(@RequestBody MultipartFile multipartFile, @PathVariable Long id) throws IOException {
        Image image = imageServiceImp.uploadImage(multipartFile, id);
        if (image != null) return new ResponseEntity<>(image,HttpStatus.CREATED);
        return new ResponseEntity<>("Somnthing well be whorng", HttpStatus.NOT_ACCEPTABLE);
    }
}
