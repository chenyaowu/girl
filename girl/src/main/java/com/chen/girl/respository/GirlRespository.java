package com.chen.girl.respository;

import com.chen.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRespository extends JpaRepository<Girl,Integer> {
    public List<Girl> findGirlByAge(Integer age);

}
