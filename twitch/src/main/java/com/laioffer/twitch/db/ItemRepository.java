package com.laioffer.twitch.db;

import com.laioffer.twitch.db.entity.ItemEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ItemRepository extends ListCrudRepository<ItemEntity, Long> {

    ItemEntity findByTwitchId(String twitchId);

}