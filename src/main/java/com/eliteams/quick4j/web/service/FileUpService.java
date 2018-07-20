package com.eliteams.quick4j.web.service;

import java.io.IOException;

/**
 * Created by hadoop on 2018/7/15.
 */
public interface FileUpService {
    void fileUpload(String target, String local) throws IOException;
}
