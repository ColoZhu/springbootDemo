package czs.eazyexcelUtils;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

public class CustomCellWriteHandler  implements CellWriteHandler {


    /**
     * Called before create the cell
     *
     * @param writeSheetHolder
     * @param writeTableHolder Nullable.It is null without using table writes.
     * @param row
     * @param head             Nullable.It is null in the case of fill data and without head.
     * @param columnIndex
     * @param relativeRowIndex Nullable.It is null in the case of fill data.
     * @param isHead
     */
    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer columnIndex, Integer relativeRowIndex, Boolean isHead) {

    }

    /**
     * Called after the cell is created
     *
     * @param writeSheetHolder
     * @param writeTableHolder Nullable.It is null without using table writes.
     * @param cell
     * @param head             Nullable.It is null in the case of fill data and without head.
     * @param relativeRowIndex Nullable.It is null in the case of fill data.
     * @param isHead
     */
    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {

    }

    /**
     * Called after all operations on the cell have been completed
     *
     * @param writeSheetHolder
     * @param writeTableHolder Nullable.It is null without using table writes.
     * @param cellDataList     Nullable.It is null in the case of add header.There may be several when fill the data.
     * @param cell
     * @param head             Nullable.It is null in the case of fill data and without head.
     * @param relativeRowIndex Nullable.It is null in the case of fill data.
     * @param isHead
     */
    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<CellData> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {


     /*   // 这里可以对cell进行任何操作
        LOGGER.info("第{}行，第{}列写入完成。", cell.getRowIndex(), cell.getColumnIndex());
//        if (!isHead && cell.getStringCellValue().contains("个")) {
        if (!isHead && cell.getColumnIndex() == 1 && cell.getStringCellValue().contains("个")) {
            Workbook workbook = writeSheetHolder.getSheet().getWorkbook();
            CellStyle cellStyle = workbook.createCellStyle();
            Font cellFont = workbook.createFont();
            cellFont.setBold(true);
            cellStyle.setFont(cellFont);
            cell.setCellStyle(cellStyle);
        }
*/







    }
}
