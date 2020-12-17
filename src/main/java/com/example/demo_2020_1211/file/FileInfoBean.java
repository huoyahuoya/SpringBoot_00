package com.example.demo_2020_1211.file;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "file_info" )
public class FileInfoBean {
    @Column( name = "file_name" )
    private String fileName;
    @Column( name = "date_time" )
    @Id
    private String dateTime;
    @Column( name = "month" )
    private String month;
    @Column( name = "file_type" )
    private String fileType;
    @Column( name = "file_size" )
    private long fileSize;

    public FileInfoBean() {
    }

    public FileInfoBean( String fileName, String month, String dateTime, String fileType, long fileSize ) {
        this.fileName = fileName;
        this.month = month;
        this.dateTime = dateTime;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName( String fileName ) {
        this.fileName = fileName;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth( String month ) {
        this.month = month;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime( String dateTime ) {
        this.dateTime = dateTime;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType( String fileType ) {
        this.fileType = fileType;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize( long fileSize ) {
        this.fileSize = fileSize;
    }

}