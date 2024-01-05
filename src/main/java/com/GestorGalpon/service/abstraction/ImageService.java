package com.GestorGalpon.service.abstraction;

import com.GestorGalpon.models.image.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {

    List<Image> findImageOnProduct(Long id);

    Image findImageById(Long id);

    Image deleteImage(String internalId) throws IOException;

    Image uploadImage(MultipartFile multipartFile, Long id) throws IOException;

    List<Image> uploadImages(List<MultipartFile> multipartFiles, Long id) throws IOException;

    Boolean isGoodRequest(MultipartFile multipartFile) throws IOException;
}
