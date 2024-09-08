package com.investMingle.chat.controller;

import com.investMingle.chat.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping("/roomList")
    public List<String> roomListSearch(@RequestParam(name = "roomName") String roomName) {
        if (StringUtils.hasText(roomName)) {
            return recordService.getRoomList(roomName);
        } else {
            return recordService.getRoomList();
        }
    }
}
