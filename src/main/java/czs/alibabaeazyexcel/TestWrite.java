package czs.alibabaeazyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import czs.bean.DemoData;
import czs.bean.User;
import czs.eazyexcelUtils.CustomCellWriteHandler;
import czs.eazyexcelUtils.CustomSheetWriteHandler;
import czs.eazyexcelUtils.MyMergeStrategy;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class TestWrite {


    //  EasyExcel.write(fileName, WidthAndHeightData.class).sheet("模板").doWrite(data());


    /**
     * 写入到固定文件中,合并单元格
     *
     * @throws IOException
     */
    @Test
    public void writeToExcelFile4() {

        //定义合并单元格的坐标范围
        List<CellRangeAddress> cellRangeAddresss = getCellRangeAddresss();
        //定义合并单元格策略
        MyMergeStrategy myMergeStrategy = new MyMergeStrategy(cellRangeAddresss);

        //写入的文excel文件
        String fileName = "I:\\temp\\writeDemo4.xlsx";

        /*------------------------------分割线------------------------------*/
        //这里自定义一个单元格的格式(标黄的行高亮显示)
        Integer[] yellowRows = {3, 5, 7, 9};
        Set<Integer> yellowRowsSet = new HashSet<>(Arrays.asList(yellowRows));
        CustomCellWriteHandler customCellWriteHandler = new CustomCellWriteHandler(yellowRowsSet);

        //获取头和内容的策略
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = getHorizontalCellStyleStrategy();

        //列宽的策略,宽度是小单位
        Integer columnWidthArr[] = {3000, 3000, 2000, 6000};
        List<Integer> columnWidths = Arrays.asList(columnWidthArr);
        CustomSheetWriteHandler customSheetWriteHandler = new CustomSheetWriteHandler(columnWidths);

        // 根据自定义导出的字段
        String[] filds = {"uid", "name", "age", "birthday"};

        String[] headers = {"唯一识别码", "姓名", "年龄", "生日"};

        List head = getHeadByFilds(headers);

        //获取模拟的实体数据集合
        List<User> userList = getUserList();


        //这里指定头的名字去写入，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName)
                .head(head)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .registerWriteHandler(customSheetWriteHandler)
                //注册单元格式
                .registerWriteHandler(customCellWriteHandler)
                //注册合并策略
                .registerWriteHandler(myMergeStrategy)
                .includeColumnFiledNames(Arrays.asList(filds))
                .sheet("模板")
                .doWrite(userList);
    }


    /**
     * 写入到固定文件中,高亮显示某一行
     *
     * @throws IOException
     */
    @Test
    public void writeToExcelFile3() {
        //这里自定义一个单元格的格式(标黄的行高亮显示)
        Integer[] yellowRows = {3, 5, 7, 9};
        Set<Integer> yellowRowsSet = new HashSet<>(Arrays.asList(yellowRows));
        CustomCellWriteHandler customCellWriteHandler = new CustomCellWriteHandler(yellowRowsSet);

        //写入的文excel文件
        String fileName = "I:\\temp\\writeDemo3.xlsx";
        /*------------------------------分割线------------------------------*/
        //获取头和内容的策略
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = getHorizontalCellStyleStrategy();

        //列宽的策略,宽度是小单位
        Integer columnWidthArr[] = {3000, 3000, 2000, 6000};
        List<Integer> columnWidths = Arrays.asList(columnWidthArr);
        CustomSheetWriteHandler customSheetWriteHandler = new CustomSheetWriteHandler(columnWidths);

        // 根据自定义导出的字段
        String[] filds = {"uid", "name", "age", "birthday"};

        String[] headers = {"唯一识别码", "姓名", "年龄", "生日"};

        List head = getHeadByFilds(headers);

        //获取模拟的实体数据集合
        List<User> userList = getUserList();

        //这里指定头的名字去写入，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName)
                .head(head)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .registerWriteHandler(customSheetWriteHandler)
                //注册单元格式
                .registerWriteHandler(customCellWriteHandler)
                .includeColumnFiledNames(Arrays.asList(filds))
                .sheet("模板")
                .doWrite(userList);
    }


    /**
     * 写入到固定文件中,这里不使用注解的方式写入列和对应的属性
     *
     * @throws IOException
     */
    @Test
    public void writeToExcelFile2() {
        //写入的文excel文件
        String fileName = "I:\\temp\\writeDemo2.xlsx";
        //获取头和内容的策略
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = getHorizontalCellStyleStrategy();

        //列宽的策略,宽度是小单位
        Integer columnWidthArr[] = {3000, 3000, 2000, 6000};
        List<Integer> columnWidths = Arrays.asList(columnWidthArr);
        CustomSheetWriteHandler customSheetWriteHandler = new CustomSheetWriteHandler(columnWidths);

        // 根据用户传入字段 假设我们只要导出 string date
        String[] filds = {"uid", "name", "age", "birthday"};

        String[] headers = {"唯一识别码", "姓名", "年龄", "生日"};

        List head = getHeadByFilds(headers);

        //获取模拟的实体数据集合
        List<User> userList = getUserList();

        //这里指定头的名字去写入，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName)
                .head(head)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .registerWriteHandler(customSheetWriteHandler)
                .includeColumnFiledNames(Arrays.asList(filds))
                .sheet("模板")
                .doWrite(userList);
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
        //获取头和内容的策略
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = getHorizontalCellStyleStrategy();

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
                //这个是导出需要展示的列
                .includeColumnFiledNames(Arrays.asList(filds))
                .sheet("模板")
                .doWrite(demoDataList);
    }


    /**
     * 获取策略,这个策略是 头是头的样式 内容是内容的样式 其他的策略可以自己实现
     *
     * @return
     */
    public static HorizontalCellStyleStrategy getHorizontalCellStyleStrategy() {
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

        return horizontalCellStyleStrategy;
    }


    /**
     * 构造表头
     *
     * @param filds
     * @return
     */
    public static List getHeadByFilds(String[] filds) {
        List<List<String>> titles = new ArrayList<List<String>>();
        for (int i = 0; i < filds.length; i++) {
            titles.add(Arrays.asList(filds[i]));
        }
        return titles;
    }


    /**
     * 根据列宽数据返回map
     *
     * @param columnWidthArr
     * @return
     */
    public static Map getColumnWidthMap(int[] columnWidthArr) {
        Map columnWidthMap = new HashMap();
        for (int i = 0; i < columnWidthArr.length; i++) {
            columnWidthMap.put(i, columnWidthArr[i]);
        }
        return columnWidthMap;
    }


    /**
     * 模拟实体数据
     *
     * @return
     */
    public static  List<DemoData> getDemoDataList() {
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


    /**
     * 模拟实体数据
     *
     * @return
     */
    public static List<User> getUserList() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUid("识别码" + i);
            user.setAge(i * 10);
            //设置属性一部分为空值
            if (i % 2 == 0) {
                user.setBirthday(new Date());
            } else {
                user.setBirthday(null);
            }
            user.setName("用户名" + i);
            list.add(user);
        }
        return list;
    }


    /**
     * 模拟合并单元格的位置
     *
     * @return
     */
    public static List<CellRangeAddress> getCellRangeAddresss() {
        List<CellRangeAddress> list = new ArrayList<>();
        //合并第4行
        CellRangeAddress item1 = new CellRangeAddress(3, 3, 0, 3);
        //合并第第6行的第一列和第二列
        CellRangeAddress item2 = new CellRangeAddress(5, 5, 0, 1);
        //合并第9行和第10行
        CellRangeAddress item3 = new CellRangeAddress(10, 11, 0, 3);

        list.add(item1);
        list.add(item2);
        list.add(item3);
        return list;

    }

}
