$(document).on("click", "#btnagregar", function(){
    $("#txtapealumno").val("");
    $("#txtnomalumno").val("");
    $("#txtproce").val("");
    $("#hddidalumno").val("0");
    $("#cboespecialidad").empty();
    $.ajax({
        type: "GET",
        url: "/Especialidad/listarEspecialidades",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboespecialidad").append(
                    `<option value="${value.idesp}">${value.nomesp}</option>`
                )
            })
        }
    })
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtapealumno").val($(this).attr("data-apealumno"));
    $("#txtnomalumno").val($(this).attr("data-nomalumno"));
    $("#txtproce").val($(this).attr("data-proce"));
    $("#hddidalumno").val($(this).attr("data-idalumno"));
    $("#cboespecialidad").empty();
    var idespecialidad = $(this).attr("data-idespecialidad");
    $.ajax({
        type: "GET",
        url: "/Especialidad/listarEspecialidades",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboespecialidad").append(
                    `<option value="${value.idespecialidad}">${value.nomesp}</option>`
                )
            })
            $("#cboespecialidad").val(idespecialidad);
        }
    })
    $("#modalNuevo").modal("show");
});


$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/Alumno/registrarAlumno",
        contentType: "application/json",
        data: JSON.stringify({
            idalumno: $("#hddidalumno").val(),
            apealumno: $("#txtapealumno").val(),
            nomalumno: $("#txtnomalumno").val(),
            idespecialidad: $("#cboespecialidad").val(),
            proce: $("#txtproce").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                ListarAlumno();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

$(document).on("click", ".btneliminar", function(){
    var idalumno = $(this).attr("data-idalumno");
    $.ajax({
        type: "DELETE",
        url: "/Alumno/eliminarAlumno",
        contentType: "application/json",
        data: JSON.stringify({
            idalumno: idalumno
        }),
        success: function(resultado){
            if(resultado.respuesta){
                ListarAlumno();
            }
            alert(resultado.mensaje);
        }
    });
});

function ListarAlumno(){
    $.ajax({
        type: "GET",
        url: "/Alumno/listarAlumnos",
        dataType: "json",
        success: function(resultado){
            $("#tblalumno > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblalumno > tbody").append("<tr>"+
                    "<td>"+value.idalumno+"</td>"+
                    "<td>"+value.apealumno+"</td>"+
                    "<td>"+value.nomalumno+"</td>"+
                    "<td>"+value.especialidad+"</td>"+
                    "<td>"+value.proce+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-idalumno='"+value.idalumno+"'"+
                                     "data-apealumno='"+value.apealumno+"'"+
                                     "data-nomalumno='"+value.nomalumno+"'"+
                                     "data-idespecialidad='"+value.especialidad+"'"+
                                     "data-proce='"+value.proce+"'>Actualizar</button>"+
                    "</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-danger btneliminar'"+
                                     "data-idalumno='"+value.idalumno+"'"+
                                     "data-apealumno='"+value.apealumno+"'"+
                                     "data-nomalumno='"+value.nomalumno+"'>Eliminar</button>"+
                    "</td></tr>");
            })
        }
    })
}