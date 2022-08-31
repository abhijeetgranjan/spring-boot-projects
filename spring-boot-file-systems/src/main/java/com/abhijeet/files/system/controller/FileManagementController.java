package com.abhijeet.files.system.controller;


import com.abhijeet.files.system.entity.EmployeeFiles;
import com.abhijeet.files.system.exception.InvalidFileIdException;
import com.abhijeet.files.system.model.ResponseData;
import com.abhijeet.files.system.service.FileManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/files")
public class FileManagementController {

    @Autowired
    private FileManagementService fileManagementService;

    @PostMapping("/upload")
    public ResponseData uploadFiles(@RequestParam("file") MultipartFile file) {

        EmployeeFiles employeeFiles = fileManagementService.uploadFile(file);
        String downloadURl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/files/download")
                .path(employeeFiles.getEmployeeImageId())
                .toUriString();

        ResponseData build = ResponseData.builder().fileName(employeeFiles.getFileName()).
                fileSize(file.getSize()).
                fileType(file.getContentType()).
                downloadURL(downloadURl).build();

        return build;

    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        try {
            EmployeeFiles attachment = fileManagementService.getFile(fileId);
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(attachment.getFileType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + attachment.getFileName()
                                    + "\"")
                    .body(new ByteArrayResource(attachment.getFile()));
        } catch (Exception e) {
            throw new InvalidFileIdException("Please check the file id");
        }


    }
}
