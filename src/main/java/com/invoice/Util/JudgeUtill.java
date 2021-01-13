package com.invoice.Util;

public class JudgeUtill {
    public  static  String whatOS(final String str){

        String osStr = "未知";

        //这里就简单判断下
        if(str.contains("Windows")){

            osStr = "Windows";
        }
        else if(str.contains("Linux")){

            osStr = "Linux";
        }

        return osStr;
    }

    //判断是啥浏览器-简单判断下
    public static String whatBrower(final String str){

        String browerStr = "未知";
        if(str.contains("Chrome")){

            browerStr = "Chrome";
        }
        else if(str.contains("Firefox")){

            browerStr = "Firefox";
        }
        return  browerStr;
    }

}
