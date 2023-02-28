package seg.demo.auth.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import seg.demo.auth.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
