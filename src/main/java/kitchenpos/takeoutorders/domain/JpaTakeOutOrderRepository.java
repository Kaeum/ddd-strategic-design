package kitchenpos.takeoutorders.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaTakeOutOrderRepository extends TakeOutOrderRepository, JpaRepository<TakeOutOrder, UUID> {
}