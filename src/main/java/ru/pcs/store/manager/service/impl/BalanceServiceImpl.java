package ru.pcs.store.manager.service.impl;

import ru.pcs.store.manager.enums.ProductStatus;
import ru.pcs.store.manager.form.BalanceForm;
import ru.pcs.store.manager.model.Balance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pcs.store.manager.model.Product;
import ru.pcs.store.manager.repositories.BalanceRepository;
import ru.pcs.store.manager.repositories.ProductRepository;
import ru.pcs.store.manager.service.BalanceService;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;
    private final ProductRepository productRepository;

    @Override
    public void create(BalanceForm form, Long productId) {
        Product product = productRepository.getById(productId);

        BigDecimal purchasePrice = form.getTotalPrice().divide(BigDecimal.valueOf(form.getNumber()));
        BigDecimal sellingPrice = (purchasePrice.divide(BigDecimal.valueOf(100))).multiply(form.getMargin());

        Balance balance = Balance.builder()
                .number(form.getNumber())
                .totalPrice(form.getTotalPrice())
                .margin(form.getMargin())
                .purchasePrice(purchasePrice)
                .sellingPrice(sellingPrice)
                .product(product)
                .build();
        balanceRepository.save(balance);

        product.getBalances().add(balance);
        product.setTotalNumber(product.getTotalNumber() + balance.getNumber());
        product.setLeftovers(product.getLeftovers() + balance.getNumber());
        if (product.getLeftovers() > 0) {
            product.setStatus(ProductStatus.enough);
        }
        productRepository.save(product);
    }

    @Override
    public List<Balance> readAll() {
        return balanceRepository.findAll();
    }

    @Override
    public List<Balance> readAllByProductId(Long productId) {
        return balanceRepository.findAllByProductIdOrderByPurchasePrice(productId);
    }

    @Override
    public List<Balance> findAllByNumberGreaterThan(Integer number) {
        return balanceRepository.findAllByNumberGreaterThan(number);
    }

    @Override
    public Balance read(Long id) {
        return balanceRepository.getById(id);
    }

    @Override
    public void update(Long id, BalanceForm form) {
        BigDecimal purchasePrice = form.getTotalPrice().divide(BigDecimal.valueOf(form.getNumber()));
        BigDecimal sellingPrice = (purchasePrice.divide(BigDecimal.valueOf(100))).multiply(form.getMargin());

        Balance balance = balanceRepository.getById(id);

        balance.setNumber(form.getNumber());
        balance.setTotalPrice(form.getTotalPrice());
        balance.setMargin(form.getMargin());
        balance.setPurchasePrice(purchasePrice);
        balance.setSellingPrice(sellingPrice);

        balanceRepository.save(balance);
    }

    @Override
    public void delete(Long id) {
        balanceRepository.deleteById(id);
    }

    @Override
    public void deleteAllByProductId(Long productId) {
        balanceRepository.deleteAllByProductId(productId);
    }
}
