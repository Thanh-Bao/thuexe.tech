package tech.thuexe.controller.enpointAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.thuexe.entity.OrderEntity;
import tech.thuexe.service.OrderService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/order")
@Validated
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<OrderEntity> save(@RequestBody OrderEntity order,
                                            @RequestParam int postId) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path(null).toUriString());
        return ResponseEntity.created(uri).body(orderService.save(order, postId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderEntity>> getOrders() {
        return ResponseEntity.ok().body(orderService.findAllByUser());
    }

}
