package com.itroi.itroi.listeners;


import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    private static final Logger log = LoggerFactory.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        log.debug("Session created: {}", event.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        log.debug("Session destroyed: {}", event.getSession().getId());
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        log.debug("Attribute added to session: {} = {}", event.getName(), event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        log.debug("Attribute removed from session: {}", event.getName());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        log.debug("Attribute replaced in session: {} = {}", event.getName(), event.getValue());
    }
}