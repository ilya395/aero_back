package ru.pcs.store.manager.service.impl;

import ru.pcs.store.manager.model.FileInfo;
import ru.pcs.store.manager.repositories.FilesInfoRepository;
import ru.pcs.store.manager.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class FileServiceImpl implements FileService {

    private final FilesInfoRepository filesInfoRepository;

    @Value("${files.storage.path}")
    private String storageFolder;

    @Override
    public void saveFile(String description, MultipartFile multipartFile) {
        String originalFileName = multipartFile.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.indexOf("."));

        FileInfo fileInfo = FileInfo.builder()
                .originalName(multipartFile.getOriginalFilename())
                .mimeType(multipartFile.getContentType())
                .description(description)
                .uploadDateTime(LocalDateTime.now())
                .storageName(UUID.randomUUID() + extension)
                .size(multipartFile.getSize())
                .build();
        filesInfoRepository.save(fileInfo);

        try {
            Files.copy(multipartFile.getInputStream(), Paths.get(storageFolder, fileInfo.getStorageName()));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void addFileToResponse(String fileName, HttpServletResponse response) {
        FileInfo fileInfo = filesInfoRepository.findByStorageName(fileName);

        response.setContentType(fileInfo.getMimeType());
        response.setContentLengthLong(fileInfo.getSize());
        response.setHeader("Content-Disposition", "fileName =\"" + fileInfo.getOriginalName() + "\"");

        try {
            Files.copy(Paths.get(storageFolder, fileInfo.getStorageName()), response.getOutputStream());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
