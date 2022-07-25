//package ru.pcs.store.manager.service.impl;
//
//import lombok.RequiredArgsConstructor;
//import ru.pcs.store.manager.form.AmountForm;
//import ru.pcs.store.manager.model.Amount;
//import ru.pcs.store.manager.repositories.AmountRepository;
//import ru.pcs.store.manager.service.AmountService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@Service
//public class AmountServiceImpl implements AmountService {
//
//    private final AmountRepository amountRepository;
//
//    @Override
//    public void create(AmountForm form) {
//        Amount amount = Amount.builder()
//                .paymentMethod(Amount.PaymentMethod.prepayment)
//                .amountPart(form.getAmountPart())
//                .build();
//
//        amountRepository.save(amount);
//    }
//
//    @Override
//    public List<Amount> readAll() {
//        return amountRepository.findAll();
//    }
//
//    @Override
//    public Amount read(Long id) {
//        return amountRepository.getById(id);
//    }
//
//    @Override
//    public void update(Long id, AmountForm amountForm) {
//        Amount amount = amountRepository.getById(id);
//        amount.setAmountPart(amountForm.getAmountPart());
//        amountRepository.save(amount);
//    }
//
//    @Override
//    public void delete(Long amountId) {
//        amountRepository.deleteById(amountId);
//    }
//
//    @Override
//    public void makeAmountFullSettlement(Long id) {
//        Amount amount = amountRepository.getById(id);
//        amount.setPaymentMethod(Amount.PaymentMethod.fullSettlement);
//        amountRepository.save(amount);
//    }
//
//    @Override
//    public void makeAmountCompensation(Long id) {
//        Amount amount = amountRepository.getById(id);
//        amount.setPaymentMethod(Amount.PaymentMethod.compensation);
//        amountRepository.save(amount);
//    }
//
//    @Override
//    public void makeAmountPrepayment(Long id) {
//        Amount amount = amountRepository.getById(id);
//        amount.setPaymentMethod(Amount.PaymentMethod.prepayment);
//        amountRepository.save(amount);
//    }
//}
