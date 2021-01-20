package com.invoice.Util;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.config.RequestConfig;
import org.springframework.util.ResourceUtils;

public class FileUtil {

    private String backupPath;

    private static ThreadLocal<Map<String, DateFormat>> threadLocal = new ThreadLocal<>();
    private static final String FILE_NAME_FORMAT_STRING = "yyyy-MM-dd";
    public static final RequestConfig defaultRequestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000)
            .setConnectionRequestTimeout(5000).build();

    /**
     * @param pattern
     * @return date format
     */
    public static DateFormat getDateFormat(String pattern) {
        Map<String, DateFormat> map = threadLocal.get();
        DateFormat format = null;
        if (null == map) {
            map = new HashMap<>();
            format = new SimpleDateFormat(pattern);
            map.put(pattern, format);
            threadLocal.set(map);
        } else {
            format = map.computeIfAbsent(pattern, k -> new SimpleDateFormat(k));
        }
        return format;
    }
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
        File filePath=new File(path.getAbsolutePath()+"/static/pdf/" );
        return filePath.getAbsolutePath();

    }
}
