package org.k3sexamples.configuration.dao;
import org.k3sexamples.configuration.dao.entities.ConfigParamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ConfigRepository extends JpaRepository<ConfigParamEntity, Integer>{
}
