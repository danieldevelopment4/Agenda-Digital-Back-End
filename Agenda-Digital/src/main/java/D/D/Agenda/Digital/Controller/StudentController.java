package D.D.Agenda.Digital.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import D.D.Agenda.Digital.Models.StudentModel;
import D.D.Agenda.Digital.Services.StudentService;

@RestController
@RequestMapping("/user")//indica la ruta con la que se podra solicitar estos servicios
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping//indica que cuando se haga una peticion de tipo POST esta hara uso uncamente del metodo a continuacion
	public StudentModel newUser(@RequestBody StudentModel user) {
		//@REquestBody indica que el objeto que se enviara como parametro llegara en el cuerpo
		//de la peticion, gracias a esto el framework sabra que hacer con estos datos y a donde deben de ser direccionados
		return studentService.newUser(user);
	}
	
//	@PostMapping(path = "/{id}")//indica que dentro de la ruta llegara un valor que sera asiganado a la clave id
//	public String deleteUser(@PathVariable("id") Long id) {
//		if(studentService.deleteUser(id)) {
//			return "se elimino el usuario identificado con el id:"+id;
//		}
//		return "NO se pudo eliminar el usuario identificado con el id:"+id;
//	}
	
}
