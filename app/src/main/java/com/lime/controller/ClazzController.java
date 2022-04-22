package com.lime.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.lime.domain.Clazz;
import com.lime.service.ClazzService;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;


@RestController
public class ClazzController {

  @Autowired
  ClazzService clazzService;

  @RequestMapping("/class/list")
  public Object list() {
    return clazzService.clazzList();
  }


  @RequestMapping("/class/open1")
  public Object open1(Clazz cls, HttpServletResponse response, HttpSession session) {
    /*
    String st = cls.getStartDate();
    String ed = cls.getEndDate();

    String yy = st.split("/")[0];
    String mm = st.split("/")[1];
    String dd = st.split("/")[2];

    String yy1 = ed.split("/")[0];
    String mm1 = ed.split("/")[1];
    String dd1 = ed.split("/")[2];

    String startDate = yy+"-"+mm+"-"+dd;

    String endDate = yy1+"-"+mm1+"-"+dd1;

    System.out.println(cls.setStartDate(startDate));
    cls.setEndDate(endDate);
     */
    session.setAttribute("classOpen", cls);


    return "success";
  }

  @RequestMapping("/class/open2")
  public Object open2(String level, int perWeek, int cost, HttpServletResponse response, HttpSession session) {

    Clazz cls = (Clazz) session.getAttribute("classOpen");

    cls.setLevel(level);
    cls.setPerWeek(perWeek);
    cls.setCost(cost);
    session.setAttribute("classOpen", cls);
    return "success";
  }


  @RequestMapping("/class/open3")
  public Object open3(String tchrIntro, String dtlIntro, HttpServletResponse response, HttpSession session) {

    Clazz cls = (Clazz) session.getAttribute("classOpen");
    cls.setTchrIntro(tchrIntro);
    cls.setDtlIntro(dtlIntro);
    session.setAttribute("classOpen", cls);

    System.out.println(session.getAttribute("classOpen"));

    clazzService.add(cls);

    return "success";

  }

  /*
  @RequestMapping("/market/add")
  public Object add(Market market, MultipartFile[] files, HttpSession session) {
    Member member = (Member) session.getAttribute("loginUser");
    System.out.println(member);
    System.out.println(files);
    market.setWriter(member);
    try {
      Object fileList = saveFile(files);
      return marketService.add(market, fileList);

    } catch (Exception e) {
      StringWriter out = new StringWriter();
      e.printStackTrace(new PrintWriter(out));
      log.error(out.toString());
      return "error!";
    }
  }
   */














  @RequestMapping("/class/list/1")
  public Object list(String regionName, String cityName) {
    System.out.println(regionName);
    System.out.println(cityName);
    if (regionName.equals("지역") || regionName.equals("전체")) {
      System.out.println(regionName);
      return clazzService.clazzList();
    }

    if (cityName.equals("도시")) {
      System.out.println(regionName);
      return clazzService.regionList(regionName);
    }

    return clazzService.cityList(regionName, cityName);

  }


  /*
  @RequestMapping("/class/add")
  public Object add(Clazz clazz, MultipartFile file) {
    try {
      clazz.setImg(saveFile(file));
      return clazzService.add(clazz);
    } catch (Exception e) {
      e.printStackTrace();
      return "error!";
    }
  }
   */

  @RequestMapping("/class/photo")
  public ResponseEntity<Resource> photo(String filename) {

    try {
      File downloadFile = new File("./upload/book/" + filename); 
      FileInputStream fileIn = new FileInputStream(downloadFile.getCanonicalPath()); 
      InputStreamResource resource = new InputStreamResource(fileIn); 

      HttpHeaders header = new HttpHeaders();
      header.add("Cache-Control", "no-cache, no-store, must-revalidate");
      header.add("Pragma", "no-cache");
      header.add("Expires", "0");


      header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

      return ResponseEntity.ok()
          .headers(header)
          .contentLength(downloadFile.length()) 
          .contentType(MediaType.APPLICATION_OCTET_STREAM) 
          .body(resource);

    } catch (Exception e) {
      System.out.println("요청한 파일이 없습니다!");
      return null;
    }
  }


  private String saveFile(MultipartFile file) throws Exception {
    if (file != null && file.getSize() > 0) { 

      String filename = UUID.randomUUID().toString();

      int dotIndex = file.getOriginalFilename().lastIndexOf(".");
      if (dotIndex != -1) {
        filename += file.getOriginalFilename().substring(dotIndex);
      }

      File photoFile = new File("./upload/book/" + filename); 
      file.transferTo(photoFile.getCanonicalFile());


      Thumbnails.of(photoFile)
      .size(50, 50)
      .crop(Positions.CENTER)
      .outputFormat("jpg")
      .toFile(new File("./upload/book/" + "50x50_" + filename));

      return filename;

    } else {
      return null;
    }
  }

}
