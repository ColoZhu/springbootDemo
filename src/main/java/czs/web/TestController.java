package czs.web;

import com.alibaba.fastjson.JSONObject;
import czs.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


//下面是一个测试controller，模拟请求接口，发送消息，
@Controller
public class TestController {

    //http://localhost:8090/demo/testSendMsg
    @RequestMapping("/testSendMsg")
    @ResponseBody
    public String testSendMsg() {
        return "success";
    }


    @RequestMapping("/testPostwomen")
    @ResponseBody
    public String testPostwomen()     {
        JSONObject data = new JSONObject();
        data.put("id", "1");
        data.put("name", "java");

        JSONObject res = new JSONObject();
        res.put("code", "200");
        res.put("msg", "成功!");
        res.put("data", data);
        return res.toString();
    }



    @RequestMapping(value = "testPostMethod", method = RequestMethod.POST)
    public String  queryYS(@RequestBody Student stu)   {
        String s = JSONObject.toJSONString(stu);
        System.out.println("stu :" + s);
        return  "测试成功!数据:"+ s;
    }


}
