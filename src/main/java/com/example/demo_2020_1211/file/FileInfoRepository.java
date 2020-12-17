package com.example.demo_2020_1211.file;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileInfoRepository extends JpaRepository< FileInfoBean, String > {
    Page< FileInfoBean > findAllByMonthAndFileType(String month, String fileType, Pageable pageable );
}
