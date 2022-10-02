package D.D.Agenda.Digital.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import D.D.Agenda.Digital.Models.StudentModel;
import D.D.Agenda.Digital.Services.StudentService;


@RestController
@RequestMapping("/student")//indica la ruta con la que se podra solicitar estos servicios
public class StudentController {

	@Autowired
	StudentService studentService;
	
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
	
	@PostMapping(value="/loggin", produces = MediaType.APPLICATION_JSON_VALUE)
	public String login(@RequestBody StudentModel student) {
		if (studentService.validateStudent(student)) {
			return "{\n"
					+ studentService.getStudentLoggin(student)
				 + "\n}";
		}else {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales erroneas");
		}
	}
	
}
