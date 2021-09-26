package com.omkar.springbatchdemo.batch;

import com.omkar.springbatchdemo.model.User;
import com.omkar.springbatchdemo.repository.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<User> {

    private final UserRepository userRepository;

    @Autowired
    public DBWriter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void write(List<? extends User> users) {
        System.out.println("Data Saved for Users: " + users);
        userRepository.saveAll(users);
    }
}
