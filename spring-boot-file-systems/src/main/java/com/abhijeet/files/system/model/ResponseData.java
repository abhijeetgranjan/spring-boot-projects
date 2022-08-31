package com.abhijeet.files.system.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseData {

    private String fileName;
    private String fileType;
    private String downloadURL;
    private Long fileSize;
}
