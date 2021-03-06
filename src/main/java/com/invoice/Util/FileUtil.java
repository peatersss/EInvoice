package com.invoice.Util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class FileUtil {
    public static void uploadFile(byte[]file,String filePath,String fileName)throws Exception{
        File targetFile=new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream fileOutputStream=new FileOutputStream(targetFile.getAbsoluteFile()+"/"+fileName);
        fileOutputStream.write(file);
        fileOutputStream.flush();
        fileOutputStream.close();

    }
    public static String getUpLoadFilePath(){
        File path=null;
        try {
            path=new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(!path.exists()){
            path=new File("");
        }
        File filePath=new File(path.getAbsolutePath()+"/static/img/" );
        return filePath.getAbsolutePath();

    }
}
