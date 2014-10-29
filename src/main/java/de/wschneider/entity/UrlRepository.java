package de.wschneider.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<UrlEntity, Long> {

    UrlEntity findByHash(final String hash);
}
