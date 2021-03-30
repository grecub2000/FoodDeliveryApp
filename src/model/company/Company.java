package model.company;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

public class Company {
    public final String id = UUID.randomUUID().toString();
    public String name;
    public ArrayList<Local> locals;

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

    public ArrayList<Local> getLocals() {
        return locals;
    }

    public void setLocals(ArrayList<Local> locals) {
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

