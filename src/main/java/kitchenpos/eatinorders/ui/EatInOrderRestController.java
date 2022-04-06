package kitchenpos.eatinorders.ui;

import kitchenpos.eatinorders.domain.EatInOrder;
import kitchenpos.eatinorders.application.EatInOrderService;
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

@RequestMapping("/api/orders/eat-in")
@RestController
public class EatInOrderRestController {
    private final EatInOrderService eatInOrderService;

    public EatInOrderRestController(final EatInOrderService eatInOrderService) {
        this.eatInOrderService = eatInOrderService;
    }

    @PostMapping
    public ResponseEntity<EatInOrder> create(@RequestBody final EatInOrder request) {
        final EatInOrder response = eatInOrderService.create(request);
        return ResponseEntity.created(URI.create("/api/orders/eat-in/" + response.getId()))
            .body(response);
    }

    @PutMapping("/{orderId}/accept")
    public ResponseEntity<EatInOrder> accept(@PathVariable final UUID orderId) {
        return ResponseEntity.ok(eatInOrderService.accept(orderId));
    }

    @PutMapping("/{orderId}/serve")
    public ResponseEntity<EatInOrder> serve(@PathVariable final UUID orderId) {
        return ResponseEntity.ok(eatInOrderService.serve(orderId));
    }

    @PutMapping("/{orderId}/complete")
    public ResponseEntity<EatInOrder> complete(@PathVariable final UUID orderId) {
        return ResponseEntity.ok(eatInOrderService.complete(orderId));
    }

    @GetMapping
    public ResponseEntity<List<EatInOrder>> findAll() {
        return ResponseEntity.ok(eatInOrderService.findAll());
    }
}
