package D.D.Agenda.Digital.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import D.D.Agenda.Digital.Models.ActivityModel;
import D.D.Agenda.Digital.Models.MatterModel;
import D.D.Agenda.Digital.Models.StudentModel;
import D.D.Agenda.Digital.Models.SubmitModel;
import D.D.Agenda.Digital.Models.SubscriptionModel;
import D.D.Agenda.Digital.Models.TeacherModel;
import D.D.Agenda.Digital.Repository.ActivityRepository;
import D.D.Agenda.Digital.Repository.MatterRepository;
import D.D.Agenda.Digital.Repository.StudentRepository;
import D.D.Agenda.Digital.Repository.SubmitRepository;
import D.D.Agenda.Digital.Repository.SubscriptionRepository;
import D.D.Agenda.Digital.Repository.TeacherRepository;

@Service
public class SubscriptionService {
	
	@Autowired
	SubscriptionRepository subscriptionRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	ActivityRepository activityRepository;
	@Autowired
	SubmitRepository submitRepository;
	
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
	
	public String show(SubscriptionModel subscription){
		String data = "[\n";
		SubscriptionModel subscriptionDB;
		StudentModel studentDB = studentRepository.findById(subscription.getStudent().getId()).get();
		ArrayList<SubscriptionModel> subscriptionList = subscriptionRepository.findAllByStudent(studentDB);
		MatterModel matterDB;
		boolean admin;
		ArrayList<ActivityModel> activitiesList;
		TeacherModel teacherDB;
		ArrayList<SubmitModel> submitList;
		for (int i = 0; i < subscriptionList.size(); i++) {
			subscriptionDB = subscriptionList.get(i); 
			matterDB = subscriptionDB.getMatter();
			admin = subscription.getStudent().getId()==matterDB.getStudent().getId();
			activitiesList = activityRepository.findAllByMatter(matterDB);
			submitList = submitRepository.findAllSubmitBySubscription(subscriptionDB);
			teacherDB = matterDB.getTeacher();
			data+= subscriptionDB.toString(matterDB.toString(subscriptionDB.isRequest(), teacherDB, activitiesList, submitList, admin));
			data+=((i<subscriptionList.size()-1)?",\n":"\n");
		}
		data+="]";
		return data;
	}
	
	
}
