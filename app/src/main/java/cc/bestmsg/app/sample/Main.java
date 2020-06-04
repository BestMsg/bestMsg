package cc.bestmsg.app.sample;

/**
 * Created by  songzip on 2020/6/3.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.Writer;

import cc.bestmsg.app.servlet.BestMsgServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Main {

    /**
     * Main method.
     *
     * @param args command line arguments passed to the application. Currently
     *             unused.
     * @throws LifecycleException   If a life cycle exception occurs.
     * @throws InterruptedException If the application is interrupted while
     *                              waiting for requests.
     * @throws ServletException     If the servlet handling the response has an
     *                              exception.
     */
    public static void main(String[] args)
            throws LifecycleException, InterruptedException, ServletException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8088);

        Context ctx = tomcat.addContext("/", new File(".").getAbsolutePath());

        Tomcat.addServlet(ctx, "hello", new HttpServlet() {
            private static final long serialVersionUID = 3600060857537422698L;

            @Override
            protected void service(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/plain");
                try (Writer writer = response.getWriter()) {
                    writer.write("Hello, Embedded World from Blue Lotus Software!");
                    writer.flush();
                }
            }
        });
        ctx.addServletMappingDecoded("/hello", "hello");

        Tomcat.addServlet(ctx, "msg", new BestMsgServlet());
        ctx.addServletMappingDecoded("/msg/*", "msg");

        tomcat.start();
        tomcat.getServer().await();
    }

}
