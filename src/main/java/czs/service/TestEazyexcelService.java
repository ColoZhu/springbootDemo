package czs.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import czs.alibabaeazyexcel.TestWrite;
import czs.bean.DemoData;
import czs.eazyexcelUtils.CustomSheetWriteHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class TestEazyexcelService {


    /**
     *  web下载excel
     * @param response
     */
    public void write(HttpServletResponse response) throws IOException {

        //获取头和内容的策略
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = TestWrite.getHorizontalCellStyleStrategy();

        //列宽的策略,宽度是小单位
        Integer columnWidthArr[] = {3000, 6000};
        List<Integer> columnWidths = Arrays.asList(columnWidthArr);
        CustomSheetWriteHandler customSheetWriteHandler = new CustomSheetWriteHandler(columnWidths);

        // 根据用户传入字段 假设我们只要导出 string date
        String[] filds = {"string", "date"};

        //获取模拟的实体数据集合
        List<DemoData> demoDataList = TestWrite.getDemoDataList();

        //这里需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        //这里使用response的流输出
        EasyExcel.write(response.getOutputStream(), DemoData.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .registerWriteHandler(customSheetWriteHandler)
                //这个是导出需要展示的列
                .includeColumnFiledNames(Arrays.asList(filds))
                .sheet("模板")
                .doWrite(demoDataList);

    }
}
