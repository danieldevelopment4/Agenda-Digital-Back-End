package D.D.Agenda.Digital.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import D.D.Agenda.Digital.Models.HoraryDayEnum;
import D.D.Agenda.Digital.Models.HoraryHourEnum;
import D.D.Agenda.Digital.Models.HoraryModel;

@Repository
public interface HoraryRepository extends CrudRepository<HoraryModel, Long>{//este repository tambien es conocido como DAO

/*
	Los metodos del CRUD( Create, Read, Update, Delete) ya se encuentran programados en la interface CrudRepository por lo que no necesitaremos
	programarlos nosotros, unicamente tendremos que hacer usos de ellos
*/
	
	public abstract HoraryModel findHoraryByDayAndHourAndDuration(HoraryDayEnum day, HoraryHourEnum hour, int duration);

}
