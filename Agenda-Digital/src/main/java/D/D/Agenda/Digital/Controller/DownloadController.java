package D.D.Agenda.Digital.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import D.D.Agenda.Digital.Models.DownloadModel;
import D.D.Agenda.Digital.Services.DownloadService;

@RestController
@RequestMapping("/download")
public class DownloadController {

	@Autowired
	DownloadService downloadService;
	
	@PostMapping("/create")
	public void create(@RequestBody DownloadModel download) {
		downloadService.newDownload(download);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody DownloadModel download) {
		downloadService.updateDownload(download);
	}
	
	
	
}
