package czs.eazyexcelUtils;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.alibaba.excel.write.style.column.AbstractHeadColumnWidthStyleStrategy;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.ehcache.core.internal.util.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;

/**
 *
 *  普通的宽度策略
 */
public class CommonColumnWidthStyleStrategy extends AbstractHeadColumnWidthStyleStrategy {

    private static final Logger logger = LoggerFactory.getLogger(CommonColumnWidthStyleStrategy.class);

    private Integer columnWidth;

    //列宽集合
    private List<Integer> columnWidths;

    /**
     *
     * @param columnWidth
     */
    public CommonColumnWidthStyleStrategy(Integer columnWidth) {
        this.columnWidth = columnWidth;
    }

    @Override
    protected Integer columnWidth(Head head, Integer columnIndex) {
        return columnWidth;
    }

   public CommonColumnWidthStyleStrategy(List<Integer> columnWidths) {

        this.columnWidth = columnWidth;
    }


/*
    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
        //这里自定义一下样式
        logger.info("普通策略设置开始~");
        if(CollectionUtils.isNotEmpty(columnWidths)){
                for (int i = 0; i < columnWidths.size(); i++) {
                    writeSheetHolder.getSheet().setColumnWidth(cell.getColumnIndex(), columnWidth);
                }
        }
        logger.info("普通策略设置结束~");
       // super.afterCellCreate(writeSheetHolder, writeTableHolder, cell, head, relativeRowIndex, isHead);
    }*/


  /*  @Override
    protected void setColumnWidth(WriteSheetHolder writeSheetHolder, List<CellData> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
         logger.info("普通策略设置setColumnWidth开始~");
        if(CollectionUtils.isNotEmpty(columnWidths)){

            for (int i = 0; i < columnWidths.size(); i++) {
                writeSheetHolder.getSheet().setColumnWidth(i, columnWidths.get(i));
            }
        }

        logger.info("普通策略设置setColumnWidth结束~");

        // super.setColumnWidth(writeSheetHolder, cellDataList, cell, head, relativeRowIndex, isHead);
    }*/

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<CellData> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
        //super.afterCellDispose(writeSheetHolder, writeTableHolder, cellDataList, cell, head, relativeRowIndex, isHead);
        logger.info("普通策略设置setColumnWidth开始~");
        if(CollectionUtils.isNotEmpty(columnWidths)){
            for (int i = 0; i < columnWidths.size(); i++) {
                writeSheetHolder.getSheet().setColumnWidth(i, columnWidths.get(i));
            }
        }

        logger.info("普通策略设置setColumnWidth结束~");
    }
}
