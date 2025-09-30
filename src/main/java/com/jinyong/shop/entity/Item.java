package com.jinyong.shop.entity;

import com.jinyong.shop.constant.ItemSellStatus;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item {

    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;    //상품코드

    @Column(name="item_name",nullable = false, length = 50)
    private String itemName;    //상품명

    @Column(name = "price", nullable = false)
    private int price;  //가격

    @Column(nullable = false)
    private int stockNumber;    //재고수량

    @Lob
    @Column(nullable = false)
    private String itemDetail;  //상품상세설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;  //상품판매상테

    private LocalDateTime regTime;  //등록시간

    private LocalDateTime updateTime;   //수정시간
    }