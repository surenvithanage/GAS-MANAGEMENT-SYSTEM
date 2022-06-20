package com.gas.management.server.mail.model;

import java.util.Map;

public class Email {
    String to;
    String from;
    String subject;
    String text;
    String template;
    Map<String, Object> properties;

    public Email() {
    }

    public Email(String to, String from, String subject, String text, String template, Map<String, Object> properties) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.text = text;
        this.template = template;
        this.properties = properties;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
}