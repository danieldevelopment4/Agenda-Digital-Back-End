package D.D.Agenda.Digital.Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import D.D.Agenda.Digital.Models.DownloadModel;
import D.D.Agenda.Digital.Repository.DownloadRepository;

@Service
public class DownloadService {
	
	@Autowired
	DownloadRepository downloadRepository;

	public void newDownload(DownloadModel download) {
		try {
			downloadRepository.save(download);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "el sistema operativo a registrar ya se encuentra registrado");
		}
	}
	
	public void updateDownload(DownloadModel download) {
		DownloadModel downloadDB = downloadRepository.findById(download.getId()).get();
		downloadDB.setOperativeSystem("");
		downloadRepository.save(downloadDB);
		downloadDB.setOperativeSystem(download.getOperativeSystem());
		downloadDB.setVersion(download.getVersion());
		downloadDB.setUrl(download.getUrl());
		downloadDB.setStatus(download.getStatus());
		downloadRepository.save(downloadDB);
	}
	
	public synchronized void addCounter (Long id) {
		DownloadModel downloadDB = downloadRepository.findById(id).get();
		downloadDB.setNoDownloads(downloadDB.getNoDownloads()+1);
		downloadRepository.save(downloadDB);
	}
	
	public ArrayList<DownloadModel> showDownloads(){
		ArrayList<DownloadModel> list = (ArrayList<DownloadModel>) downloadRepository.findAll();
		list.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
		return list; 
	}
	
	public boolean lookForUpdate(DownloadModel download){
		DownloadModel downloadDB = downloadRepository.findById(download.getId()).get();
		return download.getVersion().equals(downloadDB.getVersion());
	}

	public String getStats() {
		ArrayList<DownloadModel> downloads = (ArrayList<DownloadModel>) downloadRepository.findAll();
		int total = 0;
		for (int i = 0; i < downloads.size(); i++) {
			total += downloads.get(i).getNoDownloads();
		}
		return "\"noDownloads\": \""+total+"\",\n";
	}
	
}
