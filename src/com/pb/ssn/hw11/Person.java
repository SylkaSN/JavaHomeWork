package com.pb.ssn.hw11;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Person implements Comparable {
    private String fio;
    private String address;
    private LocalDate birthDay;
    private LocalDateTime lastEdit;
    private ArrayList<String> phones;

    public Person() {
        phones = new ArrayList<>();
    }

    public Person(String fio, String address, LocalDate birthDay, LocalDateTime lastEdit, ArrayList<String> phones) {
        this.fio = fio;
        this.address = address;
        this.birthDay = birthDay;
        this.lastEdit = lastEdit;
        this.phones = phones;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
        this.lastEdit = LocalDateTime.now();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.lastEdit = LocalDateTime.now();
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
        this.lastEdit = LocalDateTime.now();
    }

    public LocalDateTime getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(LocalDateTime lastEdit) {
        this.lastEdit = lastEdit;
        this.lastEdit = LocalDateTime.now();
    }

    public ArrayList<String> getPhones() {
        return phones;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        return fio.compareTo(((Person)o).getFio());
    }

    @Override
    public String toString() {
        return "Person{" +
                "fio='" + fio + '\'' +
                ", address='" + address + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", lastEdit='" + lastEdit + '\'' +
                ", phones=" + phones.toString() +
                '}';
    }
}
