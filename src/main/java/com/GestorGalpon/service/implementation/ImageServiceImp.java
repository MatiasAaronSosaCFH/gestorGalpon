package com.GestorGalpon.service.implementation;

import com.GestorGalpon.models.image.CloudinaryService;
import com.GestorGalpon.models.image.Image;
import com.GestorGalpon.models.product.Product;
import com.GestorGalpon.repository.ImageRepository;
import com.GestorGalpon.repository.ProductRepository;
import com.GestorGalpon.service.abstraction.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ImageServiceImp implements ImageService {

    private final ImageRepository imageRepository;
    private final CloudinaryService cloudinaryService;
    private final ProductRepository productRepository;

    @Override
    public List<Image> findImageOnProduct(Long id) {
        return imageRepository.findAll();
    }

    @Override
    public Image findImageById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public Image deleteImage(String internalId) throws IOException {

        Image image = imageRepository.findByInternalId(internalId).orElse(null);
        if (image != null) {
            cloudinaryService.delete(internalId);
            return imageRepository.findById(image.getId()).get();
        }
        return null;
    }

    @Override
    public Image uploadImage(MultipartFile multipartFile, Long id) throws IOException {

        if (isGoodRequest(multipartFile)) {
            Map result = cloudinaryService.upImage(multipartFile);
            Product product = productRepository.findById(id).orElse(null);
            Image image = new Image((String) result.get("original_filename"),
                    (String) result.get("url"),
                    (String) result.get("public_id"),
                    product);

            imageRepository.save(image);
            return image;
        }

        return null;
    }

    @Override
    public List<Image> uploadImages(List<MultipartFile> multipartFiles, Long id) throws IOException {
        List<Image> images = new ArrayList<>();

        for (MultipartFile file : multipartFiles){
            Image image = uploadImage(file,id);
            if (image == null ) return null;
            images.add(image);
        }
        return images;
    }

    @Override
    public Boolean isGoodRequest(MultipartFile multipartFile) throws IOException {
        BufferedImage entry = ImageIO.read(multipartFile.getInputStream());
        if (entry != null) return true;
        return false;
    }
}
