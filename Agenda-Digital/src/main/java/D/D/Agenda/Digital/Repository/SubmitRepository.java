package D.D.Agenda.Digital.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import D.D.Agenda.Digital.Models.ActivityModel;
import D.D.Agenda.Digital.Models.SubmitModel;
import D.D.Agenda.Digital.Models.SubscriptionModel;

@Repository
public interface SubmitRepository extends CrudRepository<SubmitModel, Long>{//este repository tambien es conocido como DAO

/*
	Los metodos del CRUD( Create, Read, Update, Delete) ya se encuentran programados en la interface CrudRepository por lo que no necesitaremos
	programarlos nosotros, unicamente tendremos que hacer usos de ellos
*/
	public abstract ArrayList<SubmitModel> findAllSubmitBySubscription(SubscriptionModel subscription);
}
