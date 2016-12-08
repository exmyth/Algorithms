package com.exmyth.algorithms.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by exmyth on 16/12/8.
 */
public class RegexTest {
    public static void main(String[] args) {
        String documentTxt = "if (!comm) {\n"
                        + "\t\t\t$(\"#validCodeTip\").html(\n"
                        + "\t\t\t\t\t\"<IMG src=\\\"http://qh.189.cn:10001/r/cms/ah/default/images/onError.gif\\\"/><font color=\\\"red\\\">\"\n"
                        + "\t\t\t\t\t\t\t+ \"请输入正确的验证码!\" + \"</font>\");\n"
                        + "\t\t\treturn;\n"
                        + "\t\t}\n"
                        + "\t\t$(\"#cusName\").html(\"\");\n"
                        + "\t\t$(\"#latnName\").html(\"\");\n"
                        + "\t\t$(\"#address\").html(\"\");\n"
                        + "\t\t$(\"#cardNum\").html(\"\");\n"
                        + "\t\t$(\"#custId\").html(\"\");\n"
                        + "\t\tif (isInvSms) {\n"
                        + "\t\t\tvar validationSms = $(\"#validationSmsInput\").val();\n"
                        + "\t\t\tif (!validationSms) {\n"
                        + "\t\t\t\talert(\"短信已经发出,请输入短信验证码！\");\n"
                        + "\t\t\t\treturn;\n"
                        + "\t\t\t}\n"
                        + "\t\t\t$.ajax({\n"
                        + "\t\t\t\ttype : \"post\",\n"
                        + "\t\t\t\turl : \"/service/passmanage/smsRandomCustInfo.action\",\n"
                        + "\t\t\t\tdata : {\n"
                        + "\t\t\t\t\t\"validationSms\" : validationSms\n"
                        + "\t\t\t\t},\n"
                        + "\t\t\t\tdataType : \"json\",\n"
                        + "\t\t\t\tsuccess : function(data) {\n"
                        + "\t\t\t\t\tif (data != null && data.flag == '1') {\n"
                        + "\t\t\t\t\t\t//prodStatus(\"aaa\");\n"
                        + "\t\t\t\t\t\t$(\"#cusName\").html(\"杨xx\");\n"
                        + "\t\t\t\t\t\t$(\"#latnName\").html(\"西xx\");\n"
                        + "\t\t\t\t\t\t$(\"#address\").html(\"西宁市xxx室\");\n"
                        + "\t\t\t\t\t\t$(\"#cardNum\").html(\"512923xxxx09116489\");\n"
                        + "\t\t\t\t\t\t$(\"#custId\").html(\"71300xxxx688\");\n"
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
