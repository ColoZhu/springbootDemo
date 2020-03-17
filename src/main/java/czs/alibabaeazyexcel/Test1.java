package czs.alibabaeazyexcel;

import com.alibaba.excel.EasyExcel;
import czs.bean.DemoData;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test1 {




    /**
     * 写入到固定文件中
     *
     * @throws IOException
     */
    @Test
    public void writeToExcelFile() {

        //写入的文excel文件
        String fileName = "I:\\temp\\writeDemo1.xlsx";

        // 根据用户传入字段 假设我们只要导出 string date
        String[] filds = {"string", "date"};

        //获取模拟的实体数据集合
        List<DemoData> demoDataList = getDemoDataList();

        //这里需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoData.class)
                .includeColumnFiledNames(Arrays.asList(filds))
                .sheet("模板")
                .doWrite(demoDataList);
    }


    /**
     * 模拟实体数据
     *
     * @return
     */
    private List<DemoData> getDemoDataList() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            //data.setDate(new Date());
            //设置属性一部分为空值
            if(i%2==0){
                data.setDoubleData(null);
            }else{
                data.setDate(new Date());
            }
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

}
