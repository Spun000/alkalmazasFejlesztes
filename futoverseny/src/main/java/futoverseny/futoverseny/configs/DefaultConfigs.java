package futoverseny.futoverseny.configs;

import futoverseny.futoverseny.models.Race;
import futoverseny.futoverseny.models.Runner;
import futoverseny.futoverseny.models.db.ResultEntity;
import futoverseny.futoverseny.repository.RaceRepository;
import futoverseny.futoverseny.repository.ResultRepository;
import futoverseny.futoverseny.repository.RunnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;

@Configuration
public class DefaultConfigs {

    @Bean
    CommandLineRunner commandLineRunner(RaceRepository raceRepository, ResultRepository resultRepository, RunnerRepository runnerRepository) {
        return args -> {
            // Create default runners
            runnerRepository.saveAll(List.of(
                    new Runner(UUID.fromString("60c66f8c-0e13-4438-a873-3560aad291e8") ,Runner.SexEnum.MALE, 22, "John Runner"),
                    new Runner(UUID.fromString("60c66f8c-0e13-4438-a873-3560aad291e9"),Runner.SexEnum.FEMALE, 20, "Jane Runner"),
                    new Runner(UUID.fromString("60c66f8c-0e13-4438-a873-3560aad291e7"),Runner.SexEnum.MALE, 18, "John Smith"),
                    new Runner(UUID.fromString("60c66f8c-0e13-4438-a873-3560aad291e6"),Runner.SexEnum.MALE, 19, "Marcus Lincoln"),
                    new Runner(UUID.fromString("60c66f8c-0e13-4438-a873-3560aad291e5"),Runner.SexEnum.FEMALE, 21, "Ada White"))
            );

            // Create default races
            raceRepository.saveAll(List.of(
                    new Race("5 km",5, UUID.fromString("740467f2-1391-4617-a19b-54d0b8bb3aac")),
                    new Race("10 km",5, UUID.fromString("740467f2-1391-4617-a19b-54d0b8bb3aad")))
            );

            // Create default results
            resultRepository.saveAll(List.of(
                    new ResultEntity(UUID.fromString("60c66f8c-0e13-4438-a873-3560aad291e7"),UUID.fromString("740467f2-1391-4617-a19b-54d0b8bb3aac"),17),
                    new ResultEntity(UUID.fromString("60c66f8c-0e13-4438-a873-3560aad291e6"),UUID.fromString("740467f2-1391-4617-a19b-54d0b8bb3aac"),22),
                    new ResultEntity(UUID.fromString("60c66f8c-0e13-4438-a873-3560aad291e5"),UUID.fromString("740467f2-1391-4617-a19b-54d0b8bb3aac"),25),
                    new ResultEntity(UUID.fromString("60c66f8c-0e13-4438-a873-3560aad291e7"),UUID.fromString("740467f2-1391-4617-a19b-54d0b8bb3aad"),38),
                    new ResultEntity(UUID.fromString("60c66f8c-0e13-4438-a873-3560aad291e8"),UUID.fromString("740467f2-1391-4617-a19b-54d0b8bb3aad"),37),
                    new ResultEntity(UUID.fromString("60c66f8c-0e13-4438-a873-3560aad291e9"),UUID.fromString("740467f2-1391-4617-a19b-54d0b8bb3aad"),48),
                    new ResultEntity(UUID.fromString("60c66f8c-0e13-4438-a873-3560aad291e6"),UUID.fromString("740467f2-1391-4617-a19b-54d0b8bb3aad"),51))
            );
        };
    }
}
