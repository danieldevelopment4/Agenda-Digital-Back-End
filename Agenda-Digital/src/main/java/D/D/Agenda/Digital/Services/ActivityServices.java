package D.D.Agenda.Digital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import D.D.Agenda.Digital.Models.ActivityModel;
import D.D.Agenda.Digital.Repository.ActivityRepository;

@Service
public class ActivityServices {

	@Autowired
	ActivityRepository activityRepository; 
	
	public void create(ActivityModel activity) {
		activityRepository.save(activity);
	}
	
	public void update(ActivityModel activity) {
		ActivityModel activityDB = activityRepository.findById(activity.getId()).get();
		
		activityRepository.save(activityDB);
	}
	
	public void delete(ActivityModel activity) {
		activityRepository.deleteById(activity.getId());
	}
	
	
}
