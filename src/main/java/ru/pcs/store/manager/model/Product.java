package ru.pcs.store.manager.model;

import lombok.*;
import ru.pcs.store.manager.enums.ProductStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    //статус зависит от кол-ва товара на складе и в брони
    //изначально установить вручную, потом автоматом
    @Column
    @Enumerated(value = EnumType.STRING)
    private ProductStatus status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "material")
    private String material;

    @Column(name = "size")
    private Integer size;

    //далее всё высчитывается

    // при добавлении закупки totalNumber += numberOfNewBalance, leftovers пересчитать
    // при оплате заказа totalNumber -= numberInOrder, booked -= numberInOrder
    @Column(name = "totalNumber")
    private Integer totalNumber;

    // leftovers = totalNumber - booked
    // при добавлении закупки leftovers пересчитать, totalNumber += numberOfNewBalance
    // при добавлении в заказ leftovers -= numberInOrder, booked += numberInOrder
    // при отмене заказа leftovers += numberInOrder, booked -= numberInOrder
    @Column(name = "leftovers")
    private Integer leftovers;

    // при добавлении в заказ booked += numberInOrder, leftovers -= numberInOrder
    // при оплате заказа booked -= numberInOrder, totalNumber -= numberInOrder
    // при отмене заказа booked -= numberInOrder, leftovers += numberInOrder
    @Column(name = "booked")
    private Integer booked;

    //будем показывать менеджеру те, которые закуплены первыми - ?
    @Column(name = "margin")
    private BigDecimal margin;

    // считаем: сумму закупки / кол-во
    @Column(name = "purchasePrice")
    private BigDecimal purchasePrice;

    // считаем: purchasePrice * margin / 100
    @Column(name = "sellingPrice")
    private BigDecimal sellingPrice;

    //связь с поставками
    @OneToMany(cascade = CascadeType.ALL)
    private List<Balance> balances;

    //связь с заказами
    @ManyToMany
    private List<OrdersList> ordersLists;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getStatus() == product.getStatus() && getId().equals(product.getId()) && getName().equals(product.getName()) && getColor().equals(product.getColor()) && getMaterial().equals(product.getMaterial()) && getSize().equals(product.getSize()) && getTotalNumber().equals(product.getTotalNumber()) && getLeftovers().equals(product.getLeftovers()) && getBooked().equals(product.getBooked()) && getMargin().equals(product.getMargin()) && getPurchasePrice().equals(product.getPurchasePrice()) && getSellingPrice().equals(product.getSellingPrice()) && Objects.equals(getBalances(), product.getBalances()) && Objects.equals(getOrdersLists(), product.getOrdersLists());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getId(), getName(), getColor(), getMaterial(), getSize(), getTotalNumber(), getLeftovers(), getBooked(), getMargin(), getPurchasePrice(), getSellingPrice(), getBalances(), getOrdersLists());
    }

    @Override
    public String toString() {
        return "Product{" +
                "Статус: " + status +
                ", id: " + id +
                ", наименование: '" + name + '\'' +
                ", цвет: '" + color + '\'' +
                ", материал: '" + material + '\'' +
                ", размер: " + size +
                ", всего в наличии: " + totalNumber +
                "шт., из них свободны для бронирования: " + leftovers +
                "шт., забронировано: " + booked +
                "шт., наценка: " + margin +
                "%, цена закупки за 1 ед.товара: " + purchasePrice +
                " руб., цена продажи 1 ед.товара: " + sellingPrice +
                '}';
    }
}
