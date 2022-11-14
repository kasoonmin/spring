package com.spring.pro28.ex01;

import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class FileUploadController {
	private static final String CURR_IMAGE_REPO_PATH = "c:\\spring\\image_repo";
	@RequestMapping(value="/form")
	public String form() {
		return "uploadForm";
	}
	
	@RequestMapping(value="/upload",method = RequestMethod.POST)
	public ModelAndView upload(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception{
		multipartRequest.setCharacterEncoding("utf-8");
		Map map = new HashMap();
		Enumeration enu = multipartRequest.getParameterNames();
		while(enu.hasMoreElements()) {
			String name=(String)enu.nextElement();
			String value = multipartRequest.getParameter(name);
			map.put(name, value);
		}
		
		List fileList = fileProcess(multipartRequest);
		map.put("fileList",fileList);
		ModelAndView mav = new ModelAndView();
		mav.addObject("map",map);
		mav.setViewName("result");
		return mav;
	}
	
//	@RequestMapping("/download")
//	protected void download(@RequestParam("imageFileName") String imageFileName, HttpServletResponse response) throws Exception{
//		OutputStream out = response.getOutputStream();
//		String filePath = CURR_IMAGE_REPO_PATH + "\\" + imageFileName;
//		File image = new File(filePath);
//		int lastIndex = imageFileName.lastIndexOf(".");
//		String fileName = imageFileName.substring(0,lastIndex);
//		File thumbnail = new File(CURR_IMAGE_REPO_PATH+"\\"+"thumbnail"+"\\" +fileName+".jpg");
//		if(image.exists()) {
//			Thumbnails.of(image).size(50, 50).outputFormat("jpg").toOutputStream(out);
//		}else {
//			return;
//		}
//		byte[] buffer = new byte[1024 * 8];
//		out.write(buffer);
//		out.close();
//	}
	
	private List<String> fileProcess(MultipartHttpServletRequest multipartRequest) throws Exception{
		List<String> fileList = new ArrayList<String>();
		Iterator<String> fileNames = multipartRequest.getFileNames();
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			String originalFileName = mFile.getOriginalFilename();
			fileList.add(originalFileName);
			File file = new File(CURR_IMAGE_REPO_PATH + "\\" + fileName);
			if(mFile.getSize()!=0) { //File Null Check
				if(! file.exists()) {//경로상에 파일이 존재하지 않을 경우
					if(file.getParentFile().mkdirs()) {//경로에 해당하는 디렉토리들을 생성
						file.createNewFile(); //이후 파일 생성
					}
			}
				mFile.transferTo(new File(CURR_IMAGE_REPO_PATH + "\\" + originalFileName)); //임시로 저장된 multipartFile을 실제 파일로 전송
		}
 	}
		return fileList;
}
}
