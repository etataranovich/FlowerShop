package by.tataranovich.shop.writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import by.tataranovich.shop.exception.ProjectException;
import by.tataranovich.shop.modelshop.FlowerType;
import by.tataranovich.shop.modelshop.Order;
import by.tataranovich.shop.modelshop.action.BuoqetPriceCalculator;
import by.tataranovich.shop.modelshop.action.TotalPriceCalculator;

public class DataWriter {

    private static final String RAW_FORMAT = "%1$-20s%2$10s%3$10s\n";
    private static final String TOTAL_FORMAT = "%1$-30s%2$10s\n";
    // для кириллицы
    public final static String ARIAL_FONT_PATH = "Font/ARIAL.ttf";

    private static Logger logger = LogManager.getLogger();

    public static void writeInFile(String filename, Order order) throws ProjectException {
	try {
	    BaseFont bf = BaseFont.createFont(ARIAL_FONT_PATH, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	    Font font = new Font(bf);
	    Document document = new Document(PageSize.A4);

	    if (filename == null) {
		logger.log(Level.FATAL, "File not found");
		throw new RuntimeException();
	    }
	    PdfWriter.getInstance(document, new FileOutputStream(filename));

	    // Tab table = new Tab();
	    document.open();
	    document.add(new Paragraph("****************************************"));
	    document.add(new Paragraph("Заказ: " + order.getId(), font));
	    document.add(new Paragraph("Клиент: " + order.getBouqet().getName(), font));
	    document.add(new Paragraph("-------------------------------------------"));
	    document.add(new Paragraph());
	    document.add(new Paragraph());
     String printTypeOfbouqetAndPackage = String.format(RAW_FORMAT, String.format("Base (%s)", order.getBouqet().getPackageType().getName()),1,
	    String.format(" %.2f \u20AC", order.getBouqet().getPackageType().getPrice()));
	    
     document.add(new Paragraph(printTypeOfbouqetAndPackage));
	    for (Map.Entry<FlowerType, Integer> entry : order.getBouqet().getFlowers().entrySet()) {
		document.add(new Paragraph((String.format(RAW_FORMAT, entry.getKey().getName(), entry.getValue(),
			String.format(" %.2f \u20AC", entry.getKey().getPrice())))));
	    }
	    document.add(new Paragraph(String.format(TOTAL_FORMAT, "Всего:",
		    String.format(" %.2f \u20AC", BuoqetPriceCalculator.calculateBuoqetPrice(order.getBouqet()))),
		    font));
	    document.add(new Paragraph(String.format(TOTAL_FORMAT, "Кол-во:", order.getBouqetCount()), font));
	    document.add(new Paragraph("----------------------------------------"));
	    document.add(new Paragraph());
	    document.add(new Paragraph(String.format(TOTAL_FORMAT, "Общая сумма:",
		    String.format(" %.2f \u20AC", TotalPriceCalculator.calculateTotalPrice(order))), font));
	    document.add(new Paragraph());
	    document.add(new Paragraph("****************************************"));
	    // document.add(check);
	    document.close();

	} catch (FileNotFoundException e) {
	    throw new ProjectException("File NOT found", e);
	} catch (DocumentException e) {
	    throw new ProjectException("Document error", e);
	} catch (IOException e) {
	    throw new ProjectException("IN_OUTput error ", e);
	}

    }
}




















// import java.io.BufferedOutputStream;
// import java.io.FileOutputStream;
//
// import com.itextpdf.kernel.geom.PageSize;
// import com.itextpdf.kernel.pdf.PdfWriter;
// import com.itextpdf.layout.Document;
//
// import by.tataranovich.modelshop.Check;
//
// public class Writer {
//
//
// private static void writeToPDF(Check check, String fileName) throws Exception
// {
// if (check != null) {
// BufferedOutputStream out = null;
// try {
// out = new BufferedOutputStream(new FileOutputStream(fileName));
// Document document = new Document(PageSize.A4, 50, 50, 50, 50);
// PdfWriter writer = PdfWriter.getInstance(document, out);
// document.add(check);
// document.close();
//
// } catch (Exception e) {
// System.out.println(e);
// }
// }
// }
// }

// PdfContentByte cb = writer.getDirectContent();
// PdfTemplate tp = cb.createTemplate(width, height);
// Graphics2D g2 = tp.createGraphics(width, height);
// java.awt.geom.Rectangle2D r2D = new java.awt.geom.Rectangle2D.Double(0, 0,
// width, height);
// chart.draw(g2, r2D, null);
// g2.dispose();
// cb.addTemplate(tp, 0, 0);