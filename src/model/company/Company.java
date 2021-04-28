package model.company;

import java.util.*;

public class Company {
    public String id = UUID.randomUUID().toString();
    public String name;
    public List<Local> locals;

    public Company(String name) {
        this.name = name;
        locals = new ArrayList<Local>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Local> getLocals() {
        return locals;
    }

    public void setLocals(List<Local> locals) {
        this.locals = locals;
    }

    public void addLocal(Local local) {
        locals.add(local);
    }

    public void showAllLocals(){
        for(int i = 0; i < locals.size(); i++) {
            System.out.println(i + ". " + locals.get(i).getName());
        }
    }


    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", locals=" + locals +
                '}';
    }



}

