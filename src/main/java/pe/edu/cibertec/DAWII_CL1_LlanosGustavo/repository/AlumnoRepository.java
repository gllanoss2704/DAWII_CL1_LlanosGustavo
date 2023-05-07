package pe.edu.cibertec.DAWII_CL1_LlanosGustavo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DAWII_CL1_LlanosGustavo.model.bd.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, String> {

}
