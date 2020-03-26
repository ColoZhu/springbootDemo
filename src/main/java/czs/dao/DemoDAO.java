package czs.dao;

import com.alibaba.fastjson.JSONObject;
import czs.bean.DemoData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 假设这个是你的DAO存储。当然还要这个类让spring管理，当然你不用需要存储，也不需要这个类。
 *
 * @author Jiaju Zhuang
 **/
public class DemoDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoDAO.class);
    public void save(List<DemoData> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
        LOGGER.info ("DemoDAO->save 调用了~~~"+ JSONObject.toJSONString(list));

    }
}
