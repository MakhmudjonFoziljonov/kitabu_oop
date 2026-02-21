package api.kitabu.controller;

import api.kitabu.dto.RegionDTO;
import api.kitabu.service.RegionService;

import java.util.List;

public class RegionController {
    RegionService regionService = new RegionService();

    public String createRegion(RegionDTO regionDTO) {
        return regionService.createRegion(regionDTO);
    }

    public List<RegionDTO> listRegion() {
        return regionService.listRegion();
    }

    public String updateRegion(int regionId, RegionDTO regionDTO) {
        return regionService.updateRegion(regionId, regionDTO);
    }

    public String deleteRegion(int regionId) {
        return regionService.deleteRegion(regionId);
    }
}
