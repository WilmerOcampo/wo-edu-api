package com.wo.edu.web.util;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    String save(MultipartFile file);

    String delete(String fileName);
}
