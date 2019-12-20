package com.example.demo.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShopOrderKeyed {

    @Id
    private Long id;
    private String description;
    private Map<String, LineItemKeyed> lineItems;

    public void addLineItems(String key, LineItemKeyed lineItem) {
        this.lineItems.put(key, lineItem);
    }

    public void removeLineItems() {
        this.lineItems.clear();
    }

    public ShopOrderKeyed(Long id, String description, Map<String, LineItemKeyed> lineItems) {
        this.id = id;
        this.description = description;
        this.lineItems = lineItems;
    }

    @Override
    public String toString() {
        return "ShopOrderKeyed{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", lineItems=" + lineItems +
                '}';
    }

    public static class LineItemKeyed {
        private BigDecimal price;
        private BigDecimal amount;

        public LineItemKeyed(BigDecimal price, BigDecimal amount) {
            this.price = price;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "LineItemKeyed{" +
                    "price=" + price +
                    ", amount=" + amount +
                    '}';
        }
    }
}
