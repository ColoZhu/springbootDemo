package czs.eazyexcelUtils;

import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 自定义拦截器
 *
 * @author
 */
public class CustomSheetWriteHandler implements SheetWriteHandler {
    //列宽集合
    private List<Integer> columnWidths;
    //构造
    public CustomSheetWriteHandler(List<Integer> columnWidths) {
        this.columnWidths = columnWidths;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomSheetWriteHandler.class);

    @Override
    public void beforeSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {

    }

    @Override
    public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
        LOGGER.info("第{}个Sheet写入成功。", writeSheetHolder.getSheetNo());

        // 区间设置 第一列第一行和第二行的数据。由于第一行是头，所以第一、二行的数据实际上是第二三行
       /* CellRangeAddressList cellRangeAddressList = new CellRangeAddressList(1, 2, 0, 0);
        DataValidationHelper helper = writeSheetHolder.getSheet().getDataValidationHelper();
        DataValidationConstraint constraint = helper.createExplicitListConstraint(new String[] {"测试1", "测试2"});
        DataValidation dataValidation = helper.createValidation(constraint, cellRangeAddressList);
        writeSheetHolder.getSheet().addValidationData(dataValidation);*/
        LOGGER.info("普通策略设置setColumnWidth开始~");
        if(CollectionUtils.isNotEmpty(columnWidths)){
            for (int i = 0; i < columnWidths.size(); i++) {
                writeSheetHolder.getSheet().setColumnWidth(i, columnWidths.get(i));
            }
        }
        LOGGER.info("普通策略设置setColumnWidth结束~");
    }
}
