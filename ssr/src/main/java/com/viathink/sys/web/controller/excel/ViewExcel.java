package com.viathink.sys.web.controller.excel;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ViewExcel extends AbstractExcelView {

	@Override
	public void buildExcelDocument(Map model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HSSFSheet sheet = workbook.createSheet("list");
		sheet.setDefaultColumnWidth((short) 12);

		HSSFCell cell = getCell(sheet, 0, 0);
		setText(cell, "Spring Excel test");

		HSSFCellStyle dateStyle = workbook.createCellStyle();
		dateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
		cell = getCell(sheet, 1, 0);
		cell.setCellValue(new Date());
		cell.setCellStyle(dateStyle);
		getCell(sheet, 2, 0).setCellValue(458);

		HSSFRow sheetRow = sheet.createRow(3);
		for (short i = 0; i < 10; i++) {
			sheetRow.createCell(i).setCellValue(i * 10);
		}

	}

}