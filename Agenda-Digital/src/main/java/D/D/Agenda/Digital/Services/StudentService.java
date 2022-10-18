package D.D.Agenda.Digital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import D.D.Agenda.Digital.Models.StudentModel;
import D.D.Agenda.Digital.Repository.StudentRepository;

//@Component//permite usar una arquitectura singleton haciendo uso correcto de los @Autowire
@Service
public class StudentService{
	
/*
	Dado que nencesitamos hacer uso del CRUD creado en la interface UserRepository crearemos una instancia de dicha interface aca, todo bien hasta
	que se empiezan a realizar las peticiones pues cada peticion debera hacer uso de una nueva instancia ocupando la memoria del equipo/server que
	ejecute el aplicativo seguido de un StackOverflow Exception que nos indica que efectivamente se saturo la memoria ram disponible para este 
	aplicativo.
	
	Para solucionar esto hacemos uso de @Autowire que le indica al framework SPRING que si hay una una nueva isntancia de la interface 
	UserRepository esta sera sobre escrita por nuevas instancias, claro esta que sera realizado cuando ya no se encuentre en uso. como resultado de
	esto tendremos una OBJECT POOL que nos permitira obtimizar los recursos de la maquina
*/
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void newStudent(StudentModel student) {
		StudentModel studentDB = studentRepository.findByEmail(student.getEmail());
		if(studentDB==null) {
			student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
			studentRepository.save(student);
		}else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "el email ingresado ya se encuentra en uso");
		}
	}
	
	public boolean validateStudent(StudentModel student) {
		
		StudentModel studentDB = studentRepository.findByEmail(student.getEmail());
		if(studentDB!=null) {
			return bCryptPasswordEncoder.matches(student.getPassword(), studentRepository.findByEmail(student.getEmail()).getPassword());
		}
		return false;
	}
	
	public String getStats() {
		return "\"noStudens\": \""+studentRepository.count()+"\",\n";
	}
	
	public String getStudentLoggin(StudentModel student) {
		StudentModel studentDB = studentRepository.findByEmail(student.getEmail());
		return "    \"id\":\""+studentDB.getId()+"\","
			+  "    \"name\":\""+studentDB.getName()+"\","
			+  "    \"lastName\":\""+studentDB.getLastName()+"\"";
	}
	
	public StudentModel getStudentMattterRegister(Long id) {
		return studentRepository.findById(id).get();
	}
	
}
