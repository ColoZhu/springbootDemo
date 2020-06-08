package czs.alibabaeazyexcel;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MailInfo implements Serializable {

    private static final long serialVersionUID = 4280650483975256784L;
    // 邮件发送者的标示
    private String key;
    // 邮件发送者的邮箱
    private String from;
    //登陆邮件发送服务器的用户名和密码(授权码)
    private String mailAccount;
    private String mailPassword;
    //收件人名字
    private String senderAlias;
    // 邮件接收者的地址数组
    private List<String> receiveAddressArray;
    // 邮件主题
    private String subject;
    // 邮件的文本内容
    private String content;
    // 邮件附件的文件名
    private String[] attachFileNames;
    //发送邮件用到的Excel相关信息和数据
    private List<ExcelFile> excelFiles;


    /**
     * 发送邮件用到的Excel相关信息和数据
     */
    @Data
    public  static class ExcelFile {
        //文件名
        private String fileName;
        //字节数组
        private byte[] byteArray;
        //html格式内容
        private String htmlContent;

    }

}


