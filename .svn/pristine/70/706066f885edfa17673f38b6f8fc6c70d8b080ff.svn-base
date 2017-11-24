package com.icinfo.cs.common.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * PDF生成辅助类
 * @author 
 *
 */
@SuppressWarnings("deprecation")
public class PdfHelper {

	public static ITextRenderer getRender(HttpServletRequest request) throws DocumentException, IOException {

		ITextRenderer render = new ITextRenderer();

         String path = request.getSession().getServletContext()
  				.getRealPath("WEB-INF/views/page/pub/infopublic/infodetail/resource");
		//添加字体，以支持中文
		render.getFontResolver().addFont(path + "/ARIALUNI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		render.getFontResolver().addFont(path + "/SIMSUN.TTC", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

		return render;
	}

	//获取要写入PDF的内容
	public static String getPdfContent(String ftlPath, String ftlName, Object o) throws   Exception, TemplateException {
		return useTemplate(ftlPath, ftlName, o);
	}

	//使用freemarker得到html内容
	public static String useTemplate(String ftlPath, String ftlName, Object o) throws   IOException, TemplateException {

		String html = null;

		Template tpl = getFreemarkerConfig(ftlPath).getTemplate(ftlName);
		tpl.setEncoding("UTF-8");

		StringWriter writer = new StringWriter();
		tpl.process(o, writer);
		writer.flush();
		html = writer.toString();
		return html;
	}

	/**
	 * 获取Freemarker配置
	 * @param templatePath
	 * @return
	 * @throws IOException
	 */
	private static Configuration getFreemarkerConfig(String templatePath) throws IOException {
		Configuration config = new Configuration();
		config.setDirectoryForTemplateLoading(new File(templatePath));
		config.setEncoding(Locale.CHINA, "utf-8");
		return config;
	}
	
	/**
	 * 获取类路径
	 * @return
	 */
	public static String getPath(){
		return PdfHelper.class.getResource("").getPath().substring(1);
	}

}
