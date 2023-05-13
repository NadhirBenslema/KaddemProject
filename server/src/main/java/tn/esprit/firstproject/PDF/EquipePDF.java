package tn.esprit.firstproject.PDF;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import tn.esprit.firstproject.entity.Equipe;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class EquipePDF {
    private List<Equipe> listEquipePDF;

    public EquipePDF(List<Equipe> listEquipePDF) {
        this.listEquipePDF = listEquipePDF;

    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(3);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Equipe ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("nom Equipe", font));
        table.addCell(cell);

           cell.setPhrase(new Phrase("Niveau", font));
          table.addCell(cell);

        // cell.setPhrase(new Phrase("Details_equipe", font));
        // table.addCell(cell);

    }


    private void writeTableData(PdfPTable table) {
        for (Equipe eqp : listEquipePDF) {
            table.addCell(String.valueOf(eqp.getIdEquipe()));
            table.addCell(eqp.getNomEquipe());
             table.addCell(eqp.getNiveau().toString());
            //table.addCell(eqp.getDetail_equipe().toString());
        }
    }



    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("List of Users", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f,3.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }

}
