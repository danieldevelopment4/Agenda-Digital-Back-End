package D.D.Agenda.Digital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import D.D.Agenda.Digital.Models.DownloadModel;
import D.D.Agenda.Digital.Repository.DownloadRepository;

@Service
public class DownloadService {
	
	@Autowired
	DownloadRepository downloadRepository;

	public void newDownload(DownloadModel download) {
		downloadRepository.save(download);
	}
	
	public void updateDownload(DownloadModel download) {
		DownloadModel downloadDB = downloadRepository.findById(download.getId()).get();
		downloadDB.setOperativeSystem("");
		downloadRepository.save(downloadDB);
		downloadDB.setOperativeSystem(download.getOperativeSystem());
		downloadDB.setUrl(download.getUrl());
		downloadDB.setStatus(download.getStatus());
		downloadRepository.save(downloadDB);
	}
	
}
