package com.eliteams.quick4j.web.controller;

import java.io.*;
import java.net.URI;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.hadoop.fs.FileSystem;
import com.eliteams.quick4j.web.model.Format;
import com.eliteams.quick4j.web.model.MetaTable;
import com.eliteams.quick4j.web.service.FileUpService;
import com.eliteams.quick4j.web.service.MetaTableService;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/meta")
public class metaTableController {
    @Resource
    private MetaTableService metaTableService;
    @Resource
    private FileUpService fileUpService;
    /*
     * mysql插入元数据并上传文件至hadoop dfs
     */
    @RequestMapping(value = "/save", method = { RequestMethod.POST })
    @ResponseBody
    public String save(HttpServletRequest request,HttpServletResponse response) throws Exception{
        MetaTable meta = new MetaTable();
        Format format = new Format();
        // 设置接收的编码格式
        request.setCharacterEncoding("UTF-8");
        SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileRealPath = "";// 文件存放真实地址
        String fileRealResistPath = "";// 文件存放真实相对路径

        // 获得容器中上传文件夹所在的物理路径
        String savePath = request.getSession().getServletContext().getRealPath("/") + "uploads/";
        System.out.println("上传文件存放路径" + savePath + "; ");
        File file = new File(savePath);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        // 获取多个上传文件
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        if(fileMap.size()!=0) {
            String zuozhe = multipartRequest.getParameter("zuozhe");
            String zhuti = multipartRequest.getParameter("zhuti");
            String laiyuan = multipartRequest.getParameter("laiyuan");
            System.out.println(zuozhe);
            System.out.println("大小为:" + fileMap.size());
            // 遍历上传文件写入磁盘
            for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
                MultipartFile mf = entity.getValue();
                //获取文件名
                String fileName = mf.getOriginalFilename();
                if (fileName != null) {
                    // 得到上传文件的扩展名
                    String formatName = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
                    fileRealPath = savePath + fileName;// 文件存放真实地址
                    FileCopyUtils.copy(mf.getBytes(), new File(fileRealPath));
                    // 上传成功，则插入数据库
                    if (new File(fileRealPath).exists()) {
                        // 相对路径赋值
                        fileRealResistPath = "uploads/" + fileRealPath.substring(fileRealPath.lastIndexOf("\\") + 1);
                        // 保存到数据库
                        System.out.println("处理的文件名:" + fileName);
                        System.out.println("存放的相对路径:" + fileRealResistPath);
                    }
                    //更改文件名，去掉文件名中的空格
                    String noWhilefileName = StringUtils.deleteWhitespace(fileName);
                    String file_loc = savePath;
                    renameFile(file_loc + fileName, file_loc + noWhilefileName);
                    // 得到存文件的文件名
                    String saveFileName = makeFileName(noWhilefileName);
                    try {
                        String localSrc = file_loc + noWhilefileName;
                        String destFileName = "";
                        String leixing = "";
                        String cunchu = "";
                        //添加一条元数据记录
                        File wenjian = new File(file_loc + noWhilefileName);
                        String filename = fileName;
                        //自动获取
                        String geshi = formatName;
                        String riqiStr = (new SimpleDateFormat("yyyy-MM-dd")).format(wenjian.lastModified());
                        //根据geshi，后缀名判断文件类型
                        String hdfs_url = "hdfs://master:9000/xctest/";
                        if (format.wenbenlist.contains(geshi)) {
                            leixing = "文本";
                            destFileName = hdfs_url + "document/" + saveFileName;
                            cunchu = "/xctest/document/" + saveFileName;
                        } else if (format.tupianlist.contains(geshi)) {
                            leixing = "图片";
                            destFileName = hdfs_url + "picture/" + saveFileName;
                            cunchu = "/xctest/picture/" + saveFileName;
                        } else if (format.yinpinlist.contains(geshi)) {
                            leixing = "音频";
                            destFileName = hdfs_url + "voice/" + saveFileName;
                            cunchu = "/xctest/voice/" + saveFileName;
                        } else if (format.shipinlist.contains(geshi)) {
                            leixing = "视频";
                            destFileName = hdfs_url + "video/" + saveFileName;
                            cunchu = "/xctest/video/" + saveFileName;
                        } else {
                            System.out.println("不能识别此文件类型！");
                            leixing = "文本";
                            destFileName = hdfs_url + "document/" + saveFileName;
                            cunchu = "/xctest/document/" + saveFileName;
                        }
                        //根据文件大小确定文件大小的合适单位Start
                        long size = wenjian.length();
                        String daxiao = "";
                        if (size < 1024) {
                            daxiao = (wenjian.length()) + " Bytes";
                        } else if (size < 1048576) {
                            daxiao = (wenjian.length() / 1024) + " KB";
                        } else if (size < 1073741824) {
                            double x = wenjian.length() / (double) (1048576);
                            NumberFormat ddft = NumberFormat.getNumberInstance();
                            String ss = ddft.format(x);

                            daxiao = ss + " MB";
                        } else {
                            double yy = wenjian.length() / (double) (1073741824);
                            NumberFormat ddft = NumberFormat.getNumberInstance();
                            String rr = ddft.format(yy);
                            daxiao = rr + " GB";
                        }
                        //根据文件大小确定文件大小的合适单位END
                        //手动添加的属性
                        String timing = fileName;
                        int shuliang = 1;
                        System.out.println("主题是：" + zhuti);
                        System.out.println("来源是：" + laiyuan);
                        //pid添加
                        int pid = 7;
                        //Emp添加属性值
                        meta.setTiming(timing);
                        meta.setDaxiao(daxiao);
                        meta.setGeshi(geshi);
                        meta.setLaiyuan(laiyuan);
                        meta.setRiqiStr(riqiStr);
                        meta.setLeixing(leixing);
                        meta.setZhuti(zhuti);
                        meta.setPid(pid);
                        meta.setZuozhe(zuozhe);
                        meta.setCunchu(cunchu);
                        meta.setIsdelete(0);
                        //文件上传到HDFS后才把记录插入到mysql中
                        fileUpService.fileUpload(destFileName, localSrc);
                        metaTableService.insert(meta);
                        System.out.println("文件上传完成");
                        //上传完成后删除文件
                        deleteFile(wenjian);
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                        // return "upload failed,  " + e.getMessage();
                        System.out.println("upload failed,  " + e.getMessage());
                        request.getRequestDispatcher("/failed.jsp").forward(request, response);
                        return "failed";
                    }
                }
            }
        }else{
            System.out.println("没有上传文件");
        }
        return "success";
    }
    /*
      文件加前缀
     */
    private String makeFileName(String fileName) {
        // 为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
        return UUID.randomUUID().toString().replaceAll("-", "") + "_" + fileName;

    }
    /*
      文件重命名
     */
    private void renameFile(String file, String toFile) {
        File toBeRenamed = new File(file);
        //检查要重命名的文件是否存在，是否是文件
        if (!toBeRenamed.exists() || toBeRenamed.isDirectory()) {

            System.out.println("File does not exist: " + file);
            return;
        }

        File newFile = new File(toFile);

        //修改文件名
        if (toBeRenamed.renameTo(newFile)) {
            System.out.println("File has been renamed.");
        } else {
            System.out.println("Error renmaing file");
        }
    }
    /*
      文件检索，首次页面加载所有文件列表
     */
    @RequestMapping("/list")
    public String metaList(HttpServletRequest request,Model model){
        String pageNow = request.getParameter("pageNow");
        model = metaTableService.selectListByPage(pageNow,model);
        return "unStruct/searchList";
    }
    /*
      查询，按照条件进行分页查询，因为涉及到分页和保存查询条件，所以需要返回新页面
     */
    @RequestMapping("/search")
    public String searchMeta(HttpServletRequest request,Model model){
        Map map = new HashMap();
        map.put("wenjianming",(String) request.getParameter("wenjianming"));
        map.put("zuozhe",(String) request.getParameter("zuozhe"));
        map.put("laiyuan",(String) request.getParameter("laiyuan"));
        map.put("leixing",(String) request.getParameter("leixing"));
        map.put("kaishiriqi",(String) request.getParameter("kaishiriqi"));
        map.put("jieshuriqi",(String) request.getParameter("jieshuriqi"));
        String pageNow = request.getParameter("pageNow");
        model = metaTableService.selectMetaByCond(pageNow,model,map);
        return "unStruct/searchListCond";
    }
    /*
      下载文件，从hdfs上面
     */
    @RequestMapping("/down")
    public void download(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
        String loc = request.getParameter("loc");
        String filename = request.getParameter("filename");
        String dest = "hdfs://master:9000"+loc;
        String local = request.getSession().getServletContext().getRealPath("/") + "uploads/"+filename;
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(dest),conf);
        FSDataInputStream fsdi = fs.open(new Path(dest));
        OutputStream output = new FileOutputStream(local);
        IOUtils.copyBytes(fsdi,output,4096,true);
        // 设置响应头，控制浏览器下载该文件
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        // 读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(local);
        // 创建输出流
        OutputStream out = response.getOutputStream();
        // 创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        // 循环将输入流中的内容读取到缓冲区当中
        while ((len = in.read(buffer)) > 0) {
            // 输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        // 关闭文件输入流
        in.close();
        // 关闭输出流
        out.close();
        //下载完成后删除文件
        File file = new File(local);
        deleteFile(file);
    }
    public static void deleteFile(File file){
        if(!file.exists())
        {
            System.out.println("文件不存在，删除文件失败");
        }
        else {
            if (file.delete()) {
                System.out.println("删除文件成功");
            } else {
                System.out.println("删除文件失败");
            }
        }
    }
    /*
      删除文件，删除hdfs上文件并将mysql数据库中元数据isdelete属性置为1
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteFile(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String loc = request.getParameter("loc");
        String hdfs = "hdfs://master:9000";
        String dest = "hdfs://master:9000"+loc;
        int result = metaTableService.delete(id);
        if(result>0){
            System.out.println("删除的元数据行数："+ result);
        }else{
            System.out.println("删除元数据失败");
            return "fail";
        }
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(hdfs),conf);
        Path path = new Path(dest);
        fs.delete(path,true);
        return "success";
    }
}
