package com.exmyth.algorithms.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by exmyth on 16/12/8.
 */
public class RegexTest {
    public static void main(String[] args) {
        String documentTxt = "success : function(data) {\n"
                        + "\t\t\t\t\tif (data != null && data.flag == '1') {\n"
                        + "\t\t\t\t\t\t//prodStatus(\"aaa\");\n"
                        + "\t\t\t\t\t\t$(\"#cusName\").html(\"xxx\");\n"
                        + "\t\t\t\t\t\t$(\"#latnName\").html(\"axx\");\n"
                        + "\t\t\t\t\t\t$(\"#address\").html(\"bxxxxxxx\");\n"
                        + "\t\t\t\t\t\t$(\"#cardNum\").html(\"cxxxxxxxx\");\n"
                        + "\t\t\t\t\t\t$(\"#custId\").html(\"dxxxxxxxx\");\n"
                        + "\t\t\t\t\t\t$(\"#custStatus\").html(prodStatus(\"1\"));\n"
                        + "\t\t\t\t\t} else {\n"
                        + "\t\t\t\t\t\talert(\"随机码发送失败:\" + data.msg);\n"
                        + "\t\t\t\t\t}\n"
                        + "\t\t\t\t}\n"
                        + "\t\t\t});\n"
                        + "\t\t} else ";
        String str=documentTxt.replaceAll("[\\t\\n\\r]", "");//将内容区域的回车换行去除
        Pattern p = Pattern.compile(".*?;\\$\\(\"#cusName\"\\).html\\(\"(.*?)\"\\);"+
                        "\\$\\(\"#latnName\"\\).html\\(\"(.*?)\"\\);"+
                        "\\$\\(\"#address\"\\).html\\(\"(.*?)\"\\);"+
                        "\\$\\(\"#cardNum\"\\)\\.html\\(\"(.*?)\"\\);"+
                        "\\$\\(\"#custId\"\\)\\.html\\(\"(.*?)\"\\);.*?"
        );
        Matcher matcher = p.matcher(str);
        if(matcher.matches()){
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
            System.out.println(matcher.group(5));
        }
        else{
            System.out.println("no match");
        }
    }
}
