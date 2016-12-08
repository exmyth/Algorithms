package com.exmyth.algorithms.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by exmyth on 16/12/8.
 */
public class RegexTest {
    public static void main(String[] args) {
        String documentTxt = "abc   \n$(\"#cusName\").html(\"杨xx\");\n"
                        + "\t\t\t\t\t\t$(\"#latnName\").html(\"西宁市\");\n"
                        + "\t\t\t\t\t\t$(\"#address\").html(\"西宁市城北区柴达木路214号4栋361室\");\n"
                        + "\t\t\t\t\t\t$(\"#cardNum\").html(\"51292319xxxx116489\");\n"
                        + "\t\t\t\t\t\t$(\"#custId\").html(\"713008xxxx88\");\n   $(";
        String str=documentTxt.replaceAll("[\\t\\n\\r]", "");//将内容区域的回车换行去除
        Pattern p = Pattern.compile(".*?\\$\\(\"#cusName\"\\).html\\(\"(.*?)\"\\);"+
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
