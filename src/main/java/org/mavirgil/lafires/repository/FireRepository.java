package org.mavirgil.lafires.repository;

import org.mavirgil.lafires.model.Fire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FireRepository extends JpaRepository<Fire, Integer> {
}
