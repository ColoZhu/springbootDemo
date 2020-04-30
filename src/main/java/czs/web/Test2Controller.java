package czs.web;

import czs.utils.RedisTool;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Api(value = "测试2",tags = "测试2")
@RestController
@RequestMapping("test")
public class Test2Controller {


    @RequestMapping(value = "test1", method = {RequestMethod.GET, RequestMethod.POST})
    public void testRedis() {
        doRedis();
    }

     static final String cron1 = "0 45 12 ? * *";
   //static final String cron1 = "0 */1 * * * ?";

    //每天上午10：15执行一次   // 每隔一分钟 0 */1 * * * ?
    @Scheduled(cron = cron1)
    public void testRedis1() {
        String msg = doRedis();
        System.out.println("msg1 :" + msg);

    }

    //每天上午10：15执行一次
    @Scheduled(cron = cron1)
    public void testRedis2() {
        String msg = doRedis();
        System.out.println("msg 2:" + msg);
    }

    //每天上午10：15执行一次
    @Scheduled(cron = cron1)
    public void testRedis3() {
        String msg = doRedis();
        System.out.println("msg 3:" + msg);
    }


    //执行redis
    private String doRedis() {
        boolean flag = RedisTool.tryGetDistributedLock("bmsMail_20200101", UUID.randomUUID().toString(), 1000 * 20);
        String msg = null;
        if (flag) {
            msg = "你获取到锁了可以去操作业务!";
        } else {
            msg = "别人获取到锁了,你就不用操作了!!!!";
        }

        return msg;
    }


}
