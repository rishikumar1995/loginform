package Register;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.Colour;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

import static jxl.format.Alignment.CENTRE;
import static jxl.format.BorderLineStyle.THIN;

@WebServlet("/excel")
public class excel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String decompositionParameter = "attachment;filename=data.xls";
        resp.setHeader("Content-disposition", decompositionParameter);
        resp.setContentType("application/vnd.ms-excel");
        resp.setHeader("Content-Type", "application/octet-stream");

        try {
            int cellno=0, rowno=0;

            busineesclass bc=new busineesclass();
            List<Map<String,String>>data=bc.exporttoexcel();
            //System.out.println(data);

            WritableWorkbook workBook = Workbook.createWorkbook(resp.getOutputStream());
            WritableSheet sheet = workBook.createSheet("First Sheet", 0);
            WritableFont font = new WritableFont(WritableFont.ARIAL, 9, WritableFont.BOLD);

            WritableCellFormat cellFormat = new WritableCellFormat(font);
            cellFormat.setBackground(Colour.GRAY_25);
            cellFormat.setBorder(Border.ALL, THIN);
            cellFormat.setAlignment(CENTRE);


            Map<String,String>data_map = data.get(0);

            Set<String> columnname=data_map.keySet();

            rowno= 5;
            for (String columnn_name: columnname){

                setValueInCell(sheet, cellFormat, cellno, rowno, columnn_name);
                setValueInCell(sheet, cellFormat, cellno++, rowno+1, data_map.get(columnn_name));
            }

            //sheet.mergeCells(cellno, rowno, cellno, rowno + 1);
            setValueInCell(sheet, cellFormat, cellno++, rowno,"");
            workBook.write();
            workBook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void setValueInCell(WritableSheet sheet, WritableCellFormat cellFormat, int cellno, int rowno, String activityName) throws WriteException, RowsExceededException {
        Label label;
        label = new Label(cellno, rowno, activityName, cellFormat);
        sheet.addCell(label);
    }
}
