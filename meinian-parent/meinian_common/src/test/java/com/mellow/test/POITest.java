package com.mellow.test;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class POITest {

    /**
     * 写入操作
     */
    @Test
    public void example02Test() throws Exception {
        // 创建工作薄对象
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 创建工作表对象
        XSSFSheet sheet = workbook.createSheet();
        // 创建行对象
        XSSFRow row0 = sheet.createRow(0);
        // 由行对象创建单元格
        row0.createCell(0).setCellValue("姓名");
        row0.createCell(1).setCellValue("性别");
        row0.createCell(2).setCellValue("地址");

        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("郑鑫雨");
        row1.createCell(1).setCellValue("男");
        row1.createCell(2).setCellValue("许昌");

        XSSFRow row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("赵冰鸽");
        row2.createCell(1).setCellValue("女");
        row2.createCell(2).setCellValue("洛阳");

        // 使用输出流
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\def.xlsx");
        // 边写边刷新
        // workbook写入
        workbook.write(fileOutputStream);
        // 输出流刷新
        fileOutputStream.flush();
        // 关闭
        fileOutputStream.close();
        workbook.close();
    }


    /**
     * 读取操作
     */
    @Test
    public void example01Test() throws IOException {
        // 创建工作薄对象
        XSSFWorkbook workbook = new XSSFWorkbook("E:\\abc.xlsx");
        // 获取工作表
        XSSFSheet sheetAt = workbook.getSheetAt(0);
        // 遍历工作表得到行对象
        for (Row cells : sheetAt) {
            // 迭代行对象读取单元格
            for (Cell cell : cells) {
                String stringCellValue = cell.getStringCellValue();
                System.out.println(stringCellValue);
            }
        }
        workbook.close();

    }

}
