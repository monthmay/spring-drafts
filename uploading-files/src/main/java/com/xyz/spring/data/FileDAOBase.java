package com.xyz.spring.data;

import com.xyz.spring.entity.FileEntity;

import java.util.List;

interface FileDAOBase {

    void saveFile(FileEntity fileEntity);

    FileEntity findFileEntityById(String id);

    List<FileEntity> findAll();
}
