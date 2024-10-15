package alberto9rm.inventories.repository;

import alberto9rm.inventories.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Producto, Integer> {
}
