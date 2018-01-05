package br.com.tonsoft.sistemacerveja.repository;

import br.com.tonsoft.sistemacerveja.model.Cerveja;
import org.springframework.data.repository.CrudRepository;

public interface CervejaRepository extends CrudRepository<Cerveja, Long> {

    Cerveja findBySkuIgnoreCase(String nome);

}
