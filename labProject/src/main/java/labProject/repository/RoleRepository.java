package labProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import labProject.entitiy.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
