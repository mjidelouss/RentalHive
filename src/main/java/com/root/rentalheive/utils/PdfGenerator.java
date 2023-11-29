package com.root.rentalheive.utils;

import java.io.ByteArrayOutputStream;
import java.util.Map;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class PdfGenerator {
    public static ByteArrayOutputStream generatePdfStream(Map<String, Object> rowData, String title) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        Font titleFont = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD, BaseColor.BLACK);
        Paragraph titleParagraph = new Paragraph(title, titleFont);
        titleParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(titleParagraph);

        Font boldFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK);

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);

        for (Map.Entry<String, Object> entry : rowData.entrySet()) {
            String columnName = entry.getKey();
            Object value = entry.getValue();

            // Add cell for column name
             PdfPCell nameCell = new PdfPCell(new Phrase(columnName, boldFont));
            nameCell.setBorder(Rectangle.NO_BORDER);
            table.addCell(nameCell);

            // Add cell for column value
            PdfPCell valueCell = new PdfPCell(new Phrase(value.toString()));
            valueCell.setBorder(Rectangle.NO_BORDER);
            table.addCell(valueCell);

            // Add a new line after each pair of name and value
            table.addCell("");
            table.addCell("");
        }

        document.add(table);
        document.close();
        return outputStream;
    }
}