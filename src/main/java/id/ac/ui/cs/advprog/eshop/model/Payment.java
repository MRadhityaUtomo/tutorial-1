package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;

import lombok.Getter;

import java.util.Map;

@Getter
public class Payment {
    String id;
    String method;
    Order order;
    Map<String, String> paymentData;

    String status;

    public Payment(String id, String method, Order order, Map<String, String> paymentData, String Status) {
        this.id = id;
        this.method = method;
        this.setOrder(order);
        this.setPaymentData(paymentData);
        this.setStatus(status);
    }


    public Payment(String id, String method, Order order, Map<String, String> paymentData) {
          this(id, method, order, paymentData, PaymentStatus.PENDING.getValue());
    }

    private void setOrder(Order order) {
        if (order != null) {
            this.order = order;
        } else {
            throw new IllegalArgumentException("Order must not be null");
        }
    }

    public void setStatus(String status) {
        if (PaymentStatus.contains(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Payment status Invalid");
        }
    }

    protected void setPaymentData(Map<String, String> paymentData) {
        if (PaymentMethod.contains(this.method)) {
            this.paymentData = paymentData;
        } else {
            throw new IllegalArgumentException("Payment method is not specified. Unable to assign payment data specific to a method");
        }
    }
}