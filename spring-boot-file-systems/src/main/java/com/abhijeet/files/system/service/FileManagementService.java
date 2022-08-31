package com.abhijeet.files.system.service;


import com.abhijeet.files.system.entity.EmployeeFiles;
import org.springframework.web.multipart.MultipartFile;

public interface FileManagementService {

        EmployeeFiles uploadFile(MultipartFile file);

        EmployeeFiles getFile(String fileId);
}
