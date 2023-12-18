package com.vslviagens.vslviagensapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vslviagens.vslviagensapi.model.Detalhes_Voos;
import java.util.List;

@Repository
public interface Detalhes_VoosRepository extends JpaRepository<Detalhes_Voos, Long> {

    List<Detalhes_Voos> findAllByVoo_Id(Long vooId);

}
