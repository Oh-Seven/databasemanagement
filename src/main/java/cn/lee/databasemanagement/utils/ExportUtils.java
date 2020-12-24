package cn.lee.databasemanagement.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.poi.util.IOUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

/**
 *  ExportUtils
 * @description 导出工具类
 * @author lilei
 * @date 2020年12月24日 16:29:00
 * @version 1.0
 */
public class ExportUtils {


    /**exportExcelWithFreeMarker
     * @description freemarker 导出excel
     * @author lilei
     * @date 2020/12/24 16:30
     * @version 1.0
     */
    public static void exportExcelWithfreemarker(String templatePath,Map<String,Object> map,HttpServletResponse response){
        FileWriter out = null;
        FileInputStream in = null;
        try {
            Configuration configuration = new Configuration();
            String path = ExportUtils.class.getResource("/templates").getPath();
            configuration.setDirectoryForTemplateLoading(new File(path));
            Template template = configuration.getTemplate(templatePath);
            File file =  File.createTempFile(UUID.randomUUID().toString(), ".xlsx");
            out = new FileWriter(file);
            //变量替换
            template.process(map, out);
            in = new FileInputStream(file);
            byte[] buffer = new byte[in.available()];
            in.read(buffer);

            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("SMD.md", "UTF-8"));
            response.setContentType("application/x-download");
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(buffer);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(out);
            IOUtils.closeQuietly(in);
        }
    }
}
