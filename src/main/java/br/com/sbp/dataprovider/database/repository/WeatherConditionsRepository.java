package br.com.sbp.dataprovider.database.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.sbp.dataprovider.database.entity.WeatherConditionsDb;

@Repository
public interface WeatherConditionsRepository extends PagingAndSortingRepository<WeatherConditionsDb, String>{

}