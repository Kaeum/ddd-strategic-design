package kitchenpos.takeoutorders.ui;

import kitchenpos.eatinorders.domain.EatInOrder;
import kitchenpos.takeoutorders.application.TakeOutOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/orders/take-out")
@RestController
public class TakeOutOrderRestController {
    private final TakeOutOrderService takeOutOrderService;

    public TakeOutOrderRestController(final TakeOutOrderService takeOutOrderService) {
        this.takeOutOrderService = takeOutOrderService;
    }

    @PostMapping
    public ResponseEntity<EatInOrder> create(@RequestBody final EatInOrder request) {
        final EatInOrder response = takeOutOrderService.create(request);
        return ResponseEntity.created(URI.create("/api/orders/take-out/" + response.getId()))
            .body(response);
    }

    @PutMapping("/{orderId}/accept")
    public ResponseEntity<EatInOrder> accept(@PathVariable final UUID orderId) {
        return ResponseEntity.ok(takeOutOrderService.accept(orderId));
    }

    @PutMapping("/{orderId}/serve")
    public ResponseEntity<EatInOrder> serve(@PathVariable final UUID orderId) {
        return ResponseEntity.ok(takeOutOrderService.serve(orderId));
    }

    @PutMapping("/{orderId}/complete")
    public ResponseEntity<EatInOrder> complete(@PathVariable final UUID orderId) {
        return ResponseEntity.ok(takeOutOrderService.complete(orderId));
    }

    @GetMapping
    public ResponseEntity<List<EatInOrder>> findAll() {
        return ResponseEntity.ok(takeOutOrderService.findAll());
    }
}
