package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeCacheRepository {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    // key - 1      value - {name - abc, age - 10, ....}
    // key - 2      value - {}

    // attendance
    // 1

    private final String EMPLOYEE_KEY_PREFIX = "emp::";

    public void insert(Employee employee){
        String key = this.EMPLOYEE_KEY_PREFIX + employee.getId();
        this.redisTemplate.opsForValue().set(key, employee);
    }

    public Employee get(int id){
        String key = this.EMPLOYEE_KEY_PREFIX + id;
        return (Employee) this.redisTemplate.opsForValue().get(key);

    }
}
