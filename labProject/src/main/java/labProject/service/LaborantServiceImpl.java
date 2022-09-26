package labProject.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import labProject.dto.LaborantDto;
import labProject.entitiy.Laborant;
import labProject.entitiy.Role;
import labProject.repository.LaborantRepository;

@Service
public class LaborantServiceImpl implements LaborantService{

	private BCryptPasswordEncoder passwordEncoder;
	
	private LaborantRepository laborantRepository;
	
	public LaborantServiceImpl(LaborantRepository laborantRepository,@Lazy  BCryptPasswordEncoder passwordEncoder) {
		this.laborantRepository = laborantRepository;
		this.passwordEncoder = passwordEncoder;
	}

	
	
	@Override
	public Laborant saveLaborant(Laborant dto) {
		Laborant laborant = new Laborant();
		laborant.setLaborantName(dto.getLaborantName());
		laborant.setLaborantSurname(dto.getLaborantSurname());
		laborant.setEmail(dto.getEmail());
		laborant.setPassword(passwordEncoder.encode(dto.getPassword()));
		laborant.setRoles(Arrays.asList(new Role("LABORANT")));
		return this.laborantRepository.save(laborant);
	}



	@Override
	public Laborant getOneLaborantById(Long id) {
		return this.laborantRepository.findById(id).orElse(null);
	}



	@Override
	public List<Laborant> findAll(String keyword) {
		if(keyword != null) {
			return this.laborantRepository.findAll(keyword);
		}
		return this.laborantRepository.findAll();
	}



	@Override
	public void deleteLaborant(Long id) {
		this.laborantRepository.deleteById(id);
		
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Laborant laborant = this.laborantRepository.findByEmail(username);
		if(laborant == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new org.springframework.security.core.userdetails.User(laborant.getEmail(),laborant.getPassword(),mapRolesToAuthorities(laborant.getRoles()));
	}
	

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
