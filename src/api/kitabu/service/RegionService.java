package api.kitabu.service;

import api.kitabu.dto.RegionDTO;
import api.kitabu.entity.RegionEntity;
import api.kitabu.enums.BookLanguage;
import api.kitabu.repository.RegionRepository;

import java.util.ArrayList;
import java.util.List;

public class RegionService {
    public String createRegion(RegionDTO regionDTO) {
        RegionEntity regionEntity = new RegionEntity();
        regionEntity.setNameUz(regionDTO.nameUz());
        regionEntity.setNameRu(regionDTO.nameRu());
        regionEntity.setNameEn(regionDTO.nameEn());
        RegionRepository.regionEntityList.add(regionEntity);
        return "Region created";
    }

    public List<RegionDTO> listRegion() {
        List<RegionDTO> regionDTOList = new ArrayList<>();
        RegionRepository.regionEntityList.forEach(regionEntity -> {
            regionDTOList.add(new RegionDTO(regionEntity.getNameUz(), regionEntity.getNameRu(), regionEntity.getNameEn()));
        });
        return regionDTOList;
    }

    public String updateRegion(int regionId, RegionDTO regionDTO) {
        RegionEntity entity = getRegionById(regionId);
        int index = RegionRepository.regionEntityList.indexOf(entity);
        entity.setNameUz(regionDTO.nameUz());
        entity.setNameRu(regionDTO.nameRu());
        entity.setNameEn(regionDTO.nameEn());
        RegionRepository.regionEntityList.set(index, entity);
        return "Region updated";
    }

    public RegionEntity getRegionById(int regionId) {
        return RegionRepository.regionEntityList.get(regionId - 1);
    }

    public String deleteRegion(int regionId) {
        RegionRepository.regionEntityList.remove(regionId - 1);
        return "Region deleted";
    }

    public String getByLanguageName(Integer regionId, BookLanguage bookLanguage) {
        RegionEntity entity = getRegionById(regionId);
        switch (bookLanguage){
            case EN -> {
                return entity.getNameEn();
            }
            case RU -> {
                return entity.getNameRu();
            }
            case UZ -> {
                return entity.getNameUz();
            }
        }
        return null;
    }
}
