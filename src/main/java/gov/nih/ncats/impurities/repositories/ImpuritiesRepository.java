package gov.nih.ncats.impurities.repositories;

import gov.nih.ncats.impurities.models.*;
import gsrs.repository.GsrsRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ImpuritiesRepository extends GsrsRepository<Impurities, Long> {
    Optional<Impurities> findById(Long id);
}
