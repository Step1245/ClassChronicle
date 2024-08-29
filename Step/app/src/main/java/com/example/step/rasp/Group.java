package com.example.step.rasp;

import java.util.ArrayList;

public class Group {
   private int id;
   private String name;
   private int course;
   ArrayList<Lesson>lessons=new ArrayList<>();
   public Group (int id, String name, int course) {
       this.id = id;
       this.name = name;
       this.course = course;
   }
       public int getId(){
           return id;
       }
       public void setId(int id){
       this.id=id;
       }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return  name ;
    }
}
