package com.hackerearth.fullstack.backend;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServer {
    private Server server;

    public void start() {
        try {
            server = new Server(8080); // serve website/ on :8080
            WebAppContext ctx = new WebAppContext();
            ctx.setResourceBase("website");
            ctx.setContextPath("/");
            server.setHandler(ctx);
            server.start();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void stop() {
        try {
            if (server != null) server.stop();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
