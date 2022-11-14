package com.spring.pro30.common.file;

import java.io.File;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class FileDownloadController {
	private static final String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";
	@RequestMapping("/download.do")
	protected void download(@RequestParam("imageFileName") String imageFileName, @RequestParam("articleNO") String articleNO, HttpServletResponse response) throws Exception{
		OutputStream out = response.getOutputStream();
		String downFile = ARTICLE_IMAGE_REPO + "\\"+articleNO+"\\" + imageFileName;
		File file = new File(downFile);
	}

}
