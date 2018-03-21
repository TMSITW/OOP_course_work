import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import org.apache.hadoop.hive.ql.optimizer.MapJoinProcessor;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;

public class SavePDF_HTML {
    public SavePDF_HTML(DefaultTableModel model, FilmBase base, boolean flag,JTable table){
        SaveXML saveXML=new SaveXML(model, base, false);
        String fileName="FilmBaseForReport.xml";
        if(fileName==null) return;
        try{
            JRDataSource ds;
            if (!flag){ ds = new JRXmlDataSource(fileName, "/filmlist/film");} else{
             ds = new JRXmlDataSource(fileName, "//film["+(table.getSelectedRow()+1)+"]/session");}
            JasperReport jasperReport;
            if (!flag) {jasperReport= JasperCompileManager.compileReport("report1.jrxml");}
            else {jasperReport= JasperCompileManager.compileReport("report2.jrxml");}
            JasperPrint print=JasperFillManager.fillReport(jasperReport, new HashMap(), ds);
            JRExporter exporter=null;
            String end;
            FileDialog save1= new FileDialog(new JFrame(),"Выбор файла для сохранения", FileDialog.SAVE);
            save1.setFile("Отчет.pdf");
            save1.setVisible(true);
            String fileName1=save1.getDirectory()+save1.getFile();
            if (fileName1.toLowerCase().endsWith("pdf")){ exporter = new JRPdfExporter();
                end="pdf";
            }
            else{
                exporter = new JRHtmlExporter();
                end="html";
            }
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, fileName1);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.exportReport();
        }catch (JRException e){e.printStackTrace();}
    }


}