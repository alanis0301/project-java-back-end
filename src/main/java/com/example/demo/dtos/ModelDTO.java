package com.example.demo.dtos;


public class ModelDTO {

    private int id;

    private String name;

    public ModelDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ModelDTO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}