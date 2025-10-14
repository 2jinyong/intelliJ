package com.jinyong.shop.controller;

import com.jinyong.shop.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class ExamController {

    @GetMapping("/exam")
    public String exam(Model model){
        model.addAttribute("data","타임리프ㅇㅇ.");
        return "exam";
    }

    @GetMapping("/exam2")
    public String exam2(Model model){
        ItemDto itemDto = new ItemDto();
        itemDto.setItemName("테스트 상품1");
        itemDto.setItemDetail("상품 상세 설명");
        itemDto.setPrice("10000");
        itemDto.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDto",itemDto);
        return "exam2";
    }

    @GetMapping("exam3")
    public String exam3(Model model){

        List<ItemDto> itemDtoList = new ArrayList<>();

        for(int i=1;i<=10;i++){
            ItemDto itemDto = new ItemDto();
            itemDto.setItemName("테스트 상품" + i);
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setPrice("10000" + i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }
        model.addAttribute("itemDtoList",itemDtoList);
        return "exam3";
    }

    @GetMapping("exam4")
    public String exam4(Model model){
        List<ItemDto> itemDtoList = new ArrayList<>();
        for(int i=1;i<=10;i++){
            ItemDto itemDto = new ItemDto();
            itemDto.setItemName("테스트 상품" + i);
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setPrice("10000" + i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }
        model.addAttribute("itemDtoList",itemDtoList);
        return "exam4";
    }

    @GetMapping("exam5")
    public String exam5(){
        return "exam5";
    }

    @GetMapping("exam6")
    public String exam6(String param1,String param2,Model model){
        model.addAttribute("param1",param1);
        model.addAttribute("param2",param2);
        return "exam6";
    }
}