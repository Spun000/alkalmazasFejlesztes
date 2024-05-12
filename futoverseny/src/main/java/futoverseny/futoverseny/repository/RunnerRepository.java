package futoverseny.futoverseny.repository;

import futoverseny.futoverseny.models.Runner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RunnerRepository extends JpaRepository<Runner, UUID> {
}
