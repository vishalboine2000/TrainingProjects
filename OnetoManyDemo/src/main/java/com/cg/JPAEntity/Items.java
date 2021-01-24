package com.cg.JPAEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ITEMS")
public class Items {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name="id")
        private long id;
        
        @Column(name="item_id")
        private String itemId;
        
        @Column(name="item_total")
        private double itemTotal;
        
        @Column(name="quantity")
        private int quantity;
        public Items(String itemId, double itemTotal, int quantity) {
            super();
        
            this.itemId = itemId;
            this.itemTotal = itemTotal;
            this.quantity = quantity;
        }
        public Items() {
            // TODO Auto-generated constructor stub
        }
        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public String getItemId() {
            return itemId;
        }
        public void setItemId(String itemId) {
            this.itemId = itemId;
        }
        public double getItemTotal() {
            return itemTotal;
        }
        public void setItemTotal(double itemTotal) {
            this.itemTotal = itemTotal;
        }
        public int getQuantity() {
            return quantity;
        }
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }      
}
