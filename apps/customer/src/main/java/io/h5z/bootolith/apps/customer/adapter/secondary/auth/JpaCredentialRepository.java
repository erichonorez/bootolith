package io.h5z.bootolith.apps.customer.adapter.secondary.auth;

import io.h5z.bootolith.components.auth.domain.Credential;
import io.h5z.bootolith.components.auth.domain.CredentialRepository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCredentialRepository extends JpaRepository<Credential, Integer>, CredentialRepository { }
