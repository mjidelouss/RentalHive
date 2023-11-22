package com.root.rentalheive.utils;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import com.itextpdf.text.*;
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

        for (Map.Entry<String, Object> entry : rowData.entrySet()) {
            String columnName = entry.getKey();
            Object value = entry.getValue();

            Paragraph columnNameParagraph = new Paragraph(columnName, boldFont);
            document.add(columnNameParagraph);

            if (columnName.equals("Equipment(s)")) {
                if (value instanceof List) {
                    List<Map<String, Object>> equipmentList = (List<Map<String, Object>>) value;
                    PdfPTable table = new PdfPTable(3);
                    table.addCell("Name");
                    table.addCell("Type");
                    table.addCell("Duration");
                    for (Map<String, Object> equipmentInfo : equipmentList) {
                        table.setWidthPercentage(100);
                        table.setSpacingBefore(10f);

                        table.addCell(equipmentInfo.get("Name").toString());
                        table.addCell(equipmentInfo.get("Type").toString());
                        table.addCell(equipmentInfo.get("Duration").toString());
                    }
                    document.add(table);
                }
            } else {
                Paragraph valueParagraph = new Paragraph(value.toString());
                document.add(valueParagraph);
            }

            document.add(new Paragraph("\n"));
        }

        document.close();
        return outputStream;
    }
}