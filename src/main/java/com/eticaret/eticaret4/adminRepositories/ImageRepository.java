package com.eticaret.eticaret4.adminRepositories;

import com.eticaret.eticaret4.adminEntities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    List<Image> findByPidEquals(int pid);



}
