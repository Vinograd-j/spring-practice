package net.vinograd.tacocloud.data;

import net.vinograd.tacocloud.model.TacoOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

}
