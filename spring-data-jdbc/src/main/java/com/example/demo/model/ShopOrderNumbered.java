package com.example.demo.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.List;

public class ShopOrderNumbered {

    @Id
    private Long id;
    private String description;
    private List<ShopOrderNumbered.LineItemNumbered> lineItems;
    public void addLineItems(ShopOrderNumbered.LineItemNumbered lineItem) {
        this.lineItems.add(lineItem);
    }
    public void removeLineItems() {
        this.lineItems.clear();
    }
    @Override
    public String toString() {
        return "ShopOrderNumbered{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", lineItems=" + lineItems +
                '}';
    }

    public ShopOrderNumbered(Long id, String description, List<LineItemNumbered> lineItems) {
        this.id = id;
        this.description = description;
        this.lineItems = lineItems;
    }

    public static class LineItemNumbered {
        private BigDecimal price;
        private BigDecimal amount;

        public LineItemNumbered(BigDecimal price, BigDecimal amount) {
            this.price = price;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "LineItemNumbered{" +
                    "price=" + price +
                    ", amount=" + amount +
                    '}';
        }
    }
}
