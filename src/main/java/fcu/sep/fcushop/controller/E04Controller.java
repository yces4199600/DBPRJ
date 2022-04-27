package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.CourseList;
import fcu.sep.fcushop.model.Product;
import fcu.sep.fcushop.model.Takes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sql2o.Connection;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class E04Controller {

  @Autowired
  private Sql2oDbHandler sql2oDbHandler;

  @PostMapping("/whatismyAPI")
  public String NameMe(@RequestBody Map params) {
    String name = params.get("name").toString();
    String imageUrl = params.get("imageUrl").toString();
    String price = params.get("price").toString();
    String description = params.get("description").toString();

    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "insert into product (id,name,image_url,price,description)"
          + "values(NULL,:name,:image_url,:price,:description)";
      connection.createQuery(query)
          .addParameter("name", name)
          .addParameter("image_url", imageUrl)
          .addParameter("price", price)
          .addParameter("description", description)
          .executeUpdate();
    }

    return "Good Create";
  }//getCourse
  @GetMapping("/getCourse")
  public ResponseEntity<List<CourseList>> getAllList(){
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select * from course limit 50";
      List<CourseList> r = connection.createQuery(query).executeAndFetch(CourseList.class);
      System.out.println(connection.createQuery(query));
      return ResponseEntity.ok().body(r);
    }
  }

//  @PostMapping("路徑")
//  public ResponseEntity<你的型別> 取名字() {
//    Connection connection = sql2oDbHandler.getConnector().open()
//    String query = "你的語法"
//    你的型別 你媽 = connection.createQuery(query).executeAndFetch(你的型別.class)
//
//    return ResponseEntity.ok().body(你媽);
//  }

  @PostMapping("/usertakes")
  public ResponseEntity<List<CourseList>> getTakes(@RequestBody Map params) {
    String userid = params.get("current_user").toString();
    System.out.println(userid);
    try (Connection connection = sql2oDbHandler.getConnector().open()) {//query語法錯誤
      String query = "SELECT * FROM course WHERE `Course_ID` IN (SELECT `Course_ID` FROM takes WHERE `Student_ID` = :userid)";
      List<CourseList> r = connection.createQuery(query).executeAndFetch(CourseList.class);
      System.out.println(connection.createQuery(query));
      return ResponseEntity.ok().body(r);
    }
  }
}
