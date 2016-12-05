package model;

import java.util.ArrayList;
import java.util.List;

import dao.BaggDAO;

public class Bagg {
   int id;
   String name;
   List<BagLinee> contents = new ArrayList<BagLinee>();

   public Bagg(int id, String name) {
      this.id = id;
      this.name = name;
   }

   public Bagg(String name) {
      this.name = name;
   }

   public void addLine(BagLinee line) {
      System.out.println("addLine()");
      contents.add(line);
      BaggDAO.instance.addLine(this, line);
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public List<BagLinee> getContents() {
      return contents;
   }

   public void setContents(List<BagLinee> contents) {
      this.contents = contents;
   }
}
