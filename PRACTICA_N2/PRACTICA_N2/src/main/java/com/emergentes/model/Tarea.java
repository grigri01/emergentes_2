/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.model;

/**
 *
 * @author ALEX
 */
public class Tarea {

    private int id;
    private String tarea;
    private boolean check;

    public Tarea() {
        this.id = 0;
        this.tarea = "";
        this.check = false;

    }

    public Tarea(int id, String tarea, boolean check) {
        this.id = id;
        this.tarea = tarea;
        this.check = check;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

   
    
}
