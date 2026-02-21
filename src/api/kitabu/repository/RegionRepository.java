package api.kitabu.repository;

import api.kitabu.entity.RegionEntity;

import java.util.LinkedList;
import java.util.List;

public class RegionRepository {
    public static List<RegionEntity> regionEntityList = new LinkedList<>();

    static {
        /*(1, 'Toshkent shahri','Tashkent city', 'Город Ташкент',
        (2, 'Toshkent viloyati','Tashkent region', 'Ташкентская область',  now(),true),
       (3, 'Andijon viloyati','Andijan region', 'Андижанская область',  now(), true),
       (4, 'Buxoro viloyati','Bukhara region', 'Бухарская область',  now(), true),
       (5, 'Jizzax viloyati', 'Jizzakh region','Джизакская область', now(), true),
       (6, 'Qoraqalpog‘iston','Karakalpakstan', 'Каракалпакстан',  now(), true),
       (7, 'Qashqadaryo viloyati', 'Kashkadarya region','Кашкадарьинская область', now(), true),
       (8, 'Navoiy viloyati', 'Navoi region','Навоийская область',  now(), true),
       (9, 'Namangan viloyati','Namangan region', 'Наманганская область',  now(), true),
       (10, 'Samarqand viloyati','Samarkand region', 'Самаркандская область',  now(), true),
       (11, 'Surxondaryo viloyati','Surkhandarya region', 'Сурхандарьинская область',  now(), true),
       (12, 'Sirdaryo viloyati','Syrdarya region', 'Сырдарьинская область',  now(), true),
       (13, 'Farg‘ona viloyati','Fergana region', 'Ферганская область',  now(), true),
       (14, 'Xorazm viloyati', 'Khorezm region','Хорезмская область',  now(), true)*/
        RegionEntity regionEntity = new RegionEntity();
        regionEntity.setId(1);
        regionEntity.setNameUz("Toshkent shahri");
        regionEntity.setNameRu("Город Ташкент");
        regionEntity.setNameEn("Tashkent city");
        regionEntityList.add(regionEntity);
    }
}
