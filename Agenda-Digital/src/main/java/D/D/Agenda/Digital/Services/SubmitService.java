package D.D.Agenda.Digital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import D.D.Agenda.Digital.Models.ActivityModel;
import D.D.Agenda.Digital.Models.SubmitModel;
import D.D.Agenda.Digital.Models.SubscriptionModel;
import D.D.Agenda.Digital.Repository.ActivityRepository;
import D.D.Agenda.Digital.Repository.SubmitRepository;
import D.D.Agenda.Digital.Repository.SubscriptionRepository;

@Service
public class SubmitService {
	
	@Autowired
	SubmitRepository submitRepository;
	@Autowired
	ActivityRepository activityRepository;
	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	public void create(SubmitModel submit) {
		ActivityModel activityDb = activityRepository.findById(submit.getActivity().getId()).get();
		submit.setActivity(activityDb);
		SubscriptionModel subscriptionDB = subscriptionRepository.findByMatterAndStudent(submit.getSubscription().getMatter(), submit.getSubscription().getStudent());
		submit.setSubscription(subscriptionDB);
		submitRepository.save(submit);
	}
	
	public void update(SubmitModel submit) {
		SubmitModel submitDB = submitRepository.findById(submit.getId()).get();
		submitDB.setNote(submit.getNote());
		submitDB.setState(submit.getState());
		submitRepository.save(submitDB);
	}
	
	public void delete(SubmitModel submit) {
		SubmitModel submitDB = submitRepository.findById(submit.getId()).get();
		submitDB.setActivity(null);
		submitDB.setSubscription(null);
		submitRepository.delete(submitDB);
	}
	
}
