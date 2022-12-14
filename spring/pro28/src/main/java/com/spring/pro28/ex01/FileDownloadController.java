package com.spring.pro28.ex01;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;


@Controller
public class FileDownloadController {
	private static String CURR_IMAGE_REPO_PATH = "c:\\spring\\image_repo";
	
	@RequestMapping("/download")
	public void download(@RequestParam("imageFileName") String imageFileName, HttpServletResponse response) throws Exception{
		OutputStream out = response.getOutputStream();
		String filePath = CURR_IMAGE_REPO_PATH + "\\" + imageFileName;
		File image = new File(filePath);
		int lastIndex = imageFileName.lastIndexOf(".");
		String fileName = imageFileName.substring(0,lastIndex);
		File thumbnail = new File(CURR_IMAGE_REPO_PATH+"\\"+"thumbnail"+"\\"+fileName+".jpg");
		if(image.exists()) {
			thumbnail.getParentFile().mkdirs();
			Thumbnails.of(image).size(150,150).outputFormat("jpg").toFile(thumbnail);
		}
		FileInputStream in = new FileInputStream(thumbnail);
		byte[] buffer = new byte[1024 * 8];
		while(true) {
			int count = in.read(buffer); // 버퍼에 읽어들인 문자개수
			if (count == -1) //버퍼의 마지막에 도달했는지 체크
				break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
		
//		@RequestMapping("/download")
//		public void download(@RequestParam("imageFileName") String imageFileName, HttpServletResponse response) throws Exception{
//			OutputStream out = response.getOutputStream();
//			String downFile = CURR_IMAGE_REPO_PATH + "\\" + imageFileName;
//			File file = new File(downFile);
//			response.setHeader("Cache-Control","no-cache");
//			response.addHeader("Content-disposition", "attachment; fileName=" + imageFileName);
//			FileInputStream in = new FileInputStream(file);
//			byte[] buffer = new byte[1024 * 8];
//			while(true) {
//				int count = in.read(buffer); // 버퍼에 읽어들인 문자개수
//				if (count == -1) //버퍼의 마지막에 도달했는지 체크
//					break;
//				out.write(buffer, 0, count);
//			}
//			in.close();
//			out.close();
	}

}
