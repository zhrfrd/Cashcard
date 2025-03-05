package zhrfrd.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   // Indicates that this is component able to handle HTTP requests
@RequestMapping("/cashcards")   // Indicates which address requests must have to access this component
class CashCardController {
    @GetMapping("/{requestedId}")   // Indicates that this is a handler method. More in specific GET requests that match /cashcards/{requestedId} will be handled by this method
    private ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {   // @PathVariable makes Spring Web aware of the requestedId supplied in the HTTP request. Now it’s available for us to use in our handler method.
        if (requestedId.equals(99L)) {
            CashCard cashCard = new CashCard(99L, 123.45);
            return ResponseEntity.ok(cashCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
