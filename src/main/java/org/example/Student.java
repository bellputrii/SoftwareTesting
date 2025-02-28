
package org.example;

public class Student {
    private String nama;
    private int semester;
    private boolean isActive;

    public Student(String nama, int semester,boolean isActive){
        this.nama = nama;
        this.semester = semester;
        this.isActive = isActive;
    }
    public  boolean isDoingMBKM(){
        return  semester >= 6 && isActive;
    }

    public String getNama() {
        return nama;
    }

    public int getSemester() {
        return semester;
    }

    public boolean isActive() {
        return isActive;
    }

}
