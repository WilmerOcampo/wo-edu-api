package com.wo.edu.web.util;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements IFileService {
    private final String folder = "files//";

    @Override
    public String save(MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(folder + file.getOriginalFilename());
                Files.write(path, bytes);
                return file.getOriginalFilename();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "default.png";
    }

    @Override
    public String delete(String fileName) {
        if (fileName != null && !fileName.equals("default.png")) {
            File file = new File(folder + fileName);
            if (file.delete()) {
                return "Archivo eliminado: " + fileName;
            } else {
                return "No se pudo eliminar el archivo: " + fileName;
            }
        }
        return "Es el archivo predeterminado.";
    }
}
