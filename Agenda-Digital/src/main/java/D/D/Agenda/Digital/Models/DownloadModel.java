package D.D.Agenda.Digital.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "descargas")
public class DownloadModel {
	@Id//la BD no sabe que esto es un ID y debemos de indicarselo a spring para que asi este le informe a la BD como actuar
	@GeneratedValue(strategy = GenerationType.IDENTITY)//ID autogenerado, consecutivo automaticamente
	@Column(unique = true, nullable = false)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String operativeSystem;
	private int noDownloads;
	private String url;
	@Column(nullable = false)
	private String status;
	
	public DownloadModel() {
		super();
	}

	public DownloadModel(Long id, String operativeSystem, int noDownloads, String url, String status) {
		super();
		this.id = id;
		this.operativeSystem = operativeSystem;
		this.noDownloads = noDownloads;
		this.url = url;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getOperativeSystem() {
		return operativeSystem;
	}

	public void setOperativeSystem(String operativeSystem) {
		this.operativeSystem = operativeSystem;
	}

	public int getNoDownloads() {
		return noDownloads;
	}

	public void setNoDownloads(int noDownloads) {
		this.noDownloads = noDownloads;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
