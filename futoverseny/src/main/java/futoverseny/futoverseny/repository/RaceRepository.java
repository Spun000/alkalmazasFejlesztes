package futoverseny.futoverseny.repository;

import futoverseny.futoverseny.models.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RaceRepository extends JpaRepository<Race, UUID> {
}

