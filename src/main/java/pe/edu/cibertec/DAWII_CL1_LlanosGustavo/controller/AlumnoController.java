package pe.edu.cibertec.DAWII_CL1_LlanosGustavo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWII_CL1_LlanosGustavo.model.bd.Alumno;
import pe.edu.cibertec.DAWII_CL1_LlanosGustavo.model.bd.Especialidad;
import pe.edu.cibertec.DAWII_CL1_LlanosGustavo.model.request.AlumnoRequest;
import pe.edu.cibertec.DAWII_CL1_LlanosGustavo.model.response.ResultadoResponse;
import pe.edu.cibertec.DAWII_CL1_LlanosGustavo.service.AlumnoService;

import java.util.List;

@Controller
@RequestMapping("/Alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/frmMantAlumno")
    public String frmMantAlumno(Model model){
        model.addAttribute("listaAlumnos",
                alumnoService.listarAlumnos());
        return "Alumno/frmMantAlumno";
    }

    @PostMapping("/registrarAlumno")
    @ResponseBody
    public ResultadoResponse registrarAlumno(@RequestBody AlumnoRequest alumnoRequest){
        String mensaje = "Alumno matriculado correctamente";
        Boolean respuesta = true;
        try{
            Alumno objAlumno = new Alumno();
            if(alumnoRequest.getIdalumno() != null){
                objAlumno.setIdalumno(alumnoRequest.getIdalumno());
            }
            objAlumno.setApealumno(alumnoRequest.getApealumno());
            objAlumno.setNomalumno(alumnoRequest.getNomalumno());
            Especialidad objEspecialidad = new Especialidad();
            objEspecialidad.setIdesp(alumnoRequest.getIdesp());
            objAlumno.setEspecialidad(objEspecialidad);
            objAlumno.setProce(alumnoRequest.getProce());
            alumnoService.registrarAlumno(objAlumno);
        }catch (Exception ex){
            mensaje = "No se pudo matricular al alumno";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta).build();
    }

    @DeleteMapping("/eliminarAlumno")
    @ResponseBody
    public ResultadoResponse eliminarAlumno(@RequestBody AlumnoRequest alumnoRequest){
        String mensaje = "Alumno eliminado correctamente";
        Boolean respuesta = true;
        try{
            alumnoService.eliminarAlumno(alumnoRequest.getIdalumno());
        }catch (Exception ex){
            mensaje = "No se pudo eliminar al alumno";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje).respuesta(respuesta).build();
    }

    @GetMapping("/listarAlumnos")
    @ResponseBody
    public List<Alumno> listarAlumnos(){
        return alumnoService.listarAlumnos();
    }


}
