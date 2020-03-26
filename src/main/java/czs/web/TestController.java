package czs.web;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import czs.bean.Student;
import czs.service.TestEazyexcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//下面是一个测试controller，模拟请求接口，发送消息，
@Controller
public class TestController {


    @Autowired
    TestEazyexcelService testEazyexcelService;

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




    /**
     * 文件下载
     * <p>
     * 1. 创建excel对应的实体对象
     * <p>
     * 2. 设置返回的 参数
     * <p>
     * 3. 直接写，这里注意，finish的时候会自动关闭OutputStream,当然你外面再关闭流问题不大
     */
    //http://localhost:8090/demo/download
    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应下载的文件名不对。这个时候 请别使用swagger 他会影像
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=demo.xlsx");
        //EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板").doWrite(data());
        testEazyexcelService.write(response);
     }



}
