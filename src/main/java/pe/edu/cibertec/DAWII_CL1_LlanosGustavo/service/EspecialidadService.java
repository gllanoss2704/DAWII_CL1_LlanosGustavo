package pe.edu.cibertec.DAWII_CL1_LlanosGustavo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL1_LlanosGustavo.model.bd.Especialidad;
import pe.edu.cibertec.DAWII_CL1_LlanosGustavo.repository.EspecialidadRepository;

import java.util.List;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> listarEspecialidades(){
        return especialidadRepository.findAll();
    }

    public void registrarEspecialidad(Especialidad especialidad){
        especialidadRepository.save(especialidad);
    }

    public void eliminarEspecialidad(Especialidad especialidad){
        especialidadRepository.deleteById(especialidad.getIdesp());
    }

}
