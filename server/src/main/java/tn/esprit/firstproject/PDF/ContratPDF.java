package tn.esprit.firstproject.PDF;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import tn.esprit.firstproject.entity.Contrat;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ContratPDF {

    private java.util.List<Contrat> listContratPDF;

    public ContratPDF(List<Contrat> listContratPDF) {
        this.listContratPDF = listContratPDF;

    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Contrat ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Date début", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date fin", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Specialite", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Montant", font));
        table.addCell(cell);

        // cell.setPhrase(new Phrase("Details_equipe", font));
        // table.addCell(cell);

    }


    private void writeTableData(PdfPTable table) {
        for (Contrat eqp : listContratPDF) {
            table.addCell(String.valueOf(eqp.getIdContrat()));
            table.addCell(eqp.getDateDebutContrat().toString());
            table.addCell(eqp.getDateFinContrat().toString());
            table.addCell(eqp.getSpecialite().toString());
            table.addCell(String.valueOf(eqp.getMontantContrat()));

        }
    }



    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("List of Contrats", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f,3.5f,3.5f,3.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }
}
