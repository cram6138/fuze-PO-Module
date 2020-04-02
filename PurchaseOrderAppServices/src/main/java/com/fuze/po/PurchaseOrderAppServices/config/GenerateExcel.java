package com.fuze.po.PurchaseOrderAppServices.config;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fuze.po.PurchaseOrderAppServices.info.ItemInfo;
import com.fuze.po.PurchaseOrderAppServices.info.PORequestInfo;

 public  class GenerateExcel {

	public static byte[] generatePOItemsExcel(List<PORequestInfo>  poRequestInfoList) {
		// TODO Auto-generated method stub
				String FILE_NAME = "FuzePOExcel.xlsx";
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet sheet = workbook.createSheet("PurchaseOrderSheet");
				
					
							Iterator<PORequestInfo> poIterator = poRequestInfoList.iterator();	
							
							int rowIndex = 0;
							
							while(poIterator.hasNext()){
								PORequestInfo poRequestInfo = poIterator.next();
							
								Row row = sheet.createRow(rowIndex++);
								CellStyle style = workbook.createCellStyle();
								style.setFillBackgroundColor(IndexedColors.LIGHT_GREEN.getIndex());
							   // style.setFillPattern(FillPatternType.LEAST_DOTS);
								row.setRowStyle(style);
								
								Cell cell0 = row.createCell(0);
								cell0.setCellStyle(style);
								cell0.setCellValue("POID");
								Cell cell1 = row.createCell(1);
								cell1.setCellStyle(style);
								cell1.setCellValue("PSLC");
								Cell cell2 = row.createCell(2);
								cell2.setCellStyle(style);
								cell2.setCellValue("NAME");
								cell0.setCellStyle(style);
								Cell cell3 = row.createCell(3);
								cell3.setCellStyle(style);
								cell3.setCellValue("TERRITORY");
								Cell cell4 = row.createCell(4);
								cell4.setCellStyle(style);
								cell4.setCellValue("MARKET");
								Cell cell5 = row.createCell(5);
								cell5.setCellStyle(style);
						    	cell5.setCellValue("POStatus");
								
						    	row = sheet.createRow(rowIndex++);
								cell0 = row.createCell(0);
								cell0.setCellValue(poRequestInfo.getId());
								cell1 = row.createCell(1);
								cell1.setCellValue(poRequestInfo.getPslc());
								cell2 = row.createCell(2);
								cell2.setCellValue(poRequestInfo.getPoName());
								cell3 = row.createCell(3);
								cell3.setCellValue(poRequestInfo.getTeritory());
								cell4 = row.createCell(4);
								cell4.setCellValue(poRequestInfo.getMarket());
							    cell5 = row.createCell(5);
								cell5.setCellValue(poRequestInfo.getPoStatus());
					
								Set<ItemInfo> itemsList = poRequestInfo.getItems();
							  	Iterator<ItemInfo> itemIterator = itemsList.iterator();	
							  	
							  	row = sheet.createRow(rowIndex++);
							  	
		     					style = workbook.createCellStyle();
								style.setFillBackgroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
							   // style.setFillPattern(FillPatternType.LESS_DOTS);
							    row.setRowStyle(style);
							    
							    cell0 = row.createCell(0);
								cell0.setCellStyle(style);
								cell0.setCellValue("ITEMID");
								cell1 = row.createCell(1);
								cell1.setCellStyle(style);
								cell1.setCellValue("NAME");
							    cell2 = row.createCell(2);
								cell2.setCellStyle(style);
								cell2.setCellValue("DESCRIPTION");
								cell3 = row.createCell(3);
								cell3.setCellStyle(style);
								cell3.setCellValue("MODEL");
								cell4 = row.createCell(4);
								cell4.setCellStyle(style);
								cell4.setCellValue("INSTOCK");
									  	
							  	while(itemIterator.hasNext()){
							  		ItemInfo itemInfo = itemIterator.next();
							  		row = sheet.createRow(rowIndex++);
							  		cell0 = row.createCell(0);
									cell0.setCellValue(itemInfo.getId());
									cell1 = row.createCell(1);
									cell1.setCellValue(itemInfo.getName());
									cell2 = row.createCell(2);
									cell2.setCellValue(itemInfo.getDescription());
									cell3 = row.createCell(3);
									cell3.setCellValue(itemInfo.getModel());
									cell4 = row.createCell(4);
									cell4.setCellValue(itemInfo.isInStock());
								                             }
							}
							
					      try {
					    	  ByteArrayOutputStream bos = new ByteArrayOutputStream();
					          try {
					              workbook.write(bos);
					          } finally {
					              bos.close();
					          }
					          byte[] bytes = bos.toByteArray();
					          return bytes;
					        } catch (FileNotFoundException e) {
					            e.printStackTrace();
					        } catch (IOException e) {
					            e.printStackTrace();
					        }
						return null;
	}
	
}
