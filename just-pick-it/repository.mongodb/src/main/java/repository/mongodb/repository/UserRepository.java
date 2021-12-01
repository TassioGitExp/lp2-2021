package repository.mongodb.repository;
import com.justpickit.core.domain.User;
import com.justpickit.core.ports.driven_R.repository.UserRepositoryPort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>, UserRepositoryPort {

}
