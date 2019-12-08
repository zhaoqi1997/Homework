package com.zq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author zhaoqi
 * @version 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class MyFile implements Serializable {
    private String id;
    private String oldName;
    private String newName;
    private String end;
    private String path;
    private Long sizes;
    private String type;
    private String isPic;
    private Integer acount;
}
