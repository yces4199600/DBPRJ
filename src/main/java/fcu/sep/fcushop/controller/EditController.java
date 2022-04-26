package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.sql2o.Connection;

/**
 * this is EditController.
 */

@RestController
@CrossOrigin
public class EditController {

  @Autowired
  private Sql2oDbHandler sql2oDbHandler;

  /**
   * this is deleteProduct function.
   ** @param params itemData.
   ** @return text.
   */
  @PostMapping("/deleteProduct")
  public String deleteData(@RequestBody Map params) {
    String id = params.get("id").toString();

    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "DELETE FROM product WHERE id = :id";
      connection.createQuery(query)
              .addParameter("id", id)
              .executeUpdate();
    }
    return "Good Delete";
  }

  /**
   * this is getNewData function.
   ** @param params itemData.
   ** @return text.
   */
  @PostMapping("/new")
  public String getNewData(@RequestBody Map params) {

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
  }

  /**
   * this is createProduct function.
   ** @param params itemData.
   ** @return text.
   */
  @PostMapping("/edit")
  public String createProduct(@RequestBody Map params) {


    String oldName = params.get("oldName").toString();
    String newName = params.get("newName").toString();
    String imageUrl = params.get("imageUrl").toString();
    String price = params.get("price").toString();
    String description = params.get("description").toString();

    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "update product set `name` = :newName, image_url = :image_url,"
              + " price = :price,description = :description"
              + " where `name` = :oldName";
      connection.createQuery(query)
              .addParameter("oldName", oldName)
              .addParameter("newName", newName)
              .addParameter("image_url", imageUrl)
              .addParameter("price", price)
              .addParameter("description", description)
              .executeUpdate();


      return "Good Edit";
    }
  }
}