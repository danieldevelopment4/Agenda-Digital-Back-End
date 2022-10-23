package D.D.Agenda.Digital.Models;

public enum SubmitStateEnum {

	//PARA RECIBIR UN ENUM MEDIANTE JSON SE DEBE DE HACER ENVIO DE EL NOMBRE DEL LA "VARIABLE" Y NO DE SU CONTENIDO
	EntregaTiempo("Entregado a tiempo"), 
	EntregaRetraso("Entrega con retraso"), 
	NoEntregado("No entregado");
	
	private String state;
	
	SubmitStateEnum(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return state;
	}
	
}
