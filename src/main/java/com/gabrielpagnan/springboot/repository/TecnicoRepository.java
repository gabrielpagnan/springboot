// TecnicoRepository.java
package com.gabrielpagnan.springboot.repository;
import com.gabrielpagnan.springboot.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {}
