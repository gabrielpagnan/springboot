// ChamadoRepository.java
package com.gabrielpagnan.springboot.repository;
import com.gabrielpagnan.springboot.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {}
