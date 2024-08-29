package com.example.step.rasp;

public class Lesson {
private Teacher teacher;
private Group group;
private Subject subject;
private String start;
private String end;
private int day0fWeek;
public Lesson( Teacher teacher, Group group, Subject subject, String start, String end, int day0fWeek) {
    this.teacher = teacher;
    this.group = group;
    this.subject = subject;
    this.start = start;
    this.end = end;
    this.day0fWeek = day0fWeek;
}

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getDay0fWeek() {
        return day0fWeek;
    }

    public void setDay0fWeek(int day0fWeek) {
        this.day0fWeek = day0fWeek;

    }

    @Override
    public String toString() {
        return "" +
                "" + teacher.getName() +
                ", " + subject.getName()
                ;
    }
}
