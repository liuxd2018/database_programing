package com.example.demo.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Set;

public class ShopOrder {
    @Override
    public String toString() {
        return "ShopOrder{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", lineItems=" + lineItems +
                '}';
    }

    @Id
    private Long id;
    private String description;
    private Set<LineItem> lineItems;

    public ShopOrder(Long id, String description, Set<LineItem> lineItems) {
        this.id = id;
        this.description = description;
        this.lineItems = lineItems;
    }

    public void addLineItems(LineItem lineItem) {
        this.lineItems.add(lineItem);
    }

    public static class LineItem {
        private BigDecimal price;
        private BigDecimal amount;

        public LineItem(BigDecimal price, BigDecimal amount) {
            this.price = price;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "LineItem{" +
                    "price=" + price +
                    ", amount=" + amount +
                    '}';
        }
    }
}
