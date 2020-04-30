package czs.alibabaeazyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.converters.DefaultConverterLoader;
import com.alibaba.fastjson.JSON;
import czs.bean.DemoData;
import czs.listenerAndConverter.ConverterDataListener;
import czs.listenerAndConverter.DemoDataListener;
import czs.listenerAndConverter.DemoExceptionListener;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class TestRead {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestRead.class);

    /**
     * 简单读取,DemoDataListener里面可以处理业务逻辑,每次读取5条数据
     */

    @Test
    public void simpleRead() {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        String fileName = "I:\\temp\\readDemo1.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
    }


    /**
     * 日期、数字或者自定义格式转换
     * <p>
     * 默认读的转换器{@link DefaultConverterLoader#loadDefaultReadConverter()}
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link ConverterData}.里面可以使用注解{@link DateTimeFormat}、{@link NumberFormat}或者自定义注解
     * <p>
     * 2. 由于默认异步读取excel，所以需要创建excel一行一行的回调监听器，参照{@link ConverterDataListener}
     * <p>
     * 3. 直接读即可
     */
    @Test
    public void converterRead() {
        String fileName = "I:\\temp\\readDemo1.xlsx";

        /*
         * 这里如果不实体接收,而是用ConverterData(都是String)接收,类型出错,不会异常!!!
         * */
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet
        EasyExcel.read(fileName, ConverterData.class, new ConverterDataListener())
                // 这里注意 我们也可以registerConverter来指定自定义转换器， 但是这个转换变成全局了， 所有java为string,excel为string的都会用这个转换器。
                // 如果就想单个字段使用请使用@ExcelProperty 指定converter
                // .registerConverter(new CustomStringStringConverter())
                // 读取sheet
                .sheet().doRead();
    }


    /**
     * 数据转换等异常处理
     *
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link ExceptionDemoData}
     * <p>
     * 2. 由于默认异步读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoExceptionListener}
     * <p>
     * 3. 直接读即可
     */
    @Test
    public void exceptionRead() {
        String fileName = "I:\\temp\\readDemo1.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet
        EasyExcel.read(fileName, ExceptionDemoData.class, new DemoExceptionListener()).sheet().doRead();
    }


    //多线程测试一下上面错误信息
    public void exceptionRead(int i) {
        String fileName = "I:\\temp\\readDemo" + i + ".xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet
        EasyExcel.read(fileName, ExceptionDemoData.class, new DemoExceptionListener()).sheet().doRead();
    }




    /**
     * 同步的返回，不推荐使用，如果数据量大会把数据放到内存里面~
     * ~~如果限制导入的行数,这种一次性读完的方式用到的还是挺多的~
     */
    @Test
    public void synchronousRead() {
        String fileName = "I:\\temp\\readDemo2.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
        List<DemoData> list = EasyExcel.read(fileName).head(DemoData.class).sheet().doReadSync();
        for (DemoData data : list) {
            LOGGER.info("同步读取到数据:{}", JSON.toJSONString(data));
        }
        // 这里 也可以不指定class，返回一个list，然后读取第一个sheet 同步读取会自动finish
        //List<Map<Integer, String>> listMap = EasyExcel.read(fileName).sheet().doReadSync();

    }


}

