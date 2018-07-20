package com.eliteams.quick4j.web.controller;

import java.io.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eliteams.quick4j.web.model.Format;
import com.eliteams.quick4j.web.model.MetaTable;
import com.eliteams.quick4j.web.service.FileUpService;
import com.eliteams.quick4j.web.service.MetaTableService;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
     * 保存数据
     */
    @RequestMapping(value = "/save", method = { RequestMethod.POST })
    public void save(HttpServletRequest request,HttpServletResponse response) throws Exception{
        MetaTable meta = new MetaTable();
        Format format = new Format();
        // 设置接收的编码格式
        request.setCharacterEncoding("UTF-8");
        Date date = new Date();// 获取当前时间
        SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat sdfFolderName = new SimpleDateFormat("yyyyMMdd");

        String newfileName = sdfFileName.format(date);// 存放文件名称
        //String newFolderName = sdfFolderName.format(date);  //存放文件夹名

        String fileRealPath = "";// 文件存放真实地址
        String fileRealResistPath = "";// 文件存放真实相对路径

        // 获得容器中上传文件夹所在的物理路径
        String savePath = request.getSession().getServletContext().getRealPath("/") + "uploads/";
        System.out.println("上传文件存放路径" + savePath + "; ");
        File file = new File(savePath);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        try {
            System.out.println("进入try");
            // 名称 界面编码 必须 和request 保存一致..否则乱码
            String firstFileName = "";
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
            String zuozhe = multipartRequest.getParameter("zuozhe");
            String zhuti = multipartRequest.getParameter("zhuti");
            String laiyuan = multipartRequest.getParameter("laiyuan");
            System.out.println(zuozhe);
            System.out.println("大小为:"+fileMap.size());
            DiskFileItemFactory fac = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(fac);
            upload.setHeaderEncoding("UTF-8");
            // 获取多个上传文件
            List fileList = upload.parseRequest(request);
            System.out.println("文件容器大小为:"+fileList.size());
            // 遍历上传文件写入磁盘
            Iterator it = (Iterator)(fileList.iterator());
            for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()){
            //while (it.hasNext()) {
                MultipartFile mf = entity.getValue();
                String fileName = mf.getOriginalFilename();
                //Object obit = it.next();
                //if (obit instanceof DiskFileItem) {
                    //DiskFileItem item = (DiskFileItem) obit;
                    // 如果item是文件上传表单域
                    // 获得文件名及路径
                    //String fileName = item.getName();
                    if (fileName != null) {
                        // 得到存文件的文件名
                        //String saveFileName = makeFileName(fileName);
                        //firstFileName = item.getName().substring(item.getName().lastIndexOf("\\") + 1);  //上传的源文件名
                        //String formatName = firstFileName.substring(firstFileName.lastIndexOf("."));// 获取文件后缀名
                        // 得到上传文件的扩展名
                        String formatName = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
                        //fileRealPath = savePath + newfileName + formatName;// 文件存放真实地址
                        fileRealPath = savePath + fileName;// 文件存放真实地址
                        //BufferedInputStream in = new BufferedInputStream(item.getInputStream());// 获得文件输入流
                        //BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(new File(fileRealPath)));// 获得文件输出流
                        //Streams.copy(in, outStream, true);// 开始把文件写到你指定的上传文件夹
                        FileCopyUtils.copy(mf.getBytes(), new File(fileRealPath));
                        // 上传成功，则插入数据库
                        if (new File(fileRealPath).exists()) {
                            // 相对路径赋值
                            fileRealResistPath = "uploads/" + fileRealPath.substring(fileRealPath.lastIndexOf("\\") + 1);
                            // 保存到数据库
                            System.out.println("处理的文件名:" + fileName);
                            System.out.println("存放的相对路径:" + fileRealResistPath);
                        }
                        System.out.println("tttttttttttttttttttttttttttt");
                        //更改文件名，去掉文件名中的空格
                        String noWhilefileName= StringUtils.deleteWhitespace(fileName);
                        String file_loc = savePath;
                        renameFile(file_loc+fileName, file_loc+noWhilefileName);
                        // 得到存文件的文件名
                        String saveFileName = makeFileName(noWhilefileName);
                        try {
                            String localSrc=file_loc+noWhilefileName;
                            String destFileName ="";
                            String leixing="";
                            String cunchu="";
                            //添加一条元数据记录
                            File wenjian = new File(file_loc+noWhilefileName);
                            String filename=fileName;
                            //自动获取
                            String geshi=formatName;
                            String riqiStr=(new SimpleDateFormat("yyyy-MM-dd")).format(wenjian.lastModified());
                            //根据geshi，后缀名判断文件类型
                            String hdfs_url = "hdfs://master:9000/xctest/";
                            if(format.wenbenlist.contains(geshi))
                            {
                                leixing="文本";
                                destFileName = hdfs_url+"document/"+saveFileName;
                                cunchu="/xctest/document/"+saveFileName;
                            }
                            else if(format.tupianlist.contains(geshi))
                            {
                                leixing="图片";
                                destFileName = hdfs_url+"picture/"+saveFileName;
                                cunchu="/xctest/picture/"+saveFileName;
                            }
                            else if(format.yinpinlist.contains(geshi))
                            {
                                leixing="音频";
                                destFileName = hdfs_url+"voice/"+saveFileName;
                                cunchu="/xctest/voice/"+saveFileName;
                            }
                            else if(format.shipinlist.contains(geshi))
                            {
                                leixing="视频";
                                destFileName = hdfs_url+"video/"+saveFileName;
                                cunchu="/xctest/video/"+saveFileName;
                            }
                            else
                            {
                                System.out.println("不能识别此文件类型！");
                                leixing="文本";
                                destFileName = hdfs_url+"document/"+saveFileName;
                                cunchu="/xctest/document/"+saveFileName;
                            }
                            //根据文件大小确定文件大小的合适单位Start
                            long size=wenjian.length();
                            String daxiao="";
                            if(size<1024)
                            {
                                daxiao=(wenjian.length())+" Bytes";
                            }
                            else if(size<1048576)
                            {
                                daxiao=(wenjian.length()/1024)+" KB";
                            }
                            else if(size<1073741824)
                            {
                                double x=wenjian.length()/(double)(1048576);
                                NumberFormat ddft= NumberFormat.getNumberInstance();
                                String ss=ddft.format(x);

                                daxiao=ss+" MB";
                            }
                            else
                            {
                                double yy=wenjian.length()/(double)(1073741824);
                                NumberFormat ddft=NumberFormat.getNumberInstance();
                                String rr=ddft.format(yy);
                                daxiao=rr+" GB";
                            }
                            //根据文件大小确定文件大小的合适单位END
                            //手动添加的属性
                            String timing=fileName;
                            int shuliang=1;
                            System.out.println("主题是："+zhuti);
                            System.out.println("来源是："+laiyuan);
                            //pid添加
                            int pid=7;
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
//                            //上传完成后删除文件
//			                if(!wenjian.exists())
//			                {
//			                	System.out.println("文件不存在，删除文件失败");
//			                }
//			                else
//			                {
//			                	if(wenjian.delete())
//			                	{
//			                		System.out.println("删除文件成功");
//			                	}
//			                	else
//			                	{
//			                		System.out.println("删除文件失败");
//			                	}
//			                }
                        }
                        catch (Exception e) {
                            // TODO: handle exception
                            e.printStackTrace();
                            // return "upload failed,  " + e.getMessage();
                            System.out.println("upload failed,  " + e.getMessage());
                            request.getRequestDispatcher("/failed.jsp").forward(request, response);
                        }
                    }
                }
            //}
        } catch (org.apache.commons.fileupload.FileUploadException ex) {
            ex.printStackTrace();
            System.out.println("没有上传文件");
            return;
        }
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
}
