package com.abhijeet.files.system.service;


import com.abhijeet.files.system.entity.EmployeeFiles;
import com.abhijeet.files.system.repository.EmployeeFilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileManagementServiceImpl implements FileManagementService {

    @Autowired
    private EmployeeFilesRepository employeeFilesRepository;

    @Override
    public EmployeeFiles uploadFile(MultipartFile file) {

        if(file.isEmpty()){
            return null;
        }
        try {
            EmployeeFiles build = EmployeeFiles.builder().fileName(file.getOriginalFilename())
                    .fileType(file.getContentType()).file(file.getBytes()).build();

            return employeeFilesRepository.save(build);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public EmployeeFiles getFile(String fileId) {
        return employeeFilesRepository.getById(fileId);
    }
}
