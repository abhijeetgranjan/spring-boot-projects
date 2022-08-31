package com.abhijeet.files.system.repository;


import com.abhijeet.files.system.entity.EmployeeFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeFilesRepository  extends JpaRepository<EmployeeFiles, String> {
}
