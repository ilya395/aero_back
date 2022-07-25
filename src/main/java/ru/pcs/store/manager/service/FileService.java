package ru.pcs.store.manager.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileService {

    void saveFile(String description, MultipartFile multipartFile);

    void addFileToResponse(String fileName, HttpServletResponse response);
}
