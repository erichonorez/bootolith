package io.h5z.bootolith.components.auth.domain;

import java.util.Optional;


public interface CredentialRepository  {
	Optional<Credential> findByUsername(String username);
}