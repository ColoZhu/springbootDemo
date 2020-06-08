package czs.alibabaeazyexcel;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import czs.utils.HttpJson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestPostMail {


    @Test
    public void sendPostToAttach() throws Exception {

        Properties props = new Properties();
        String host = "smtp.exmail.qq.com"; // 腾讯企业邮箱的smtp服务器
        String to = "611766335@qq.com";     // 邮件要发送到的邮箱地址
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", host);
        String content = "hello";
        String subJect = "这是一个好消息1";
        //发送邮件VO
        MailInfo mailInfo = new MailInfo();
        mailInfo.setSubject( subJect);
        mailInfo.setContent(content);
        //收件人
        List<String> receiveAddressArray = new ArrayList<>();
        receiveAddressArray.add(to);
        mailInfo.setReceiveAddressArray(receiveAddressArray);

        //获取excel
        MailInfo.ExcelFile excelFile = TestWrite.writeToMail();
        ArrayList<MailInfo.ExcelFile> list = Lists.newArrayList();
        list.add(excelFile);

        mailInfo.setExcelFiles(list);
        String json = JSONObject.toJSONString(mailInfo);
        //启动命令,缺少输出到日志文件
        //java -jar springboot-mailserv-0.0.1-SNAPSHOT.jar --server.port=8889

        //远程调用接口 http://localhost:8888/mailserv/sendMail
        String res = HttpJson.httpPostWithjson("http://localhost:8888/mailserv/sendMail", json);
        //开发环境
        //String res = HttpJson.httpPostWithjson("http://192.168.147.233:8889/mailserv/sendMail", json);

        System.out.println("res :" + res);


    }

}
