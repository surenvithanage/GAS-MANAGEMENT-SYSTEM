package com.gas.management.server.service.order;

import com.gas.management.server.dto.OrderDto;
import com.gas.management.server.entity.Order;
import com.gas.management.server.mail.model.Email;
import com.gas.management.server.repository.OrderRespository;
import com.gas.management.server.service.mail.MailService;
import com.gas.management.server.service.sms.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRespository orderRespository;

    @Autowired
    private SmsService smsService;

    @Autowired
    private MailService mailService;

    @Override
    public Order create(OrderDto orderDto) {

        try {
            Order order = new Order();
            order.setEmail(orderDto.getEmail());
            order.setMobileNumber(orderDto.getMobileNumber());
            order.setQuantity(orderDto.getQuantity());
            order.setShopId(orderDto.getShopId());
            order.setUserId(orderDto.getUserId());

//            smsService.sendSMS(orderDto.getMobileNumber());

            Email email = new Email();
            email.setFrom("surenanthonyvithanage@gmail.com");
            email.setTo(orderDto.getEmail());
            email.setSubject("Order Placed Successfully");
            email.setTemplate("welcome-email.html");
            email.setText("Order have been placed successfully. You can come and collect the Gas on " + new Date() + " after 13.00 pm. Thank you");
            mailService.sendHtmlMessage(email);

            return orderRespository.save(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterable<Order> list() {
        return orderRespository.findAll();
    }

    @Override
    public Order find(long id) {
        Optional<Order> optionalOrder = orderRespository.findById(id);
        if (optionalOrder.isPresent()) {
            return optionalOrder.get();
        }
        return null;
    }

    @Override
    public Order update(OrderDto orderDto, long id) {
        Order order;
        try {
            Optional<Order> optionalOrder = orderRespository.findById(id);
            if (optionalOrder.isPresent()) {
                order = optionalOrder.get();
                order.setMobileNumber(orderDto.getMobileNumber());
                order.setEmail(orderDto.getEmail());
                return orderRespository.save(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        Optional<Order> optionalOrder = orderRespository.findById(id);
        if (optionalOrder.isPresent()) {
            orderRespository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Order> userRelated(long id) {
        return orderRespository.findByUserId(id);
    }

    @Override
    public List<Order> shopRelated(long id) {
        return null;
    }
}
