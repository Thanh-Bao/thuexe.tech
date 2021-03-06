package tech.thuexe.controller.RESTfulAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.thuexe.entity.OrderEntity;
import tech.thuexe.service.OrderService;
import tech.thuexe.utility.CustomException;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/orders")
@Validated
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping()
    public ResponseEntity<OrderEntity> save(@RequestBody OrderEntity order,
                                            @RequestParam int postId) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path(null).toUriString());
        return ResponseEntity.created(uri).body(orderService.save(order, postId));
    }

    @GetMapping()
    public ResponseEntity<List<OrderEntity>> getOrders() {
        return ResponseEntity.ok().body(orderService.findAllByUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> getOrder(@PathVariable int id) {
        return ResponseEntity.ok().body(orderService.findById(id));
    }

    @PostMapping("/{id}/checkout")
    public ResponseEntity<String> checkout(@PathVariable int id) throws CustomException {
        orderService.checkout(id);
        return ResponseEntity.ok().body("ok");
    }

}
