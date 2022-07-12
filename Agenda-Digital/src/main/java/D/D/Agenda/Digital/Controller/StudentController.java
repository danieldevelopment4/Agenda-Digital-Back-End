package D.D.Agenda.Digital.Controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import D.D.Agenda.Digital.Models.StudentModel;
import D.D.Agenda.Digital.Security.JWTAuthorizationFilter;
import D.D.Agenda.Digital.Services.StudentService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/student")//indica la ruta con la que se podra solicitar estos servicios
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	JWTAuthorizationFilter jwtAuthorizationFilter;
	
	/*
	 * @RequestBody: indica que el objeto que se enviara como parametro llegara en el cuerpo de la peticion 
	 * 
	 * 
	 * @RequestParam: indica que el objeto que se enviara como parametro llegara en la cabecera de la peticion
	 * login(RequestBody("email") String email, RequestBody("password") String password)
	 * 
	 * gracias a esto el framework sabra que hacer con estos datos y a donde deben de ser direccionados
	 */
	
	@PostMapping("/register")
	public void register(@RequestBody StudentModel student) {
		studentService.newStudent(student);
	}
	
	@PostMapping("/loggin")
	public String login(@RequestBody StudentModel student) {
		
		if (studentService.validateStudent(student)) {
			String token = getJWTToken(student.getEmail());
			return "{\n"
					+ "    \"AccessToken\":\""+token+"\""
				+ "\n}";
		}else {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales erroneas");
		}
	}
	
	private String getJWTToken(String email) {
		String secretKey = jwtAuthorizationFilter.getSECRET();
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("STUDENT");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(email)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

//		return "Bearer " + token;
		return token;
	}
	
//	@PostMapping(path = "/{id}")//indica que dentro de la ruta llegara un valor que sera asiganado a la clave id
//	public String deleteUser(@PathVariable("id") Long id) {
//		if(studentService.deleteUser(id)) {
//			return "se elimino el usuario identificado con el id:"+id;
//		}
//		return "NO se pudo eliminar el usuario identificado con el id:"+id;
//	}
	
}
