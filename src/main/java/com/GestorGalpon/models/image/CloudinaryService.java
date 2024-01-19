package com.GestorGalpon.models.image;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class CloudinaryService {

    private Cloudinary cloudinary;

    private Map<String, String> values = new HashMap<>();

    public CloudinaryService(){
        values.put("cloud_name","dprhopips");
        values.put("api_key","894311123961918");
        values.put("api_secret","SAL6phTWQHcyVFHRN7RYlnKAy70");
        cloudinary = new Cloudinary(values);
    }

    public Map upImage(MultipartFile multipartFile)throws IOException{
        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return result;
    }

    public Map delete(String id) throws IOException{
        return cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
    }

    public File convert(MultipartFile multipartFile) throws IOException{
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream file2 = new FileOutputStream(file);
        file2.write(multipartFile.getBytes());
        file2.close();
        return file;
    }
}
