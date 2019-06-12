package at.fh.swenga.jpa.report.pdf.itext5;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import at.fh.swenga.jpa.model.CityModel;

public class PdfCityReportViewItext5 extends AbstractIText5PdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// change the file name
		response.setHeader("Content-Disposition", "attachment; filename=\"report.pdf\"");


		List<CityModel> cities = (List<CityModel>) model.get("cities");

		document.add(new Paragraph("City list"));

		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 1.0f, 3.0f, 3.0f , 3.0f });
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);

		// write table header
		cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("City Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Country Name", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("State Name", font));
		table.addCell(cell);

		// write table row data
		for (CityModel city : cities) {
			table.addCell(city.getId() + "");
			table.addCell(city.getCityName());
			table.addCell(city.getCountryName());
			table.addCell(city.getStateName());
		}

		document.add(table);
	}

}
