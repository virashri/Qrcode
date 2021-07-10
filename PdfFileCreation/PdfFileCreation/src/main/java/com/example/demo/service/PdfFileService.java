package com.example.demo.service;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import javax.swing.text.StyleConstants.ColorConstants;

import org.springframework.stereotype.Service;


import com.itextpdf.barcodes.BarcodeQRCode;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

@Service
public class PdfFileService
{
	public void pdfCreation() throws MalformedURLException
	{
		String filepath="C:\\Users\\Dell\\Desktop\\PdfFiles\\simple1.pdf";
		
		try {
			PdfWriter writer = new PdfWriter(filepath);
			
			PdfDocument pdfdoc = new PdfDocument(writer);
			
			pdfdoc.addNewPage();
			
			Document document = new Document(pdfdoc);
			
		    document.add(new Paragraph("iText is a library for creating and manipulating PDF files in Java and .NET. iText was written by Bruno Lowagie. The source code was initially distributed as open source under the Mozilla Public License or the GNU Library General Public License open source licenses."));
			
		   List list = new List();
		   
		   list.add("Java");
		   list.add("Python");
		   list.add("C#");
		   list.add("C");
		   
		   float[] columnWidth= {200f,200f,200f,200f};
		   Table table = new Table(columnWidth);
		   table.addCell(new Cell().add("id"));
		   table.addCell(new Cell().add("First Name"));
		   table.addCell(new Cell().add("Last Name"));
		   table.addCell(new Cell().add("Email"));
		   table.addCell(new Cell().add("101"));
		   table.addCell(new Cell().add("Sachin"));
		   table.addCell(new Cell().add("Patil"));
		   table.addCell(new Cell().add("sachin@gmail.com"));
		   document.add(list);
		   document.add(table);
		   
		 
		   BarcodeQRCode qrCode = new BarcodeQRCode("https://www.iitk.ac.in/esc101/share/downloads/javanotes5.pdf");
		   PdfFormXObject barcodeObject = qrCode.createFormXObject(pdfdoc);
		   Image barcodeImage = new Image(barcodeObject).setWidth(50f).setHeight(50f);
		   
		   document.add(barcodeImage);
		   
		   
		   
			 document.close();
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
