package br.com.chainpass.repository;

import br.com.chainpass.domain.Chain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChainRepository extends JpaRepository<Chain, Long> {
}
