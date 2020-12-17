package com.example.demo_2020_1211.file;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class FileInfoController {

    private FileInfoRepository FileInfoRepository;

    private ObjectMapper mapper;

    public FileInfoController( FileInfoRepository FileInfoRepository, ObjectMapper mapper ) {
        this.FileInfoRepository = FileInfoRepository;
        this.mapper = mapper;
    }

    @RequestMapping( "/getFileInfoLog" )
    @ResponseBody
    public String getFileInfoLog( @RequestParam( value = "page_index", required = false, defaultValue = "1" ) Integer pageNum,
                                  @RequestParam( value = "page_total", required = false, defaultValue = "20" ) Integer pageSize,
                                  @RequestParam( value = "file_type", defaultValue = "log" ) String fileType,
                                  @RequestParam( value = "log_date") String month ) {
        log.info( "查询{}周期归档日志，文件类型{}，分页信息：当前第{}页 - 每页{}条数据", month, fileType, pageNum, pageSize );
        // 初始化返回值
        String responseJson = "{}";
        Map< String, Object > result = new HashMap<>( 3 );
        result.put( "result", 500 );
        result.put( "message", "数据转换失败！" );
        result.put( "data", new ArrayList<>() );

        // 准备分页条件
        Pageable pageable = PageRequest.of( pageNum, pageSize, Sort.Direction.DESC, "dateTime" );

        // 查询结果
        log.info( "查询归档信息数据..." );
        Page< FileInfoBean > page = FileInfoRepository.findAllByMonthAndFileType( month, fileType, pageable );
        log.info( "查询到{}条归档信息数据", page.getTotalElements() );
        // 组装返回值
        result.put( "result", 200 );
        result.put( "message", "成功" );
        result.put( "data", page.getContent() );
        try {
            responseJson = mapper.writeValueAsString( result );
        } catch ( JsonProcessingException e ) {
            log.error( "数据转换失败!", e );
        }
        log.info( "查询结果准备完毕，返回结果数据！" );
        return responseJson;
    }
}
