package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.FrontMirror;
import servlets.Frontend;

public class Main {
    public static void main(String[] args) {
        Frontend frontend = new Frontend();
        FrontMirror frontMirror = new FrontMirror();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(frontMirror), "/mirror");
        context.addServlet(new ServletHolder(frontend), "/*");

        Server server = new Server(8080);
        server.setHandler(context);

        try {
            server.start();
            java.util.logging.Logger.getGlobal().info("Server started");
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
