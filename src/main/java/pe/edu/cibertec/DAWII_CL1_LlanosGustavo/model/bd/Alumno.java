package pe.edu.cibertec.DAWII_CL1_LlanosGustavo.model.bd;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alumno")
@Getter
@Setter
@NoArgsConstructor
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idalumno;
    @Column(name = "apealumno")
    private String apealumno;
    @Column(name = "nomalumno")
    private String nomalumno;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idesp")
    private Especialidad especialidad;

    @Column(name = "proce")
    private String proce;

}
