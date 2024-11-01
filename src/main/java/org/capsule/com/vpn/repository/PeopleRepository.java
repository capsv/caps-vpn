package org.capsule.com.vpn.repository;

import java.util.Optional;
import org.capsule.com.vpn.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Long> {

    @Query(value = """
        select * from main_dev.person where id=:id
        """, nativeQuery = true)
    Optional<Person> findById(@Param(value = "id") Long id);
}
