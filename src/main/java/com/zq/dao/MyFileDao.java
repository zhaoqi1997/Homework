package com.zq.dao;

import com.zq.entity.MyFile;

import java.util.List;

public interface MyFileDao {
    public void insertFile(MyFile file);

    public List<MyFile> selectAll();

    public MyFile selectByName(String newName);

    public void updateBy(MyFile myFile);

    public void deleteBy(String newName);
}
