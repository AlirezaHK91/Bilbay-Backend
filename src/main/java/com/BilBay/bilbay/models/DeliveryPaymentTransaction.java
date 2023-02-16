package com.BilBay.bilbay.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

    @Entity
    @Table(name = "delivery_payment_transactions")
    public class DeliveryPaymentTransaction {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, updatable = false)
        private int id;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "buyer_id", referencedColumnName = "id")
        private User user;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "orders_id", referencedColumnName = "id")
        private Order order;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "delivery_alternatives_id", referencedColumnName = "id")
        private DeliveryAlternative deliveryAlternatives;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "card_payment_id", referencedColumnName = "id")
        private CardPayment cardPayment;

        @NotNull
        @Column(name = "is_successful")
        @ColumnDefault("false")
        private boolean isSuccessful;
        @CreationTimestamp
        @Column(name = "created_at")
        private LocalDate createdAt;


        public DeliveryPaymentTransaction() {
        }
        public DeliveryPaymentTransaction(int id, User user, Order order, DeliveryAlternative deliveryAlternatives, CardPayment cardPayment, boolean isSuccessful, LocalDate createdAt) {
            this.id = id;
            this.user = user;
            this.order = order;
            this.deliveryAlternatives = deliveryAlternatives;
            this.cardPayment = cardPayment;
            this.isSuccessful = isSuccessful;
            this.createdAt = createdAt;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Order getOrder() {
            return order;
        }

        public void setOrder(Order order) {
            this.order = order;
        }

        public DeliveryAlternative getDeliveryAlternatives() {
            return deliveryAlternatives;
        }

        public void setDeliveryAlternatives(DeliveryAlternative deliveryAlternatives) {
            this.deliveryAlternatives = deliveryAlternatives;
        }

        public CardPayment getCardPayment() {
            return cardPayment;
        }

        public void setCardPayment(CardPayment cardPayment) {
            this.cardPayment = cardPayment;
        }

        public boolean isSuccessful() {
            return isSuccessful;
        }

        public void setSuccessful(boolean successful) {
            isSuccessful = successful;
        }

        public LocalDate getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDate createdAt) {
            this.createdAt = createdAt;
        }
    }




}