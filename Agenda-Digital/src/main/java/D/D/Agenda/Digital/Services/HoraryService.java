package D.D.Agenda.Digital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import D.D.Agenda.Digital.Models.HoraryDayEnum;
import D.D.Agenda.Digital.Models.HoraryHourEnum;
import D.D.Agenda.Digital.Models.HoraryModel;
import D.D.Agenda.Digital.Repository.HoraryRepository;

@Service
public class HoraryService {
	
	@Autowired
	HoraryRepository horaryRepository;
	
	public HoraryModel create(HoraryModel horary) {
		return horaryRepository.save(horary);
	}
	
	public String show(){
		String data = "";
		data += "days:[";
		HoraryDayEnum[] days = HoraryDayEnum.values();
		for (int i = 0; i < days.length; i++) {
			data+="\""+days[i];
			data+=(i!=days.length-1)?"\",":"\"";
		}
		data +="],\n";
		data+="hours:[";
		HoraryHourEnum[] hour = HoraryHourEnum.values();
		for (int i = 0; i < hour.length; i++) {
			data+="\""+hour[i];
			data+=(i!=hour.length-1)?"\",":"\"";
		}
		data+="]";
		return data;
	}
	
	public HoraryModel getHorary(HoraryModel horary) {
		return horaryRepository.findHoraryByDayAndHourAndDuration(horary.getDay(), horary.getHour(), horary.getDuration());
	}
	
	
}
