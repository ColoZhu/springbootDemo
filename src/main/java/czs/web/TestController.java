package czs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


//下面是一个测试controller，模拟请求接口，发送消息，
@Controller
public class TestController {

    //http://localhost:8090/demoNew/testSendMsg
    @RequestMapping("/testSendMsg")
    @ResponseBody
    public String testSendMsg() {
        return "success";
    }

}
