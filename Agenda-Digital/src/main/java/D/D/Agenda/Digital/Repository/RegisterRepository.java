package D.D.Agenda.Digital.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import D.D.Agenda.Digital.Models.RegisterModel;
import D.D.Agenda.Digital.Models.StudentModel;

@Repository
public interface RegisterRepository extends CrudRepository<RegisterModel, Long>{//este repository tambien es conocido como DAO

/*
	Los metodos del CRUD( Create, Read, Update, Delete) ya se encuentran programados en la interface CrudRepository por lo que no necesitaremos
	programarlos nosotros, unicamente tendremos que hacer usos de ellos
*/
	
	public abstract Iterable<RegisterModel> findAllByIdStudent(long id);
	
}
