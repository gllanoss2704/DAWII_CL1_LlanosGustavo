package pe.edu.cibertec.DAWII_CL1_LlanosGustavo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DAWII_CL1_LlanosGustavo.model.bd.Especialidad;

@Repository
public interface EspecialidadRepository
        extends JpaRepository<Especialidad, String> {
}
