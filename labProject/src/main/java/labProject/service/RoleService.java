package labProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import labProject.entitiy.Role;
import labProject.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public Role getRoleById(Long id) {
		return this.roleRepository.findById(id).orElse(null);
	}
}
