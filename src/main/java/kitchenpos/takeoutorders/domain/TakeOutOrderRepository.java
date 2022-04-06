package kitchenpos.takeoutorders.domain;

import kitchenpos.ordertable.domain.OrderTable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TakeOutOrderRepository {
    TakeOutOrder save(TakeOutOrder takeOutOrder);

    Optional<TakeOutOrder> findById(UUID id);

    List<TakeOutOrder> findAll();

    boolean existsByOrderTableAndStatusNot(OrderTable orderTable, OrderStatus status);
}

