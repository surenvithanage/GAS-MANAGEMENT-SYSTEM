package com.gas.management.server.service.sms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SmsService {

    private static final String TWILIO_ACCOUNT_SID = "";
    private static final String TWILIO_AUTH_TOKEN = "";
    private static final String TWILIO_TEST_NUMBER = "";

    public void sendSMS(String customerNumber) {
        Twilio.init(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
        Message.creator(new PhoneNumber(customerNumber),
                new PhoneNumber(TWILIO_TEST_NUMBER), "Order have been placed successfully. You can come and collect the Gas on " + new Date() + " after 13.00 pm. Thank you").create();
    }
}
