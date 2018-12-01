package net.devtopia.demo.domain;

public interface UserRepository {
    User findById(String id);
}
