package org.lightfor.freemarker.servlet;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * servlet
 * Created by Light on 2017/7/11.
 */
public class FreemarkerServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html");
        // 实际的逻辑是在这里
        PrintWriter out = response.getWriter();
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
/*        WebappTemplateLoader templateLoader = new WebappTemplateLoader(request.getServletContext(), "WEB-INF/templates");
        cfg.setTemplateLoader(templateLoader);*/
        cfg.setClassForTemplateLoading(this.getClass(), "/templates");
        Map<String, String> msg = new HashMap<>();
        msg.put("message", "Hello World!");
        Template sampleTemplate = cfg.getTemplate("hello.ftl");
        Writer writer = new StringWriter();
        try {
            sampleTemplate.process(msg, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        out.write(writer.toString());
    }
}
