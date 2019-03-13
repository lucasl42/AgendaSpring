package com.ibm.telefone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.telefone.model.TelefoneModel;

@Repository
public interface TelefoneRepository extends JpaRepository<TelefoneModel, Long>{

}
