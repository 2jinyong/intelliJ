    package com.jinyong.shop.repository;

    import com.jinyong.shop.entity.Item;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.List;

    public interface ItemRepository extends JpaRepository<Item, Long> {

        List<Item> findByItemName(String itemName);
        List<Item> findByItemNameOrItemDetail(String itemName,String itemDetail);
        List<Item> findByPriceLessThan(int price);
        List<Item> findAllByOrderByPriceDesc();
    }
