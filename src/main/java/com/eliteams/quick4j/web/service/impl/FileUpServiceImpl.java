package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.web.service.FileUpService;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by hadoop on 2018/7/15.
 */
@Service
public class FileUpServiceImpl implements FileUpService{
    @Override
    public void fileUpload(String target, String local) throws IOException {
        FileInputStream in=new FileInputStream(new File(local));
        Configuration conf=new Configuration();
        conf.set("fs.defaultFS", target);
        FileSystem fs = FileSystem.get(conf);
        OutputStream out =fs.create(new Path(target));
        IOUtils.copyBytes(in, out, 4096, true);
    }
}
