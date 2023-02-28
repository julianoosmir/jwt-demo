package seg.demo;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import seg.demo.auth.entity.Role;
import seg.demo.auth.entity.User;
import seg.demo.auth.service.RoleService;
import seg.demo.auth.service.UserService;

@Service
public class Initializer {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@PostConstruct
	public void criaUsuariosEPermissoes() {
		Role roleAdmin = new Role();

		roleAdmin.setName("USER");

		roleService.save(roleAdmin);

		User user = new User();
		user.setAtivo(true);
		user.setEmail("teste@teste.com");
		user.setNome("juliano");
		user.setSenha(new BCryptPasswordEncoder().encode("123456"));
		user.setUsername("julianoosmir");
		user.setRoles(Arrays.asList(roleAdmin));

		userService.save(user);

	}
}