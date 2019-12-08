package com.zq.service;

import com.zq.dao.MyFileDao;
import com.zq.entity.MyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhaoqi
 * @version 1.8
 */
@Service
@Transactional
public class FileServiceImpl implements FileService {
    @Autowired
    private MyFileDao myFileDao;


    @Override
    public void insert(MyFile file) {
          myFileDao.insertFile(file);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<MyFile> selectAll() {
        List<MyFile> myFiles = myFileDao.selectAll();
        return myFiles;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public MyFile selectByName(String newName) {

        MyFile myFile = myFileDao.selectByName(newName);
        return myFile;
    }

    @Override
    public void update(MyFile file) {
        myFileDao.updateBy(file);
    }

    @Override
    public void delete(String newName) {
        myFileDao.deleteBy(newName);
    }
}
