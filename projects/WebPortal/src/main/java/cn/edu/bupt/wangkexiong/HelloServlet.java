package cn.edu.bupt.wangkexiong;

import javax.servlet.*;
import javax.servlet.http.*;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.*;
import java.util.*;

public class HelloServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        logger.info("Received GET request");

        PrintWriter out;
        out = response.getWriter();
        out.print("Hello World");
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        Map params = request.getParameterMap();

        if (params != null) {
            Iterator iter = params.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry)iter.next();
                String key = (String) entry.getKey();
                String[] val = (String[]) entry.getValue();
                logger.info("{} : {}", key, val);
            }

            String name = request.getParameter("username");
            if (name != null && name != "") {
                Welcome secretary = new Welcome(name);
                request.getSession().setAttribute("info", secretary.sayHello());
            } else {
                request.getSession().invalidate();
            }
        }

        request.getRequestDispatcher("/").forward(request,response);
    }
}
