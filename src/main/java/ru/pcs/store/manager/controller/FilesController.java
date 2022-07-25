package ru.pcs.store.manager.controller;

import ru.pcs.store.manager.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Controller
public class FilesController {

    private final FileService fileService;

    @Autowired
    public FilesController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/files/upload")
    public String getFilesUploadPage() {
        return "files_upload";
    }

    @GetMapping("/files/{file:.+}")
    public void getFile(@PathVariable("file") String fileName, HttpServletResponse response) {
        fileService.addFileToResponse(fileName, response);
    }

    @PostMapping("/files/upload")
    public String uploadFile(@RequestParam("description") String description, @RequestParam("file") MultipartFile multipartFile) {
        fileService.saveFile(description, multipartFile);
        return "redirect:/files/upload";
    }
}
