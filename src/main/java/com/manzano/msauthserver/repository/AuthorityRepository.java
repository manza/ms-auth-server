package com.manzano.msauthserver.repository;

import com.manzano.msauthserver.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Defines queries refering Authority
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {

    Authority findByName(String name);

}
