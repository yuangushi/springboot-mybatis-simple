package com.ylp.test.controller;

import com.ylp.test.entity.User;
import com.ylp.test.mapper.UserMapper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class ExcelController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/exportExcel.json")
    public ResponseEntity<Resource> exportExcel(HttpServletRequest request, HttpServletResponse response){
        try{
            ClassPathResource classPathResource=new ClassPathResource("/export/demo.xlsx");
            InputStream inputStream=classPathResource.getInputStream();
            Workbook workbook=new XSSFWorkbook(inputStream);
            Sheet sheet0=workbook.getSheetAt(0);
            List<User> userList=userMapper.getAllUser();
            for(int i=0;i<userList.size();i++){

                Row row = sheet0.getRow(i + 1);
                if(null==row){
                    row=sheet0.createRow(i+1);
                }
                Cell cell0=row.getCell(0);
                if(null==cell0){
                    cell0=row.createCell(0);
                }
                cell0.setCellValue(userList.get(i).getId());

                Cell cell1=row.getCell(1);
                if(null==cell1){
                    cell1=row.createCell(1);
                }
                cell1.setCellValue(userList.get(i).getUserName());
            }
            String fileName="用户信息.xlsx";
            downExcel(response,fileName,workbook);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<Resource>(HttpStatus.OK);
    }

    public void downExcel(HttpServletResponse response,String fileName,Workbook workbook){
        try{
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
                    "attachment;filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"");
            workbook.write(response.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
