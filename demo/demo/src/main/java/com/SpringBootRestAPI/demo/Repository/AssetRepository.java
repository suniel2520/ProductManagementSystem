package com.SpringBootRestAPI.demo.Repository;

import com.SpringBootRestAPI.demo.Entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Integer> {
    List<Asset> findByAssetName(String assetName);
}
