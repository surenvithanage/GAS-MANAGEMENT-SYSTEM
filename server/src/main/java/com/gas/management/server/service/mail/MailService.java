package com.gas.management.server.service.mail;

import com.gas.management.server.mail.model.Email;

public interface MailService {
    void sendSimpleMessage(Email email);
}
