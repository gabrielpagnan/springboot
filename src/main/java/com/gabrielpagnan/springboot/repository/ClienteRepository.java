// ClienteRepository.java
package com.gabrielpagnan.springboot.repository;
import com.gabrielpagnan.springboot.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {}
