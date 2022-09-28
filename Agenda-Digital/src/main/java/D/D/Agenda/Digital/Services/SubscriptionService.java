package D.D.Agenda.Digital.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import D.D.Agenda.Digital.Models.StudentModel;
import D.D.Agenda.Digital.Models.SubscriptionModel;
import D.D.Agenda.Digital.Repository.StudentRepository;
import D.D.Agenda.Digital.Repository.SubscriptionRepository;

@Service
public class SubscriptionService {
	
	@Autowired
	SubscriptionRepository subscriptionRepository;
	@Autowired
	StudentRepository studentRepository;
	
	public SubscriptionModel subscribe(SubscriptionModel subscription) {
		return subscriptionRepository.save(subscription);
	}
	
	public void aprobeSubscription(SubscriptionModel subscription) {
		SubscriptionModel subscriptionDB = subscriptionRepository.findById(subscription.getId()).get();
		subscriptionDB.setRequest(false);
		subscriptionRepository.save(subscriptionDB);
	}
	
	public void deniedSubscription(SubscriptionModel subscription) {
		SubscriptionModel subscriptionDB = subscriptionRepository.findById(subscription.getId()).get();
		subscriptionDB.setMatter(null);
		subscriptionDB.setStudent(null);
		
		subscriptionRepository.delete(subscriptionDB);
	}
	
	public ArrayList<SubscriptionModel> show(SubscriptionModel subscription){
		StudentModel studentDB = studentRepository.findById(subscription.getStudent().getId()).get();
		ArrayList<SubscriptionModel> subscriptionList = subscriptionRepository.findAllByStudent(studentDB);
		for (int i = 0; i < subscriptionList.size(); i++) {
			subscriptionList.get(i).setStudent(null);//removemos informacion del estudiante, NO la requerimos
			subscriptionList.get(i).getMatter().setStudent(null);//removemos informacion del estudiante OWNER, NO la requerimos
		}
		return subscriptionList;
	}
	
	
}
