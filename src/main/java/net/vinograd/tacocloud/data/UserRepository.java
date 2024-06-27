package net.vinograd.tacocloud.data;

import net.vinograd.tacocloud.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
