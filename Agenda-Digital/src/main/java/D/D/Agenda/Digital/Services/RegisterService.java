package D.D.Agenda.Digital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import D.D.Agenda.Digital.Models.RegisterModel;
import D.D.Agenda.Digital.Repository.RegisterRepository;

@Service
public class RegisterService {
	
	@Autowired
	RegisterRepository registerRepository;
	
	public void register(RegisterModel register) {
		registerRepository.save(register);
	}
	
	public void aprobeRegister(RegisterModel register) {
		RegisterModel registerDB = registerRepository.findById(register.getId()).get();
		registerDB.setRequest(false);
		registerRepository.save(registerDB);
	}
	
	public void unregister(RegisterModel register) {
		registerRepository.deleteById(register.getId());
	}
	
	
}
