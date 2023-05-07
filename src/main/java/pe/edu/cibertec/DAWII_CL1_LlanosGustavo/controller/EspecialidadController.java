package pe.edu.cibertec.DAWII_CL1_LlanosGustavo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.cibertec.DAWII_CL1_LlanosGustavo.model.bd.Especialidad;
import pe.edu.cibertec.DAWII_CL1_LlanosGustavo.service.EspecialidadService;

import java.util.List;

@Controller
@RequestMapping("/Especialidad")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping("/frmMantEspecialidad")
    public String frmMantEspecialidad(Model model){
        model.addAttribute("listaEspecialidades", especialidadService.listarEspecialidades());
        return "Especialidad/frmMantEspecialidad";
    }

    @GetMapping("/listarEspecialidades")
    @ResponseBody
    public List<Especialidad> listarEspecialidades(){
        return especialidadService.listarEspecialidades();
    }

}
