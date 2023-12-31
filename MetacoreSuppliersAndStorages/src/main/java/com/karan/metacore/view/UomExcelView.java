package com.karan.metacore.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.karan.metacore.model.Uom;

public class UomExcelView extends AbstractXlsxView {
	
	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) 
					throws Exception 
	{
	
		//set file name
		response.addHeader("Content-Disposition", "attachment;filename=uoms.xlsx");
		
		//read data from Model
		@SuppressWarnings("unchecked")
		List<Uom> list = (List<Uom>) model.get("list");
		
		Sheet sheet = workbook.createSheet("UOMS");
		setHeader(sheet);
		setBody(sheet,list);
		
	}
	
	private void setHeader(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("TYPE");
		row.createCell(2).setCellValue("MODEL");
		row.createCell(3).setCellValue("DESCRIPTION");
	}
	
	private void setBody(Sheet sheet, List<Uom> list) {
		int rowNum = 1;
		for(Uom uom : list ) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(uom.getId());
			row.createCell(1).setCellValue(uom.getUomType());
			row.createCell(2).setCellValue(uom.getUomModel());
			row.createCell(3).setCellValue(uom.getDescription());
		}
	}

	
}