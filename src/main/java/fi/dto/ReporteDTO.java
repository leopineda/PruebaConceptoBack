package fi.dto;

public class ReporteDTO {
    /**
     * Nombre de la carrera
     */
    private String carrera;

    /**
     * Clave del grupo
     */
    private String grupo;

    /**
     * Nombre de la materia
     */
    private String materia;

    /**
     * Descripción del semestre
     */
    private String semestre;

    private String alumno;

    private String cuenta;

    private Double calificacion;

    /**
     * Constructor.
     */
    public ReporteDTO() {
        super();
    }

    public ReporteDTO(String carrera, String grupo, String materia, String semestre, String alumno, String cuenta, Double calificacion) {
        this.carrera = carrera;
        this.grupo = grupo;
        this.materia = materia;
        this.semestre = semestre;
        this.alumno = alumno;
        this.cuenta = cuenta;
        this.calificacion = calificacion;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }
}
