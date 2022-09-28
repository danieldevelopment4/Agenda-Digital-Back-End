package D.D.Agenda.Digital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import D.D.Agenda.Digital.Models.ActivityModel;
import D.D.Agenda.Digital.Models.MatterModel;
import D.D.Agenda.Digital.Repository.ActivityRepository;
import D.D.Agenda.Digital.Repository.MatterRepository;

@Service
public class ActivityServices {

	@Autowired
	ActivityRepository activityRepository; 
	@Autowired
	MatterRepository matterRepository;
	
	public void create(ActivityModel activity) {
		MatterModel matterDB = 	matterRepository.findById(activity.getMatter().getId()).get();
		activity.setMatter(matterDB);
		activityRepository.save(activity);
	}
	
	public void update(ActivityModel activity) {
		ActivityModel activityDB = activityRepository.findById(activity.getId()).get();
		activityDB.setName(activity.getName());
		activityDB.setDescription(activity.getDescription());
		activityDB.setPercent(activity.getPercent());
		activityDB.setNoDaysRecordatories(activity.getNoDaysRecordatories());
		activityDB.setSubmissionDate(activity.getSubmissionDate());
		activityDB.setTerm(activity.getTerm());
		activityRepository.save(activityDB);
	}
	
	public void delete(ActivityModel activity) {
		ActivityModel activityDB = activityRepository.findById(activity.getId()).get();
		activityDB.setMatter(null);
		activityRepository.delete(activityDB);
	}
	
	
}
