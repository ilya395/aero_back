package ru.pcs.store.manager.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "balance")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private Integer number;

    @Column(name = "totalPrice")
    private BigDecimal totalPrice;

    // размер наценки в %
    // будем показывать менеджеру те, которые закуплены первыми - ?
    @Column(name = "margin")
    private BigDecimal margin;

    // закупочная цена за 1 ед.товара
    // считаем: сумму закупки / кол-во
    @Column(name = "purchasePrice")
    private BigDecimal purchasePrice;

    // цена продажи за 1 ед.товара
    // считаем: purchasePrice * margin / 100
    @Column(name = "sellingPrice")
    private BigDecimal sellingPrice;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Balance)) return false;
        Balance balance = (Balance) o;
        return getId().equals(balance.getId()) && getNumber().equals(balance.getNumber()) && getTotalPrice().equals(balance.getTotalPrice()) && getMargin().equals(balance.getMargin()) && getPurchasePrice().equals(balance.getPurchasePrice()) && getSellingPrice().equals(balance.getSellingPrice()) && getProduct().equals(balance.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumber(), getTotalPrice(), getMargin(), getPurchasePrice(), getSellingPrice(), getProduct());
    }

    @Override
    public String toString() {
        return "Balance{" +
                "id: " + id +
                ", Наименование: " + product.getName() +
                ", количество: " + number +
                " шт., общая сумма закупки: " + totalPrice +
                " руб., наценка: " + margin +
                "%, цена закупки за 1 ед.товара: " + purchasePrice +
                " руб., цена продажи 1 ед.товара: " + sellingPrice +
                " руб. , id товара: " + product.getId() +
                '}';
    }
}
