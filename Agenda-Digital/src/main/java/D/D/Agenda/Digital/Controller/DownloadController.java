package D.D.Agenda.Digital.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/addCounter")
	public void addCounter(@RequestBody DownloadModel download) {
		downloadService.addCounter(download.getId());
	}
	
	@PostMapping("/view")
	public ArrayList<DownloadModel> showDownloads() {
		return downloadService.showDownloads();
	}

}
