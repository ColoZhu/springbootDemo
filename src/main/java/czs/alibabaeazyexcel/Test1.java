package czs.alibabaeazyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import czs.bean.DemoData;
import czs.eazyexcelUtils.CommonColumnWidthStyleStrategy;
import czs.eazyexcelUtils.CustomCellWriteHandler;
import czs.eazyexcelUtils.CustomSheetWriteHandler;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class Test1 {


    /**
     * 写入到固定文件中
     *
     * @throws IOException
     */
    @Test
    public void writeToExcelFile3() {
        //获取模拟的实体数据集合
        List<DemoData> demoDataList = getDemoDataList();
        //写入的文excel文件
        String fileName = "I:\\temp\\writeDemo1.xlsx";

        ExcelWriter writer = EasyExcel.write(fileName).build();

        String[] filds = {"string", "date"};
        List head = getHeadByFilds(filds);
        //设置列宽 设置每列的宽度
        int columnWidthArr[] = {15, 30};
        Map columnWidthMap = getColumnWidthMap(columnWidthArr);

        WriteSheet writeSheet = new WriteSheet();
        writeSheet.setSheetNo(0);
        writeSheet.setSheetName("第一个sheet");
        writeSheet.setHead(head);
        writeSheet.setColumnWidthMap(columnWidthMap);
        //or 设置自适应宽度
        //sheet1.setAutoWidth(Boolean.TRUE);
        writer.write(demoDataList, writeSheet);

        writer.finish();

    }

    /**
     * 构造表头
     * @param filds
     * @return
     */
    private List getHeadByFilds(String[] filds) {
        List<List<String>> titles = new ArrayList<List<String>>();
        for (int i = 0; i < filds.length; i++) {
            titles.add(Arrays.asList(filds[i]));
        }
        return  titles;
    }


    /**
     * 写入到固定文件中
     *
     * @throws IOException
     */
    @Test
    public void writeToExcelFile2() {

        //写入的文excel文件
        String fileName = "I:\\temp\\writeDemo1.xlsx";
        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        // 背景设置为红色
        headWriteCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());

        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short) 10);


        headWriteCellStyle.setWriteFont(headWriteFont);
        // 内容的策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        // 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND 不然无法显示背景颜色.头默认了 FillPatternType所以可以不指定
        //contentWriteCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
        // 背景绿色
        //contentWriteCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        //WriteFont contentWriteFont = new WriteFont();
        // 字体大小
        //contentWriteFont.setFontHeightInPoints((short)20);
        //contentWriteCellStyle.setWriteFont(contentWriteFont);
        // 这个策略是 头是头的样式 内容是内容的样式 其他的策略可以自己实现
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =
                new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);


        //设置列宽 设置每列的宽度
        int columnWidthArr[] = {15, 30};
        Map columnWidthMap = getColumnWidthMap(columnWidthArr);


        // 根据用户传入字段 假设我们只要导出 string date
        String[] filds = {"string", "date"};


        //获取模拟的实体数据集合
        List<DemoData> demoDataList = getDemoDataList();

        //writeSheet.setColumnWidthMap(columnWidthMap);

        EasyExcel.write(fileName)
                .head(DemoData.class)
                .sheet("模板")
                .includeColumnFiledNames(Arrays.asList(filds))
                .doWrite(demoDataList);




    }


    /**
     * 根据列宽数据返回map
     *
     * @param columnWidthArr
     * @return
     */
    private Map getColumnWidthMap(int[] columnWidthArr) {
        Map columnWidthMap = new HashMap();
        for (int i = 0; i < columnWidthArr.length; i++) {
            columnWidthMap.put(i, columnWidthArr[i]);
        }
        return columnWidthMap;
    }


    /**
     * 写入到固定文件中
     *
     * @throws IOException
     */
    @Test
    public void writeToExcelFile() {

        //写入的文excel文件
        String fileName = "I:\\temp\\writeDemo1.xlsx";


        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        // 背景设置为红色
        headWriteCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());

        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short) 10);


        headWriteCellStyle.setWriteFont(headWriteFont);
        // 内容的策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        // 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND 不然无法显示背景颜色.头默认了 FillPatternType所以可以不指定
        //contentWriteCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
        // 背景绿色
        //contentWriteCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        //WriteFont contentWriteFont = new WriteFont();
        // 字体大小
        //contentWriteFont.setFontHeightInPoints((short)20);
        //contentWriteCellStyle.setWriteFont(contentWriteFont);
        // 这个策略是 头是头的样式 内容是内容的样式 其他的策略可以自己实现
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =
                new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);


        //列宽的策略,宽度是小单位
        Integer columnWidthArr[] = {3000, 6000};
        List<Integer> columnWidths = Arrays.asList(columnWidthArr);
        CustomSheetWriteHandler customSheetWriteHandler = new CustomSheetWriteHandler(columnWidths);

        // 根据用户传入字段 假设我们只要导出 string date
        String[] filds = {"string", "date"};

        //获取模拟的实体数据集合
        List<DemoData> demoDataList = getDemoDataList();

        //这里需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoData.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .registerWriteHandler(customSheetWriteHandler)
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
            if (i % 2 == 0) {
                data.setDoubleData(null);
            } else {
                data.setDate(new Date());
            }
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

}
