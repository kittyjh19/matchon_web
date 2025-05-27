package com.multi.matchon.stadium.repository;

import com.multi.matchon.stadium.domain.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {

    List<Stadium> findByCpNm(String cpNm);
}
