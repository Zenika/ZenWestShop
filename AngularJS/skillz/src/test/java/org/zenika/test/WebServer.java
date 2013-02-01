package org.zenika.test;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.zenika.skillz.web.SkillzWebAppInitializer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebServer implements TestRule {


    private final int portNumber;

    public WebServer() {
        this.portNumber = Integer.getInteger("port", 8080);
    }

    public String getURL() {
        return "http://localhost:" + portNumber + "/";
    }

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {

                Server server = new Server(portNumber);
                ServletContextHandler context = new ServletContextHandler();
                context.addEventListener(new ServletContextListener() {
                    @Override
                    public void contextInitialized(ServletContextEvent sce) {
                        new SkillzWebAppInitializer().onStartup(sce.getServletContext());
                    }

                    @Override
                    public void contextDestroyed(ServletContextEvent sce) {
                    }
                });

                server.setHandler(context);
                server.start();
                try {
                    base.evaluate();
                } finally {
                    server.stop();
                }
            }
        };
    }
}