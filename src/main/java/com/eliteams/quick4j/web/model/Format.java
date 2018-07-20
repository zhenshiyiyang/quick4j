package com.eliteams.quick4j.web.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2018/7/15.
 */
public class Format {
    public final static List<String> wenbenlist =new ArrayList<String>();
    public final static List<String> tupianlist =new ArrayList<String>();
    public final static List<String> yinpinlist =new ArrayList<String>();
    public final static List<String> shipinlist =new ArrayList<String>();

    public Format(){
        //文本格式
        wenbenlist.add("txt");
        wenbenlist.add("doc");
        wenbenlist.add("docx");
        wenbenlist.add("xml");
        wenbenlist.add("csv");
        wenbenlist.add("yaml");
        wenbenlist.add("pdf");
        //图片格式
        tupianlist.add("jpg");
        tupianlist.add("bmp");
        tupianlist.add("jpeg");
        tupianlist.add("png");
        tupianlist.add("gif");
        tupianlist.add("tag");
        tupianlist.add("exif");
        tupianlist.add("fpx");
        tupianlist.add("svg");
        tupianlist.add("psd");
        tupianlist.add("cdr");
        tupianlist.add("pcd");
        tupianlist.add("dxf");
        tupianlist.add("ufo");
        tupianlist.add("eps");
        tupianlist.add("hdri");
        tupianlist.add("ai");
        tupianlist.add("raw");
        tupianlist.add("tiff");
        //音频格式
        yinpinlist.add("ogg");
        yinpinlist.add("mp3");
        yinpinlist.add("asf");
        yinpinlist.add("wma");
        yinpinlist.add("wav");
        yinpinlist.add("mp3pro");
        yinpinlist.add("rm");
        yinpinlist.add("real");
        yinpinlist.add("ape");
        yinpinlist.add("module");
        yinpinlist.add("midi");
        yinpinlist.add("vqf");
        yinpinlist.add("cda");
        yinpinlist.add("flac");
        yinpinlist.add("aac");
        //视频格式
        shipinlist.add("aiff");
        shipinlist.add("avi");
        shipinlist.add("mov");
        shipinlist.add("mpeg");
        shipinlist.add("mpg");
        shipinlist.add("qt");
        shipinlist.add("ram");
        shipinlist.add("viv");
        shipinlist.add("rmvb");
        shipinlist.add("asf");
        shipinlist.add("divx");
        shipinlist.add("mp4");
        shipinlist.add("mkv");
        shipinlist.add("vob");
        shipinlist.add("mpe");
        shipinlist.add("wmv");
    }
    public static List<String> getWenbenlist() {
        return wenbenlist;
    }

    public static List<String> getTupianlist() {
        return tupianlist;
    }

    public static List<String> getYinpinlist() {
        return yinpinlist;
    }

    public static List<String> getShipinlist() {
        return shipinlist;
    }
}
