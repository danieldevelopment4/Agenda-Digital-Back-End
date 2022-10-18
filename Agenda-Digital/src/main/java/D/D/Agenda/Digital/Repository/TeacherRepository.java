package D.D.Agenda.Digital.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import D.D.Agenda.Digital.Models.TeacherModel;

@Repository
public interface TeacherRepository extends CrudRepository<TeacherModel, Long>{//este repository tambien es conocido como DAO

/*
	Los metodos del CRUD( Create, Read, Update, Delete) ya se encuentran programados en la interface CrudRepository por lo que no necesitaremos
	programarlos nosotros, unicamente tendremos que hacer usos de ellos
*/

//	@Query(value = "select * from docente WHERE cellphone=cellphone or email=email", nativeQuery = true)
//	public Iterable<TeacherModel> findExisitingTeacher(@Param("cellphone")String cellphone, @Param("email")String email);
	
	public abstract TeacherModel findByCellphone(String cellphone);
	
}
