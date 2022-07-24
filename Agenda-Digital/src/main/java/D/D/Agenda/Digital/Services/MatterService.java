package D.D.Agenda.Digital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import D.D.Agenda.Digital.Models.MatterModel;
import D.D.Agenda.Digital.Repository.MatterRepository;

@Service
public class MatterService {
	
	@Autowired
	MatterRepository matterRepository;
	
	public MatterModel create(MatterModel matter) {
		return matterRepository.save(matter);
	}
	
	public void update(MatterModel matter) {
		MatterModel matterDB = matterRepository.findById(matter.getId()).get();
		
		matterRepository.save(matterDB);
	}
	
	public void delete(MatterModel matter) {
		matterRepository.deleteById(matter.getId());
	}
	
	public MatterModel getMatter(Long id) {
		return matterRepository.findById(id).get();
	}

}
