    package com.jinyong.shop.repository;

    import com.jinyong.shop.entity.Item;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;

    import java.util.List;

    public interface ItemRepository extends JpaRepository<Item, Long> {

        List<Item> findByItemName(String itemName);
        List<Item> findByItemNameOrItemDetail(String itemName,String itemDetail);
        List<Item> findByPriceLessThan(int price);
        List<Item> findAllByOrderByPriceDesc();
        @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
        List<Item> findByItemDetail(String itemDetail);
    }
