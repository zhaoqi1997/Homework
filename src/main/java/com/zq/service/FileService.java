package com.zq.service;

import com.zq.entity.MyFile;

import java.util.List;

public interface FileService {
    public void insert(MyFile file);

    public List<MyFile> selectAll();

    public MyFile selectByName(String newName);

    public void update(MyFile file);

    public void delete(String newName);
}
