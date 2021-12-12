package com.pb.ssn.hw11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class PhoneBook {
    private ArrayList<Person> pb = new ArrayList<>();
    private ObjectMapper mapper;

    public PhoneBook() {
    }

    public void addPerson(Person person) {
        pb.add(person);
    }

    public ArrayList<Person> getPersons() {
        return pb;
    }

    public void delRecord(Person record) {
        pb.remove(record);
    }

    public void delRecord(int idx) {
        pb.remove(idx);
    }

    public void loadBook(String pathToFile) throws IOException {
        if (mapper == null) createMapper();
        pb = new ArrayList<>(Arrays.asList(mapper.readValue(Paths.get(pathToFile).toFile(), Person[].class)));

    }

    public void saveBook(String pathToFile) throws IOException {
        if (mapper == null) createMapper();
        mapper.writeValue(Paths.get(pathToFile).toFile(), pb);
    }

    private void createMapper() {
        mapper = new ObjectMapper();
        // pretty printing (json с отступами)
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // для работы с полями типа LocalDate и LocalDateTime
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        mapper.registerModule(module);
    }
}
