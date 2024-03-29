package D.D.Agenda.Digital.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import D.D.Agenda.Digital.Models.ActivityModel;
import D.D.Agenda.Digital.Models.MatterModel;
import D.D.Agenda.Digital.Models.StudentModel;
import D.D.Agenda.Digital.Models.SubmitModel;
import D.D.Agenda.Digital.Models.SubscriptionModel;
import D.D.Agenda.Digital.Models.TeacherModel;
import D.D.Agenda.Digital.Repository.ActivityRepository;
import D.D.Agenda.Digital.Repository.StudentRepository;
import D.D.Agenda.Digital.Repository.SubmitRepository;
import D.D.Agenda.Digital.Repository.SubscriptionRepository;

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
	
	public boolean validateSubscriptionByMatterName(MatterModel matter) {
		StudentModel studentDB = studentRepository.findById(matter.getStudent().getId()).get();
		ArrayList<SubscriptionModel> subscriptionList = subscriptionRepository.findAllByStudent(studentDB);
		for (int i = 0; i < subscriptionList.size(); i++) {
			if(subscriptionList.get(i).getMatter().getName().equals(matter.getName())) {
				return true;
			}
		}
		return false;
	}
	
	public SubscriptionModel subscribe(SubscriptionModel subscription) {
		SubscriptionModel subscriptionDB = subscriptionRepository.findByMatterAndStudent(subscription.getMatter(), subscription.getStudent());
		if(subscriptionDB==null) {
			return subscriptionRepository.save(subscription);
		}else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ya te encuentras subscrito a esta materia");
		}
	}
	
	public boolean isTheLastOne(SubscriptionModel subscription) {
		ArrayList<SubscriptionModel> subscriptionList = subscriptionRepository.findAllByMatter(subscription.getMatter());
		int aprobedRequest = 0;
		for (int i = 0; i < subscriptionList.size(); i++) {
			if(!subscriptionList.get(i).isRequest()) {//conteo de solicitudes aprobadas
				aprobedRequest++;
			}
		}
		return aprobedRequest==0?true:false;
	}
	
	public StudentModel getNewAdmin(MatterModel matter) {
		ArrayList<SubscriptionModel> subscriptionList = subscriptionRepository.findAllByMatter(matter);
		for (int i = 0; i < subscriptionList.size(); i++) {
			if(!subscriptionList.get(i).isRequest()) {//solicitudes aprobadas
				return subscriptionList.get(i).getStudent();
			}
		}
		return null;
	}
	
	public void deleteUnprobedSubscription(MatterModel matter) {
		ArrayList<SubscriptionModel> subscriptionList = subscriptionRepository.findAllByMatter(matter);
		for (int i = 0; i < subscriptionList.size(); i++) {
			subscriptionList.get(i).setMatter(null);
			subscriptionList.get(i).setStudent(null);
			subscriptionRepository.delete(subscriptionList.get(i));
		}
	}
	
	public void aprobeSubscription(SubscriptionModel subscription) {
		SubscriptionModel subscriptionDB = subscriptionRepository.findByMatterAndStudent(subscription.getMatter(), subscription.getStudent());
		subscriptionDB.setRequest(false);
		subscriptionRepository.save(subscriptionDB);
	}
	
	public void deniedSubscription(SubscriptionModel subscription) {
		SubscriptionModel subscriptionDB = subscriptionRepository.findByMatterAndStudent(subscription.getMatter(), subscription.getStudent());
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
		ArrayList<SubscriptionModel> studentsList;
		ArrayList<StudentModel> aprobedStudentsList;
		ArrayList<StudentModel> waitingStudentsList;
		ArrayList<ActivityModel> activitiesList;
		TeacherModel teacherDB;
		ArrayList<SubmitModel> submitList;
		
		for (int i = 0; i < subscriptionList.size(); i++) {
			subscriptionDB = subscriptionList.get(i); 
			matterDB = subscriptionDB.getMatter();
			admin = subscription.getStudent().getId()==matterDB.getStudent().getId();
			studentsList = subscriptionRepository.findAllByMatter(matterDB);
			aprobedStudentsList= new ArrayList<>();
			waitingStudentsList= new ArrayList<>();
			for (int j= 0;  j< studentsList.size(); j++) {
				if(!studentsList.get(j).isRequest()) {//aprobado
					aprobedStudentsList.add(studentsList.get(j).getStudent());
				}else {//en espera
					waitingStudentsList.add(studentsList.get(j).getStudent());
				}
			}
			activitiesList = activityRepository.findAllByMatter(matterDB);
			activitiesList = sortActivities(activitiesList);
			submitList = submitRepository.findAllSubmitBySubscription(subscriptionDB);
			teacherDB = matterDB.getTeacher();
			data+= subscriptionDB.toString(matterDB.toString(subscriptionDB.isRequest(), teacherDB, activitiesList, submitList, admin, aprobedStudentsList, waitingStudentsList));
			data+=((i<subscriptionList.size()-1)?",\n":"\n");
		}
		data+="]";
		return data;
	}
	
	private ArrayList<ActivityModel> sortActivities(ArrayList<ActivityModel> activitiesList){
		ActivityModel aux;
		for (int i = activitiesList.size() - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (Integer.parseInt(activitiesList.get(j).getTerm()) > Integer.parseInt(activitiesList.get(j+1).getTerm())) {
					aux = activitiesList.get(j+1);
					activitiesList.remove(j+1);
					activitiesList.add(j+1, activitiesList.get(j));
					activitiesList.remove(j);
					activitiesList.add(j, aux);
				}
			}
		}
		return activitiesList;
	}
	
}
